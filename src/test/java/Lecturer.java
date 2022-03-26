public class Lecturer extends User {


    @Override
    protected String setIsStudentOrLecturer() {
        return "L";
    }

    public Lecturer(String firstName, String lastName) {
        super(firstName, lastName);
    }
}

