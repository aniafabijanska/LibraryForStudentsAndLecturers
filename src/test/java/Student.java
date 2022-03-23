public class Student extends User {

    private String name;
    private String surname;

    public Student(String name, String surname) {
        super(name,surname);
        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean isLimitReached() {
        return false;
    }
}
