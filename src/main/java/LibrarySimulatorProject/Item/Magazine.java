package LibrarySimulatorProject.Item;

import java.util.Objects;

public class Magazine extends Item {

    private String number;

    public Magazine(String title, String number) {
        super(title);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazine magazine = (Magazine) o;
        return Objects.equals(number, magazine.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

