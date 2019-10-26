
public class Product extends Products {
	
	public Product(String depart,String nameProduct, float priceProduct, int barCodeId, int quant) {
		name = nameProduct;
		price = priceProduct;
		barCode = barCodeId;
		quantity = quant;
		department = depart;
	}
	public String toString() {
		return "\nDepartment: "+department+" "+"\nName: "+name + " "+"\nPrice: "+price +" "+"\nBarcode: "+ barCode+" "+"\nQuantity: "+ quantity;
	}

}
