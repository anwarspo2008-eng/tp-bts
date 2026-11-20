
import java.io.*;

public class main {
    public static void main(String[] args) throws IOException {      
        File f = new File("test.txt");
        //int c = r.read();
        System.out.println("exist :" + f.exists());
        if (!(f.createNewFile())){
            System.out.println("fichier non exixste !");
        }
        else{
            System.out.println("fichier exist !");
        }
        System.out.println("nom :" + f.getName());
        System.out.println("chemin :" +f.getPath());
        System.out.println("chemin absolu :" +f.getAbsolutePath());
        System.out.println("taille :" +f.length() +" octet");
        System.out.println("est un fichier :" +f.isFile());
        System.out.println("est un dossier :" +f.isDirectory());
        // System.out.println("deleted : " + f.delete());
        

        
    }
}