import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WirtingToFile {
    private static final String FILE_PATH = "WRITE_README.txt";

        public static void main(String[] args) {
            String textToAdd = "Tekst dodany do nowego pliku\ndruga linia tekstu";

            addContentToFile(textToAdd);
        }



    public static void addContentToFile(String text) {
        /*
        Za pomocą metody statycznej Paths.get() tworzymy obiekt typu Path wskazujący na plik, którego lokalizacja
        została przekazana ze zmiennej FILE_PATH
         */
            Path filePath = Paths.get(FILE_PATH);
        /*
        Jako, że metoda statyczna Files.writeString() może zwrócić wyjątek IOException (np. że nie ma pliku) musimy ją
        umieścić w konstrukcji try-catch
         */
            try {
            /*
            Metoda Files.writeString() otwiera plik, do którego w argumencie metody przekazujemy ścieżkę do pliku, zawartość,
            którą chcemy do tego pliku zapisać oraz sposób operacji na pliku (szczegóły odnośnie operacji StandardOpenOption.CREATE
            można przeczytać klikając z CTRL na słowo CREATE). Sposób operacji na pliku można zmienić na dowolny dostępny w StandardOpenOption
            Jeżeli plik można otworzyć to metoda zapisze w nim zawartość ze zmiennej text.
             */
                Files.writeString(filePath, text, StandardOpenOption.CREATE);
            } catch (IOException e) {
            /*
            Jeżeli nie można otworzyć pliku to na ekranie wypisujemy komentarz
             */
                System.out.println("Unable to add text to the file");
            }
        }


}
