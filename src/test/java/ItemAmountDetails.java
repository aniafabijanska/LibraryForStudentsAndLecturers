
public class ItemAmountDetails {
    private int totalQuantity;
    private int currentQuantity;

    public ItemAmountDetails() {
        this(1, 1);
    }

    public ItemAmountDetails(int totalQuantity, int currentQuantity) {
        this.totalQuantity = totalQuantity;
        this.currentQuantity = currentQuantity;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void decreaseCurrentQuantity() {
        this.currentQuantity--;
    }

    void increaseQuantity() {
        this.currentQuantity++;
        this.totalQuantity++;
    }

    void increaseQuantity(int amount) {
        this.currentQuantity += amount;
        this.totalQuantity += amount;
    }
}
