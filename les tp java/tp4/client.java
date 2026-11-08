
public class client implements Comparable, Cloneable { 
    private int num; 
    private String email, nom; 

    public client(int num, String email, String nom) throws NuminvalideException { 
        if (num <= 0) { 
            throw new NuminvalideException("le nombre est invalide"); 
        } else { 
            this.num = num; 
            this.email = email; 
            this.nom = nom; 
        } 
    } 

    @Override 
    public boolean equals(Object o) { 
        if (!(o instanceof client)) return false;
        client c = (client) o; 
        return this.num == c.num; 
    } 

    @Override 
    public String toString() { 
        return "num: " + num + ", email:" + email + ",nom:" + nom; 
    } 

    @Override 
    public int compareTo(Object obj) { 
        client c = (client) obj; 
        return Integer.compare(this.num, c.num); 
    } 
} 
 
class NuminvalideException extends Exception { 
    public NuminvalideException(String message) { 
        super(message); 
    } 
}
