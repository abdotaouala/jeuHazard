package metier;

public class JeuMetier {

	private int nombreSecret;
	private boolean fin;
	public void genererSecret(){
		nombreSecret = (int)(Math.random()*10);
	}
	public String jouer(int nb){
		if(fin==false){
			if(nb>nombreSecret){
				return "Votre nombre "+nb+" plus grand";
			}else if(nb<nombreSecret){
				return "Votre nombre "+nb+" plus petit";
			}else{
				fin=true;
				return "Bravo! vous avez gagni�";
				
			}
		}else{
			return "le jeu est termin�, et le nombre chercher "+nombreSecret;
		}
	}
	public boolean isFin() {
		return fin;
	}
	public void setFin(boolean fin) {
		this.fin = fin;
	}
	
}
