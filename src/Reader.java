import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

    public class Reader implements Iterator<String>, Iterable<String> {
        private Scanner scanner;

        Reader(File file) throws FileNotFoundException {
            scanner = new Scanner(file);
        }

        @Override
        public boolean hasNext() {
            return scanner.hasNextLine();
        }

        @Override
        public String next() {
            return scanner.nextLine();
        }

        @Override
        public Iterator<String> iterator() {
            return this;
        }
    }

