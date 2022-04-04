
import java.util.ArrayList;
import java.util.List;

public abstract class User {

    protected String firstName;
    protected String lastName;
    protected static int count=0;
    protected int libraryCardIndex;
    protected char isStudentOrLecturer;

    protected List<Item> rentedItems = new ArrayList<>();
    protected int rentItemsLimit;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        libraryCardIndex=count++;
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

    public boolean canRent()
    {
        if(rentedItems.stream().count() <rentItemsLimit)
            return true;
        else return false;
    }

    public void rent(Item item)
    {
        rentedItems.add(item);
    }

}
