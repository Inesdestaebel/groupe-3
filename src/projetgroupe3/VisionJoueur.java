package projetgroupe3;

import java.io.Serializable;

public class VisionJoueur implements Serializable{
	private Personnage p;
	private Plateaudejeu map;
	private Partie partie;
	private Deplacements dep;

	public VisionJoueur(Personnage p) {
		this.p=p;
	}

	public void showVision() {
		p.getPlateau().afficherPlateauPerso();
		System.out.println(p);
	}
	
}
