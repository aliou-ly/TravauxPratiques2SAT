import java.io.File;
import java.io.FileNotFoundException;

    public class Reader<String> extends ReadFile<String> {

        Reader(File file) throws FileNotFoundException {
            super(file);
        }

        @Override
        public boolean hasNext() {
            return scannerFile.hasNextLine();
        }

        @Override
        public String next() {
            return (String) scannerFile.nextLine();
        }

    }

