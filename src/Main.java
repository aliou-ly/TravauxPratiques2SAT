import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ReaderInt readerInt = new ReaderInt(new File("./formule-2-sat.txt"));
        System.out.println(readerInt.nextInt()+"\t"+readerInt.nextInt());
    }


}