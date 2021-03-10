package projetgroupe3;

import java.util.Scanner;

public class test {
	public static void main(String[] args){
		
		int[] pos= {0,0};
		Personnage petitjoueur= new Personnage("Petit Joueur", pos);
		
		System.out.println(petitjoueur);
		Scanner sc= new Scanner(System.in);
		System.out.println("Dimention du plateau svp:");
		int X=sc.nextInt();
		System.out.println("par ");
		int Y=sc.nextInt();
		System.out.println("nb de pieges :");
		int piege=sc.nextInt();

		System.out.println("nb de potion :");
		int potion=sc.nextInt();

		System.out.println("nb de murs :");
		int murs=sc.nextInt();
		
		System.out.println("nb de joueurs :");

		int joueur=sc.nextInt();

		
		Plateaudejeu partie1= new Plateaudejeu(X,Y,murs,piege,potion,joueur);
		partie1.afficher();		
		sc.close();
		System.out.println("termine");
	}
} 
