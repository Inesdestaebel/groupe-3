package projetgroupe3;

public class TestPlateau {

	public static void main(String[] args) {
		//Test pour les murs
		Plateaudejeu p= new Plateaudejeu(5,5,0,0,0);
		int[]pos={2,0};                 
		Personnage H = new Personnage("Test",pos);
		int[]mur= {2,2};
		p.setOnePlateau('#', mur);                                                  
		
		//Déplacements du joueur                         
		Deplacements D = new Deplacements(H,p);                                 
		System.out.println("Veuillez entrer vos 4 actions :");                                 
		p.afficher();                                 
		String move = "DDDD";                                                          
		
		//Utilisation des fonctions de déplacement                                                                  
		D.Move(move, H, p);                                 
		p.afficher();                                 
		System.out.println(H);                                                               
	
		//Test pour les pièges                 
		Plateaudejeu p2= new Plateaudejeu(5,5,0,0,0);                                  
		Personnage T = new Personnage("Test",pos);                 
		p2.setOnePlateau('~', mur);       
		
		Deplacements D2 = new Deplacements(T,p2);                             
		System.out.println("Veuillez entrer vos 4 actions :");                             
		p2.afficher();                             
		String move2 = "DDDD";
		
		D2.Move(move2, T, p2);                             
		p2.afficher();                             
		System.out.println(H);                             
		} 

	}
