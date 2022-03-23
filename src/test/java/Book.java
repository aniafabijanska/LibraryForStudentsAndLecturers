public class Book extends Item {

    protected String author;

    public Book(String title, String author) {
        super(title);
        this.author = author;
    }
    public void Books(){
        System.out.println( title + ";"+ author);
    }

}
    /*
    public Book(String title, String author, int NumberOfAllCopies) {
        this.title = title;
        this.author = author;
        this.NumberOfAllCopies = NumberOfAllCopies;


        }
        book.add(Integer.parseInt(title), author);

    }
    public void displayBooks() {
        for (String books : book) {
            System.out.println(books);
        }
    }}*/