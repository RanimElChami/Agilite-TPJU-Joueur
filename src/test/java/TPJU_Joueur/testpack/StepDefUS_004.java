package TPJU_Joueur.testpack;

import java.util.Scanner;

import TPJU_Joueur.classesTP.Joueur;
import TPJU_Joueur.classesTP.Maillot;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class StepDefUS_004 {
	private Maillot maillot;
	private Joueur joueur;
	private boolean estLeBonJoueur = false;

	@Given("^un maillot et un joueur$")
	public void given(Maillot maillot, Joueur joueur) throws Throwable {
		this.maillot = maillot;
		this.joueur = joueur;
	}

	@When("^Estelle saisit la taille (.*), le marque (.*) et le joueur (.*)$")
	public void saisieTailleMaillotJoueur() throws Throwable {
		Scanner input = new Scanner (System.in);

		System.out.println("Entrer la taille du maillot");
		String taille = input.next();

		System.out.println("Entrer le marque du maillot");
		String marque = input.next();

		System.out.println("Entrer le nom du joueur");
		String nom = input.next();

		System.out.println("Entrer le prénom du joueur");
		String prenom = input.next();

		System.out.println("Entrer le numéro du joueur");
		int numero = input.nextInt();

		estLeBonJoueur = (joueur.getNom() == nom) && (joueur.getPrenom() == prenom) && (joueur.getNumero() == numero);
	}

	@When("^Estelle saisit la taille (.*), le marque (.*)$")
	public void saisieTailleMaillotJoueurOutline() throws Throwable {
		Scanner input = new Scanner (System.in);

		System.out.println("Entrer la taille du maillot");
		String taille = input.next();

		System.out.println("Entrer le marque du maillot");
		String marque = input.next();
	}

	@Then("^le maillot est créé$")
	public void creerMaillot(String taille, String marque) throws Throwable {
		if(estLeBonJoueur) {
			maillot = new Maillot(taille, marque, joueur);
		}
	}

	@Then("^un message d'erreur s'affiche$")
	public void creerMaillotOutline(String taille, String marque) throws Throwable {
		System.out.println("Aucun joueur n'a été choisi pour ce maillot");
	}

}