public class StudentArray implements StudentADT {
	
	Node head;
	Node tail;
	//Student [] board;
	private class Node{
		Student student;
		Node next;
	}
	int numEntries;
	
	public StudentArray() {
		//board = new Student[100];
		numEntries =0;
		head = null;
		tail = null;
	}
	public void setCurrentStudent(Student std) {
		/*double newScore = student.getScore();
		if(numEntries < board.length || newScore > board[numEntries-1].getScore()){
		 if(numEntries < board.length) 
			 numEntries++;
		 
		 int j = numEntries - 1;
		 while (j > 0 && board [j-1].getScore()<newScore) {
			 board[j] = board [j-1];
		 j--;
		}
		 board[j] = student;
		 }*/
		 
		Node node = new Node();
		node.student = std;
		
		if(head == null) {
			node.next = null;
			head = node;
			numEntries++;
			
		}else {
			Node h = head;
			
			if (h.student.getScore() < std.getScore()) {
				node.next = head;
				head = node;
				numEntries++;
				
			}
			else if(head.next == null) {
				head.next = null;
				node = null;
				numEntries++;
			}
			else {
				while (h.next != null) {
					if (h.next.student.getScore() < std.getScore())
						
						break;
					
					h=h.next;
				}
				node.next = h.next;
				h.next = node;
				numEntries++;
			}
		}
		
		}
		
	
	


	@Override
	public Student getCurrentStudent() {
		// TODO Auto-generated method stub
		return null;
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
		double mean = 0;
		if(numEntries > 0)
		{mean = this.getTotal()/numEntries;
		return mean;}
		else
			return 0;
	}

	@Override
	public double getSD() {
		// TODO Auto-generated method stub
		/*double SD;
		double score = 0;
		double score11 = 0;
		
		for (int i = 0;i<numEntries; i++) {
			score= board[i].getScore();
			score11 += Math.pow(score - this.getMean(),2);
			
		}
		SD = Math.sqrt(score11/(numEntries-1));
		return SD;*/
		double total = 0;
		double score;
		double SD;
		Node h = head;
		while(h != null) {
			score = h.student.getScore();
			
			total +=((score - this.getMean())*(score - this.getMean()));
			h = h.next;
		}
		SD = Math.sqrt(total/(numEntries-1));
		return SD;
		
	}

	@Override
	public double getMax() {
		// TODO Auto-generated method stub
		
		return head.student.getScore();
	}

	@Override
	public double getMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		double total = 0;
		double score;
		Node h = head;
		while(h != null) {
			score = h.student.getScore();
			total +=score;
			h = h.next;
		}
		return total;
	}
	public void getAllScore() {
	/*for(int i=0; i <numEntries;i++) {
		double score = board[i].getScore();
		System.out.println(i +" : " + score);
	}
	System.out.println("number of Student = " + this.numEntries);*/
		
		Node h = head;
		while( h != null) {
			System.out.println("score = " + h.student.getScore());
			h = h.next;
			
		}
		System.out.println("number of Student = " + this.numEntries);
	}
	
	public Student remove(int index /*int i*/) /*throws IndexOutOfBoundsException*/{
		
		/*if( i<0 || i>= numEntries)
			throw new IndexOutOfBoundsException("Invalid index: " + i);
		Student temp = board[i];
		for (int j = i; j < numEntries - 1 ; j++)
			board[j] = board[j+1];
		board[numEntries - 1] = null;
		numEntries--;
		return temp;*/
		
		int i = 0;
		Node h = head;
		if(index == 0) {
			head = head.next;
		}
		else {
			while(i < this.numEntries && i < index) {
				h=h.next;
				i++;
			}
			if(i == this.numEntries-1) {
				
			}
			else {
				h.next = h.next.next;
			}
		}
		this.numEntries--;
		return null;
	}

}

