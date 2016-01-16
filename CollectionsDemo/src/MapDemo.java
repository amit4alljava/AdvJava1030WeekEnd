import java.util.ArrayList;
import java.util.HashMap;


public class MapDemo {

	public static void main(String[] args) {
		HashMap<String,ArrayList<Integer>> phoneMap = new HashMap<>();
		ArrayList<Integer> amitPhone = new ArrayList<>();
		amitPhone.add(2222);
		amitPhone.add(3333);
		phoneMap.put("amit",amitPhone);
		/*phoneMap.put("amit",44444);
		phoneMap.put("ram",3333);*/
		System.out.println(phoneMap.get("amit"));

	}

}
