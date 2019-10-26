
public class Main {
	
	
	public static void main(String args[]) {
		
		
		
		GroceryStore store = new GroceryStore("Lidl");
		
		//Adding Departments in store
		store.addDepartment("Entry");
		store.addDepartment("Fruits");
		store.addDepartment("Drinks");
		store.addDepartment("Diary");
		store.addDepartment("Chocolates");
		store.addDepartment("Spices");
		store.addDepartment("Alcohol");
		store.addDepartment("Bakery");
		store.addDepartment("Pizza");
		store.addDepartment("Veggies");
		store.addDepartment("Exit");
		
		
		//Connecting Departments
		store.connectDepartments("Entry", "Fruits");
		store.connectDepartments("Fruits", "Drinks");
		store.connectDepartments("Fruits", "Alcohol");
		store.connectDepartments("Fruits", "Entry");
		store.connectDepartments("Drinks", "Fruits");
		store.connectDepartments("Drinks", "Diary");
		store.connectDepartments("Drinks", "Spices");
		store.connectDepartments("Diary", "Chocolates");
		store.connectDepartments("Diary", "Drinks");
		store.connectDepartments("Alcohol", "Fruits");
		store.connectDepartments("Alcohol", "Veggies");
		store.connectDepartments("Alcohol", "Spices");
		store.connectDepartments("Alcohol", "Fruits");
		store.connectDepartments("Spices", "Chocolates");
		store.connectDepartments("Spices", "Drinks");
		store.connectDepartments("Spices", "Alcohol");
		store.connectDepartments("Spices", "Pizza");
		store.connectDepartments("Chocolates", "Diary");
		store.connectDepartments("Chocolates", "Bakery");
		store.connectDepartments("Bakery", "Chocolates");
		store.connectDepartments("Bakery", "Pizza");
		store.connectDepartments("Pizza", "Veggies");
		store.connectDepartments("Pizza", "Spices");
		store.connectDepartments("Pizza", "Bakery");
		store.connectDepartments("Veggies", "Alcohol");
		store.connectDepartments("Veggies", "Pizza");
		store.connectDepartments("Veggies", "Exit");
		store.connectDepartments("Exit", "Veggies");
		
		
		
		
		//Adding Product to the store
		store.addProduct("Fruits","Oranges",3, 10, 20);
		store.addProduct("Fruits","Banana",2, 2, 50);
		store.addProduct("Fruits","Grapes",8, 3, 25);
		store.addProduct("Drinks","Cold Drink", 5, 15, 75);
		store.addProduct("Drinks","Juice", 2, 5, 30);
		store.addProduct("Vegies","Patato",1, 12, 23);
		store.addProduct("Vegies","Capsicum",3, 13, 25);
		store.addProduct("Vegies","Brinjal",2, 14, 26);
		store.addProduct("Chocolates","Toblerone",11, 15, 15);
		store.addProduct("Chocolates","Milk Chocolates",12, 16, 20);
		store.addProduct("Bakery","Bread",3, 30, 15);
		store.addProduct("Bakery","Cookies",4, 31, 25);
		store.addProduct("Diary","Yogurt",5, 32, 20);
		store.addProduct("Diary","Milk",1, 33, 40);
		store.addProduct("Alchol","Beer",2, 34, 29);
		store.addProduct("Alchol","Wine",15, 35, 20);
		store.addProduct("Spices","Chilly",2, 36, 50);
		store.addProduct("Spices","Bay Leaves",5, 37, 15);
		store.addProduct("Pizza","Margherita",10, 38, 10);
		store.addProduct("Pizza","BBQ",15, 39, 5);
		store.addProduct("Cosmetic","Body Lotion",12, 40, 10);
		store.addProduct("Cosmetic","Shower Gel",8, 41, 20);
		
		
		
		//Adding Fresh Product to Store
		store.addFreshProduct("Apple", 15,7, 3);
		store.addFreshProduct("Milk", 1, 12, 10);
		store.addFreshProduct("Kiwi", 8, 19,5);
		store.addFreshProduct("Tamatto", 3, 20,30);
		store.addFreshProduct("Beans", 5, 21,10);
		store.addFreshProduct("Patato", 1, 22,30);
		store.addFreshProduct("Oranges", 4, 23,40);
		
		
		//Adding Clients to Store
		store.addClient("Vaibav Paliwal");
		store.addClient("Rahul Yadav");
		store.addClient("Ankit Singh");
		store.addClient("Joseph");
		store.addClient("Tom");
		store.addClient("Akshay");
		
		
		//Adding items to Basket
		store.addToBasket(10,2,1);
		store.addToBasket(15, 2, 1);
		store.addToBasket(3, 3, 1);
		store.addToBasket(12, 1, 1);
		store.addToBasket(34, 5, 2);
		store.addToBasket(35, 2, 2);
		store.addToBasket(38, 1, 2);
		store.addToBasket(39, 1, 2);
		store.addToBasket(30, 2, 5);
		store.addToBasket(33, 5, 5);
		store.addToBasket(16, 2, 5);
		
		
		//Print basket using customerId
		//store.printBasket(1);
		//store.printBasket(2);
		//store.printBasket(5);
		
		//RequestFreshProduct
		// For Client 1
		store.requestFreshProduct(7, 2, 1);
		store.requestFreshProduct(12, 2, 1);
		store.requestFreshProduct(21, 2, 1);
		store.requestFreshProduct(23, 3, 1);
		// For Client 2
		store.requestFreshProduct(7, 2, 2);
		store.requestFreshProduct(19, 1, 2);
		store.requestFreshProduct(19, 1, 2);
		
		
		
		// Serve Next Request
		store.serveNextRequest();
		store.serveNextRequest();
		store.serveNextRequest();
		store.serveNextRequest();
		//store.serveNextRequest();
		//store.serveNextRequest();
		//store.serveNextRequest();
		
		
		// Again we will check the fresh product is added or not
        //store.printBasket(1);
		 // store.printBasket(2);
        
        
        // Compute Basket Price using CliendId
        
        //System.out.println(store.computeBasketPrice(1));
        
        
        //This method will print the unreserved requests
		//store.printUnservedRequests();
        
        //Add product to the shopping List of Client directly
		store.addToShoppingList(10,1,1);
		
		//Checkout and print bills of Client using Client Id
		
		store.checkout(1);
		System.out.println();
		
		//To print shopping history of Client using ClientId
		
		//store.printShoppingHistory(2);
		
		store.printShoppingHistory(1);
		
		
		//This method will clear the shopping list of Client.
		store.clearShoppingList(1);
		
		//This will print the existing path between two nodes
		
		//store.path("Entry", "Exit");
		
	
		
		
	
		
		
				
		
		
		
		
	}

}
