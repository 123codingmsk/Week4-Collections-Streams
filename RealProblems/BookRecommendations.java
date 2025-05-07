import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Book{
    String title;
    String author;
    String genre;
    double rating;

    Book(String title, String author, String genre, double rating){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String toString(){
        return "title->"+title+" author->"+author+" genre->"+genre+" rating->"+rating;
    }
}

class BookRecommendation{
    String title;
    double rating;

    BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }
    public String toString(){
        return "title->"+title+" rating->"+rating;
    }
}

public class BookRecommendations {

    public static void filterGenre(List<Book> e){
        System.out.println("Filtered by genre: ");
        e.stream().filter(e1->e1.genre=="Air" && e1.rating > 4.0)
                .forEach(System.out::println);
        System.out.println();
    }

    public static List<BookRecommendation> transformBook(List<Book> b){
        return b.stream().map(b1->new BookRecommendation(b1.title, b1.rating)).toList();
    }

    public static void sortByRating(List<BookRecommendation> br){
        System.out.println("Sorted by rating: ");
        br.stream().sorted((b1, b2)->Double.compare(b2.rating, b1.rating))
                .forEach(System.out::println);
        System.out.println();
    }
    //chatgpt
    public static void paginateTopBooks(List<BookRecommendation> br, int pageSize) {
        System.out.println("Paginated Top 10 Books (5 per page):");

        List<BookRecommendation> top10 = br.stream()
                .sorted((b1, b2) -> Double.compare(b2.rating, b1.rating)) // descending
                .limit(10)
                .toList();

        int totalPages = (int) Math.ceil(top10.size() / (double) pageSize);

        for (int i = 0; i < totalPages; i++) {
            System.out.println("\n--- Page " + (i + 1) + " ---");
            top10.stream()
                    .skip(i * pageSize)
                    .limit(pageSize)
                    .forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        List<Book> b = Arrays.asList(
                new Book("Nature", "Manoj", "Air", 5.0),
                new Book("Water", "Raj", "Land", 4.5),
                new Book("Fire", "Kajal", "Sun", 3.5)
        );

        //filterGenre(b);
        List<BookRecommendation> res = transformBook(b);
        //res.forEach(System.out::println);

        //sortByRating(res);
        paginateTopBooks(res, 3);
    }
}
