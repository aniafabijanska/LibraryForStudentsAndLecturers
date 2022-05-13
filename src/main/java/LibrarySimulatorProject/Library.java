package LibrarySimulatorProject;

import LibrarySimulatorProject.Item.Book;
import LibrarySimulatorProject.Item.Item;
import LibrarySimulatorProject.Item.Magazine;
import LibrarySimulatorProject.User.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Collections;
import java.util.regex.Pattern;

public class Library {

    private List<User> users = new ArrayList<>();
    private Map<Item, ItemAmountDetails> itemsAmountDetailsMap = new HashMap<>();

    public List<User> getUserList() {
        return users;
    }

    public Map<Item, ItemAmountDetails> itemsAmountDetailsMap() {
        return itemsAmountDetailsMap;
    }

    public void addUserToLibrary(User... users) {
        Collections.addAll(this.users, users);
    }

    public void addItemToLibrary(Item... items) {

        for (Item item : items) {
            if (itemsAmountDetailsMap.size() == 0) {
                ItemAmountDetails itemDetails = new ItemAmountDetails();
                itemsAmountDetailsMap.put(item, itemDetails);
            } else {
                boolean isItemInMap = false;
                for (Map.Entry<Item, ItemAmountDetails> entry : itemsAmountDetailsMap.entrySet()) {
                    if (entry.getKey().equals(item)) {
                        entry.getValue().increaseQuantity();
                        isItemInMap = true;
                        break;
                    }
                }
                if (!isItemInMap) {
                    ItemAmountDetails itemDetails = new ItemAmountDetails();
                    itemsAmountDetailsMap.put(item, itemDetails);
                }
            }
        }
    }

    public boolean rentItemToUser(Book item, User user) {

        if (canRent(item, user)) {
            user.rent(item);
            itemsAmountDetailsMap.get(item).decreaseCurrentQuantity();
            return true;
        } else
            return false;
    }

    private boolean canBeRented(Item item) {
        return (itemsAmountDetailsMap.get(item).getCurrentQuantity() > 0);
    }

    private boolean canRent(Item item, User user) {
        if (item == null || user == null) {
            return false;
        } else {
            return (canBeRented(item) && user.canRent());
        }
    }

    public void printListOfMagazines() {

        for (Map.Entry<Item, ItemAmountDetails> entry : itemsAmountDetailsMap.entrySet()) {
            Item item = entry.getKey();
            Integer currentQuantity = entry.getValue().getCurrentQuantity();
            Integer totalQuantity = entry.getValue().getTotalQuantity();

            if (item instanceof Magazine) {
                System.out.println(item.getTitle() + ";" + ((Magazine) item).getNumber() + ";" + totalQuantity + ";" + currentQuantity);
            }
        }
    }

    public void printListOfBooks() {

        for (Map.Entry<Item, ItemAmountDetails> entry : itemsAmountDetailsMap.entrySet()) {
            Item item = entry.getKey();
            Integer currentQuantity = entry.getValue().getCurrentQuantity();
            Integer totalQuantity = entry.getValue().getTotalQuantity();

            if (item instanceof Book) {
                System.out.println(item.getTitle() + ";" + ((Book) item).getAuthor() + ";" + totalQuantity + ";" + currentQuantity);
            }
        }
    }

    public void printListOfUsers() {
        for (User user : users
        )
            System.out.println(user.getFirstName() + ";" + user.getLastName() + ";" + user.getLibraryCardIndex() + ";" + user.isStudentOrLecturer());
    }


    public void printListOfRentedItems() {
        for (User user : users) {

            String itemInfoMain = "";
            StringBuilder rentedItemsInfoFull;
            if (user.rentedItems.stream().count() == 0) return;

            else {
                rentedItemsInfoFull = new StringBuilder("ID" + user.getLibraryCardIndex() + " [");
                for (Item item : user.rentedItems) {
                    if (item instanceof Book) {
                        String itemInfo = item.getTitle() + "-" + ((Book) item).getAuthor() + "; ";
                        itemInfoMain = itemInfoMain + itemInfo;
                    } else {
                        String itemInfo = item.getTitle() + "-" + ((Magazine) item).getNumber() + "";
                        itemInfoMain = itemInfoMain + itemInfo;
                    }
                }
                rentedItemsInfoFull.append(itemInfoMain);
                rentedItemsInfoFull.deleteCharAt(rentedItemsInfoFull.length() - 1).append("");

            }
            System.out.println(rentedItemsInfoFull + "]");
        }
    }

    public String exportUsersWithItemsToFile(User user) {
        StringBuilder itemInfoMain = new StringBuilder();
        if ((long) user.rentedItems.size() != 0) {
            itemInfoMain.append("ID" + user.getLibraryCardIndex());

            for (Item item : user.rentedItems) {
                String itemInfo;
                if (item instanceof Book) {
                    itemInfo = item.getTitle() + "-" + ((Book) item).getAuthor() + ";";
                } else {
                    itemInfo = item.getTitle() + "-" + ((Magazine) item).getNumber() + ";";
                }
                itemInfoMain.append("[").append(itemInfo).deleteCharAt(itemInfoMain.length() - 1).append("]");
            }
        }
        return itemInfoMain.toString();
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

    public void exportUsersWithItemsToFile(String csvFile) {
        getUserList();

        try {
            FileWriter myWriter = new FileWriter(csvFile);
            for (User user : getUserList()) {
                if (!exportUsersWithItemsToFile(user).equals(""))
                    myWriter.write(exportUsersWithItemsToFile(user) + "\r\n");
            }
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void importItemsFromFile(String csvFile) {
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

    public void importItemsFromFile(String[] lines) {
        String title = lines[0];
        Boolean isItemOnList = false;

        if (lines[3].charAt(0) == 'B') {
            String author = lines[1];
            int quantity = Integer.valueOf(lines[2]);

            Book book = new Book(title, author);

            for (Map.Entry<Item, ItemAmountDetails> entry : itemsAmountDetailsMap().entrySet()) {
                if (entry.getKey().equals(book)) {
                    entry.getValue().increaseQuantity(quantity);
                    isItemOnList = true;
                    break;
                }
            }
            if (!isItemOnList) {
                ItemAmountDetails itemDetails = new ItemAmountDetails(quantity, quantity);
                itemsAmountDetailsMap().put(book, itemDetails);
            }
        } else if (lines[3].charAt(0) == 'M') {
            String number = lines[1];
            int quantity = Integer.valueOf(lines[2]);

            Magazine magazine = new Magazine(title, number);

            for (Map.Entry<Item, ItemAmountDetails> entry : itemsAmountDetailsMap().entrySet()) {
                if (entry.getKey().equals(magazine)) {
                    entry.getValue().increaseQuantity(quantity);
                    isItemOnList = true;
                    break;
                }
            }
            if (!isItemOnList) {
                ItemAmountDetails itemDetails = new ItemAmountDetails(quantity, quantity);
                itemsAmountDetailsMap().put(magazine, itemDetails);
            }
        } else {
            System.out.println("Błędny plik");
        }
    }
}

