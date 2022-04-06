import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Runner {

    private static Library library = new Library();

    public static void main(String[] args) {


        createUserListFile();

        User user = new Student("Adam", "Kowalski");
        User student1 = new Student("Ewa", "Kowalska");
        User student2 = new Student("Kajetan", "Kormoran");
        User lecturer = new Lecturer("Asia", "Kowalska");
        User lecturer1 = new Lecturer("Magda", "Kowalska");

        library.addUserToLibraryTest(user, student1, student2, lecturer, lecturer1);
        //library.printListOfUsers();

        //if (user instanceof Lecturer) System.out.println(false);
      //  else if (user instanceof Student) System.out.println(true);


        System.out.println("");
        importItemsFromFile("ItemList.txt");
        library.addItemToLibrary(new Book("Potop", "H. Sienkiewicz"));
        library.addItemToLibrary(new Book("Potop", "H. Sienkiewicz"));
        library.addItemToLibrary(new Book("Ogniem i mieczem", "H. Sienkiewicz"));
        library.addItemToLibrary(new Book("Harry Potter. Czara Ognia", "J.K. Rowling"));
        library.addItemToLibrary(new Book("Harry Potter. Książe półkrwi", "J.K. Rowling"));
        library.addItemToLibrary(new Book("Harry Potter. Czara Ognia", "J.K. Rowling"));
        library.addItemToLibrary(new Book("Lśnienie", "S. King"));
        library.addItemToLibrary(new Magazine("Kobiety kodują", "1/2022"));
        library.addItemToLibrary(new Magazine("Kobiety kodują", "1/2020"));
        library.addItemToLibrary(new Magazine("Kobiety kodują", "1/2020"));
        library.addItemToLibrary(new Magazine("Think Like A Man", "6/2022"));
        library.addItemToLibrary(new Book("Potop", "H. Sienkiewicz"));
        library.addItemToLibrary(new Book("Harry Potter. Czara Ognia", "J.K. Rowling"));

        library.countItemsFromList();
        library.RemoveDuplicatesTwoList();




        importItemsFromFile("ItemList.txt");

        library.rentItemToUser(library.getUserList().get(0), library.getItems().get(0));
        library.rentItemToUser(library.getUserList().get(0), library.getItems().get(3));
        library.rentItemToUser(library.getUserList().get(1), library.getItems().get(3));
        library.rentItemToUser(library.getUserList().get(1), library.getItems().get(1));
        library.rentItemToUser(library.getUserList().get(1), library.getItems().get(1));
        library.rentItemToUser(library.getUserList().get(3), library.getItems().get(1));
        library.rentItemToUser(library.getUserList().get(3), library.getItems().get(4));


        System.out.println(" ");
        library.printListOfUsers();
        System.out.println(" ");
        library.printListOfMagazines();
        System.out.println(" ");
        library.printListOfBooks();
        System.out.println(" ");
        library.printListOfRentedItems();

        exportUsersWithItemsToFile("UserList.txt");
    }

    public static void createUserListFile() {
        try {
            File myObj = new File("UserList.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void exportUsersWithItemsToFile(String csvFile) {
        library.getUserList();

        try {
            FileWriter myWriter = new FileWriter(csvFile);
            for (User user : library.getUserList()) {
                if (!library.exportUsersWithItemsToFile(user).equals(""))
                    myWriter.write(library.exportUsersWithItemsToFile(user) + "\r\n");
            }
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void importItemsFromFile(String csvFile) {
        try {
            File myObj = new File(csvFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                String[] parts = line.split(Pattern.quote(";"));

                importItemsFromFile(parts);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void importItemsFromFile(String[] lines) {
        String title = lines[0];
        Boolean isItemOnList = false;

        if (lines[3].charAt(0) == 'B') {
            String author = lines[1];
            int quantity = Integer.valueOf(lines[2]);

            Book book = new Book(title, author);


            library.addItemToLibrary(book);


            for (Map.Entry<Item, ItemAmountDetails> entry : library.itemsHashMap().entrySet()) {
                if (library.isSameEntry(entry.getKey(), book)) {
                    entry.getValue().increaseQuantity(quantity);
                    isItemOnList = true;
                    break;
                }
            }
            if (!isItemOnList) {
                library.getItemsCounts().add(quantity);
                ItemAmountDetails itemDetails = new ItemAmountDetails(quantity, quantity);
                library.itemsHashMap().put(book, itemDetails);
            }
        } else if (lines[3].charAt(0) == 'M') {
            String number = lines[1];
            int quantity = Integer.valueOf(lines[2]);

            Magazine magazine = new Magazine(title, number);

            library.addItemToLibrary(magazine);

            for (Map.Entry<Item, ItemAmountDetails> entry : library.itemsHashMap().entrySet()) {
                if (library.isSameEntry(entry.getKey(), magazine)) {
                    entry.getValue().increaseQuantity(quantity);
                    isItemOnList = true;
                    break;
                }
            }
            if (!isItemOnList) {
                library.getItemsCounts().add(quantity);
                ItemAmountDetails itemDetails = new ItemAmountDetails(quantity, quantity);
                library.itemsHashMap().put(magazine, itemDetails);
            }
        } else {
            System.out.println("Błędny plik");
        }
    }
}
