

public class LinkedList implements Comparable {
	private class ListElement {
		private Comparable el1;
		private ListElement el2;

		public ListElement(Comparable el, ListElement nextElement) {
			el1 = el;
			el2 = nextElement;
		}

		public ListElement(Comparable el) {
			this(el, null);
		}

		public Comparable first() {
			return el1;
		}

		public ListElement rest() {
			return el2;
		}

		public void setFirst(Comparable value) {
			el1 = value;
		}

		public void setRest(ListElement value) {
			el2 = value;
		}
	}
	
	private ListElement head;

	public LinkedList() {
		head = null;
	}

	public void addFirst(Comparable o) {
		head = new ListElement(o, head);
		
	}
	public void addLast(Comparable o) {
		if(head==null) 
			head = new ListElement(o,head);
		else {
			ListElement d = head;
			while(d.rest()!=null) {
				d=d.rest();
			}
			d.setRest(new ListElement(o));
		}
	}
	public int size() {
		int count =0;
		ListElement d = head;
		while(d!=null) {
			d=d.rest();
			count++;
		}
		return count;
	}
	

	public Comparable getFirst() {
		return head.first();
	}
	public Comparable getLast() {
		return this.get(this.size()-1);
		//ListElement d = head;
		//  while(d.rest()!=null) {
		//	  d=d.rest();
		 // }
		 // return d.first();
		  }
	public void removeFirst() {
		head=head.rest();
	}
	public String toString() {
		String s= "(";
		ListElement d= head;
		while(d!=null) {
			s+= d.first().toString();
			s+= " ";
			d=d.rest();
		}
		s+= ")";
		return s;
	}
	public Comparable get(int n) {
		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		return d.first();
	}
	public boolean isEmpty() {
		return this.size()==0;
	}
	public void set(int n, Comparable O) {
		ListElement d= head;
		while(n>0) {
			d=d.rest();
			n--;
		}
		d.setFirst(O);
	}
	public void remove(int n) {
		ListElement d = head;
		while(n>1) {
			d=d.rest();
			n--;
		}
		d.setRest(d.rest().rest());
	}
	public boolean contains(Comparable o) {
		ListElement d = head;
		while(d!=null) {
			if(d.first()==o)
				return true;
			d=d.rest();
		}
		return false;
	}
	public void print() {
		System.out.println(this.toString());
	}
	public void removeLast() {
		if(this.size()==0) {
			System.out.println("Empty List");
		}
		else if(this.size()==1) {
			this.head = null;
		}else {
			ListElement d = head;
			int n = this.size()-1;
			while(n>1) {
				d=d.rest();
				n--;
			}
			d.setRest(null);
		}
	}
	public Comparable find(Comparable o) {
		Comparable result = null;
		ListElement d = head;
		while(d!=null) {
			if(d.first().toString().equals(o)) {
				result = (Comparable) d.first();
				break;
			}
			d=d.rest();
		}
		return result;
	}
	public void reverse() {
		Comparable d;
		for(int i=0;i<this.size()/2;i++) {
			d = this.get(i);
			this.set(i, this.get(this.size()-1-i));
			this.set(this.size()-1-i, d);
		}
	}
	public LinkedList doubleData() {
		LinkedList doubled = new LinkedList();
		ListElement d= head;
		while(d!=null) {
			doubled.addLast(d.first());
			doubled.addLast(d.first());
			d=d.rest();
		}
		return doubled;
	}

	
	public void append(LinkedList List2) {
		ListElement d = List2.head;
		while(d!=null) {
			this.addLast(d.first());
			d = d.rest();
		}
	}
	public void addSorted(Comparable o) {
		if(head==null)
			head = new ListElement(o,null);
		else if(head.first().compareTo(o)>0) {
			head = new ListElement(o,head);
		}else {
			ListElement d = head;
			while((d.rest()!=null)&&(d.rest().first().compareTo(o)<0)){
				d=d.rest();
				
			}
			ListElement next = d.rest();
			d.setRest(new ListElement(o,next));
		}
	}
	public int compareTo(Object o) {
		return 0;
	}


}
