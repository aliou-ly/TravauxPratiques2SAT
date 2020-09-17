import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ReaderInteger extends Reader {
        private ArrayList<Integer> integerLinkedList = new ArrayList<>();

        ReaderInteger(File file) throws FileNotFoundException {
            super(file);
            addIntegerFromFile();
        }

        private void addIntegerFromFile(){
            for (String line : this){
                addIntegerFromLine(line);
            }
        }

        private void addIntegerFromLine(String line) {
            Scanner scanner = new Scanner(line);
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    integerLinkedList.add(scanner.nextInt());
                } else { scanner.next(); }
            }
     }


     public Iterator<Integer> iteratorInteger() {
        return integerLinkedList.iterator();
    }

}
