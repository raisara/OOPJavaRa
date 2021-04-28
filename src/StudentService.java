import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StudentService {
    static String[] read(String path) throws IOException {
        return Files.readAllLines(Paths.get(path)).toArray(new String[0]);
    }

    static Student[] readasObject(String path) throws IOException {
        //return Files.readAllLines(Paths.get(path)).toArray(new String[0]);
        String[] read = new String[0];
        read = StudentService.read(path);
        Student[] students = new Student[read.length];
        int count = 0;
        for (String line : read) {
            String[] linetoArray = line.split(",");
            Student student = new Student();

            student.setName(linetoArray[0]);
            student.setLastName(linetoArray[1]);
            student.setYear(Integer.parseInt(linetoArray[2]));
            student.setGender(linetoArray[3].charAt(0));
            student.setMark(Double.parseDouble(linetoArray[4]));

            students[count++] = student;

        }
        return students;
    }

    public static void printFullNamesOfStudents(Student[] students) {
        for (Student s :
                students) {
            System.out.println(s.getName() + " " + s.getLastName());
        }
    }

    public static void printMaleStudents(Student[] students) {
        for (Student s :
                students) {
            if (s.getGender() == 'm') {
                System.out.println(s);
            }
        }
    }

    public static void femaleGreaterThan(Student[] students) {
        for (Student s :
                students) {
            if (s.getGender() == 'f' && s.getMark() > 50.4) {
                System.out.println(s);
            }
        }
    }

    public static void studentInformationWithMinimalMark(Student[] students) {
        Student min = students[0];
        for (Student s :
                students) {
            if (s.getMark() < min.getMark()) {
                min = s;
            }
        }
        System.out.println("\nstudent information having the minimal mark:");
        System.out.println("Full Name " + min.getName() + " " + min.getLastName());
        System.out.println("Year: " + min.getYear() + ", Gender: " + min.getGender() + ", Mark: " + min.getMark());
    }

    public static void biggestMaleStudent(Student[] students) {
        Student biggest = null;
        for (Student s :
                students) {
            if (s.getGender() == 'm') {
                if (biggest == null) {
                    biggest = s;
                } else {
                    if (s.getYear() < biggest.getYear()) {
                        biggest = s;
                    }
                }

            }
        }

        System.out.println("\nbiggest male student information:");
        System.out.println("Full Name " + biggest.getName() + " " + biggest.getLastName());
        System.out.println("Year: " + biggest.getYear() + ", Gender: " + biggest.getGender() + ", Mark: " + biggest.getMark());
    }

    public static void sortedByMark(Student[] students) {
        boolean isActive = true;
        int countOfFors = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < students.length - 1 - countOfFors; i++) {
                if (students[i].getMark() < students[i + 1].getMark()) {
                    Student x = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = x;
                    isActive = true;
                }
            }
            countOfFors++;
        }
        System.out.println(students);
    }

    public static void femaleSortedByYear(Student[] students) {
        int count = 0;
        for (Student student : students) {
            if (student.getMark() == 'f') {
                count++;
            }
        }
        Student[] females = new Student[count];
        int index = 0;
        for (Student human : students) {
            if (human.getMark() == 'f') {
                females[index++] = human;
            }
        }

        boolean isActive = true;
        int countOfFors = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < females.length - 1 - countOfFors; i++) {
                if (females[i].getYear() < females[i + 1].getYear()) {
                    Student x = females[i];
                    females[i] = females[i + 1];
                    females[i + 1] = x;
                    isActive = true;
                }
            }
            countOfFors++;
        }
        System.out.println(females);
    }

}
