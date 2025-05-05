public class CensorBadWords {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        String[] badwords = {"damn","stupid"};
        for(String word : badwords) {
            text = text.replaceAll(word, "****");
        }
        System.out.println(text);
    }
}