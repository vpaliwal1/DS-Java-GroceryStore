
public class Department implements Comparable {
	private String department;
	//private LinkedList products;
	
	
	public Department(String name) {
		department = name;
		//LinkedList products = new LinkedList();
		
		
		
	}
	public String getName() {
		return department;
	}
	@Override
	public int compareTo(Object o) {
		Department x = (Department) o;
		return ((Comparable)department).compareTo(x.getName());
	}

}
