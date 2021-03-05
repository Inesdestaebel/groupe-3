package projetgroupe3;

public class Main {

	public static void main(String[] args) {
		int X = 15;
		int Y = 9;
		Plateaudejeu plateau = new Plateaudejeu(X,Y);
		for ( int y = 0 ; y<Y; y++ ) {
			for ( int x = 0 ; x<X; x++ ) {
				System.out.print(plateau[x][y]);
		}
		System.out.println();
		}

	}

}
