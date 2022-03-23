public abstract class User {

    protected String firstName;
    protected String lastName;
    protected static int count = 1;
    protected int libraryCardIndex;
    protected char isStudentOrLecturer;


    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        libraryCardIndex = count++;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getLibraryCardIndex() {
        return libraryCardIndex;
    }

    public char isStudentOrLecturer() {
        return isStudentOrLecturer;
    }

    public abstract boolean isLimitReached();




    public void User1(String fN, String lN) {
        this.firstName = fN;
        this.lastName = lN;
        libraryCardIndex = count++;

    }}




