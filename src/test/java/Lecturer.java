public class Lecturer extends User {


    private String name;
    private String surname;

    public Lecturer(String name, String surname) {
        super(name, surname);


        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean isLimitReached() {
        return false;
    }
}

