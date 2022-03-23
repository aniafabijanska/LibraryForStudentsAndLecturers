import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Library library = new Library();

        Scanner scan = new Scanner(System.in);
        boolean shouldContinue = true;

        while (shouldContinue) {
            System.out.println("Wybierz opjcę");
            System.out.println("1. Dodaj nowego użytkownika");
            System.out.println("2. Wypisz wszystkich użytkowników");
            System.out.println("3. Dodaj książkę do  zbiorów");
            System.out.println("4. Wypożycz książkę");
            System.out.println("5. Wypisz wszystkie magazyny");
            System.out.println("6. Wypisz wszystkie książki");
            System.out.println("7. Wyjście");
            int userChoice = scan.nextInt();
            switch (userChoice) {
                case 1 -> {
                    User user = AddNewUserProcedure();
                    library.addUserToLibrary(user,library.getUserList());
                }


                case 2 -> {
                    System.out.println("Lista użytkowników");
                    library.printListOfUsers();
                    System.out.println("");
                }
                //  case 3 -> library.addItemToLibrary();
                case 4 -> System.out.println("Wybrano 4");
                case 5 -> {
                    System.out.println("Lista książek");
                    library.printListOfBooks();
                    System.out.println("");
                }
                case 6 -> System.out.println("Wybrano 6");
                case 7 -> shouldContinue = false;
            }

        }
    }

    public static User AddNewUserProcedure()
    {
        Scanner scan = new Scanner(System.in);
        String name;
        String surname;
        char type;
        User user=null;

        do{
            System.out.println("Podaj imię:");
            name = scan.nextLine();

        }    while(name.isBlank());

        do{
            System.out.println("Podaj nazwisko:");
            surname = scan.nextLine();

        }    while(surname.isBlank());

        do{
            System.out.println("Student czy Wykładowca? 'S'/ 'L':");
            type = scan.next().charAt(0);
        }      while(type != 'S' && type != 'L');

        if(type =='S')
        {
            user = new Student(name,surname);
        }
        else if(type =='L')
        {
            user = new Lecturer(name,surname);
        }

        return user;

    }}