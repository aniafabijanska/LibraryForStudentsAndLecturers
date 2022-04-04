import java.util.*;

public class Library {

    private List<User> users = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private List<Integer> itemsCounts = new ArrayList<>();
    private  List<ItemAmountDetails> itemAmountDetailsAmount = new ArrayList<>();
    private Map<Item,ItemAmountDetails> itemsHashMap=new HashMap<>();
    private Map<Item,Integer> itemsHashMapWithNoDuplicates = new HashMap();

    //GETTERS
    public List<User> getUserList() {
        return users;
    }
    public List<Item> getItems() {
        return items;
    }
    public Map<Item,ItemAmountDetails> itemsHashMap() {
        return itemsHashMap;}

    public void addUserToLibraryTest(User... users) {
        for (User user : users) {
            this.users.add(user);
        }
    }
    public void addItemToLibrary (Item... items){
        for (Item item : items) {
            this.items.add(item);
        }
    }

    public void countItemsFromList()
    {
        int occurrences=0;
        for(Item ItemChecked : items) {

            for(Item otherItem : items) {
                if(isSameEntry(otherItem,ItemChecked))
                    occurrences++;
            }
            ItemAmountDetails itemDetails = new ItemAmountDetails(occurrences, occurrences);
            itemAmountDetailsAmount.add(itemDetails);
            occurrences=0;
        }
    }

    public void RemoveDuplicatesTwoList()
    {
        for (int i=0; i<items.stream().count();i++)
        {
            boolean firstTime=true;

            for (int j=0; j<items.stream().count();j++)
            {
                if(isSameEntry(items.get(i), items.get(j)))
                {
                    if(firstTime)
                    {
                        itemsHashMap.put(items.get(j),itemAmountDetailsAmount.get(j));
                        firstTime=false;
                    }
                }
            }
        }
    }

    public boolean isSameEntry(Item itemChecked, Item itemOther)
    {
        if(itemChecked.getTitle().equals(itemOther.getTitle()))
        {
            if(itemChecked instanceof Magazine && itemOther instanceof  Magazine)
            {
                if(((Magazine) itemChecked).getNumber().equals(((Magazine) itemOther).getNumber()))
                    return true;
                else return false;
            }

            else if(itemChecked instanceof Book && itemOther instanceof  Book){
                if(((Book) itemChecked).getAuthor().equals(((Book) itemOther).getAuthor()))
                    return true;
                else return false;
            }
            else
                return false;
        }
        else
        {
            return false;
        }
    }

    public void rentItemToUser(User user, Item item) {

        if (canRent(item, user)) {
            user.rent(item);
            itemsHashMap.get(convertItemFromListToHashMap(item)).decreaseCurrentQuantity();
        }
    }

    private boolean canBeRented(Item item) {
        return (itemsHashMap.get(convertItemFromListToHashMap(item)).getCurrentQuantity()>0);
    }

    private boolean canRent(Item item, User user) {
        return (canBeRented(item) && user.canRent());
    }

    public Item convertItemFromListToHashMap(Item item) {
        for (Map.Entry<Item, ItemAmountDetails> entry : itemsHashMap.entrySet()) {
            if(isSameEntry(entry.getKey(),item ))
            {
                return entry.getKey();
            }
        }
        return null;
    }

    //PRINT LISTS METHODS

    public void printListOfMagazines() {

        for(Map.Entry<Item, ItemAmountDetails> entry : itemsHashMap.entrySet()) {
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

        for(Map.Entry<Item, ItemAmountDetails> entry : itemsHashMap.entrySet()) {
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