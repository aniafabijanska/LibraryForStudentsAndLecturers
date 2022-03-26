
import java.io.*;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;


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
        for (Item item : items
        ) {
            if (item instanceof Book)
                System.out.println(item.getTitle() + ";" + ((Book) item).getAuthor() + ";");
        }
        System.out.println();
    }

    public void printListOfMagazines() {
        for (Item item : items
        ) {
            if (item instanceof Magazine)
                System.out.println(item.getTitle() + ";" + ((Magazine) item).getNumber() + ";");
        }
    }


    public boolean rentItemToUser(Item item, User user) {
        return false;
    }}














