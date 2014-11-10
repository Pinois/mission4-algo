import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class GestionEnregistrements {
	public static final int NOMBREDOMAINES = 3;
	public static final int FOR1NAME = 0;
	public static final int FOR2NAME = 1;
	public static final int FOR3NAME = 2;
	private TreeMap<String, Enregistrement> enregistrements = null;
	List<TreeMap<String, List<Enregistrement>>> EnregistrementsParDomaine = null;

	public GestionEnregistrements() {
		enregistrements = new TreeMap<String, Enregistrement>();
		EnregistrementsParDomaine = new ArrayList<TreeMap<String, List<Enregistrement>>>(NOMBREDOMAINES);
		for (int i = 0; i < NOMBREDOMAINES; i++) {
			EnregistrementsParDomaine.set(i, new TreeMap<String, List<Enregistrement>>());
		}
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
	
	public List<Enregistrement> getEnregistrementsParDomaine(int domaine, String nom) {
		return EnregistrementsParDomaine.get(domaine).get(nom);
	}
	
	public void addEnregistrement(String title, Enregistrement enregistrement) {
		if(title != null && !title.isEmpty() && !enregistrements.containsKey(title)){
			enregistrements.put(title, enregistrement);
			
			for (int i = 0; i < NOMBREDOMAINES; i++) {
				List<Enregistrement> enregistrementsPourUnDomaine = null;
				switch (i) {
					case FOR1NAME:
						if(enregistrement.getFor1() != null){
							enregistrementsPourUnDomaine = EnregistrementsParDomaine.get(FOR1NAME).get(enregistrement.getFor1());
							if(enregistrementsPourUnDomaine == null){
								enregistrementsPourUnDomaine = new ArrayList<Enregistrement>();
							}
							enregistrementsPourUnDomaine.add(enregistrement);
						}

						break;
					case FOR2NAME:
						if(enregistrement.getFor1() != null){
							enregistrementsPourUnDomaine = EnregistrementsParDomaine.get(FOR2NAME).get(enregistrement.getFor2());
							if(enregistrementsPourUnDomaine == null){
								enregistrementsPourUnDomaine = new ArrayList<Enregistrement>();
							}
							enregistrementsPourUnDomaine.add(enregistrement);
						}
						break;
					case FOR3NAME:
						if(enregistrement.getFor3() != null){
							enregistrementsPourUnDomaine = EnregistrementsParDomaine.get(FOR3NAME).get(enregistrement.getFor3());
							if(enregistrementsPourUnDomaine == null){
								enregistrementsPourUnDomaine = new ArrayList<Enregistrement>();
							}
							enregistrementsPourUnDomaine.add(enregistrement);
						}
						break;
					default:
						break;
				}
			}
		}
	}
}