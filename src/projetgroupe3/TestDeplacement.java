package projetgroupe3;

public class TestDeplacement {
	public static void main(String[] args) {

		Plateaudejeu plateau = new Plateaudejeu(10,10,1,1,1);
		Personnage H=plateau.addPlayer("Jean");
		Deplacements dpl= new Deplacements(H,plateau);
		
		System.out.println("constructeur ok");
		
		dpl.setCaseActu('X');
		System.out.println("setCaseActu('X'), getCaseActu(): "+dpl.getCaseActu());

				
		System.out.println("Test monter");
		String s="Z";
		dpl.Dep(s);
		
		System.out.println("Test descendre");
		s="S";
		dpl.Dep(s);
		
		System.out.println("Test a gauche");
		s="Q";
		dpl.Dep(s);
		
		System.out.println("Test a droite");
		s="D";
		dpl.Dep(s);
		
		System.out.println("Test ramasser");
		s="R";
		dpl.Dep(s);
		
		System.out.println("Test utiliser potion");
		s="E";
		dpl.Dep(s);

		System.out.println("Test utiliser bombe");
		s="B";
		dpl.Dep(s);
		
		System.out.println("Test invalid command 'm'");
		s="m";
		dpl.Dep(s);
		System.out.println("Test utiliser bombe");
		s="B";
		dpl.Dep(s);
		
		System.out.println("Test Move");
		s="ZQSDREBmj";
		dpl.Move (s);
		
		
		System.out.println("Test DepClient dans MoveClient");
		s="ZQSDREBmj";
		System.out.println(dpl.MoveClient (s,plateau));		
		System.out.println("victoire?: "+dpl.getVictoire());
		dpl.cestGagne();
		System.out.println("victoire apres cestGagne(): "+dpl.getVictoire());

		
	}
}
