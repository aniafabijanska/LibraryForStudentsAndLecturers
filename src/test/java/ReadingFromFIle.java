import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class ReadingFromFile {

   private static final String FILE_PATH = "README.txt";


    public static void main(String[] args) {

        System.out.println("\n");
        String content11 = readFileContentJava11();
        System.out.println(content11);
    }

   public static String readFileContentJava11() {
          Path filePath = Paths.get(FILE_PATH);

          try {
           return Files.readString(filePath);
        } catch (IOException e) {
            System.out.println("Not able to read the file");
              return "";
        }
    }}


