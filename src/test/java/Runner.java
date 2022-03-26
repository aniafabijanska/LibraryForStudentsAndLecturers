import java.util.ArrayList;
import java.util.List;

public class Runner {

    private List<User> users = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    public static void main(String[] args) {
        Library library = new Library();
        User user = new Student("Adam", "Kowalski");
        User student1 = new Student("Ewa", "Kowalska");
        User lecturer = new Lecturer("Asia", "Kowalska");
        User lecturer1 = new Lecturer("Magda", "Kowalska");
        library.addUserToLibrary(user, student1, lecturer, lecturer1);
        library.printListOfUsers();

        if (user instanceof Lecturer) System.out.println(false);
        else if (user instanceof Student) System.out.println(true);

        Library library1 = new Library();

        Item book = new Book("Ogniem i mieczem", "Henryk Sienkiewicz");
        Item book1 = new Book("Harry Potter. Czara Ognia", "J.K. Rowling");
        Item book2 = new Book("Harry Potter. Czara Ognia", "J.K. Rowling");
        Item book3 = new Book("Harry Potter. Czara Ognia", "J.K. Rowling");
        Item book4 = new Book("Lśnienie", "S. King");
        Item magaizne = new Magazine("Kobiety kodują", 1);
        Item magazine1 = new Magazine("Dektektyw", 2);
        Item magazine2 = new Magazine("Dektektyw", 2);
        library1.addItemToLibrary(book, book1, book2, book3, book4, magaizne, magazine1, magazine2);
        library1.printListOfBooks();
        library1.printListOfMagazines();
    }


}



