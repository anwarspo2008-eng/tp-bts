import java.util.ArrayList;
import java.util.Date; 

public class Command { 
    private String numCmd;
    private Date dateCmd;
    private Client cli;
    private ArrayList<Article> ListArt;

    public Command(String numCmd, Date dateCmd, Client cli) {
        this.numCmd = numCmd;
        this.dateCmd = dateCmd; 
        this.cli = cli;
        this.ListArt = new ArrayList<>();
    }

    public boolean addArt(Article art) {
        return this.ListArt.add(art); 
    }
    public Article delArt(String code) {
        for (int i = 0; i < ListArt.size(); i++) {
            if (ListArt.get(i).getCode().equals(code)) {
                return ListArt.remove(i);
            }
        }
        return null; 
    }

    public Article delArt(int index) {
        if (index >= 0 && index < ListArt.size()) {
            return this.ListArt.remove(index);
        }
        return null;
    }

    public Article updateArt(int index, Article newArticle) {
        if (index >= 0 && index < ListArt.size()) {
            return this.ListArt.set(index, newArticle); 
        }
        return null;
    }

    @Override
    public String toString() {
    }
}
