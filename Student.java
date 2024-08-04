import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Student {
	String Roll;
	String Name;
	String Password;
	public HashMap<Subjects, Marks> subjectMarksMap;	
	public static boolean LoggedIn;
	
Student(String Roll, String Name,String Password,HashMap<Subjects,Marks> sub){
	this.Roll=Roll;
	this.Name=Name;
	this.Password= Password;
	this.subjectMarksMap=sub;
}
Student(){	
}

public static ArrayList<Student> studentList=new ArrayList<>();

	public static void registerStudent() {
		System.out.println("\n//////Registration Form/////");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter roll number: ");
        String rollNumber = scanner.next();
        
        System.out.print("Enter name: ");
        String name = scanner.next();
        
        System.out.print("Enter password: ");
        String password = scanner.next();
        
        System.out.println("Enter no. of subjects!!i.e. 4 or 5");
        
        int noOfSub=scanner.nextInt();
        scanner.nextLine();
        
        Subjects.displayAvailableSubjects();
        HashMap<Subjects, Marks> subjectMarksMap = new HashMap<>();
        for (int i = 0; i < noOfSub; i++) {
        	
            System.out.print("Enter name of subject " + (i + 1) + ": ");
            String subjectName = scanner.nextLine();
        
            boolean subjectFound=false;
            
            for(int j=0; j<Subjects.availableSubjects.size(); j++) {
            	Subjects subject=Subjects.availableSubjects.get(j);
            	
                if (subject.Name.equalsIgnoreCase(subjectName) ){
                	if (subjectMarksMap.containsKey(subject)) {
                			System.out.println("Do not Select repetedd subjects!!");
                			i--;
                			subjectFound = true;
                			break;
                	}
                	else {
                		Marks mark = new Marks();
                        subjectMarksMap.put(subject, mark);
                        System.out.println("Subject selected successfully!");
                        subjectFound = true;
                        break;
                	}
                }	
            }                	 
            if(!subjectFound) {
            	System.out.println("Invalid subject , again enter the subject Name!!");
            	i--;
            }           
        }
              
        Student student = new Student(rollNumber, name, password,subjectMarksMap);
        studentList.add(student);
        
        System.out.println("Student registered successfully!");
	}
	
	public static void login() {
		System.out.println("\n//////Student LogIn/////");
	    LoggedIn = false;
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter your Roll no.!!");
	    String roll=scanner.next();
	    System.out.println("Enter your Password!!");
	    String password =scanner.next();
	    for (Student student : studentList) {
	        if (student.Roll.equals(roll) && student.Password.equals(password)) {
	            System.out.println("Login successful!");
	            LoggedIn = true;
	            break;
	        }
	    }
	  
	    if (!LoggedIn) {
	        System.out.println("Invalid username or password. Please try again.");
	        LoggedIn = false;
	    }
	}

	public static void displayDetails() { 
		System.out.println("\n//////Sudent Details/////");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter roll number: ");
        String rollNumber = scanner.next();
        
        for (Student student : studentList) {
	        if (student.Roll.equals(rollNumber) && student.LoggedIn) {
	        	 System.out.println("//////Student Details//////");
	        	    System.out.println("Name: " + student.Name);
	        	    System.out.println("Roll: " + student.Roll);

	        	    System.out.println("Subjects are:");
	        	    for (Subjects subject : student.subjectMarksMap.keySet()) {
	        	    	
	        	        Marks marks = student.subjectMarksMap.get(subject);
	        	        
	        	        System.out.println("Subject: " + subject.Name);
	        	        if(subject.teacher!=null) {
	        	        System.out.println("Teacher: " + subject.teacher.Name);
	        	        System.out.println("Mid-Term Marks: " + marks.Mid);
	        	        System.out.println("Assignment Marks: " + marks.Assignment);
	        	        System.out.println("Quiz Marks: " + marks.Quiz);
	        	        System.out.println("Final Marks: " + marks.Final);
	        	        System.out.println("---------------");
	        	    
	        	    int totalMarks = 0;
	        	    for (Marks mark : student.subjectMarksMap.values()) {
	        	        totalMarks += mark.Mid + mark.Assignment + mark.Quiz + mark.Final;
	        	    }
	        	        System.out.println("Total Marks: " + totalMarks);

	        	        System.out.println("----------------------");
	        	    }
	        }

	        } else {
            System.out.println("Access denied. Please login to view your details.");}
       
        	}        
		}
	
	
	public static void showAllStudents() {
	    if (studentList.isEmpty()) {
	        System.out.println("No students registered.");
	        return;
	    }
	    
	    System.out.println("////// List of Students //////");
	    for (Student student : studentList) {
	        System.out.println("Name: " + student.Name + ", Roll: " + student.Roll);
	    }
	}
	
	}

	
	
	
	


