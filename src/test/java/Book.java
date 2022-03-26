public class Book extends Item {

    private String author;


    public Book(String title, String author) {
        super(title);
        this.author = author;
        System.out.println(author + ";" + title);

    }


}



