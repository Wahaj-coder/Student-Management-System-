
public class Main {

	public static void main(String[] args) {
		
		Student.registerStudent();
		Student.registerStudent();
		
		Teacher.registerTeacher();
		Teacher.EnterMarks();
		
		Student.login();
		Student.displayDetails();
		
		Subjects.TeacherNameBySubject() ;
		Subjects.stdBYSub();
		
		Result.SortAndPrintByTotalMarks();
	}
}
