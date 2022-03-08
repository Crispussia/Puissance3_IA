import java.util.Arrays;

public class Noeud {

    /**
     * Attribut
     * matrice: repr ́esente la grille d’une situation donn ́ee du jeu
     * max: un bool ́een qui est  ́egal `atruesi le noeud est de type max et `afalsesile noeud est de type min
     * h: c’est l’ ́evaluation du noeud. Un score positif repr ́esente une situation dujeu favorable pour le joueurmaxet un score n ́egatif repr ́esente une situationfavorable pour le joueurmin
     */
    public int[][] matrice;
    private boolean max;
    private int h;

    /*Constructeur*/
    public Noeud(boolean max, int[][] matrice) {
        this.max = max;
        this.matrice = matrice;
    }
    /*assesseurs*/

    public int getH() {
        return h;
    }

    public int[][] getMatrice() {

        return matrice;
    }

    public void setH(int h) {
        this.h = h;
    }

    public boolean isMax() {
        return this.max;
    }


    public String toString() {
        String str = "+---+---+---+---+---+\n| ";
        for (int i = 0; i < this.getMatrice().length; i++) {
            for (int j = 0; j < this.getMatrice()[0].length; j++) {
                str = str + this.getMatrice()[i][j] + " | ";
            }
            if (i == this.getMatrice().length - 1) {
                str = str + "\n+---+---+---+---+---+\n ";
            } else {
                str = str + "\n+---+---+---+---+---+\n| ";
            }


        }

        return str;
    }

    public int troisPionsAlignesLigne(boolean typeJoueur) {

        /* Initialisation */

        /* Joueur ou IA */
        int symboleJoueur;
        if (typeJoueur == true) {
            symboleJoueur = 1;
        } else {
            symboleJoueur = 2;
        }
        int compteur = 0;
        for (int i = 0; i < this.matrice.length; i++) {
            compteur = 1;
            for (int j = 0; j < this.matrice[0].length - 1; j++) {
                if (this.getMatrice()[i][j] != 0 && this.getMatrice()[i][j] == this.getMatrice()[i][j + 1] && this.getMatrice()[i][j] == symboleJoueur)
                    compteur++;
                else
                    compteur = 1;
                if (compteur == 3) {

                    return 1000;

                }
            }

        }

        return 0;
    }

    public void setMax(boolean max) {
        this.max = max;
    }

    public void setMatrice(int[][] matrice) {
        this.matrice = matrice;
    }

    public int troisPionsAlignesColonne(boolean typeJoueur) {

        /* Initialisation */

        /* Joueur ou IA */
        int symboleJoueur;
        if (typeJoueur == true) {
            symboleJoueur = 1;
        } else {
            symboleJoueur = 2;
        }
        int compteur = 0;
        for (int j = 0; j < this.matrice[0].length; j++) {
            compteur = 1;
            for (int i = 0; i < this.matrice.length - 1; i++) {
                if (this.getMatrice()[i][j] != 0 && this.getMatrice()[i][j] == this.getMatrice()[i + 1][j] && this.getMatrice()[i][j] == symboleJoueur)
                    compteur++;
                else
                    compteur = 1;
                if (compteur == 3) {

                    return 1000;

                }
            }

        }

        return 0;
    }

    public int troisPionsPossiblesLigne(boolean typeJoueur) {


        int symbolJoueur;
        if (typeJoueur == true) {
            symbolJoueur = 1;
        } else {
            symbolJoueur = 2;
        }
        int evaluation = 0;
        for (int i = 0; i < this.getMatrice().length; i++) {

            for (int j = 0; j < this.getMatrice()[0].length ; j++) {

                if(this.getMatrice()[i][j] == 0){
                    //110 101 011 01 101
                    if(j-2 >= 0 && this.getMatrice()[i][j - 1] == this.getMatrice()[i][j - 2]  && this.getMatrice()[i][j - 2] == symbolJoueur){
                            evaluation = evaluation + 200;
                    }
                    if((j-1) >= 0 && (j+1 <this.getMatrice()[0].length ) && this.getMatrice()[i][j - 1] ==this.getMatrice()[i][j + 1] &&this.getMatrice()[i][j + 1]==symbolJoueur){
                            evaluation = evaluation + 200;
                    }
                    if(j+2 < this.getMatrice()[0].length && this.getMatrice()[i][j + 1]==this.getMatrice()[i][j + 2]&& this.getMatrice()[i][j + 2] == symbolJoueur){
                            evaluation = evaluation + 200;
                    }
                    if(j-1 >= 0 && this.getMatrice()[i][j - 1] == symbolJoueur){
                         evaluation = evaluation + 30;

                    }
                    if(j+1 <this.getMatrice()[0].length && this.getMatrice()[i][j + 1] == symbolJoueur){
                            evaluation = evaluation + 30;
                    }

                }

            }
        }
        return  evaluation;
    }
    public int troisPionsPossiblesColonne(boolean typeJoueur) {


        int symbolJoueur;
        if (typeJoueur == true) {
            symbolJoueur = 1;
        } else {
            symbolJoueur = 2;
        }
        int evaluation = 0;
        for (int j = 0; j< this.getMatrice()[0].length ; j++) {

            for (int i = 0; i < this.getMatrice().length ; i++) {

                if(this.getMatrice()[i][j] == 0){
                    //1 0 1 0 1
                    //1 1 0 1 0
                    //0 1 1
                    if(i-2 >= 0 && this.getMatrice()[i-1][j] == this.getMatrice()[i-2][j]  && this.getMatrice()[i-2][j] == symbolJoueur){
                        evaluation = evaluation + 200;
                    }
                    if((i-1) >= 0 && (i+1 <this.getMatrice().length ) && this.getMatrice()[i-1][j] ==this.getMatrice()[i+1][j] &&this.getMatrice()[i+1][j]==symbolJoueur){
                        evaluation = evaluation + 200;
                    }
                    if(i+2 < this.getMatrice().length && this.getMatrice()[i+1][j]==this.getMatrice()[i+2][j]&& this.getMatrice()[i+2][j] == symbolJoueur){
                        evaluation = evaluation + 200;
                    }
                    if(i-1 >= 0 && this.getMatrice()[i-1][j] == symbolJoueur){
                        evaluation = evaluation + 30;

                    }
                    if(i+1 <this.getMatrice().length && this.getMatrice()[i+1][j] == symbolJoueur){
                        evaluation = evaluation + 30;
                    }

                }

            }
        }
        return  evaluation;
    }
    public void evaluer(){
        this.h = -2*troisPionsAlignesLigne(false)
                 +troisPionsAlignesLigne(true)
                 -2*troisPionsAlignesColonne(false)
                 +troisPionsAlignesColonne(true)
                 -2*troisPionsPossiblesLigne(false)
                 +troisPionsPossiblesLigne(true)
                 -2*troisPionsPossiblesColonne(false)
                 +troisPionsPossiblesColonne(true);
    }
}




