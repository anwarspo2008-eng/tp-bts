
import java.io.*;


public class m1{
    public static void main(String[] args) throws IOException 
    {
        Writer w = new BufferedWriter(new FileWriter("test.txt")); 
        w.write('A');
     
        char[] tab = {'b', 'n' ,'f' ,'p'};
        w.write(tab);
    }
}
