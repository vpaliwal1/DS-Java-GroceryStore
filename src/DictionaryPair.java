
public class DictionaryPair implements Comparable{
	
	private Comparable key;
	private Object value;
	
	public DictionaryPair (Comparable  someKey ,Object  someValue){
		key = someKey;
		value = someValue;
		
	}
	public Comparable getKey(){
		return key;
		
	}
	public Object getValue(){
		return value;
		
	}
	public void setKey (Comparable newKey){
		key = newKey;
		
	}
	public void setValue(Object newValue){
		value = newValue;
	}
	public String toString() {
		return "(" + key + ": " + value + ")";
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}


