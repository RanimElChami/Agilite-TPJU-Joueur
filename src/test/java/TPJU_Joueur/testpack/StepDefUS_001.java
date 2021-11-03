package TPJU_Joueur.testpack;

import java.util.Scanner;

import TPJU_Joueur.classesTP.Equipe;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class StepDefUS_001 {
	private Equipe equipe;

	@Given("^une envie")
	public void uneEnvie(String equipe) throws Throwable {
	}

	@When("^Estelle choisit un nom d'équipe$")
	public void choixNomEquipe() throws Throwable {
		Scanner input = new Scanner (System.in);
		System.out.println("Entrer un nom d'équipe");
		String nom = input.next();
	}

	@Then("^L'équipe (.*) est créée$")
	public void creerEquipe(String nom) throws Throwable {
		this.equipe = new Equipe(nom);
	}

}