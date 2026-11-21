public class Voiture extends Vehicule implements Assurable {
    private int nombrePlaces;

    public Voiture(String matricule, String marque, double tarif, int nombrePlaces) throws TarifInvalideException {
        super(matricule, marque, tarif);
        this.nombrePlaces = nombrePlaces;
    }

    @Override
    public double calculerCout(int nbJours){
        if (nbJours <= 0) {
            throw new IllegalArgumentException("Le nombre de jours doit être positif (> 0) !");
        }
        return nbJours * this.tarif; 
    }

    @Override
    public double calculerAssurance() {
        return this.tarif * 0.10;
    }

    @Override
    public String toString() {
        return super.toString() + ", Places : " + nombrePlaces;
    }
}