import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReaderInteger extends Reader {
    private Scanner scannerInt;

        ReaderInteger(File file) throws FileNotFoundException {
            super(file);
            if (super.hasNext())
                scannerInt = new Scanner(super.next());
        }

        private void nextLine() {

        }
    public boolean hasNextIntInLine() throws NoSuchElementException {

        while(scannerInt.hasNext()) {
            if (scannerInt.hasNextInt())
                return scannerInt.hasNextInt();
            scannerInt.next();
        }
        return false;
    }

    public boolean hasNextInt() {
        return super.hasNext();
    }

    public int nextInt() {
        if ((! hasNext()) && super.hasNext()) {
            scannerInt = new Scanner(super.next());
            hasNext();
        }
            return scannerInt.nextInt();
    }
}
