
public class FreshProducts extends Products{
		
	public FreshProducts(String nameFp, float priceFp, int barcodeId, float amountInKg) {
		name = nameFp;
		price = priceFp;
		barCode = barcodeId;
		quantity = amountInKg;
	}
	public void removeFresh(float amount) {
		quantity = quantity - amount;
		
	}
	public String toString() {
		return "\nName: "+name + " "+"\nPrice: "+price +" "+"\nBarcode: "+ barCode+" "+"\nQuantity: "+ quantity;
	}

}
