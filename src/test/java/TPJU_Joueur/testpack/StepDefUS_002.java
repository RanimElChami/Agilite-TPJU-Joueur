package TPJU_Joueur.testpack;

import java.util.Scanner;

import TPJU_Joueur.classesTP.Joueur;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class StepDefUS_002 {
	private Joueur joueur;

	@Given("^une equipe$")
	public void given() throws Throwable {
	}

	@When("^EEstelle saisit le nom, le prénom et le numéro du joueur$")
	public void saisieNomPrenomNumero() throws Throwable {
		Scanner input = new Scanner(System.in);

		System.out.println("Entrer le nom du joueur");
		String nom = input.next();

		System.out.println("Entrer le prénom du joueur");
		String prenom = input.next();

		System.out.println("Entrer le numéro du joueur");
		int numero = input.nextInt();
	}

	@Then("^le joueur (.*), (.*), (\\d+) est créé$")
	public void creerJoueur(String nom, String prenom, int numero) throws Throwable {
		this.joueur = new Joueur(nom, prenom, numero);
	}
}