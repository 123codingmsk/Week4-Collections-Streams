import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class RotateElements{
	
	public static <T> void rotateList(List<T> list, int rotateBy){
		int n = list.size();
		List<T> temp = new ArrayList<>(n);
		
		for (int i = 0; i < n; i++) {
            temp.add(null);
        }
		for(int i=0; i<n; i++){
			int placingIndex = ((i+1) + rotateBy) % n;
			temp.set(placingIndex, list.get(i));
		}
		for(int i=0; i<temp.size(); i++){
			list.set(i, temp.get(i));
		}
	}
	
	public static void main(String[] a){
		List<Integer> list = Arrays.asList(10,20,30,40,50);
		rotateList(list, 2);
		System.out.println(list);
	}	
}