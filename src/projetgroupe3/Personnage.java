package projetgroupe3;

import java.util.ArrayList;



public class Personnage {
	private String name;
	private int pV=5;
	private ArrayList<Item>inventaire= new ArrayList<Item>();
	private boolean alive=true;
	private int[] position= new int[2];
	private Plateaudejeu plateau = new Plateaudejeu(9,15,44,15,15);//Pas idéal...
	
	public Personnage(String name, int[]position) {
		setName(name);
		setPosition(position);
		inventaire.add(Item.Bombe);
	}
	
	public Personnage(String name){
		setName(name); 
		inventaire.add(Item.Bombe);
	}
	

	public Plateaudejeu getPlateau() {
		return plateau;
	}
	
	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}

	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if (name.length()<=10 && name.length()>0)
			this.name = name;
		else
			System.out.println("Votre nom doit faire au moins 1 caractère et au maximum 10!");
	}
	
	public int getPV() {
		return pV;
	}
	
	public void setPV(int pv) {
		if(pv>=0)
		pV = pv;
		else 
			System.out.println("Ce nombre est inférieur à zéro.");
	}



	public ArrayList<Item> getInventaire() {
		return inventaire;
	}

	public void setInventaire(ArrayList<Item> inventaire) {
		this.inventaire = inventaire;
	}
	public void addPotion() {
		this.inventaire.add(Item.Potion);
	}

	public boolean isAlive() {
		return alive;
	}
	public void dead() {
		alive=false;	
	}
	
	//-2PV lorsqu'il y a un piège
	public void trap() {
		int dmg=2;
		if(pV-dmg<1) {
			dead();
		}else{
			setPV(this.getPV()-dmg);
		
		}
	}
	// permet au Personnage de se soigner s’il possède une potion dans son inventaire
	public void usePotion() {
		
		int heal=3;
		if (!getInventaire().isEmpty()) {
			int i=0;
			while ((i<getInventaire().size()-1) & (getInventaire().get(i)!=Item.Potion)) {
				i++;
			}
			if (getInventaire().get(i)==Item.Potion) {
				setPV(this.getPV()+heal);
				System.out.println("Vous utilisez une potion, +"+heal+" HP");
				inventaire.remove(i);
			}
			else {
				System.out.println("Vous n'avez pas de potion dans votre inventaire...");

			}
		}
		else {
			System.out.println("Votre inventaire est vide");

		}
		
	}

public String usePotionClient() {
		String str="";
		int heal=3;
		if (!getInventaire().isEmpty()) {
			int i=0;
			while ((i<getInventaire().size()-1) & (getInventaire().get(i)!=Item.Potion)) {
				i++;
			}
			if (getInventaire().get(i)==Item.Potion) {
				setPV(this.getPV()+heal);
				str+="Vous utilisez une potion, +"+heal+" HP\n";
				inventaire.remove(i);
			}
			else {
				str+="Vous n'avez pas de potion dans votre inventaire...\n";

			}
		}
		else {
			str+="Votre inventaire est vide\n";

		}
		return str;
		
	}

	// L'objet bombe detruit tous les murs autour du personnage lors de son utilisation. On en a une seule
	//pour tout le jeu, il n'y en a pas sur le plateau. On a crée cet objet pour éviter d'être coincé entre 
	//des murs lors d'une partie.
	public void useBomb(Plateaudejeu p) {		
		if (!getInventaire().isEmpty()) {
			int i=0;
			while ((i<getInventaire().size()-1) & (getInventaire().get(i)!=Item.Bombe)) {
				i++;
			}
			if (getInventaire().get(i)==Item.Bombe) {
				if (getPosition()[0]+1<p.getX()) {
					if (p.valeurcase(getPosition()[0]+1, getPosition()[1])=='#') {
						int[] down={getPosition()[0]+1,getPosition()[1]};
						p.setOnePlateau(' ',down);
						p.setOnePlateauPerso(' ',down);;
					}
				}
				
				if (getPosition()[0]-1>=0) {
					if (p.valeurcase(getPosition()[0]-1, getPosition()[1])=='#') {
						int[] up ={getPosition()[0]-1,getPosition()[1]};
						p.setOnePlateau(' ',up);
						p.setOnePlateauPerso(' ',up);;
					}
				}
				
				if (getPosition()[1]+1<p.getY()) {
					if (p.valeurcase(getPosition()[0], getPosition()[1]+1)=='#') {
						int[] right ={getPosition()[0],getPosition()[1]+1};
						p.setOnePlateau(' ',right);
						p.setOnePlateauPerso(' ',right);;
					}
				}
				
				if (getPosition()[1]-1>=0) {
					if (p.valeurcase(getPosition()[0], getPosition()[1]-1)=='#') {
						int[] left = {getPosition()[0],getPosition()[1]-1};

						p.setOnePlateau(' ',left);
						p.setOnePlateauPerso(' ',left);;
					}
				}
				System.out.println("BOOM!");
				inventaire.remove(i);
			}
			else {
				System.out.println("Vous n'avez pas de bombe dans votre inventaire...");

			}
		}
		else System.out.println("Inventaire vide");
		
	}

		
	public String useBombClient(Plateaudejeu p) {
		String str="";
		if (!getInventaire().isEmpty()) {
			int i=0;
			while ((i<getInventaire().size()-1) & (getInventaire().get(i)!=Item.Bombe)) {
				i++;
			}
			if (getInventaire().get(i)==Item.Bombe) {
				if (getPosition()[0]+1<p.getX()) {
					if (p.valeurcase(getPosition()[0]+1, getPosition()[1])=='#') {
						int[] down={getPosition()[0]+1,getPosition()[1]};
						p.setOnePlateau(' ',down);
						p.setOnePlateauPerso(' ',down);;
					}
				}
				
				if (getPosition()[0]-1>=0) {
					if (p.valeurcase(getPosition()[0]-1, getPosition()[1])=='#') {
						int[] up ={getPosition()[0]-1,getPosition()[1]};
						p.setOnePlateau(' ',up);
						p.setOnePlateauPerso(' ',up);;
					}
				}
				
				if (getPosition()[1]+1<p.getY()) {
					if (p.valeurcase(getPosition()[0], getPosition()[1]+1)=='#') {
						int[] right ={getPosition()[0],getPosition()[1]+1};
						p.setOnePlateau(' ',right);
						p.setOnePlateauPerso(' ',right);;
					}
				}
				
				if (getPosition()[1]-1>=0) {
					if (p.valeurcase(getPosition()[0], getPosition()[1]-1)=='#') {
						int[] left = {getPosition()[0],getPosition()[1]-1};

						p.setOnePlateau(' ',left);
						p.setOnePlateauPerso(' ',left);;
					}
				}
				str+="BOOM!\n";
				inventaire.remove(i);
			}
			else {
				str+="Vous n'avez pas de bombe dans votre inventaire...\n";

			}
		}
		else str+="Inventaire vide\n";
		return str;
	}
	
	@Override
	public String toString() {
		if (alive){
			return "[name=" + name + ", pV=" + pV + ", inventaire=" + inventaire + "]";

		}
		else {
			return "[name=" + name+" is dead !!!]";
		}
	}

	
	
	

}
