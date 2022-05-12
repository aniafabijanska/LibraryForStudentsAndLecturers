package LibrarySimulatorProject.Item;

import java.util.Comparator;
import java.util.Objects;


public class Item implements Comparator<Item> {

    public String title;

    public Item(String title) {
        this.title = title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(title, item.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compare(Item o1, Item o2) {
        return o1.title.compareTo(o2.title);
    }
}



        





