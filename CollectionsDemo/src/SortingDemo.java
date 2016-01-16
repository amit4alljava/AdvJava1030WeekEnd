import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*class SortById implements Comparator<Customer>{
	public int compare(Customer o1 , Customer o2){
		return o1.getId().compareTo(o2.getId());
	}
}

class SortByPrice implements Comparator<Customer>{
	public int compare(Customer o1 , Customer o2){
		return o1.getCreditLimit().compareTo(o2.getCreditLimit());
	}
}*/

class Customer implements Comparable<Customer>{

	private Integer id;
	private String name;
	private Double creditLimit;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", creditLimit="
				+ creditLimit + "]";
	}
	@Override
	public int compareTo(Customer c) {
	//	Customer c = (Customer)o;
		// TODO Auto-generated method stub
		//return this.name.compareToIgnoreCase(c.name);
		return c.name.compareTo(this.name);
				
	}
	
}
public class SortingDemo {

	public static void main(String[] args) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Customer ram = new Customer();
		ram.setId(1002);
		ram.setName("Ram");
		ram.setCreditLimit(9000.0);
		customerList.add(ram);
		
		Customer shyam = new Customer();
		shyam.setId(1001);
		shyam.setName("Shyam");
		shyam.setCreditLimit(19000.0);
		customerList.add(shyam);
		
		//Collections.sort(customerList, new SortById());
/*		Collections.sort(customerList,new Comparator<Customer>() {
			public int compare(Customer o1 , Customer o2){
				return o1.getId().compareTo(o2.getId());
			}
		});*/
		//Comparator<Customer> c= (o1,o2)->o1.getId().compareTo(o2.getId());
		Collections.sort(customerList,(o1,o2)->o1.getId().compareTo(o2.getId()));
		System.out.println("After Sort "+customerList);
		
		

	}

}
