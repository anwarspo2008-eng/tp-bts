
import java.io.*;


public class main2{
    public static void main(String[] args) throws IOException{
        InputStream in = new FileInputStream("test.txt");
        byte[] tab = new byte[4];
        int n = in.read(tab);
        System.out.println("");


    }
}