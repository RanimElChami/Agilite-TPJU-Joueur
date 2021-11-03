package TPJU_Joueur.testpack;

import java.util.ArrayList;

import TPJU_Joueur.classesTP.Equipe;
import TPJU_Joueur.classesTP.Joueur;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class StepDefUS_003 {
	private Equipe equipe;
	private Joueur joueur;
	private ArrayList<Joueur> joueurs;

	@Given("^une équipe et un joueur$")
	public void given(Equipe equipe, Joueur joueur) throws Throwable {
		this.equipe = equipe;
		this.joueur = joueur;
	}

	@When("^le joueur est ajouté à l'équipe$")
	public void ajouteJoueurAEquipe() throws Throwable {
		this.joueurs = new ArrayList<Joueur> ();
	}

	@Then("^a liste des joueurs de l'équipe est affiché$")
	public void then() throws Throwable {
		this.joueurs = this.equipe.ajouterJoueur(this.joueur);
		if(this.joueurs.contains(this.joueur)) {
			System.out.println(this.joueurs);
		}
	}
}