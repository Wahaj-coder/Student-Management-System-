
import java.util.ArrayList;
import java.util.List;

public class Result {
	public static void SortAndPrintByTotalMarks() {
	    List<Student> stdSortList = Student.studentList; // Accessing the student list from the Students class

	    int n = stdSortList.size();

	    for (int i = 0; i < n - 1; i++) {
	        for (int j = 0; j < n - i - 1; j++) {
	            Student student1 = stdSortList.get(j);
	            Student student2 = stdSortList.get(j + 1);

	            int totalMarks1 = calculateTotalMarks(student1);
	            int totalMarks2 = calculateTotalMarks(student2);

	            if (totalMarks1 < totalMarks2) {
	                // Swap the students
	                Student temp = stdSortList.get(j);
	                stdSortList.set(j, stdSortList.get(j + 1));
	                stdSortList.set(j + 1, temp);
	            }
	        }
	    }

	    System.out.println("Students Sorted by Total Marks:");
	    for (Student student : stdSortList) {
	        int totalMarks = calculateTotalMarks(student);
	        System.out.println("Name: " + student.Name + ", Total Marks: " + totalMarks);
	    }
	}

	private static int calculateTotalMarks(Student student) {
		int totalMarks = 0;
	    for (Subjects subject : student.subjectMarksMap.keySet()) {
	        Marks marks = student.subjectMarksMap.get(subject);
	        // Calculate the total marks based on the marks for each subject
	        int subjectTotalMarks = marks.Mid + marks.Assignment + marks.Quiz + marks.Final;
	        totalMarks += subjectTotalMarks;
	    }
	    return totalMarks;
	}

}
