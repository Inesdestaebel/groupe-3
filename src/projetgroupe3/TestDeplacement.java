package projetgroupe3;

public class TestDeplacement {
	public static void main(String[] args) {
		Deplacements dpl= new Deplacements();
		
		System.out.println("constructeur ok");
		
		dpl.setCaseActu('X');
		System.out.println("setCaseActu('X'), getCaseActu(): "+dpl.getCaseActu());

		System.out.println("victoire?"+dpl.getVictoire());
		dpl.cestGagne();
		System.out.println("victoire apres cestGagne(): "+dpl.getVictoire());
		Plateaudejeu P= new Plateaudejeu(10, 10, 1, 1, 1);
		Personnage H=P.addPlayer("Halfred");
		
		
		
		public void Dep(Personnage H, Plateaudejeu P, String dep);
		

	}

}
