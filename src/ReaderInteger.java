import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReaderInteger extends Reader {
    private Scanner scannerInt;

        ReaderInteger(File file) throws FileNotFoundException {
            super(file);
            if (super.hasNext())
                scannerInt = new Scanner(super.next());
        }

        private boolean hasNextIntInLine() throws NoSuchElementException {

            while(scannerInt.hasNext()) {
                if (scannerInt.hasNextInt())
                    return scannerInt.hasNextInt();
                scannerInt.next();
            }
            return false;
        }

        public boolean hasNextInt() {
            if (hasNextIntInLine()) {
                return hasNextIntInLine();
            }
            while ((!hasNextIntInLine()) && (super.hasNext())){
                scannerInt = new Scanner(super.next());
            }
            return hasNextIntInLine();
        }

        public int nextInt() {
            hasNextInt();
            return scannerInt.nextInt();
        }
}
