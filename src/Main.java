
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        ReaderInteger readerInteger = new ReaderInteger(new File ("/amuhome/l19027109/Téléchargements/formule-2-sat.txt"));
        readerInteger.nextInt();
        readerInteger.nextInt();
        readerInteger.nextInt();
        System.out.println(readerInteger.nextInt());

    }


}