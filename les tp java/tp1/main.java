public class main{
  public static void main(String[] args){
    Etudiant e = new Etudiant();

    try{
      e.setNote(25);
      System.out.println("Note de l'étudiant : " + e.getNote());
    } catch (NoteInvalideException ex) {
      System.out.println("Erreur : " + ex.getMessage());
    }
  }
}

class NoteInvalideException extends Exception {
    public NoteInvalideException(String message) {
        super(message);
    }
}

class Etudiant {
  private double note;
  public void setNote(double note) throws NoteInvalideException {
    if ( note < 0 || note > 20) {
      throw new NoteInvalideException("La note doit être comprise entre 0 et 20.");
    }
    this.note = note;
  }
  public double getNote() {
    return note;
  }
}
