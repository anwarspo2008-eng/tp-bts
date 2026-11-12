public class main {
    public static void main(String[] args) {
        comptBancaire compte = new comptBancaire("ahmed", 1600);
        try {
            compte.retrait(1500.0);
        } catch (soldeIsuffisantException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class soldeIsuffisantException extends Exception {
    public soldeIsuffisantException(String message) {
        super(message);
    }
}

class comptBancaire {
    private     double  solde;
    private     String  titulaire;

    public  comptBancaire(String titulaire, double solde){
        this.titulaire = titulaire;
        this.solde = solde;
    }
    public void setsold(double solde) throws soldeIsuffisantException {
        if (solde <= 0) {
            throw new soldeIsuffisantException("illegalArgummentException");
        } else {
            this.solde = solde;
            throw new soldeIsuffisantException("legalArgummentException");
        }
    }
    public void retrait(double montant) throws soldeIsuffisantException {
        if (montant <= 0) {
            throw new soldeIsuffisantException("illegalArgummentException");
        }
        if (montant > solde) {
            throw new soldeIsuffisantException("solde insuffisant");
        } else {
            solde -= montant;
            throw new soldeIsuffisantException("retrait effectué avec succès");

        }
    }
    public double getSolde() {
        return solde;
    }
}