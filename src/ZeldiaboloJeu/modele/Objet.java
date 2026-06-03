package ZeldiaboloJeu.modele;

public class Objet{

	private String nom;
	private int x;
	private int y;

	public Objet() {
		this.nom = "Objet";
	}

	public Objet(int x, int y) {
		this.x = x;
		this.y = y;
		this.nom = "Objet";
	}


	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int n) {
		this.x = n;
	}

	public void setY(int n) {
		this.y = n;
	}

	public String getNom(){
		return this.nom;
	}

	public void setNom(String n){
		this.nom = n;
	}
}