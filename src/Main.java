import java.util.ArrayList;
import java.util.List;


public class Main {
	public static final int RANK = 0;
	public static final int TITLE = 1;
	public static final int FOR1 = 2;
	public static final int FOR1NAME = 3;
	public static final int FOR2 = 4;
	public static final int FOR2NAME = 5;
	public static final int FOR3 = 6;
	public static final int FOR3NAME = 7;
	
	public static void main(String[] args) {
		
		// création et ouverture du fichier en lecture
		Fichier fichierR = new Fichier();
		fichierR.ouvrir("journals.csv", 'R');
		String ligneInput = null;
		GestionEnregistrements gestionEnregistrement = new GestionEnregistrements();
		// On effectue la lecture ligne par ligne
		while((ligneInput = fichierR.lire()) != null){
			// On commence par vérifier si la ligne n'est pas vide, si c'est le cas, on passe à la ligne suivante
			if(ligneInput.isEmpty()){
				continue;
			}
			// On check le cas où la ligne contient des '"' et on effectue un traitement particulier
			if(ligneInput.contains("\"")){
				ligneInput = traitement(ligneInput);
			}
			// On calcule le nombre de virgule séparant les différents champs pour vérfier la cohérence des données
			int nombreVirgule = 0;
			for (int i = 0; i < ligneInput.length(); i++) {
				if(ligneInput.charAt(i) == ','){
					nombreVirgule++;
				}
			}
			// Si le nombre de virgule séparant les différents champs n'est pas celle défini en header de fichier.
			if(nombreVirgule != 7){
				continue;
			}
			// Après avoir séparé les différents champs, on remplace pour chaque champ les '\' par des ','
			String[] champs = ligneInput.split(",");
			for (int i = 0; i < champs.length; i++) {
				champs[i] = champs[i].replace('\\', ',');
			}
			
			Enregistrement enregistrement = null;
			switch (champs.length) {
				case 4:
					enregistrement = new Enregistrement(champs[RANK], champs[TITLE], champs[FOR1], champs[FOR1NAME]);
					break;
				case 6: 
					enregistrement = new Enregistrement(champs[RANK], champs[TITLE], champs[FOR1], champs[FOR1NAME], champs[FOR2], champs[FOR2NAME]);
					break;
				case 8:
					enregistrement = new Enregistrement(champs[RANK], champs[TITLE], champs[FOR1], champs[FOR1NAME], champs[FOR2], champs[FOR2NAME], champs[FOR3], champs[FOR3NAME]);
					break;
				default:
					break;
			}
			if(enregistrement != null)
				gestionEnregistrement.putEnregistrement(enregistrement.getTitle(), enregistrement);
		}
		List<Enregistrement> enreg = gestionEnregistrement.getEnregistrementsParDomaine(GestionEnregistrements.FOR2NAME, "1506");
		if (enreg !=null) {
			for (Enregistrement enregistrement : enreg) {
				System.out.println(enregistrement.toString());
			}
		}
		// simple test
//		System.out.println((gestionEnregistrement.getEnregistrement("Accounting Historians Journal")).toString());
	}
	/**
	 * vérifie si le token est un integer ou non
	 * @param token
	 * 						le token à traiter
	 * @return false si le token n'est pas un "integer"
	 */
	public static boolean isInteger(String token){
		try{
			Integer.valueOf(token);
			return true;
		} catch(NumberFormatException e){
			return false;
		}
	}
	public static String traitement(String input){
		for(int i =0; i<input.length()-1; i++){
			if(input.charAt(i)== ',' && input.charAt(i+1)=='"' ){
				int j =i;
				while (!((input.length() == j+1 && input.charAt(j) == '"') || (input.charAt(j)=='"' && input.charAt(j+1)==','))){
					j++;
				}
				// Pour une chaine comprise entre '"', on remplace les ',' par des '\' en prévention d'un futur split sur cette ligne avec le séparateur ','
				String subStringModified = (input.substring(i+2,j)).replace(',', '\\'); 
				// On remplace l'ancienne substring par la nouvelle
				input = input.substring(0,i+1)+subStringModified+input.substring(j+1,input.length());
			}
		}
		// on remplace tous les "" par des "
		input = input.replaceAll("\"\"", "\"");
		return input;
	}
	
	
}
