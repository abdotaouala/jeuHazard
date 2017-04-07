package web;

import java.util.ArrayList;
import java.util.List;

public class Modele {

	private int nombre;
	private List<String> historique=new ArrayList<>();
	private boolean fin=false;
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public List<String> getHistorique() {
		return historique;
	}
	public void setHistorique(List<String> historique) {
		this.historique = historique;
	}
	public boolean isFin() {
		return fin;
	}
	public void setFin(boolean fin) {
		this.fin = fin;
	}
	
}
