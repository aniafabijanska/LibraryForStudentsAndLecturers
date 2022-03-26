public class Student extends User {


    @Override
    protected String setIsStudentOrLecturer() {
        return "S";
    }

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
