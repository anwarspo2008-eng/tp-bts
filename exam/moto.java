public class moto extends Vehicule implements Assurable{
    private int cylindre;

    public moto(String matricule, String marque, int cylindre) throws TarifInvalideException {
        super(matricule, marque, tarif);
        this.cylindre = cylindre;
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
        return this.tarif * 0.15;
    }
    @Override
    public String toString() {
        return super.toString() + ", cylindre : " + cylindre;
    }
}