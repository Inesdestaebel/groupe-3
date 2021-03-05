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

	
	
	/*
	//Pour la classe Plateaudejeu j'ai pensé à ça
	//petite methode pour ajouter un Peronnage dans une partie sur un Plateaudejeu 
	public Personnage addPlayer {
		Scanner sc= new Scanner(System.in);
		Random r = new Random();
		int x=r.nextInt(this.X);
		int y=r.nextInt(this.Y);
		while (plateau[x][y]!='?') {
			int x=r.nextInt(this.X);
			int y=r.nextInt(this.Y);	
		}
		int[]pos= {x,y};
		System.out.println("Votre nom de Personnage");
		String name=sc.next();
		Personnage player=new Personnage(name,pos );
		this.plateau[x][y]='H' //H designera le personnage lors de l'affichage du plateau.
		sc.close();
		return player;
	}
	
	
	*/
	

}
