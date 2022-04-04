public class Magazine extends Item{

    protected String number;

    public Magazine(String title, String number) {
        super(title);
        this.number=number;
    }

    public String getNumber() { return number;}
}
