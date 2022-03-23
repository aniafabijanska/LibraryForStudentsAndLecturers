

public class Item {
    protected String title;

    public Item(String title) {
        this.title = title;

    }
    }

        
/*

class BookStore{
    private int storeId;
    private List <Object> titles = new ArrayList<>();
/*
    public Item(int storeId) {
        this.storeId = storeId;
    }




    public void printItem() {
        String booksToPrint = "";
        for(int i=0; i< titles.size(); i++) {
            if (i == 0) {
                booksToPrint = (String) titles.get(i);
            } else {
                booksToPrint = booksToPrint + ", " + titles.get(i);
            }


        }
        System.out.println("Book store id:" + storeId);
        System.out.print(booksToPrint);
    }
    public void addBookToStore(String title) {
        titles.add(title);


    }public void addBookToStore(String author) {
        author.add(author);
    }

    public static int idParser(String storeIdAsString) {
        String text = storeIdAsString.replace("ID", "");
        return Integer.parseInt(text);
    }}}}*/
