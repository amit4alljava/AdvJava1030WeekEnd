import java.util.HashSet;


public class HashSetDemo {

	public static void main(String[] args) {
		Book java = new Book("Head First","Sierra",900.0);
		Book java2 = new Book("Head First","Sierra",900.0);
		Book c = new Book("Let Us C","Yashwant",900.0);
		Book c2 = new Book("Let Us C","Yashwant",500.0);
		HashSet<Book> set = new HashSet<>();
		set.add(java);
		set.add(java2);
		set.add(c);
		set.add(c2);
		System.out.println(set);
		System.out.println(java.hashCode());
		System.out.println(java2.hashCode());
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		

	}

}
