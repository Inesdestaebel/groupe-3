package projetgroupe3;

import java.util.ArrayList;



public class Personnage {
	private String name;
	private int pV=5;
	private ArrayList<Item>inventaire= new ArrayList<Item>();
	private boolean alive=true;
	private int[] position= new int[2];

	
	public Personnage(String name, int[]position) {
		setName(name);
		setPosition(position);
		inventaire.add(Item.Bombe);
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
		this.name = name;
	}


	
	public int getPV() {
		return pV;
	}
	
	public void setPV(int pv) {
		pV = pv;
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
	
	// permet au Personnage de se soigner s’il possède une potion dans son inventaire
	public void trap() {
		int dmg=2;
		setPV(this.getPV()-dmg);
	}
	
	public void usePotion() {
		
		int heal=3;
		if (!getInventaire().isEmpty()) {
			int i=0;
			while ((i<getInventaire().size()) & (getInventaire().get(i)!=Item.Potion)) {
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

	
	// L'objet bombe detruit tous les murs autour du personnage lors de son utilisation
	public void useBomb(Plateaudejeu p) {		
		if (!getInventaire().isEmpty()) {
			int i=0;
			while ((i<getInventaire().size()) & (getInventaire().get(i)!=Item.Bombe)) {
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
				inventaire.remove(i);
			}
			else {
				System.out.println("Vous n'avez pas de bombe dans votre inventaire...");

			}
		}
		else System.out.println("Inventaire vide");
		
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
