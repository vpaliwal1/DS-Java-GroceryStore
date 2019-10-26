

public class Stack implements Comparable {
		private LinkedList data;

		public Stack() {
			data = new LinkedList();
		}

		public void push(Comparable o) {
			data.addFirst(o);
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

