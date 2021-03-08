package projetgroupe3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Personnage {
	private String name;
	private int pV=5;
	private ArrayList<Item>inventaire= new ArrayList<Item>();
	private boolean alive=true;
	private int[] position= new int[2];
	
	
	

	public Personnage(String name, int[]position) {
		setName(name);
		setPosition(position);
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


	public void dead() {
		alive=false;	
	}
	
	// permet au Personnage de se soigner s’il possède une potion dans son inventaire
	
	public void UsePotion() {
		int heal=3;
		int i=0;
		while ((i<getInventaire().size()) & (getInventaire().get(i)!=Item.Potion)) {
			i++;
		}
		if (getInventaire().get(i)==Item.Potion) {
			setPV(this.getPV()+heal);
			inventaire.remove(i);
		}
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
