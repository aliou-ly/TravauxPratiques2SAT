
import java.io.File;
import java.io.FileNotFoundException;
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
        public void hasNextIntInLine() {

            while(scannerInt.hasNext()) {
                if (scannerInt.hasNextInt()) {
                    scannerInt.hasNextInt();
                    return;
                }
                scannerInt.next();
            }
        }
    public int nextIntInLine() {
            hasNextIntInLine();
        return scannerInt.nextInt();
    }

    /*public boolean hasNextInt() {
            if (hasNextIntInLine()) {
                return hasNextIntInLine();
            }

            while ((!hasNextIntInLine()) && (super.hasNext())){
               toNewline();
            }
            return hasNextIntInLine();
        }

        public int nextInt() throws NoSuchElementException {
           // hasNextInt();
            return scannerInt.nextInt();
        }

        */
}
