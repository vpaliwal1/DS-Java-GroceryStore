
public class GroceryStore implements GroceryStoreInterface {
	private String groceryStore;
	private Dictionary myProducts;
	private Dictionary myFreshProducts;
	private Dictionary myClients;
	private int id;
	private Queue waitingRequestFresh;
	//private Dictionary myDepartments;
	private Graph departmentGraph;
	
	
	
	public GroceryStore(String name){
		System.out.println("Welcome to the "+ name+ " store.");
	this.groceryStore = name;
	myProducts = new Dictionary();
	myFreshProducts = new Dictionary();
	myClients = new Dictionary();
	id =0;
	waitingRequestFresh = new Queue();
	//myDepartments = new Dictionary();
	departmentGraph = new Graph();
	
	}
	/**
	 * Adds a product to the store 
	 * 
	 * @param name - represents the name of the new product
	 * @param price - represents the price of the new product
	 * @param barcodeId - is the bar-code number of the new product 
	 * @param count - is the number of items of the new product in the store
	 */
	

	public void addProduct(String department,String name, float price, int barcodeId, int count) {
		if(myProducts.contains(barcodeId)) {
			//float currentQty = ((Product)getProductByBarcode(barcodeId)).getQuantity();
			((Products)findProductByBarcode(barcodeId)).addQuantity(count);   //if product exist it will increase the quantity
		}
		else {
			Product newProduct = new Product(department,name,price,barcodeId,count);
			myProducts.add(barcodeId, newProduct);                                      //if product not present this will add as new product
		
			
		}
		
		
	}
	/**
	 * Adds a fresh product to the store
	 * 
	 * @param name - represents the name of the new fresh product
	 * @param pricePerKg - represents the price of the new fresh product
	 * @param barcodeId - is the bar-code number of the new fresh product (identifying only the type)
	 * @param amountInKg - is the amount in kilograms the new fresh product in the store
	 */

    
    
	public void addFreshProduct(String name, float pricePerKg, int barcode, float amountInKg) {
		if(myFreshProducts.contains(barcode)) {
			//float currentQty = ((Product)getFreshProductByBarcode(barcode)).getQuantity();
			((FreshProducts)findFreshProductByBarcode(barcode)).addQuantity(amountInKg);  //if fresh product exist it will increase the quantity
		}
		else {
			FreshProducts newFresh = new FreshProducts(name,pricePerKg,barcode,amountInKg);
			myFreshProducts.add(barcode, newFresh);                                          //if fresh product not present this will add as new fresh product
		
			
		}
		
	}
	
	/**
	 * Registers a new client in the store
	 * 
	 * @param name - name of the client
	 * @return a unique id number identifying the client
	 */
        
	
	public int addClient(String name) {
		id++;
		Client client = new Client(name, id);                     
		myClients.add(id, client);                                //this will add client with name and Id.
		//System.out.println("Your Client Id is : "+ id);
		//System.out.println("Client name: "+name);
		return id;
		
	}
	/**
	 * Adds a product to the basket for a specific client. Make sure you adjust
	 * the amount of the product that is available at the store for others. 
	 * 
	 * @param barcodeId - the bar code of the product that is added to the basket 
	 * @param count - number of the packages of the product that is added to the basket 
	 * @param customerId - the client id that is adding the product to the basket
	 */

	
	
	
	
	public void addToBasket(int barcodeId, int count, int customerId) {
		
		if (((Product)findProductByBarcode(barcodeId)).getQuantity()>= count){
			((Client)findClientById(customerId)).getBasket().addItem((Product)findProductByBarcode(barcodeId),count);  //this will add the product to basket
			((Product)findProductByBarcode(barcodeId)).removeQuantity(count);                                         // it will remove the quantity of product added in the basket
			}else
				System.out.println("Quantity is not enough");  //it will print if the quantity is not enough to add in Basket
			
		}
		
	
	/**
	 * Removes a product to the basket for a specific client. Make sure you adjust
	 * the amount of the product that is available at the store for others.
	 * 
	 * @param barcodeId - the bar code of the product that is removed added from the basket
	 * @param count - number of the packages of the product that is removed from the basket
	 * @param customerId - the client id that is removing the product from the basket
	 */
		
		
		
		


	@Override
	public void removeFromBasket(int barcodeId, int count, int customerId) {
		findClientById(customerId).getBasket().removeItem(((Product)findProductByBarcode(barcodeId)), count);  //this will remove the product in basket
		((Product)findProductByBarcode(barcodeId)).addQuantity(count);                                        // to update quantity after removing product
		
		
	}
	/**
	 * Prints the content of a basket for a specific client
	 * 
	 * @param customerId - the client id whose basket will be printed out
	 */

	@Override
	public void printBasket(int customerId) {
			findClientById(customerId).getBasket().print();  // this will print the basket present in basket class
			
				
		
	}
	/**
	 * Computes the total price of the basket for a specific client
	 * 
	 * @param customerId - the client id whose basket will be printed out
	 * @return total price of products in the basket
	 */

	@Override
	public float computeBasketPrice(int customerId) {
		System.out.println("The total price of items in basket are: ");
		
		return ((Client)findClientById(customerId)).getBasket().calculatePrice(); //this will call the calculate price method present in basket class to print total price of items
		
		
		
	
		
	
	}
	/**
	 * Requests an amount in kg of the fresh product. If the request is
	 * successful, it is automatically added to the basket. 
	 * 
	 * @param barcodeId - the bar code of the fresh product that is requested by the client
	 * @param amount - amount in kilograms that is requested by the client
	 * @param customerId - the client id of the client making the request
	 */

	@Override
	public void requestFreshProduct(int barcodeId, float amount, int customerId) {
		Request newRequest = new Request(barcodeId,amount,customerId);            //here we will request a fresh product
		waitingRequestFresh.push(newRequest);                                     // new request will be pushed to the queue on the basis of FIFO
			
		
		
		
	}
	/**
	 * Processes the next request in the queue. If the request can be produces
	 * then it adds the product to the basket. 
	 * 
	 * Note: Fresh product cannot be removed from the basket. Once it is
	 * requested it has to be paid by the client
	 * 
	 * @return true if the next request was successfully processed, false otherwise
	 */

	@Override
	public boolean serveNextRequest() {
		//return false;
		Request a = (Request)waitingRequestFresh.pop();
		int barcodeId= a.getBarcodeId();
		float amount = a.getAmount();
		int customerID = a.getID();
		float amountAvailable = ((FreshProducts) findFreshProductByBarcode(barcodeId)).getQuantity();
		if(amountAvailable>=amount) {                         //if the required amount is less than available amount the fresh product will be added to basket
			addFreshToBasket(barcodeId, customerID, amount);
			//System.out.println(a.toString());
			return true;
			
			
		}else {
			System.out.println("*******************");
			System.out.println("Not enough amount"); //this will print if amount is greater than available
			return false;
		} 
	}
	/**
	 * This method will print currently unserved requests that are waiting to be processed 
	 */

	@Override
	public void printUnservedRequests() {
    if(waitingRequestFresh.isEmpty()) 
    	System.out.println("No unreserved request"); //if there is nothing in the unreserved request
    else {
    	System.out.println("Requests are : ");
    	for(int i=0;i<waitingRequestFresh.size();i++) {
    		System.out.println(((Request)waitingRequestFresh.get(i)).toString()); //this will print the waiting request present in queue
    	}
    
    }
	    
		
	}
	/**
	 * This method adds a new department to the store
	 * 
	 * @param departmentName - is the name of the department that is added to the store
	 */

	public void addDepartment(String departmentName) {
		//Department department = new Department(departmentName);
		//myDepartments.add(departmentName, department);		
		departmentGraph.addNode(departmentName);           // this will add departments as nodes of graph
		
	}	
	
	/**
	 * This method will help in getting the product using barcode 
	 * @param productBarcode
	 */
	public Products findProductByBarcode(int Barcode) {
		Products product = ((Products)myProducts.find(Barcode));  //here i use dictionary and finding the product using barcode
		return product;
		
		
	}
	/**
	 * This method will help in getting the Clinet using ClientId 
	 * @param ClientId
	 */
	public Client findClientById(int clientId) {
		Client client = ((Client)myClients.find(clientId));     //here i use dictionary and finding the Client using clientID
		return client;
	}
	/**
	 * This method will help in getting the Fresh Product using Barcode
	 * @param productBarcode
	 */
	public Products findFreshProductByBarcode(int Barcode) {
		Products freshproduct = ((Products)myFreshProducts.find(Barcode)); //here i use dictionary and finding the fresh product using barcode
		return freshproduct;
		}
	
	/**
	 * This method will help in adding Fresh product to Basket
	 * @param barcodeId, customerId,amount
	 */
	public void addFreshToBasket(int barcodeId,int customerId,float amount) {
		
		findClientById(customerId).getBasket().addFreshProduct((FreshProducts)findFreshProductByBarcode(barcodeId), amount); // here we are adding fresh product to basket
		((FreshProducts)findFreshProductByBarcode(barcodeId)).removeFresh(amount);                                          // removing the quantity after addition from total quantity
		
	}
	/**
	 * Checkouts specified client and prints a bill.
	 * 
	 * @param customerId - the client id of the client that checkouts the items from the
	 *     basket and finalizes the purchase 
	 */
	
	public void checkout(int customerId) {
		System.out.println("*************************");
		System.out.println("The total items in "+findClientById(customerId).getName()+" basket is: ");
		((Client)findClientById(customerId)).getBasket().print();     //printing the items present in Basket of client
		System.out.println();
		
		System.out.println("The total price for "+findClientById(customerId).getName()+" is: ");
		System.out.println(((Client)findClientById(customerId)).getBasket().calculatePrice()); // printing the total amount as bill using client id
		
		((Client)findClientById(customerId)).checkout();	 //here we are calling the checkout method from the basket class
		
		
		
		
	}
	
	/**
	 * Connecting 2 departments. Two departments are connected when there is a direct aisle
	 * between them. 
	 * 
	 * @param department1 - name of the first department that will be connected.
	 * @param department2 - name of the second department that will be connected.
	 */
	
	public void connectDepartments(String department1, String department2) {
		//Department from = (Department)findDepartmentByName(department1);
		//Department to = (Department)findDepartmentByName(department2);
		
		departmentGraph.addEdge(department1, department2,1);  //connecting departments as nodes in graph
		
		
		
	}
	//public void path(String department1,String department2) {
		//System.out.println (departmentGraph.Path(department1, department2));
		
	//}
	/**
	 * Prints the shortest path between 2 departments. 
	 * 
	 * @param department1 - name of the source department.
	 * @param department2 - name of the destination department.
	 */
	

	public void shortestPath(String department1, String department2) {
		//System.out.println(departmentGraph.Path(department1,department2));
		
	}
	/**
	 * Prints a summary of previous purchases
	 * 
	 * @param customerId - the client id for which the shopping history will be printed
	 */
	@Override
	public void printShoppingHistory(int customerId) {
		System.out.println("The items in the history of "+findClientById(customerId).getName()+" : ");
		((Client)findClientById(customerId)).printHistory();    //printing the shopping history from bakset class
		
		
		
	}
	/**
	 * Adds a product to the shopping list of a specific client. 
	 * 
	 * @param barcodeId - the bar code of the product that is added to the shopping list 
	 * @param count - number of the packages of the product that is added to the shopping list
	 * @param customerId - the client id that is adding the product to the shopping list
	 */
	
	public void addToShoppingList(int barcodeId, int count, int customerId) {
		
		
			((Client)findClientById(customerId)).getShoppingList().addItem((Product)findProductByBarcode(barcodeId),count); //adding the product to the client shopping list
			((Product)findProductByBarcode(barcodeId)).removeQuantity(count);  //removing quantity after addition
			
			
		}
	/**
	 * Removes all items from the shopping list. 
	 * 
	 * @param customerId - the client id for which the shopping list will be cleared.
	 */
	
	public void clearShoppingList(int customerId) {
		
		((Client)findClientById(customerId)).clearShoppingList(); //clear the shopping list of client
	}
	/**
	 * Prints optimal path to buy all products from the shopping list 
	 * 
	 * @param customerId - the client id for which the shopping list will be cleared.
	 */
	public void printsOptimalPath(int customerId) {
		
		
	}
	
	
	}



