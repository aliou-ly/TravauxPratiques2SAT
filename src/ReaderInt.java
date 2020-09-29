
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReaderInt extends Reader {
    private Scanner scannerInt;

        ReaderInt(File file) throws FileNotFoundException {
            super(file);
            toNewline();
        }
    void toNewline(){
        if (super.hasNext())
            scannerInt = new Scanner(super.next());
    }
    public boolean hasNextIntInLine() {

            while(scannerInt.hasNext()) {
                if (scannerInt.hasNextInt()) {
                    return scannerInt.hasNextInt();
                }
                scannerInt.next();
            }
            return false;
        }
    public int nextIntInLine() {
            hasNextIntInLine();
        return scannerInt.nextInt();
    }

    public boolean hasNextInt() {
            if (hasNextIntInLine()) {
                return hasNextIntInLine();
            }

            while ((!hasNextIntInLine()) && (super.hasNext())){
               toNewline();
            }
            return hasNextIntInLine();
        }

        public int nextInt() throws NoSuchElementException {
            hasNextInt();
            return scannerInt.nextInt();
        }

}
