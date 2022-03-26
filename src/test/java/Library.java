import java.util.ArrayList;
import java.util.List;


public class Library {
    private List<User> users = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    private List<Magazine> magazines = new ArrayList<>();

    public void addUserToLibrary(User... users) {
        for (User user : users) {
            this.users.add(user);
        }
    }

    public void printListOfUsers() {
        for (User user : users) {
            user.displayUserInformation();
        }
    }

    public void addItemToLibrary(Item... items) {
        for (Item item : items) {
            this.items.add(item);
        }
    }
    public void printListOfBooks() {
        for (Item book : books) {
            System.out.println(book);
        }
    }

    public void printListOfMagazines() {
        for (Item magazine : magazines) {
            System.out.println(magazine);
        }
    }
    public boolean rentItemToUser(Item item, User user) {
        return false;
    }
    public void importItemsFromFile(String csvFile){}

    public void exportUsersWithItemsToFile(String csvFile){}
}







