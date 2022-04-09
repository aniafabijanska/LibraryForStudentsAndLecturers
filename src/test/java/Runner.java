
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

        library.addUserToLibrary(user, student1,student2, lecturer, lecturer1);

        //MOŻNA SOBIE DODAĆ JAKIEŚ O KSIĄŻKI
        System.out.println("");
        importItemsFromFile("ItemList.txt");
        library.addItemToLibrary(new Book("Potop", "H. Sienkiewicz"),new Book("Kosmodupa","L.Koczkodan"));
        library.addItemToLibrary(new Book("Potop", "H. Sienkiewicz"));
        library.addItemToLibrary(new Book("Ogniem i mieczem", "H. Sienkiewicz"));

        Book test1 = new Book("Potop", "H. Sienkiewicz");
        Book test2 = new Book("Kosmodupa","L.Koczkodan");
        Book test3 = new Book("Ogniem i mieczem", "H. Sienkiewicz");

        library.rentItemToUser(library.getUserList().get(0), test1);
        library.rentItemToUser(library.getUserList().get(1), test2);

        library.rentItemToUser(library.getUserList().get(0), test1);
        library.rentItemToUser(library.getUserList().get(0), test3);
        library.rentItemToUser(library.getUserList().get(0), test3);
        library.rentItemToUser(library.getUserList().get(0), test3);
        library.rentItemToUser(library.getUserList().get(0), test3);
        library.rentItemToUser(library.getUserList().get(0), test2);

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

    public static void exportUsersWithItemsToFile(String csvFile)
    {
        library.getUserList();

        try {
            FileWriter myWriter = new FileWriter(csvFile);
            for (User user : library.getUserList()) {
                if(!library.exportUsersWithItemsToFile(user).equals(""))
                    myWriter.write(library.exportUsersWithItemsToFile(user)+ "\r\n");
            }
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void importItemsFromFile(String csvFile)
    {
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

    public static void importItemsFromFile(String[]lines)
    {
        String title = lines[0];
        Boolean isItemOnList=false;

        if (lines[3].charAt(0) == 'B') {
            String author = lines[1];
            int quantity = Integer.valueOf(lines[2]);

            Book book = new Book(title, author);

            for (Map.Entry<Item, ItemAmountDetails> entry : library.itemsAmountDetailsMap().entrySet()) {
                if(entry.getKey().equals(book))
                {
                    entry.getValue().increaseQuantity(quantity);
                    isItemOnList=true;
                    break;
                }
            }
            if(!isItemOnList)
            {
                ItemAmountDetails itemDetails = new ItemAmountDetails(quantity,quantity);
                library.itemsAmountDetailsMap().put(book,itemDetails);
            }
        }
        else if (lines[3].charAt(0) == 'M') {
            String number = lines[1];
            int quantity = Integer.valueOf(lines[2]);

            Magazine magazine = new Magazine(title, number);

            for (Map.Entry<Item, ItemAmountDetails> entry : library.itemsAmountDetailsMap().entrySet()) {
                if(entry.getKey().equals(magazine))
                {
                    entry.getValue().increaseQuantity(quantity);
                    isItemOnList=true;
                    break;
                }
            }
            if(!isItemOnList)
            {
                ItemAmountDetails itemDetails = new ItemAmountDetails(quantity, quantity);
                library.itemsAmountDetailsMap().put(magazine, itemDetails);
            }
        }
        else {
            System.out.println("Błędny plik");
        }
    }
}
