import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
class Product implements Comparable<Product>{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(Product p){
		return this.name.compareTo(p.name);
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}
	
}
class Order{
	private int id;
	private String name;
	private Date delDate;
	private ArrayList<Product> productList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDelDate() {
		return delDate;
	}
	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}
	
	public ArrayList<Product> getProductList() {
		return productList;
	}
	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", delDate=" + delDate
				+ ", productList=" + productList + "]";
	}
	
	
}

class CashCustomer{
	private int id;
	private String name;
	HashMap<String,HashSet<Address>> addressMap ;
	private HashMap<Integer,Order> orderMap ;
	CashCustomer(int id, String name){
		this.id = id;
		this.name = name;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public HashMap<String, HashSet<Address>> getAddressMap() {
		return addressMap;
	}
	public void setAddressMap(HashMap<String, HashSet<Address>> addressMap) {
		this.addressMap = addressMap;
	}
	
	
	public HashMap<Integer, Order> getOrderMap() {
		return orderMap;
	}
	public void setOrderMap(HashMap<Integer, Order> orderMap) {
		this.orderMap = orderMap;
	}
	@Override
	public String toString() {
		return "CashCustomer [id=" + id + ", name=" + name + ", addressMap="
				+ addressMap + ", orderMap=" + orderMap + "]";
	}
	
	
	
}
class Address{
	private String city;
	private String state;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + "]";
	}
	@Override
	public int hashCode(){
		return city.length();
	}
	public boolean equals(Object o){
		Address address = (Address)o;
		if(this.state.equals(address.state) && this.city.equals(address.city)){
			return true;
		}
		else
		{
			return false;
		}
	}
	
}

public class CollectionExample {

	public static void main(String[] args) {
		CashCustomer ram = new CashCustomer(1001,"Ram");
		Address ramoffice1 = new Address();
		ramoffice1.setCity("Delhi");
		ramoffice1.setState("Delhi");
		HashSet<Address> ramOfficeSet = new HashSet<Address>();
		ramOfficeSet.add(ramoffice1);
		Address ramoffice2 = new Address();
		ramoffice2.setCity("Mumbai");
		ramoffice2.setState("Mumbai");
		
		ramOfficeSet.add(ramoffice2);
		
		Address ramoffice3 = new Address();
		ramoffice3.setCity("Mumbai");
		ramoffice3.setState("Mumbai");
		
		ramOfficeSet.add(ramoffice3);
		HashMap<String,HashSet<Address>> addressMap = new HashMap<>();
		addressMap.put("office", ramOfficeSet);
		
		Address resAddress1 = new Address();
		resAddress1.setCity("Delhi");
		resAddress1.setState("Delhi");
		
		Address resAddress2 = new Address();
		resAddress2.setCity("Delhi");
		resAddress2.setState("Delhi");
		
		HashSet<Address> resSet = new HashSet<>();
		resSet.add(resAddress1);
		resSet.add(resAddress2);
		addressMap.put("res",resSet);
		ram.setAddressMap(addressMap);
		//************************************************
		Order firstOrder = new Order();
		firstOrder.setId(1001);
		firstOrder.setName("Mobile Order");
		firstOrder.setDelDate(new Date());
		ArrayList<Product> productList = new ArrayList<>();
		Product p1 = new Product();
		p1.setId(10);
		p1.setName("Nokia");
		productList.add(p1);
		 p1 = new Product();
		p1.setId(20);
		p1.setName("Apple");
		productList.add(p1);
		Collections.sort(productList);
		firstOrder.setProductList(productList);
		HashMap<Integer,Order> orderMap = new HashMap<>();
		orderMap.put(firstOrder.getId(),firstOrder);
		Order secondOrder = new Order();
		secondOrder.setId(1002);
		secondOrder.setName("LED Order");
		secondOrder.setDelDate(new Date());
		
		orderMap.put(secondOrder.getId(),secondOrder);
		ram.setOrderMap(orderMap);
		CashCustomer shyam = new CashCustomer(1002,"Shyam");
		HashMap<String,CashCustomer> customerMap = new HashMap<>();
		customerMap.put("ram", ram);
		customerMap.put("shyam", shyam);
		System.out.println("Enter the Customer Name to Search");
		Scanner scanner = new Scanner(System.in);
		String customerKey= scanner.next();
		CashCustomer customer = customerMap.get(customerKey);
		if(customer!=null){
			System.out.println("Found...");
			System.out.println("Customer Id "+customer.getId());
			System.out.println("Name "+customer.getName());
			//System.out.println(customer);
			System.out.println("Enter the Type of Address u want to see");
			String type = scanner.next();
			HashSet<Address> addressSet = customer.getAddressMap().get(type);
			if(addressSet!=null){
				System.out.println("Address is "+addressSet);
			}
			else
			{
				System.out.println("Wrong Address Type....");
			}
			System.out.println("Orders are "+customer.getOrderMap().get(1001));
		}
		else
		{
			System.out.println("Not Found...");
		}
		

	}

}
