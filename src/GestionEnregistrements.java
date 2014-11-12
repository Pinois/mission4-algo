import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GestionEnregistrements {
	public static final int NOMBREDOMAINES = 3;
	public static final String FOR1NAME = "for1name";
	public static final String FOR2NAME = "for2name";
	public static final String FOR3NAME = "for3name";
	public static final String RANG = "rang";
	private TreeMap<String, Enregistrement> enregistrements = null;
	Map<String, Map<String, TreeMap<String, Enregistrement>>> enregistrementsParDomaine = null;

	public GestionEnregistrements() {
		enregistrements = new TreeMap<String, Enregistrement>();
		enregistrementsParDomaine = new HashMap<String, Map<String, TreeMap<String, Enregistrement>>>();
		enregistrementsParDomaine.put(FOR1NAME, new HashMap<String, TreeMap<String, Enregistrement>>());
		enregistrementsParDomaine.put(FOR2NAME, new HashMap<String, TreeMap<String, Enregistrement>>());
		enregistrementsParDomaine.put(FOR3NAME, new HashMap<String, TreeMap<String, Enregistrement>>());
		enregistrementsParDomaine.put(RANG, new HashMap<String, TreeMap<String, Enregistrement>>());
	}

	public List<Enregistrement> getEnregistrements() {
		return new ArrayList<Enregistrement>(enregistrements.values());
	}

	public void setEnregistrements(TreeMap<String, Enregistrement> enregistrements) {
		this.enregistrements = enregistrements;
	}

	public Enregistrement getEnregistrement(String title) {
		return enregistrements.get(title);
	}

	public List<Enregistrement> getEnregistrementsParDomaine(String domaine, String nom) {
		TreeMap<String, Enregistrement> enregs = enregistrementsParDomaine.get(domaine).get(nom);
		return (enregs != null) ? new ArrayList<Enregistrement>(enregs.values()) : new ArrayList<Enregistrement>() ;
	}

	public void putEnregistrement(String title, Enregistrement enregistrement) {
		if (title != null && !title.isEmpty() && !enregistrements.containsKey(title)) {
			enregistrements.put(title, enregistrement);

			TreeMap<String, Enregistrement> enregistrementsPourUnDomaine = null;
			if (!enregistrement.getFor1Name().isEmpty()) {
				enregistrementsPourUnDomaine = enregistrementsParDomaine.get(FOR1NAME).get(enregistrement.getFor1Name());
				if (enregistrementsPourUnDomaine == null) {
					enregistrementsPourUnDomaine = new TreeMap<String, Enregistrement>();
					enregistrementsParDomaine.get(FOR1NAME).put(enregistrement.getFor1Name(), enregistrementsPourUnDomaine);
				}
				enregistrementsPourUnDomaine.put(enregistrement.getTitle(), enregistrement);
			}
			if (!enregistrement.getFor2Name().isEmpty()) {
				enregistrementsPourUnDomaine = enregistrementsParDomaine.get(FOR2NAME).get(enregistrement.getFor2Name());
				if (enregistrementsPourUnDomaine == null) {
					enregistrementsPourUnDomaine = new TreeMap<String, Enregistrement>();
					enregistrementsParDomaine.get(FOR2NAME).put(enregistrement.getFor2Name(), enregistrementsPourUnDomaine);
				}
				enregistrementsPourUnDomaine.put(enregistrement.getTitle(), enregistrement);
			}
			if (!enregistrement.getFor3Name().isEmpty()) {
				enregistrementsPourUnDomaine = enregistrementsParDomaine.get(FOR3NAME).get(enregistrement.getFor3Name());
				if (enregistrementsPourUnDomaine == null) {
					enregistrementsPourUnDomaine = new TreeMap<String, Enregistrement>();
					enregistrementsParDomaine.get(FOR3NAME).put(enregistrement.getFor3Name(), enregistrementsPourUnDomaine);
				}
				enregistrementsPourUnDomaine.put(enregistrement.getTitle(), enregistrement);
			}
			if (!enregistrement.getRank().isEmpty()) {
				enregistrementsPourUnDomaine = enregistrementsParDomaine.get(RANG).get(enregistrement.getRank());
				if (enregistrementsPourUnDomaine == null) {
					enregistrementsPourUnDomaine = new TreeMap<String, Enregistrement>();
					enregistrementsParDomaine.get(RANG).put(enregistrement.getRank(), enregistrementsPourUnDomaine);
				}
				enregistrementsPourUnDomaine.put(enregistrement.getTitle(), enregistrement);
			}
		}
	}

	public List<Enregistrement> getEnregistrementsParDomaines(boolean rangDomaine, String rangName, boolean for1Domaine, String for1Name, boolean for2Domaine, String for2Name, boolean for3Domaine, String for3Name) {
		List<Enregistrement> enregs = new ArrayList<Enregistrement>(enregistrements.values());
		List<Enregistrement> enregsResult = new ArrayList<Enregistrement>();
		for (Enregistrement enreg : enregs) {
			if(!((for1Domaine && !enreg.getFor1Name().equals(for1Name)) || (for2Domaine && !enreg.getFor2Name().equals(for2Name)) || (for3Domaine && !enreg.getFor3Name().equals(for3Name)) || (rangDomaine && !enreg.getRank().equals(rangName)) )){
				enregsResult.add(enreg);
			}
		}
		
		return new ArrayList<Enregistrement>(enregsResult);
	}
}
