import java.util.List;
import java.util.ArrayList;

abstract class Category{
	private String name;
	
	Category(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}

class BookCategory extends Category{
	BookCategory(String name){
		super(name);
	}
}

class ClothCategory extends Category{
	ClothCategory(String name){
		super(name);
	}
}

class GadgetCategory extends Category{
	GadgetCategory(String name){
		super(name);
	}
}

class Product<T extends Category>{
	private String name;
	private double price;
	private T category;
	
	Product(String name, double price, T category){
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	public String getName(){
		return name;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public T getCategory(){
		return category;
	}
	
	public void displayProduct() {
        System.out.println("Product: " + name);
		System.out.println("Price: " + price);
		System.out.println("Category: " + category.getName());
    }
}

class DiscountUtils{
	public static <T extends Product> void applyDiscount(T product, double percentage){
		double discountedPrice = product.getPrice() * (1 - percentage / 100);
		product.setPrice(discountedPrice);
		System.out.println("Discount applied: " + percentage + "%  New price: " + discountedPrice);
	}
}

public class OnlineMarketPlace{
	public static void main(String[] a){
		BookCategory fiction = new BookCategory("Fiction");
        ClothCategory menWear = new ClothCategory("Men's Wear");
        GadgetCategory mobile = new GadgetCategory("Mobile Devices");
		
		Product<BookCategory> book = new Product<>("The Alchemist", 499.0, fiction);
        Product<ClothCategory> shirt = new Product<>("Formal Shirt", 1299.0, menWear);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 19999.0, mobile);
		
		List<Product<? extends Category>> catalog = new ArrayList<>();
		catalog.add(book);
		catalog.add(shirt);
		catalog.add(phone);
		
        for (Product<? extends Category> p : catalog) {
            p.displayProduct();
        }

        System.out.println("\n Applying Discounts:");
        DiscountUtils.applyDiscount(book, 10);
        DiscountUtils.applyDiscount(shirt, 20);
        DiscountUtils.applyDiscount(phone, 5);
		
        System.out.println("\n Updated Catalog:");
        for (Product<? extends Category> p : catalog) {
            p.displayProduct();
        }
	}
}