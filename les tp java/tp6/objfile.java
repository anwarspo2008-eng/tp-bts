import java.io.*;

class etudiant implements Serializable {
    String id;
    String name;
    public etudiant(String id , String name){
        this.id = id;
        this.name = name;
    }
}

public class objfile{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        etudiant e1 =  new etudiant("p123", "karim");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("etudiant.dat"));
        out.writeObject(e1);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("etudiant.dat"));
        etudiant e =(etudiant) in.readObject();
        System.out.println(e);
        in.close();
    }
}


