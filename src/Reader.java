import java.awt.desktop.SystemEventListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Reader {
        public Stream streamReader;

    public Reader(Path path) throws IOException {
        streamReader = Files.lines(path);
    }

}
