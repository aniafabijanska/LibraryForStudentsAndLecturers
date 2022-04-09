import java.util.*;
import java.util.Collections;

public class Library {

    private List<User> users = new ArrayList<>();
    private Map<Item,ItemAmountDetails> itemsAmountDetailsMap =new HashMap<>();

    //GETTERS
    public List<User> getUserList() {
        return users;
    }

    public Map<Item,ItemAmountDetails> itemsAmountDetailsMap() {
        return itemsAmountDetailsMap;}

    public void addUserToLibrary(User... users) {
        Collections.addAll(this.users, users);
    }

    public void addItemToLibrary (Item... items){

        for (Item item: items)
        {
            if(itemsAmountDetailsMap.size() == 0) {
                ItemAmountDetails itemDetails = new ItemAmountDetails();
                itemsAmountDetailsMap.put(item, itemDetails);
            }
            else
            {
                boolean isItemInMap=false;
                for (Map.Entry<Item, ItemAmountDetails> entry : itemsAmountDetailsMap.entrySet())
                {
                    if(entry.getKey().equals(item))
                    {
                        entry.getValue().increaseQuantity();
                        isItemInMap=true;
                        break;
                    }
                }
                if(!isItemInMap)
                {
                    ItemAmountDetails itemDetails = new ItemAmountDetails();
                    itemsAmountDetailsMap.put(item, itemDetails);
                }
            }

        }
    }

    public void rentItemToUser(User user, Item item) {

        if (canRent(item, user)) {
            user.rent(item);
            itemsAmountDetailsMap.get(item).decreaseCurrentQuantity();
        }
    }

    private boolean canBeRented(Item item) {
        return (itemsAmountDetailsMap.get(item).getCurrentQuantity()>0);
    }

    private boolean canRent(Item item, User user) {
        return (canBeRented(item) && user.canRent());
    }

    public Item convertItemFromListToHashMap(Item item) {
        for (Map.Entry<Item, ItemAmountDetails> entry : itemsAmountDetailsMap.entrySet()) {
            if(entry.getKey().equals(item))
            {
                return entry.getKey();
            }
        }
        return null;
    }

    //PRINT LISTS METHODS

    public void printListOfMagazines() {

        for(Map.Entry<Item, ItemAmountDetails> entry : itemsAmountDetailsMap.entrySet()) {
            Item item = entry.getKey();
            Integer currentQuantity = entry.getValue().getCurrentQuantity();
            Integer totalQuantity = entry.getValue().getTotalQuantity();

            if(item instanceof Magazine)
            {
                System.out.println(item.getTitle() + ";" + ((Magazine) item).getNumber() + ";"+totalQuantity+";"+currentQuantity);
            }
        }
    }

    public void printListOfBooks() {

        for(Map.Entry<Item, ItemAmountDetails> entry : itemsAmountDetailsMap.entrySet()) {
            Item item = entry.getKey();
            Integer currentQuantity = entry.getValue().getCurrentQuantity();
            Integer totalQuantity = entry.getValue().getTotalQuantity();

            if(item instanceof Book)
            {
                System.out.println(item.getTitle() + ";" + ((Book) item).getAuthor() + ";"+totalQuantity+";"+currentQuantity);
            }
        }
    }

    public void printListOfUsers() {
        for (User user : users
        )
            System.out.println(user.getFirstName() + ";" + user.getLastName() + ";" + user.getLibraryCardIndex() + ";" + user.isStudentOrLecturer());
    }


    //METODA OPCJONALNIE DO SPRAWDZENIA CZY WSZYSTKO DZIAŁA
    public void printListOfRentedItems()
    {
        for (User user: users)
        {
            String rentedItemsInfoFull="";
            String itemInfoMain="";

            if(user.rentedItems.stream().count() ==0) return;
            else
            {
                rentedItemsInfoFull = "ID"+user.getLibraryCardIndex() + " [";
                for (Item item : user.rentedItems)
                {
                    if(item instanceof Book)
                    {
                        String itemInfo= item.getTitle()+"-"+((Book) item).getAuthor()+" ";
                        itemInfoMain=itemInfoMain+itemInfo;
                    }
                    else
                    {
                        String itemInfo= item.getTitle()+"-"+((Magazine) item).getNumber()+" ";
                        itemInfoMain=itemInfoMain+itemInfo;
                    }
                }
                rentedItemsInfoFull=rentedItemsInfoFull+itemInfoMain;
            }
            System.out.println(rentedItemsInfoFull);
        }
    }

    public String exportUsersWithItemsToFile(User user)
    {
        StringBuilder rentedItemsInfoFull=new StringBuilder();

        String itemInfoMain="";

        if(user.rentedItems.stream().count() !=0)
        {
            rentedItemsInfoFull.append("ID"+user.getLibraryCardIndex() + " [");
            for (Item item : user.rentedItems)
            {
                if(item instanceof Book)
                {
                    String itemInfo= " "+item.getTitle()+"-"+((Book) item).getAuthor()+";";
                    itemInfoMain=itemInfoMain+itemInfo;
                }
                else
                {
                    String itemInfo= " "+item.getTitle()+"-"+((Magazine) item).getNumber()+";";
                    itemInfoMain=itemInfoMain+itemInfo;
                }
            }
            rentedItemsInfoFull.append(rentedItemsInfoFull+itemInfoMain);
            rentedItemsInfoFull.deleteCharAt(rentedItemsInfoFull.length()-1).append("]");
        }
        return rentedItemsInfoFull.toString();
    }
}
