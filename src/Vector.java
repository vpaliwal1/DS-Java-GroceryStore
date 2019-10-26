
public class Vector  {
	protected Object data[];
	protected int count;
	protected int capacity;
	
	public Vector(int capacity)
	{
		data = new Object[capacity];
		count = 0;
		this.capacity = capacity;
	}

	public int size()
	{
		return count;
	}
 
	public boolean isEmpty()
	{
		return size() == 0;
	}
	public boolean isFull() {
		return count>=capacity;
	}

	public Object get(int index)
	{
		return data[index];
	}
	public void extendCapacity() {
		Object data2[] = new Comparable[count*2];
		for(int i=0;i<count;i++) {
			data2[i]=data[i];
		}
		this.capacity= count*2;
		data = data2;
		
		
	}

	public void set(int index, Object obj)
	{
		data[index] = obj;
	}

	public boolean contains(Object obj)
	{
		for(int i=0;i<count;i++) {
			if(data[i]== obj)
				return true;
			
		}
		return false;
	}
	public int getIndex(Object o) {
		int index =0;
		for(int i=0;i<count;i++) {
			if(data[i]==o)
				index =i;
		}
		return index;
	}
	
	public void addFirst(Object item)
	{
		for(int i=count;i>=1;i--) {
			data[i]=data[i-1];
			
		}
		data[0]=item;
		count++;
		
	}

	public void addLast(Object o)
	{
		if(isFull())extendCapacity();
		data[count] = o;
		count++;
	}
	
	/*
	public boolean binarySearch(Object key)
	{
	int start = 0;
	int end = count - 1;
	while(start <= end)
	{
		int middle = (start + end + 1) / 2;
		if(key < data[middle]) end = middle -1;
		else if(key > data[middle]) start = middle + 1;
		else return true;
	}
	return false;
	}
	*/

	public Object getFirst()
	{
		return data[0];
	}

	public Object getLast()
	{
		return data[count-1];
	}
	public String toString() {
		String result = " ";
		for(int i=0;i<count;i++) {
			result += data[i].toString()+" ";
			
		}return result;
	}
	public void print() {
		for(int i=0;i<count;i++) {
			System.out.println(data[i]+" ");
		}
		System.out.println(" ");
	}
	public int find(Comparable o) {
		for(int i=0;i<count;i++) {
			if(data[i]==o)
				return i;
		}
		return -1;
		
	}

	public void removeLast()
	{
		data[count-1]=null;
		count--;
	} 

	public void removeFirst()
	{
		for(int i=0;i<count-1;i++) {
			data[i]=data[i+1];
		}
		count--;
	}
	public void reverse() {
		Object temp;
		for(int i=0;i<count/2;i++)
		{
			temp = data[i];
			data[i]=data[count-1-i];
			data[count-1-i]=temp;
		}
	}
	public Vector doubleData() {
		Vector doubled = new Vector(count*2);
		for(int i=0;i<count;i++) {
			doubled.addLast(data[i]);
			doubled.addLast(data[i]);
		}
		return doubled;
	}
	
	
	
	//public int compareTo(Object o) {
		//return 0;
	//}
	

}

