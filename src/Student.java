public class Student {
	String studentID;
	String studentName;
	double midtermExam;
	double finalExam;
	double quizzes;
	double project;
	double participation;

	public Student(String studentID, String studentName, double midtermExam, double finalExam, double quizzes,
			double project, double participation) {
		// TODO Auto-generated constructor stub
		this.studentID = studentID;
		this.studentName= studentName;
		this.midtermExam= midtermExam;
		this.finalExam= finalExam;
		this.quizzes= quizzes;
		this.project= project;
		this.participation= participation;
	}
	
	public double getScore() {
		return this.midtermExam+
		this.finalExam+
		this.quizzes+
		this.project+
		this.participation;
	}

}