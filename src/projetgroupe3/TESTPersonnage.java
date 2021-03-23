package projetgroupe3;

public class TESTPersonnage {
	public static void main(String[]args) {
		
		int[] pos = {2,2};
		Personnage P = new Personnage("Ines",pos);
		System.out.println(P);
		
		//TESTPosition
		System.out.println(P.getPosition()); //gérer le fait qu'on peut avoir n'importe quelle position? Sans prendre en compte X et Y
		int[] pos2 = {2,-1}; //Ne gère pas inférieur à zero
		P.setPosition(pos2);
		System.out.println(P.getPosition()); //pas d'affichage...
		
		//TESTName
		System.out.println(P.getName());
		P.setName("Inesavecunnomtroplong");
		System.out.println(P.getName());
		P.setName("");
		System.out.println(P.getName());
		P.setName("Ines2");
		System.out.println(P.getName());
		
		//TESTPV
		System.out.println(P.getPV());
		P.setPV(-4);
		System.out.println(P.getPV());
		P.setPV(0); //est ce que ca doit être accepté?
		System.out.println(P.getPV());
		P.setPV(10);
		System.out.println(P.getPV());
		P.setPV(5);
		
		//TESTInventaire
		System.out.println(P.getInventaire());
		//P.setInventaire(null); //Provoque une erreur lorsqu'on veut ajouter quelque chose
		System.out.println(P.getInventaire());
		//P.setInventaire(); //ArrayListItem??
		P.addPotion();
		System.out.println(P.getInventaire());
		
		//TESTAlivedead
		System.out.println(P.isAlive());
		P.dead();
		System.out.println(P.isAlive());
		
		//TESTTrapPotion
		P.trap();
		System.out.println(P.getPV());
		P.trap();
		System.out.println(P.getPV());
		P.trap();
		System.out.println(P.isAlive());
		
		//TESTUseBomb il faudrait un plateau pour mieux tester...
		//System.out.println(P.getInventaire());
		//P.useBomb(p);
		
		//TESTToString
		System.out.println(P);
		
		
	}
	
	
}
