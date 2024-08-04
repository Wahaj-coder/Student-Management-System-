import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Teacher {

	int ID;
   String Name;
   String password;
   String degrees[];
   List<Subjects> sub;
   Teacher(int ID,String n,String password,String[] d,List<Subjects> sub){
	   this.ID=ID;
	   this.Name=n;
	   this.password=password;
	   this.degrees=d;
	   this.sub=sub;
   }
   
   public static ArrayList<Teacher> teacherList=new ArrayList<>();
	public static void registerTeacher() {
			
			System.out.println("\n//////Teacher Registration Form/////");		//register
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Enter Teacher ID: ");
	        int ID = scanner.nextInt();
	        
	        System.out.print("Enter Teacher's name: ");
	        String name = scanner.next();
	        
	        System.out.print("Enter your password: ");
	        String password = scanner.next();
	        
	        System.out.print("Enter your no.of degrees: ");//degrees
	        int noOfDegrees= scanner.nextInt();
	        String degrees[]= new String[noOfDegrees];
	        for(int i=0;i<noOfDegrees;i++) {
	        	System.out.println("Enter your "+(i+1)+" degree's name: ");
	        	String d=scanner.next();
	        	degrees[i]=d;
	        }
	        
	        System.out.print("Enter no.of Subjects you teach i.e.1or2: ");//subjects
	        int noOfSub= scanner.nextInt();
	        scanner.nextLine();
	        Subjects.displayAvailableSubjects();
	        ArrayList<Subjects> subjectsTeach = new ArrayList<>();
	        for (int i = 0; i < noOfSub; i++) {
	        	
	            System.out.print("Enter name of subject " + (i + 1) + " you teach : ");
	            String subjectName = scanner.nextLine();
	        
	            boolean subjectFound=false;
	            
	            for(int j=0; j<Subjects.availableSubjects.size(); j++) {
	            	Subjects subject=Subjects.availableSubjects.get(j);
	            	
	                if (subject.Name.equalsIgnoreCase(subjectName) ){
	                	for(int k=0; k<subjectsTeach.size();k++) {
	                		if(subjectName.equalsIgnoreCase(subjectsTeach.get(k).Name)) {
	                			System.out.println("Do not Select repeated subjects!!");
	                			i--;
	                			subjectFound = true;
	                			break;
	                		}
	                	}
	                	 if (!subjectFound) {
	                         subjectsTeach.add(subject);
	                         System.out.println("Correct");
	                         subjectFound = true;
	                         break;
	                }
	            }}
	            if(!subjectFound) {
	            	System.out.println("Invalid subject , again enter the subject Name!!");
	            	i--;
	            }
	        }

	        Teacher teach = new Teacher(ID, name, password,degrees,subjectsTeach);
	        teacherList.add(teach);
	        
	        System.out.println("Teacher registered successfully!");
    
	        // Assign the teacher object to the subjects
	        for (Subjects subject : subjectsTeach) {
	            subject.teacher=teach;
	        }
	}
	
	public static void EnterMarks() {													//marks
		System.out.println("\n//////Marks/////");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Your ID: ");
        int ID = scanner.nextInt();
        
        System.out.print("Enter Your Password!: ");
        String password = scanner.next();
        scanner.nextLine();
        for(Teacher t:teacherList) {
        	if(password.equals(t.password)&&ID==t.ID) {
                ArrayList<Student> studentsInSubject = new ArrayList<>();
                boolean subjectFound = false;
                Subjects selectedSubject = null;
                System.out.print("Enter Subject name you want to enter marks: ");
                
                String subName = scanner.nextLine();
               
                while (!subjectFound) {
                    for (int w = 0; w < Subjects.availableSubjects.size(); w++) {
                        Subjects sub = Subjects.availableSubjects.get(w); // Traverse available list

                        if (sub.Name.equalsIgnoreCase(subName)) { // Compare subject valid or not
                            subjectFound = true;
                            selectedSubject = sub;
                            System.out.println("Students registered in the given Subject are:");

                            for (Student student : Student.studentList) {
                                if (student.subjectMarksMap.containsKey(sub)) {
                                    System.out.println("Roll#: " + student.Roll + " Name: " + student.Name);
                                    studentsInSubject.add(student);
                                    
                                }
                            }
                            break;
                        }
                    }

                    if (!subjectFound) {
                        System.out.println("Insert valid subject name!!");
                        System.out.print("Enter Subject you teach: ");
                        subName = scanner.next();
                        scanner.nextLine();
                    }
                }
        	   if (selectedSubject.teacher.ID == ID) {         	
                for(int l=0;l<studentsInSubject.size();l++) {
                	System.out.println("\nEnter roll no. from the above list!");
                    String stdRoll=scanner.next();
                    scanner.nextLine();
                	Student stud=studentsInSubject.get(l);        
                	
                	if(stud.Roll.equals(stdRoll)) {
                		
                	    boolean continueEnteringMarks = true;                        
                        while (continueEnteringMarks) {
                		System.out.println("Press M for Mid, A for Asignment, Q for Quiz marks, F for Final,and X for exit!!");
                		String choice =scanner.next();
                		
                		if(choice.equalsIgnoreCase("M")) {
                		System.out.print("Enter Mid-Term marks: ");
                		int midMarks = scanner.nextInt();
                		stud.subjectMarksMap.get(selectedSubject).Mid=midMarks;}
                		
                		else if(choice.equalsIgnoreCase("A")){
                			System.out.print("Enter Asignment marks: ");
                    		int AsMarks = scanner.nextInt();
                    		stud.subjectMarksMap.get(selectedSubject).Assignment=AsMarks;}
                		
                		else if(choice.equalsIgnoreCase("Q")){
                			System.out.print("Enter Quiz marks: ");
                    		int QMarks = scanner.nextInt();
                    		stud.subjectMarksMap.get(selectedSubject).Quiz=QMarks;}
                		
                		else if(choice.equalsIgnoreCase("F")){
                			System.out.print("Enter Final marks: ");
                    		int FMarks = scanner.nextInt();
                    		stud.subjectMarksMap.get(selectedSubject).Final=FMarks;}
                		
                		else if (choice.equalsIgnoreCase("X")) {
                            continueEnteringMarks = false;}
                            
                         else {
                            System.out.println("Invalid choice. Please try again.");}
                        }
                    
                	}
                	else {
                		System.out.println("The student is not registered in the Subject");
                		l--;}
                	
                }       		        		
        }}
        	else {
        		System.out.println("Enter correcr Teacher ID or Password!!");
        		EnterMarks();}
 
        }    
	}

}
