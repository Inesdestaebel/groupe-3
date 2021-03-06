package projetgroupe3;

public class Main {

	public static void main(String[] args) {
		int X = 15;
		int Y = 9;
		Plateaudejeu plateau = new Plateaudejeu(X,Y);
		for ( int x = 0 ; x<X; x++ )
			for ( int y = 0 ; y<Y; y++ )
				System.out.println(plateau.getPlateau(x, y));
		
		System.out.println();
		}
}


