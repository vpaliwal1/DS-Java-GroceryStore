
public class Request implements Comparable {
	private int ID;
	private float amount;
	private int barcode;
	
	public Request(int barcodeId,float amountProduct,int customerId) {
		amount = amountProduct;
		barcode = barcodeId;
		ID = customerId;
	}
	public int getBarcodeId() {
		return barcode;
	}
	public float getAmount() {
		return amount;
	}
	public int getID() {
		return ID;
	}
	public String toString() {
		return "***********" + "\nClientId: "+ID+"\nBarcode: "+barcode+"\nAmount: "+amount;
	
	}
	@Override
	public int compareTo(Object o) {
		Request x = (Request) o;
		return ((Comparable) barcode).compareTo(x.getBarcodeId());
	}

}
