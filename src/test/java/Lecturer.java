public class Lecturer extends User {
    public Lecturer(String firstName, String lastName) {

        super(firstName, lastName);

        isStudentOrLecturer = 'L';

        rentItemsLimit = 10;
    }
}
