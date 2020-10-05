
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReaderInt<Integer> extends ReadFile<java.lang.Integer> {
    private Scanner scannerInt;

    ReaderInt(File file) throws FileNotFoundException {
        super(file);
        toNewline();
    }

    private void toNewline() {
        scannerInt = new Scanner(scannerFile.nextLine());
    }

    private boolean hasNextIntInLine() {

        while (scannerInt.hasNext()) {
            if (scannerInt.hasNextInt()) { return true; }
            scannerInt.next();
        }
        return false;
    }

    @Override
    public boolean hasNext() {

        while ((!hasNextIntInLine()) && (scannerFile.hasNextLine())){
            toNewline();
        }
        return hasNextIntInLine();
    }

    @Override
    public java.lang.Integer next() throws NoSuchElementException {
        hasNext();
        return scannerInt.nextInt();
    }
}
