
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class read {
    public static void main(String[] args)  throws IOException{
        File f =  new File("test.txt");
        f.createNewFile();
        FileWriter fw = new FileWriter("test.txt");
        fw.write("A");
        fw.write(" bonjour ");
        char[] tab = {'a' , 'x' , 'n'};
        fw.write(tab);
        fw.flush();
        fw.close();
    }
}

