package projetgroupe3;

public class TestPlateau {

	public static void main(String[] args) {
		
		Plateaudejeu p;
		// Test constructeur ==> test des setteurs des differents attributs
		p= new Plateaudejeu(5,5,0,0,0);
		
		//Test pour les murs
		
		int[]pos={2,0};                 
		Personnage H = p.addPlayer("Test");
		// Test setOnePlateau et SetOnePlateauPerso
		p.setOnePlateau(' ', H.getPosition());
		p.setOnePlateau('H', pos);
		p.setOnePlateauPerso('?', H.getPosition());
		p.setOnePlateauPerso('H', pos);
		H.setPosition(pos);
		// Test valeurcase
		int[]mur= {H.getPosition()[0],H.getPosition()[1]+2};
		p.setOnePlateau('#', mur);
		System.out.println(mur[0]+" , "+ mur[1]);
		System.out.println(p.valeurcase(mur[0], mur[1]));

		//Déplacements du joueur                         
		Deplacements D = new Deplacements(H,p);                                 
		System.out.println("Veuillez entrer vos 4 actions :");                                 
		// Test afficher() et afficherPlateauPerso()
		p.afficher();       
		p.afficherPlateauPerso();
		String move = "DDDD";                                                          
		
		//Utilisation des fonctions de déplacement                                                                  
		D.Move(move);                                 
		p.afficher();
		p.afficherPlateauPerso();
		// Test valeurcaseperso
		System.out.println("\n"+p.valeurcaseperso(mur[0], mur[1]));
		System.out.println("la case en dessous vaut: "+p.valeurcaseperso(mur[0]-1, mur[1])+" sur le plateauperso");                                              
		System.out.println(H);                                                               
	
		//Test pour les pièges                 
		Plateaudejeu p2= new Plateaudejeu(5,5,0,0,0);                                  
		int[]pos2={2,0};
		//Test addPlayerServeur
		Personnage T= new Personnage("Test2");
		int [] posDuPerso = p2.addPlayerServeur(T);
		p2.afficher(); 
		System.out.println(posDuPerso[0]+" , "+ posDuPerso[1]);
		p2.setOnePlateau(' ', posDuPerso);
		p2.setOnePlateau('H', pos2);
		p2.setOnePlateauPerso('?', posDuPerso);
		p2.setOnePlateauPerso('H', pos2);
		T.setPosition(pos2);
		int[]piege= {T.getPosition()[0],T.getPosition()[1]+2};
		p2.setOnePlateau('~', piege);                                                 
		Deplacements D2 = new Deplacements(T,p2);                             
		System.out.println("Veuillez entrer vos 4 actions :");                             
		p2.afficher(); 
		p2.afficherPlateauPerso();
		String move2 = "DDDD";
		System.out.println(T); 
		D2.Move(move2);                             
		p2.afficher();  
		p2.afficherPlateauPerso();
		System.out.println(T); 
		
		
		
		
		
		
		} 

	}

