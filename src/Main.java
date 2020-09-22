
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

       /*for (String string: readerInteger) {
           System.out.println(string);
       };*/
        while (readerInteger.hasNextInt()){
            System.out.print(readerInteger.nextInt()+"\t");
        }

    }


}