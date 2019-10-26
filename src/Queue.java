
public class Queue implements Comparable {
	private LinkedList data;

	public Queue() {
		data = new LinkedList();
	}

	public void push(Comparable o) {
		data.addLast(o);
	}
	public Comparable get(int n) {
		return data.get(n);
	}

	public Comparable pop() {
		Comparable top = data.getFirst();
		data.removeFirst();
		return top;
	}

	public Comparable top() {
		return data.getFirst();
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	public void print() {
		data.print();
	}

	public int compareTo(Object o) {
		return 0;
	}

}
