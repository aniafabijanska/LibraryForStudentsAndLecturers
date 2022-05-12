package LibrarySimulatorProject;

import LibrarySimulatorProject.Item.Book;
import LibrarySimulatorProject.User.Lecturer;
import LibrarySimulatorProject.User.Student;
import LibrarySimulatorProject.User.User;

public class Runner {

    private static Library library = new Library();

    public static void main(String[] args) {

        library.createUserListFile();

        User user = new Student("Adam", "Kowalski");
        User student1 = new Student("Adam", "Kowalski");
        User student2 = new Student("Adam", "Kowalski");
        User lecturer = new Lecturer("Asia", "Kowalska");
        User lecturer1 = new Lecturer("Magda", "Kowalska");

        library.addUserToLibrary(user, student1, student2, lecturer, lecturer1);

        System.out.println("");
        library.importItemsFromFile("src/main/java/LibrarySimulatorProject/User/Files/ItemList.txt");
        library.addItemToLibrary(new Book("Potop", "H. Sienkiewicz"), new Book("Kosmodupa", "L.Koczkodan"));
        library.addItemToLibrary(new Book("Potop", "H. Sienkiewicz"));
        library.addItemToLibrary(new Book("Ogniem i mieczem", "H. Sienkiewicz"));

        Book test1 = new Book("Potop", "H. Sienkiewicz");
        Book test2 = new Book("Kosmodupa", "L.Koczkodan");
        Book test3 = new Book("Ogniem i mieczem", "H. Sienkiewicz");

        library.rentItemToUser(test2, library.getUserList().get(0));
        library.rentItemToUser(test3, library.getUserList().get(2));
        library.rentItemToUser(test1, library.getUserList().get(1));
        library.rentItemToUser(test3, library.getUserList().get(3));
        library.rentItemToUser(test3, library.getUserList().get(1));
        library.rentItemToUser(test3, library.getUserList().get(3));
        library.rentItemToUser(test3, library.getUserList().get(1));
        library.rentItemToUser(test2, library.getUserList().get(2));

        System.out.println(" ");
        library.printListOfUsers();
        System.out.println(" ");
        library.printListOfMagazines();
        System.out.println(" ");
        library.printListOfBooks();
        System.out.println(" ");
        library.printListOfRentedItems();

        library.exportUsersWithItemsToFile("src/main/java/LibrarySimulatorProject/User/Files/UserList.txt");

    }
}
