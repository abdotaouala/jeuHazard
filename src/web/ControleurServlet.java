package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.JeuMetier;

public class ControleurServlet extends HttpServlet {

	JeuMetier metier;
	@Override
	public void init(ServletConfig config) throws ServletException {
		metier=new JeuMetier();
		metier.genererSecret();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("vueJeu.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Modele mod;
	    String gagnant="";
	    String rep="";
		HttpSession session=req.getSession();
		if(session.getAttribute("model")==null){
			 mod=new Modele();
			session.setAttribute("model", mod);
		}else{
			mod=(Modele)session.getAttribute("model");
		}
		if(req.getParameter("action").equals("Relancer")){
			metier.genererSecret();
			mod.setFin(false);
			metier.setFin(false);
			mod.setNombre(0);
			mod.setHistorique(new ArrayList<>());
		}
		int nb=Integer.parseInt(req.getParameter("nombre"));
	     rep=metier.jouer(nb)	;
		 if(rep.indexOf("Bravo")>=0){
			 mod.setFin(true);
			 gagnant=req.getRemoteAddr();
		 }
		 if(rep.indexOf("le jeu est terminé")>=0){
			 rep=rep+", le gagnant est "+gagnant;
		 }
		 mod.setNombre(nb);	 
		 mod.getHistorique().add(rep);
		 req.setAttribute("model", mod);
		 req.getRequestDispatcher("vueJeu.jsp").forward(req, resp);
}

}
