public abstract class User {


    private String firstName;
    private String lastName;
    private static int count = 1;
    private int libraryCardIndex;
    private String isStudentOrLecturer;

    public String getIsStudentOrLecturer() {

        if (getIsStudentOrLecturer() == "S") {
            isStudentOrLecturer = "S";}
        else if (getIsStudentOrLecturer() == "L") {isStudentOrLecturer = "L";}
            return isStudentOrLecturer;
        }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        libraryCardIndex = count++;
    }

    public void displayUserInformation() {
        System.out.println(firstName + ";" + lastName + ";" + libraryCardIndex + ";" + setIsStudentOrLecturer());
    }

    protected abstract String setIsStudentOrLecturer();
}