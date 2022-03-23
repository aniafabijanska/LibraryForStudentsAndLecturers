import java.util.ArrayList;
import java.util.List;



public class Library {
        private List<User> users = new ArrayList<>();


public void addUserToLibrary(User newUser, List<User> usersList)
        {
        usersList.add(newUser);
        System.out.println("Nowy użytkownik został dodany");
        }

public void addItemToLibrary(Item newItem, List<Item> itemsList)
        {
        itemsList.add(newItem);
        System.out.println("Nowy przedmiot został dodany");
        }


public List<User> getUserList() {
        return users;
        }

public void printListOfUsers() {
        for (User user : users
        )

                System.out.println(user.getFirstName() + ";" + user.getLastName() + ";" + user.getLibraryCardIndex() + ";" + user.isStudentOrLecturer());
        /*for (int i = 0; i < namesList.size(); i++) {
                System.out.println(namesList.get(i));*/
        }

public void printListOfBooks(){
         List<Book> books = new ArrayList<>();
         books.add(new Book("Ogniem i mieczem", "Henryk Sienkiewicz" ));
         books.add(new Book("Ogniem i mieczem", "Henryk Sienkiewicz" ));
         books.add(new Book("Ogniem i mieczem", "Henryk Sienkiewicz" ));
         books.add(new Book("Harry Potter", "J.K. Rowling" ));
         books.add(new Book("Harry Potter", "J.K. Rowling" ));
         books.add(new Book("Lśnienie", "S. King" ));


        for (Book listOfBook: books) {
        System.out.println(listOfBook);
}

        }
        }
/*List<String> namesList = new ArrayList<>();
        namesList.add("Bartek", "Ania", "Piotr");
public class Library{
   private List<User> users = new LinkedList<>();
    private List<Item> items = new ArrayList<>();

    public void addUserToLibrary(User newUser, List<User> usersList)
    {
        usersList.add(newUser);
        System.out.println("Nowy użytkownik został dodany");
    }




    public List<User> getUserList() {
        return users;
    }

    public void printListOfUsers() {
        for (User user : users
        ) {
            System.out.println(user.getFirstName() + ";" + user.getLastName() + ";" + user.getLibraryCardIndex() + ";" + user.isStudentOrLecturer());
        }



        }


    public void addItemToLibrary(Item newItem, List<Item> itemsList) {
        {
            itemsList.add(newItem);
            System.out.println("Nowy przedmiot został dodany");
        }

    }
    public void printListOfBooks() {
        ArrayList<Book> list = new ArrayList<Book>();

    Book book = new Book ("Ogniem i mieczem", "Henryk Sienkiewicz");
    Book book1 = new Book ("Ogniem i mieczem", "Henryk Sienkiewicz");
    Book book2 = new Book ("Ogniem i mieczem", "Henryk Sienkiewicz");
    Book book3 = new Book ("Tożsamość Bourne’a", "Robert Ludlum");
    Book book4 = new Book ("Tożsamość Bourne’a", "Robert Ludlum");
    Book book5 = new Book ("Gra o tron", "George R.R. Martin");

        for(Book  items:list) {
            System.out.println((items.getTitle()) + items.getAuthor());

        }

        }


}*/
