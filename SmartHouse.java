package Generics;

import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem{
	private String name;
	private double price;
	
	WarehouseItem(String name, double price){
		this.name = name;
		this.price = price;
	}
	
	public String getName(){
		return name;
	}
	
	public double getPrice(){
		return price;
	}
	
	abstract void display();
}

class Electronics extends WarehouseItem{
	private String brand;
	
	Electronics(String name, double price, String brand){
		super(name, price);
		this.brand = brand;
	}
	
	public String getBrand(){
		return brand;
	}
	
	@Override
	public void display(){
		System.out.println("Electronics: "+getName());
		System.out.println("Brand: "+getBrand());
		System.out.println("Price: "+getPrice());
		System.out.println();
	}
}

class Groceries extends WarehouseItem{
	private String expirydate;
	
	Groceries(String name, double price, String expirydate){
		super(name, price);
		this.expirydate = expirydate;
	}
	
	public String getExpirydate(){
		return expirydate;
	}
	
	@Override
	public void display(){
		System.out.println("Groceries: "+getName());
		System.out.println("Price: "+getPrice());
		System.out.println("Expiry date: "+getExpirydate());
		System.out.println();
	}
}

class Furniture extends WarehouseItem{
	private String material;
	
	Furniture(String name, double price, String material){
		super(name, price);
		this.material = material;
	}
	
	public String getMaterial(){
		return material;
	}
	
	@Override
	public void display(){
		System.out.println("Furniture: "+getName());
		System.out.println("Material: "+getMaterial());
		System.out.println("Price: "+getPrice());
		System.out.println();
	}
}

class Storage<T extends WarehouseItem>{
	private List<T> items;
	
	Storage(){
		items = new ArrayList<>();
	}
	
	public void addItem(T item){
		items.add(item);
	}
	
	public List<T> getItems(){
		return items;
	}
}

class WareHouseUtils{
	public static void displayAllItems(List<? extends WarehouseItem> items){
		for(WarehouseItem item : items){
			item.display();
		}
	}
}

public class SmartHouse{
	public static void main(String[] a){
		Storage<Electronics> elecStorage = new Storage<>();
        elecStorage.addItem(new Electronics("Smartphone", 699.99, "Samsung"));
        elecStorage.addItem(new Electronics("Laptop", 1299.49, "Dell"));

        Storage<Groceries> grocStorage = new Storage<>();
        grocStorage.addItem(new Groceries("Apples", 4.99, "2025-05-01"));
        grocStorage.addItem(new Groceries("Milk", 2.49, "2025-04-25"));

        Storage<Furniture> furnStorage = new Storage<>();
        furnStorage.addItem(new Furniture("Chair", 79.99, "Wood"));
        furnStorage.addItem(new Furniture("Table", 159.99, "Metal"));

        System.out.println("Electronics:");
        WareHouseUtils.displayAllItems(elecStorage.getItems());

        System.out.println("\n Groceries:");
        WareHouseUtils.displayAllItems(grocStorage.getItems());

        System.out.println("\n Furniture:");
        WareHouseUtils.displayAllItems(furnStorage.getItems());
	}
}