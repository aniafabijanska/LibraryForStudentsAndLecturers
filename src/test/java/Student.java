public class Student extends User
{
    public Student(String firstName, String lastName) {

        super(firstName, lastName);

        isStudentOrLecturer = 'S';

        rentItemsLimit=4;
    }
}
 