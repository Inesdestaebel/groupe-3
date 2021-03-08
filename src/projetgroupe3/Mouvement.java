package projetgroupe3;

public class Mouvement {
	// on va partir sur une base Z Q S D avec Z = devant Q = gauche S= derrière et D = droite (ce qui est le plus fréquemment utilisé dans les jeux)
	// on se base sur un axe X Y donc pour se déplacer horizontalement, le x varie & verticalement le y varie

	public void Haut() {
	if(plateau[x][y+1] == ' ' ||  '~' || 'P');
	char pos ;
	pos = plateau[x][y];   // la position du personnage actuellement
	plateau[x][y] = " ";
	plateau[x][y+1] = pos; // normalement temp sera toujours ce que l'on a donné comme "symobole" à notre personnage



	}
	public void Bas() {
	if(plateau[x][y-1] == ' ' ||  '~' || 'P'); // si la case où l'on souhaite aller existe (et donc n'est pas un mur)  
	char pos ;
	pos = plateau[x][y];  
	plateau[x][y] = " ";
	plateau[x][y-1] = pos;  



	}
	public void Gauche() {
	if(plateau[x-1][y] == ' ' ||  '~' || 'P');
	char pos ;
	pos = plateau[x][y];  
	plateau[x][y] = " ";
	plateau[x-1][y] = pos;



	}
	public void Droite() {
	if(plateau[x+1][y] == ' ' ||  '~' || 'P');
	char pos ;
	pos = plateau[x][y];  
	plateau[x][y] = " ";
	plateau[x+1][y] = pos;  



	}
	}

	// Pour la fonction main il faudrait faire un scanner qui selon ce que l'on rentre Z Q S D, Haut Bas Droite ou gauche s'exécute.

	// donc en gros, la fonction va créer une variable  pos qui va prendre ce qui se trouve à la position actuelle du joueur (donc ce qu'on a choisi comme lettre pour le joueur)
	// ensuite la position actuelle du joueur va devenir "" donc un espace vide
	// puis la position selon ce que le joueur a rentré deviendra pos soit comment on a appelé le joueur sur le plateau
	// la seule chose qu'il faut bouger c'est le plateau [x][y] il faudrait remplacer par les coordonnés des joueurs mais je sais pas comment les récupérer.

