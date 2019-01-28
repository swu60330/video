public class StudentArray implements StudentADT {
	
	Node head;
	Node tail;
	//Student[] board;
	private class Node{
		Student student;
		Node next;
	}
	int numEntries = 0;

	public StudentArray() {
		//board = new Student[100];
		numEntries = 0;
		head = null;
		tail = null;
	}
	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		if(numEntries == 0)
			return true;
		else
		return false;
	}

	@Override
	public boolean full() {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public double getMean() {
		// TODO Auto-generated method stub
		if(this.numEntries > 0) {
		return this.getTotal()/this.numEntries;
		}
		return 0;

		
	}

	@Override
	public double getSD() {
		// TODO Auto-generated method stub
		double total = 0;
		double score;
		Node h = head;
		while(h != null) {
			score = h.student.getScore();
			total+=(score-this.getMean())*(score-this.getMean());
			h =h.next;
		}
		return Math.sqrt(total/(this.numEntries-1));
		
	}

	@Override
	public double getMax() {
		// TODO Auto-generated method stub
		
		return head.student.getScore();
	}

	@Override
	public double getMin() {
		// TODO Auto-generated method stub
		return tail.student.getScore();
	}

	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		double total = 0;
		double score;
		Node h = head;
		while(h != null) {
			score = h.student.getScore();
			total+=score;
			h =h.next;
		}
		return total;
	}
	@Override
	public Student getCurrentStudent() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setCurrentStudent(Student std) {
		// TODO Auto-generated method stub
		Node node = new Node();
		node.student=std;
		
		// Add 1st node
		if (head ==null) {
			node.next = null;
			head =node;
			numEntries++;
			tail = node;
		}else {
			Node h = head;
			if(h.student.getScore() < std.getScore()) {
				node.next = head;
				head = node;
			}else {
				while(h.next.student.getScore() > std.getScore()) {
					h = h.next;
				}
				node = h.next;
				h.next = node;
				
			}
		}
	}
	public void getAllscore() {
		Node h = head;
		while (h!=null) {
			System.out.println("score=" +h.student.getScore());
			h = h.next;
		}
		System.out.println("Number of Student:"+this.numEntries);
	}
	/*public Student remove(int i) {
		if(i < 0 || i>=numEntries)
			throw new IndexOutOfBoundsException("Invalid index" +i);
		Student temp = board[i];
		for(int j=i;j<numEntries-1;j++)
			board[numEntries-1]=null;
		numEntries--;
		return temp;
		
	}*/
}