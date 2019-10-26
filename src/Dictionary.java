public class Dictionary 
{
	private LinkedList data;
	
	
	public Dictionary()
	{
		data = new LinkedList();
	}

	public void add(Comparable key,Object value)
	{
		boolean j = false;
		for(int i=0;i<data.size();i++) {
			if(((DictionaryPair) data.get(i)).getKey() == key) {
				j = true;
				((DictionaryPair) data.get(i)).setValue(value);
			}		
		}
		if(j == false) {
			DictionaryPair newPair = new DictionaryPair(key ,value);
			data.addLast(newPair);;
		}
	}
	public int size() {
		return data.size();
	}
	
	public int findPosition (Comparable key)
	{
		int index = -1;
		for(int i=0;i<data.size();i++) {
			if(((DictionaryPair) data.get(i)).getKey()==key)
			index = i;
		}
		return index;
	}
	
	public Object find (Comparable key)
	{
		int index = this.findPosition(key);
		if (index == -1)
			return null;
		else
			return ((DictionaryPair) data.get(index)).getValue();
	}
	public Object remove(Comparable key) {
		int n =0;
		for(int i=0;i<data.size();i++) {
			if(((DictionaryPair) data.get(i)).getKey()==key)
				data.remove(i);
		    
		}
		return data;
			}
	public void print() {
		data.print();
	}
	public boolean contains(Comparable key) {
		boolean c = false;
		for(int i=0;i<data.size();i++) {
			if(((DictionaryPair) data.get(i)).getKey()==key) 
				c = true;		
		}
		return c;
	
	}
}
