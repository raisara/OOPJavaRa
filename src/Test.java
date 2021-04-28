import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            Student[] k = StudentService.readasObject("src\\Students.txt");
            StudentService.printFullNamesOfStudents(k);
            StudentService.printMaleStudents(k);
            StudentService.femaleGreaterThan(k);
            StudentService.studentInformationWithMinimalMark(k);
            StudentService.biggestMaleStudent(k);
            StudentService.sortedByMark(k);
            StudentService.femaleSortedByYear(k);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
