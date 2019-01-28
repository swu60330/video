import java.io.*;

class TestStudentADT {

	public static void main(String[] args){
	
		String filePath ="student_utf8.txt";
		Student student;
		
	
		String studentID;
		String studentName;
		double midtermExam;
		double finalExam;
		double quizzes;
		double project;
		double participation;
	
		try{
			 
			 StudentArray studentArray = new StudentArray();
			 //StudentLinkedList studentLinkedList = new StudentLinkedList();
			 
			 FileReader fr = new FileReader(filePath);
			 BufferedReader br = new BufferedReader(fr);
			 
			 String line = br.readLine();
			 
			 while(line!=null){
				 
				 if(line.trim().length() !=0){
					
					 String[] tokens = line.split("\t");
					 
					 studentID = tokens[0];
					 studentName = tokens[1];
					 midtermExam = Double.parseDouble(tokens[2]);
					 finalExam = Double.parseDouble(tokens[3]);
					 quizzes = Double.parseDouble(tokens[4]);
					 project = Double.parseDouble(tokens[5]);
					 participation = Double.parseDouble(tokens[6]);
					 
					 student = new Student(studentID, 
									studentName, 
									midtermExam, 
									finalExam, 
									quizzes, 
									project, 
									participation);
					System.out.println(student.getScore());
					studentArray.setCurrentStudent(student);
					//studentLinkedList.setCurrentStudent(student);
				 }
				 
				 line = br.readLine();
			 }
			 
			 br.close();
			
			// 
			 System.out.println("Total="+studentArray.getTotal());
			 System.out.println("SD="+studentArray.getSD());
			 System.out.println("Min ="+studentArray.getMin());
			 System.out.println("Max ="+studentArray.getMax());
			 System.out.println(studentArray.toString());
			 //System.out.println(studentLinkedList.toString());
			 studentArray.getAllscore();
			 studentArray.remove(0);
			 studentArray.getAllscore();
			
		} catch(FileNotFoundException e1){
			System.out.println("File: "+filePath+" NOT found.");
		} catch(IOException e2){
			System.out.println(e2);
		}
	
	}

}