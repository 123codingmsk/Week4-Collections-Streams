interface MealPlan{
	void displayType();
	boolean isValid();
}

class VegetarianMeal implements MealPlan{
	public void displayType(){
		System.out.println("Vegetarian Meal including the milk and egg");
	}
	public boolean isValid(){
		return true;
	}
}

class VeganMeal implements MealPlan{
	public void displayType(){
		System.out.println("Vegan Meal with rice and tofu");
	}
	public boolean isValid(){
		return false;
	}
}

class Meal<T extends MealPlan>{
	private T product;
	
	Meal(T product){
		this.product = product;
	}
	
	public void serve(){
		System.out.print("Serving: ");
		product.displayType();
	}
	
	public T getProduct(){
		return product;
	}
}

class Validate{
	public static <T extends MealPlan> Meal<T> generatePlan(T product){
		if(product.isValid()){
			return new Meal<>(product);
		}else{
			//System.out.println("Invalid Meal type!");
			throw new IllegalArgumentException("Invalid meal Type!");
		}
	}
}

public class MealPlanGenerator{
	public static void main(String[] a){
		Meal<VegetarianMeal> vm = Validate.generatePlan(new VegetarianMeal());
		vm.serve();
		
		Meal<VeganMeal> vvm = Validate.generatePlan(new VeganMeal());
		vvm.serve();
	}
}