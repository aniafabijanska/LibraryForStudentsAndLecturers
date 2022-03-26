import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Runner {

    private List<User> users = new ArrayList<>();

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


        ArrayList<Item> arr = new ArrayList<>();
        Library items = new Library();

        items.addItemToLibrary(new Book("Ogniem i mieczem", "Henryk Sienkiewicz"));
        items.addItemToLibrary(new Book("Ogniem i mieczem", "Henryk Sienkiewicz"));
        items.addItemToLibrary(new Book("Ogniem i mieczem", "Henryk Sienkiewicz"));
        items.addItemToLibrary(new Book("Harry Potter. Czara Ognia", "J.K. Rowling"));
        items.addItemToLibrary(new Book("Harry Potter. Czara Ognia", "J.K. Rowling"));
        items.addItemToLibrary(new Book("Lśnienie", "S. King"));
        items.addItemToLibrary(new Magazine("Kobiety kodują", "1/2020"));
        items.addItemToLibrary(new Magazine("Kobiety kodują", "2/2021"));
        items.printListOfBooks();
        items.printListOfMagazines();

        Set<Item> set = arr.stream().collect(Collectors.toSet());

             set.forEach(Item -> System.out.println(Item));
    }
}

       /* Map<Item, Integer> itemMap = Items.stream().collect(Collectors.toMap(s), Collectors.counting()));
        System.out.println(itemMap);
*/


/* Item book = new Book("Ogniem i mieczem", "Henryk Sienkiewicz");
        Item book1 = new Book("Harry Potter. Czara Ognia", "J.K. Rowling");
        Item book2 = new Book("Harry Potter. Czara Ognia", "J.K. Rowling");
        Item book3 = new Book("Harry Potter. Czara Ognia", "J.K. Rowling");
        Item book4 = new Book("Lśnienie", "S. King");
        Item magaizne = new Magazine("Kobiety kodują", 1);
        Item magazine1 = new Magazine("Dektektyw", 2);
        Item magazine2 = new Magazine("Dektektyw", 2);
       */  /*list.addItemToLibrary(book, book1, book2, book3, book4, magaizne, magazine1, magazine2);*/




