
public class Client implements Comparable{
	private String clientName;
	private int clientID;
	private Basket basket;
	private Vector history;
	private Basket shoppingList;
	private Graph optimalPath;
	
	
	public Client(String name, int Id) {
		clientName = name;
		clientID = Id;
		basket = new Basket();
		history = new Vector(20);
		shoppingList = new Basket();
		optimalPath = new Graph();
		
	
	}
	public void addBasket(Product products, int qty) {
		basket.addItem(products,qty);
	}
	
	public void clearShoppingList() {
		shoppingList = null;
	}
		
	public void removeBasket(Product products, int quantity) {
		basket.removeItem(products,quantity);
	}
	public void Client1(String name) {
		this.clientName = name;
		
	}
	//public void addFreshProduct(FreshProducts products,float qty){
		//basket.addFreshProduct(products,qty);
	//}
	
	
	
	public Basket getBasket() {
		return basket;
	}	
	
	public String getName() {
		return clientName;
		
	}
	public double getId() {
		return clientID;
		
	}
	public void removeAll() {
		basket.removeAll();
	}
	public void printAll() {
		basket.print();
	}
	public float computePrice() {
		return basket.calculatePrice();
	}
	public String toString() {
		return "Client name is :" + " "+ clientName+"Client Id is  :"+ " "+ clientID+" ";
	}
	public Vector gethistory() {
		return history;
	}
	public void checkout() {
		history.addLast(basket);
		this.basket = new Basket();
		}
	public void printHistory() {
		for(int i=0;i<history.size();i++) {
			((Basket)history.get(i)).print();
		}
	}

	@Override
	public int compareTo(Object o) {
		Client x = (Client) o;
		return ((Comparable)clientID).compareTo(x.getId());
		//return 0;
	}
	public Basket getShoppingList() {
		
		return shoppingList;
	}
	public Graph pathL() {
		
	return optimalPath;
	
	}


}
