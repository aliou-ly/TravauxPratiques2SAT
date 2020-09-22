import java.io.File;
import java.io.FileNotFoundException;
import com.company.Graph;

public class Main {
    static ReaderInteger readerInteger;

    static {
        try {
            readerInteger = new ReaderInteger(new File ("/amuhome/l19027109/Téléchargements/formule-2-sat.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //tatic Graph graph = new Graph(readerInteger.nextInt());

    public static void main(String[] args) {

      for (String string : readerInteger) {
          System.out.println(string);
      }

      for (String string: readerInteger) {
          System.out.println(string);
      }
    }
    static void createGraph(){
    }
}