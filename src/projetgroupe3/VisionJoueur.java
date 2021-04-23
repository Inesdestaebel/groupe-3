package projetgroupe3;


public class VisionJoueur{
	private Client player;
	
	
	public VisionJoueur(Client player) {
		setClient(player);
	}
	
	public void setClient(Client player) {
		this.player=player;
	}
	
	public Client getClient() {
		return player;
	}
	
	
	public String showplateau() {
		String a="";
		for ( int x = 0 ; x<player.p2.getPlateau().getX(); x++ ) {
			for ( int y = 0 ; y<player.p2.getPlateau().getY(); y++ ) {
				a=a+player.p2.getPlateau().valeurcaseperso(x, y);
			}
		a=a+"\n";
		}
		return a;
		}
	
	public String showperso() {
		return player.p.toString();
	}
	
	public String demandeactions() {
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
	
	
}
