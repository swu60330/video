import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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
	Scanner sc = new Scanner(System.in);
	int remove = 0;
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
					 
					 
									
					studentArray.setCurrentStudent(student);
					//studentLinkedList.setCurrentStudent(student);
				 }
				 
				 line = br.readLine();
			 }
			 
			 br.close();
			
			 studentArray.getAllScore();
			 System.out.println("Max : "+studentArray.getMax());
			// System.out.println("Min : "+studentArray.getMin());
			 System.out.println("Mean : "+studentArray.getMean());
			 System.out.println("SD : " +studentArray.getSD());
			 
			 System.out.println("---------------Remove----------------");
			 System.out.println("Remove Index : ");
			 remove = sc.nextInt();
			 studentArray.remove(remove);
			 System.out.println("---------------New Data----------------");
			 studentArray.getAllScore();
			 System.out.println("Max : "+studentArray.getMax());
			// System.out.println("Min : "+studentArray.getMin());
			 System.out.println("Mean : "+studentArray.getMean());
			 System.out.println("SD : " +studentArray.getSD());
			
			 
			/* System.out.println("-------------------------------");
			 
			 System.out.println("Full : " +studentArray.full());
			 System.out.println("Empty : " +studentArray.empty());
			 System.out.println(studentArray.toString());
			 System.out.println(studentLinkedList.toString());*/
			
			
		} catch(FileNotFoundException e1){
			System.out.println("File: "+filePath+" NOT found.");
		} catch(IOException e2){
			System.out.println(e2);
		}
	
	}

}
