

public class Graph {
	private class Node implements Comparable{
		private Comparable info;
		private LinkedList edges;
		private boolean visited = false;
		
		public Node(Comparable label) {
			info = label;
			edges = new LinkedList();
			
		}
		public void setVisited(boolean val) {
			visited = val;
		}
		public boolean isVisited() {
			return visited;
		}
		public  void addEdge(Edge e) {
			edges.addLast(e);
		}
		
		public int compareTo(Object o) {
			Node n = (Node) o;
			return n.info.compareTo(info);
		}
		public Comparable getLabel() {
			return info;
		}
		public LinkedList getEdges() {
			return edges;
		}
		public String toString() {
			return this.getLabel().toString();
		}
		
	}
	private class Edge implements Comparable{
		private Node toNode;
		private int weight;
		
		public Edge(Node to, int w) {
			toNode = to;
			weight = w;
		}
		public String toString() {
			return toNode.toString() + "(Weight "+ weight+ ")";
		}
		public int getWeight() {
			return weight;
		}
		public int compareTo(Object o) {
			Edge n = (Edge) o;
			return n.toNode.compareTo(toNode);
		}
	}
	private LinkedList nodes;
	public Graph() {
		nodes = new LinkedList();
	}
	public int nrNodes(){
		return nodes.size();
	}
	public Node getNode(int i){		
		return (Node)nodes.get(i);
	}
	public void addNode(Comparable label) {
		nodes.addLast(new Node(label));
	}
	public Comparable getNodeInfo(int i){	
		Node node = (Node)nodes.get(i);
		return node.info;
	}
	public void setUnvisitedAll() {
		for (int i=0;i<nodes.size();i++) 
			((Node) nodes.get(i)).setVisited(false);
		}
		private Node findNode(Comparable nodeLabel) {
			 Node res = null;
			 for (int i = 0; i < nodes.size(); i++) {
			 Node n = (Node) nodes.get(i);
			if (n.getLabel() == nodeLabel) {
			res = n;
			break;
			 }
			 }
			 return res; 
			//return (Node) nodes.find(nodeLabel);
	}
		public boolean findPath(Comparable nodeLabel1, Comparable nodeLabel2) {
			this.setUnvisitedAll();
			Node startState = findNode(nodeLabel1);
			Node endState = findNode(nodeLabel2);
			Stack toDoList = new Stack();
			
			toDoList.push(startState);
			while (!toDoList.isEmpty()) {
				Node current = (Node) toDoList.pop();
				
				current.setVisited(true);
				if (current == endState)
					return true;
				else {
					for (int i = 0; i < current.edges.size(); i++) {
						Edge e = (Edge) current.edges.get(i);
						
						if (e.toNode.isVisited() == false)
							toDoList.push(e.toNode);
					}
				}
			}
			return false;
		}
		
		
		 public LinkedList findPathList(Comparable nodeLabel1, Comparable nodeLabel2) {
			 
			Node startState = findNode(nodeLabel1);
			Node endState = findNode(nodeLabel2);
			LinkedList pathList = new LinkedList ();
			Stack toDoList = new Stack();
			LinkedList visitedList = new LinkedList ();
			toDoList.push(startState);
		    while (!toDoList.isEmpty()) { 	
				Node current = (Node) toDoList.pop();
				visitedList.addFirst(current);
				pathList.addLast(current);
			   
				if (current.equals(endState)) {		
					return pathList;		
					} else {		
					    for (int i = 0; i < current.edges.size(); i++) {		    	
					        Edge e = (Edge) current.edges.get(i);  
					        if (!visitedList.contains(e.toNode)) {
					             toDoList.push(e.toNode);		             
					              }   
					        if (e.toNode.equals(endState))
					               break;
					         }
					    }
				}  
			return null;
		    }
				
		

		public void addEdge(Comparable nodeLabel1, Comparable nodeLabel2, int weight) {
			Node n1 = findNode(nodeLabel1);
			Node n2 = findNode(nodeLabel2);
			n1.addEdge(new Edge(n2, weight));
		}
       
	/*	public void addEdge( Comparable nodeLabel1, Comparable nodeLabel2)
		{
			Node n1 = findNode(nodeLabel1);
			Node n2 = findNode(nodeLabel2);
			n1.addEdge( new Edge (n2, 1));			// Setting one by default but it could be change as a parameter.
		} */

		public String toString() {
			String result = "*** Graph *** \n";
			for (int i = 0; i < nodes.size(); i++) {
				result += nodes.get(i).toString() + ": " + ((Node) nodes.get(i)).getEdges().toString() + "\n";
			}
			return result;
		}

		public void print() {
			System.out.println(this.toString());
		}
		public LinkedList Path(Comparable node1, Comparable node2) {
			for (int i=0;i<nodes.size();i++) {
				((Node) nodes.get(i)).setVisited(false);
			}
				Node startNode = findNode(node1);
				Node endNode = findNode(node2);
				Stack toDo = new Stack();
				toDo.push(startNode);
				LinkedList list = new LinkedList();
				while(!toDo.isEmpty()) {
					Node current = (Node) toDo.pop();
					current.setVisited(true);
					for(int j=0;j<list.size();j++) {
						boolean ispresent = false;
						for(int k=0;k<((Node)list.getLast()).edges.size();k++) {
							Edge e = (Edge) ((Node) list.getLast()).edges.get(k);
							if((e.toNode==current)| (((Node)list.getLast())==current)) {
								ispresent = true;
								break;
							}
							
							
						}
						if(ispresent==false) 
							list.removeLast();
					}
						list.addLast(current);
						if(current==endNode) {
							break;
						}else {
							for(int a=0;a<current.edges.size();a++) {
								Edge e = (Edge) current.edges.get(a);
								if(e.toNode.visited==false)
									toDo.push(e.toNode);
								
							}
						}
					}
					System.out.print(((Node) list.getFirst()).getLabel()+" ");
					list.removeFirst();
					for(int b=0;b<list.size();b++) {
						System.out.print("-: ");
						System.out.print(((Node)list.get(b)).getLabel()+" ");
					}
					System.out.println();
					return list;
				}
		
		
				
		
}

		

