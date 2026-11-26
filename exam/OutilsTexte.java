public class OutilsTexte{
    public static String formaterNomClient(String nom){
        if(nom == null){
            System.out.println("insufisant args");
        }
        String o = nom.trim();
        return o.toUpperCase();
    }
    public static boolean verifierMatricule(String matricule){
    if (matricule == null) {
        return false;
    }
    boolean commenceParMA = matricule.startsWith("MA- ");
    boolean finitPar26 = matricule.endsWith("-26");
    boolean contientTiret = matricule.indexOf('-') != -1;
    return commenceParMA && finitPar26 && contientTiret;
    }
}   
