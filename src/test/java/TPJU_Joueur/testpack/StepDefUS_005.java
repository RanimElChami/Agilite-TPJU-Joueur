package TPJU_Joueur.testpack;

import static org.junit.Assert.*;

import java.util.ArrayList;

import TPJU_Joueur.classesTP.Equipe;
import TPJU_Joueur.classesTP.Joueur;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefUS_005 {
	Joueur newJoueur;
	Equipe equipe;
	ArrayList<Joueur> nouvelleListeJoueurs;
	
	@Given("un joueur")
	public void un_joueur() {
		this.newJoueur = new Joueur("Micheal", "Jordan", 45);
	}

	@Given("une equipe")
	public void une_equipe() {
		this.equipe = new Equipe("Paris Saint-Germain");
		this.nouvelleListeJoueurs = equipe.ajouterJoueur(newJoueur);
	}

	@When("l appartenance du joueur à l equipe est vérifiée")
	public void l_appartenance_du_joueur_à_l_equipe_est_vérifiée() {
		assertNotNull(this.newJoueur.getEquipe());
		assertEquals(this.newJoueur.getEquipe(), equipe);
	}

	@Then("Le joueur sera supprimé et la nouvelle liste de joueur sera renvoyée")
	public void le_joueur_sera_supprimé_et_la_nouvelle_liste_de_joueur_sera_renvoyée() {
		this.nouvelleListeJoueurs = equipe.supprimerJoueur(newJoueur);
		assertFalse(this.nouvelleListeJoueurs.contains(this.newJoueur));
	}
	
	@Given("le joueur ne fait pas partie de l equipe")
	public void le_joueur_ne_fait_pas_partie_de_l_equipe() {
		assertFalse(this.nouvelleListeJoueurs.contains(this.newJoueur));
	}

	@Then("Le système refuse et affiche un message")
	public void le_système_refuse_et_affiche_un_message() {
	    assertEquals(equipe.supprimerJoueur(newJoueur), "Le joueur n'appartient pas à cette équipe! L'opération de suppression ne sera pas réalisée");
	}

}