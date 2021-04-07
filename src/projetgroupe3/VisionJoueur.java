package projetgroupe3;

import java.io.Serializable;

public class VisionJoueur implements Serializable{
	private Client player;
	private Plateaudejeu map;
	private Partie partie;
	private Deplacements dep;

	public VisionJoueur(Client player) {
		player.getPlateau();
		player.p.getName();
		player.p.getInventaire();
		player.p.getPV();
	}
	
	public String showplateau(Client player) {
		String a="";
		for ( int x = 0 ; x<player.p.getPlateau().getX(); x++ ) {
			for ( int y = 0 ; y<player.p.getPlateau().getY(); y++ ) {
				a=a+player.p.getPlateau().valeurcaseperso(x, y);
			}
		a=a+"\n";
		}
		return a;
		}
	
	public String showperso(Client player) {
		return player.p.toString();
	}
	
	public String demandeactions(Client player) {
		String a="Z vous permet de monter";
		a=a+"\n"+"S vous permet de descendre.";
		a=a+"\n"+"D vous permet d'aller à droite.";
		a=a+"\n"+"Q vous permet d'aller à gauche.";
		a=a+"\n"+"R vous permet de ramasser un objet.";
		a=a+"\n"+"E vous permet d'utiliser une potion.";
		a=a+"\n"+"B vous permet d'utiliser une bombe.";
		a=a+"\n"+"Veuillez entrer vos 4 actions :";
		return a;
	}
	
	//public String explicdeplacement(Client player) {
	//	
	//}
	
}
