package projetgroupe3;

public class TestPlateau {

	public static void main(String[] args) {
		//Test pour les murs
		Plateaudejeu p= new Plateaudejeu(5,5,0,0,0);
		int[]pos={2,3};                 
		Personnage H = new Personnage("Test",pos);                 
		p[2][3]="#";                                                   
		
		//Déplacements du joueur                         
		Deplacements D = new Deplacements(H,p);                                 
		System.out.println("Veuillez entrer vos 4 actions :");                                 
		p.afficher();                                 
		String move = "DDDD";                                                          
		
		//Utilisation des fonctions de déplacement                                                                  
		D.Move(move, H, p);                                 
		p.afficher();                                 
		System.out.println(H);                                 
		}                              
	
		//Test pour les pièges                 
		Plateaudejeu p= new Plateaudejeu(5,5,0,0,0);                 
		int[]pos={2,3};                 
		Personnage T = new Personnage("Test",pos);                 
		p[2][3]="~";       
		
		Deplacements D = new Deplacements(T,p);                             
		System.out.println("Veuillez entrer vos 4 actions :");                             
		p.afficher();                             
		String move = "DDDD";
		
		D.Move(move, T, p);                             
		p.afficher();                             
		System.out.println(H);                             
		} 

	}
