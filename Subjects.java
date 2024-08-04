import java.util.ArrayList;
import java.util.Scanner;
public class Subjects {
	String Name;
	Teacher teacher;
	Student student;
	Subjects(String name){
		this.Name=name;
	
	}
	public static ArrayList<Subjects> availableSubjects =new ArrayList<>();
	static {
        availableSubjects.add(new Subjects("Differential Equation" ));
        availableSubjects.add(new Subjects("Linear Algebra"));
        availableSubjects.add(new Subjects("Data Structures"));
        availableSubjects.add(new Subjects("Islamiat"));
        availableSubjects.add(new Subjects("PST"));
        availableSubjects.add(new Subjects("Accounting"));
        availableSubjects.add(new Subjects("Management"));
    }

    public static void addSubject(Subjects subject) {
        availableSubjects.add(subject);
    }

    public static void displayAvailableSubjects() {
        System.out.println("Available Subjects:");
        for (Subjects subject : availableSubjects) {
            System.out.println(subject.Name);
        }
    }

    public static void stdBYSub() {
        System.out.println("\n//////Registered Students in the Subject/////");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Subject name: ");
        String subName = scanner.next();

        boolean subjectFound = false;

        for (Subjects sub : availableSubjects) {
            if (sub.Name.equalsIgnoreCase(subName)) {
                subjectFound = true;
                System.out.println("Students registered in the given Subject are:");

                for (Student student : Student.studentList) {
                    if (student.subjectMarksMap.containsKey(sub)) {
                        System.out.println("Roll#: " + student.Roll + " Name: " + student.Name);
                    }
                }
                break;
            }
        }

        if (!subjectFound) {
            System.out.println("Insert valid subject name!!");
            stdBYSub();
        }
    }
    public static void TeacherNameBySubject() {
    	System.out.println("\n////////Teacher Details/////////");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter name: ");
        String subName = scanner.next();
        
    	for(int j=0; j<Subjects.availableSubjects.size(); j++) {
        	Subjects subject=Subjects.availableSubjects.get(j);       	
            if (subject.Name.equalsIgnoreCase(subName) ){
            	System.out.println("\t"+subject.teacher.Name);
            }
            }
   }
 
}
