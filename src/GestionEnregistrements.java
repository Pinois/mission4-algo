import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class GestionEnregistrements {
	public static final int NOMBREDOMAINES = 3;
	public static final String FOR1NAME = "for1";
	public static final String FOR2NAME = "for2";
	public static final String FOR3NAME = "for3";
	private TreeMap<String, Enregistrement> enregistrements = null;
	Map<String, TreeMap<String, List<Enregistrement>>> enregistrementsParDomaine = null;

	public GestionEnregistrements() {
		enregistrements = new TreeMap<String, Enregistrement>();
		enregistrementsParDomaine = new HashMap<String,TreeMap<String, List<Enregistrement>>>();
		enregistrementsParDomaine.put(FOR1NAME, new TreeMap<String, List<Enregistrement>>());
		enregistrementsParDomaine.put(FOR2NAME, new TreeMap<String, List<Enregistrement>>());
		enregistrementsParDomaine.put(FOR3NAME, new TreeMap<String, List<Enregistrement>>());
	}

	public TreeMap<String, Enregistrement> getEnregistrements() {
		return enregistrements;
	}

	public void setEnregistrements(TreeMap<String, Enregistrement> enregistrements) {
		this.enregistrements = enregistrements;
	}
	
	public Enregistrement getEnregistrement(String title) {
		return enregistrements.get(title);
	}
	
	public List<Enregistrement> getEnregistrementsParDomaine(String domaine, String nom) {
		return enregistrementsParDomaine.get(domaine).get(nom);
	}
	
	public void putEnregistrement(String title, Enregistrement enregistrement) {
		if(title != null && !title.isEmpty() && !enregistrements.containsKey(title)){
			enregistrements.put(title, enregistrement);

			List<Enregistrement> enregistrementsPourUnDomaine = null;
			if(enregistrement.getFor1() != null){
				enregistrementsPourUnDomaine = enregistrementsParDomaine.get(FOR1NAME).get(enregistrement.getFor1());
				if(enregistrementsPourUnDomaine == null){
					enregistrementsPourUnDomaine = new ArrayList<Enregistrement>();
					enregistrementsParDomaine.get(FOR1NAME).put(enregistrement.getFor1(), enregistrementsPourUnDomaine);
				}
				enregistrementsPourUnDomaine.add(enregistrement);
			}
			if(enregistrement.getFor2() != null){
				enregistrementsPourUnDomaine = enregistrementsParDomaine.get(FOR2NAME).get(enregistrement.getFor2());
				if(enregistrementsPourUnDomaine == null){
					enregistrementsPourUnDomaine = new ArrayList<Enregistrement>();
					enregistrementsParDomaine.get(FOR2NAME).put(enregistrement.getFor2(), enregistrementsPourUnDomaine);
				}
				enregistrementsPourUnDomaine.add(enregistrement);
			}
			if(enregistrement.getFor3() != null){
				enregistrementsPourUnDomaine = enregistrementsParDomaine.get(FOR3NAME).get(enregistrement.getFor3());
				if(enregistrementsPourUnDomaine == null){
					enregistrementsPourUnDomaine = new ArrayList<Enregistrement>();
					enregistrementsParDomaine.get(FOR3NAME).put(enregistrement.getFor3(), enregistrementsPourUnDomaine);
				}
				enregistrementsPourUnDomaine.add(enregistrement);
			}
		}
	}
}