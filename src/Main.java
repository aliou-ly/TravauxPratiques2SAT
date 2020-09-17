
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        ReaderInteger reader =  new ReaderInteger(new File("/amuhome/l19027109/Téléchargements/formule-2-sat.txt"));
        //addIntegerFromLine(new Scanner("p cnf 3 4"));
    }

   /*  static void addIntegerFromLine(Scanner scanner) {
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
            } else { scanner.next(); }
        }
    }*/
}