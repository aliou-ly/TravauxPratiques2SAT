import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public abstract class ReadFile<E> implements Iterator<E> {
    protected Scanner scannerFile;

    ReadFile(File file) throws FileNotFoundException {
        scannerFile = new Scanner(file);
    }
}
