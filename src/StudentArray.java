public class StudentArray implements StudentADT {
	
	Student[] board;
	int numEntries = 0;

	public StudentArray() {
		board = new Student[100];
		numEntries = 0;
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
		if (numEntries == board.length)
			return true;
		else
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
		double allscore = 0;
		double score = 0;
		int N = this.numEntries;
		for(int i=0;i<numEntries;i++) {
			score = board[i].getScore();
			allscore += (score-this.getMean())*(score-this.getMean());
		}
		return Math.sqrt(allscore/(N-1));
		
	}

	@Override
	public double getMax() {
		// TODO Auto-generated method stub
		return board[0].getScore();
	}

	@Override
	public double getMin() {
		// TODO Auto-generated method stub
		return board[numEntries -1].getScore();
	}

	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		double total = 0;
		double score;
		for(int i=0; i <numEntries; i++) {
			score = board[i].getScore();
			total+=score;
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
		double score = std.getScore();
		if(numEntries < board.length || score >board[numEntries -1].getScore()) {
			if(numEntries < board.length)
				numEntries++;
			int j = numEntries-1;
			while(j > 0 && board[j-1].getScore()<score) {
				board[j] = board[j-1];
				j--;
				
			}
			board[j]=std;
		}
	}
	public void getAllscore() {
		for(int i =0;i<numEntries;i++) {
			double score = board[i].getScore();
			System.out.println(score);
		}
		System.out.println("Number of Student:"+this.numEntries);
	}
	public Student remove(int i) {
		if(i < 0 || i>=numEntries)
			throw new IndexOutOfBoundsException("Invalid index" +i);
		Student temp = board[i];
		for(int j=i;j<numEntries-1;j++)
			board[numEntries-1]=null;
		numEntries--;
		return temp;
		
	}
}