public abstract class Vehicule implements Comparable{
    protected String matricule;
    protected String marque;
    protected double tarif;
    
    public abstract double calculerCout(int nbJours);

    public Vehicule(String matricule , String marque ,double tarif) throws TarifInvalideException{
            if(tarif <= 0 ){
                throw new TarifInvalideException("TarifInvalide");
            }
            else{
                this.tarif = tarif;
            }
            if(matricule == null){
                throw new IllegalArgumentException("IllegalArgument");
            }
            else{
                this.matricule = matricule;
            }
            this.marque = marque ;
    }
    public String getmarque(){
        return this.marque;
    }
    public String getmatricule(){
        return this.matricule;
    }
    public double gettarif(){
        return this.tarif;
    }
    public void affichermarque(){
        System.err.println("la marque est :" +this.marque);
    }
   @Override
    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (ob == null || !(ob instanceof Vehicule)) return false;

        Vehicule v = (Vehicule) ob;
        return this.matricule.equalsIgnoreCase(v.matricule);
    }

    @Override
    public int compareTo(Object o) {
        Vehicule v = (Vehicule) o;
        return Double.compare(this.tarif, v.tarif);
    }
    @Override
    public String toString(){
        return "matricule :" +matricule + " la marque :" + "tarif :" +tarif ;
    }
}