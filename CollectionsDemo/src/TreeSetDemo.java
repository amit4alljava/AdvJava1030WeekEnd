import java.util.Comparator;
import java.util.TreeSet;

class Book { //implements Comparable<Book>{
	String name;
	String author;
	double price;
	Book(String name, String author, double price){
		this.name = name;
		this.author = author;
		this.price = price;
	}
	@Override
	public String toString(){
		return this.name+" "+this.author+" "+this.price;
	}
	
	public boolean equals(Object o){
		Book book = (Book)o;
		if(this.name.equals(book.name) 
				&& this.author.equals(book.author)
				&& this.price==book.price){
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		if(this.name.equals("Head First")){
			return 10;
		}
		else
		{
			return 20;
		}
		
	}
	/*@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return this.name.compareToIgnoreCase(o.name);
	}*/
}
class SortByAuthor implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.author.compareToIgnoreCase(o2.author);
	}
	
}
public class TreeSetDemo {

	public static void main(String[] args) {
		Book java = new Book("Head First","Sierra",900.0);
		Book java2 = new Book("Head First","Sierra",900.0);
		Book c = new Book("Let Us C","Yashwant",500.0);
		Book c2 = new Book("Let Us C","Yashwant",500.0);
		//TreeSet<Book> set = new TreeSet<>();  // Comparable
		SortByAuthor sa = new SortByAuthor();
		//TreeSet<Book> set = new TreeSet<>(sa);
		/*TreeSet<Book> set = new TreeSet<>(new Comparator<Book>() {
		public int compare(Book o1 , Book o2){
			return o1.author.compareToIgnoreCase(o2.author);
		}
		});*/
		TreeSet<Book> set = 
				new TreeSet<>((o1,o2)
						->o1.author.
						compareToIgnoreCase(o2.author));
		
		set.add(java);
		set.add(java2);
		set.add(c);
		set.add(c2);
		System.out.println(set);
		
		

	}

}
