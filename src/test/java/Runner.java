import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
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


        Library itemss = new Library();

        itemss.addItemToLibrary(new Book("Ogniem i mieczem", "Henryk Sienkiewicz"));
        itemss.addItemToLibrary(new Book("Harry Potter. Czara Ognia", "J.K. Rowling"));
        itemss.addItemToLibrary(new Book("Harry Potter. Czara Ognia", "J.K. Rowling"));
        itemss.addItemToLibrary(new Book("Lśnienie", "S. King"));
        itemss.addItemToLibrary(new Magazine("Kobiety kodują", "1/2020"));
        itemss.addItemToLibrary(new Magazine("Kobiety kodują", "1/2020"));
        itemss.addItemToLibrary(new Magazine("Think Like A MAN", "6/2022"));
        itemss.printListOfBooks();
        itemss.printListOfMagazines();


        ArrayList<Item> book = new ArrayList<>();
        book.add(new Book("Ogniem i mieczem", "Henryk Sienkiewicz"));
        book.add(new Book("Harry Potter. Czara Ognia", "J.K. Rowling"));
        book.add(new Book("Harry Potter. Czara Ognia", "J.K. Rowling"));
        book.add(new Book("Lśnienie", "S. King"));
        Map<Object, Long> counts = book.stream().collect(Collectors.groupingBy(item -> item.title, Collectors.counting()));
        System.out.println(counts);

        ArrayList<Item> magazine = new ArrayList<>();
        magazine.add(new Magazine("Kobiety kodują", "1/2020"));
        magazine.add(new Magazine("Kobiety kodują", "1/2020"));
        magazine.add(new Magazine("Think Like A MAN", "6/2022"));

        Map<Object, Long> counts1 = magazine.stream().collect(Collectors.groupingBy(item -> item.title, Collectors.counting()));
        System.out.println(counts1);



    }

public class Pliki {

    public static void main(String[] args) {

        String csvFile = "csvFile.txt";

        exportUsersWithItemsToFile(csvFile);

        String odczytanyTekst = exportUsersWithItemsToFile(csvFile);

        System.out.println("Odczytany tekst:\n" + odczytanyTekst);
    }

    public static String exportUsersWithItemsToFile (String csvFile) {

        try {

            PrintWriter out = new PrintWriter(csvFile);

            out.println("Raz");
            out.println("Dwa");
            out.println("Trzy");

            out.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Niestety, nie mogę utworzyć pliku!");
        }
        return csvFile;
    }

    public static String importItemsFromFile(String csvFile) {

        File plikDane = new File(csvFile);

        String odczyt = "";
        try {

            Scanner skaner = new Scanner(plikDane);

            while (skaner.hasNextLine()) {

                odczyt = odczyt + skaner.nextLine() + "\n";
            }

        } catch (FileNotFoundException e) {
            System.out.println("Brak Pliku do odczytania!");
        }
        return odczyt;
    }
}}


/* Item book = new Book("Ogniem i mieczem", "Henryk Sienkiewicz");
        Item book1 = new Book("Harry Potter. Czara Ognia", "J.K. Rowling");
        Item book2 = new Book("Harry Potter. Czara Ognia", "J.K. Rowling");
        Item book3 = new Book("Harry Potter. Czara Ognia", "J.K. Rowling");
        Item book4 = new Book("Lśnienie", "S. King");
        Item magaizne = new Magazine("Kobiety kodują", 1);
        Item magazine1 = new Magazine("Dektektyw", 2);
        Item magazine2 = new Magazine("Dektektyw", 2);
       */  /*list.addItemToLibrary(book, book1, book2, book3, book4, magaizne, magazine1, magazine2);*/




