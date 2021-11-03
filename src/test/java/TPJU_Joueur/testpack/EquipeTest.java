package TPJU_Joueur.testpack;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import TPJU_Joueur.classesTP.Equipe;
import TPJU_Joueur.classesTP.Joueur;
import TPJU_Joueur.classesTP.Maillot;
import exceptions.JoueurDejaMembreException;
import exceptions.JoueurNonMembreException;

public class EquipeTest {

	// Créer une instance de la classe Joueur et de la classe Equipe
	Joueur premierNouveauJoueur;
	Joueur deuxièmeNouveauJoueur;
	Equipe equipe;
	Maillot newMaillot;

	// Common fixture for running tests
	@Before
	public void setUp() throws Exception {
		premierNouveauJoueur = new Joueur("Micheal", "Jordan", 45);
		newMaillot = new Maillot("L", "Addidas", premierNouveauJoueur);
		equipe = new Equipe("Paris Saint-Germain");
		deuxièmeNouveauJoueur = new Joueur("Nicholas", "Smurf", 16);
	}

	@Test
	public void testProprietesJoueur() {
		// Vérifier que le nom du joueur est égal à Micheal
		assertEquals(premierNouveauJoueur.getNom(), "Micheal");
		// Vérifier que l'équipe de ce nouveau joueur est null
		assertNull(premierNouveauJoueur.getEquipe());
	}

	@Test
	public void testAjoutDeJoueursEquipe() {
		// Ajouter le joueur à cette équipe
		ArrayList<Joueur> nouvelleListeJoueurs = equipe.ajouterJoueur(premierNouveauJoueur);

		// Récupérer la taille initiale de la liste après l'ajout du premier joueur
		int ancienneTaille = nouvelleListeJoueurs.size();
		// Vérifier qu'après l'ajout du joueur à la liste, l'équipe de ce joueur n'est pas null
		assertNotNull(premierNouveauJoueur.getEquipe());
		// Vérifier si l'équipe du joueur en question est la meme equipe à laquelle le joueur a été ajouté
		assertEquals(premierNouveauJoueur.getEquipe(), equipe);
		// Vérifier si la liste de joueur contient le joueur qui a été ajouté
		assertTrue(nouvelleListeJoueurs.contains(premierNouveauJoueur));

		// Ajouter un deuxième joueur
		nouvelleListeJoueurs = equipe.ajouterJoueur(deuxièmeNouveauJoueur);
		// Vérifier si la taille de la liste est égale à 2 puisqu'un nouveau joueur a été ajouté à la liste
		assertEquals(nouvelleListeJoueurs.size(), 2);
	}

	@Test
	public void testAjoutDePlusieursJoueursEquipe() {
		// Ajouter plusieurs joueurs en meme temps
		ArrayList<Joueur> nouvelleListeJoueurs = equipe.ajouterJoueur(premierNouveauJoueur, deuxièmeNouveauJoueur);
		assertEquals(nouvelleListeJoueurs.size(), 2);
	}

	@Test
	public void testJoueurDejaMembreException() throws JoueurDejaMembreException {
		// Ajouter le joueur à cette équipe
		ArrayList<Joueur> nouvelleListeJoueurs = equipe.ajouterJoueur(premierNouveauJoueur);
		nouvelleListeJoueurs = equipe.ajouterJoueur(premierNouveauJoueur);
	}

	@Test
	public void testJoueurDejaMembreAutreEquipeException() throws JoueurDejaMembreException {
		// Ajouter le joueur à cette équipe
		ArrayList<Joueur> nouvelleListeJoueurs = equipe.ajouterJoueur(deuxièmeNouveauJoueur);
		// Vérifier si on arrive à ajouter un joueur de l'équipe PSG à l'équipe Marseille
		Equipe equipe2 = new Equipe("Marseille");
		ArrayList<Joueur> deuxiemeNouvelleListeJoueurs = equipe2.ajouterJoueur(deuxièmeNouveauJoueur);
		assertEquals(deuxiemeNouvelleListeJoueurs.size(), 0);
	}

	@Test
	public void testSuppressionDeJoueursEquipe() throws JoueurNonMembreException {
		ArrayList<Joueur> nouvelleListeJoueurs = equipe.ajouterJoueur(premierNouveauJoueur, deuxièmeNouveauJoueur);
		// Vérifier que les deux joueurs ont bien été ajoutés, si c'est le cas la taille de la liste doit etre égale à 2
		assertEquals(nouvelleListeJoueurs.size(), 2);
		// Créer une nouvelle liste qui sera égale à la liste renvoyée lorsqu'un joueur est supprimé d'une équipe
		ArrayList<Joueur> nouvelleListeSupression = equipe.supprimerJoueur(premierNouveauJoueur);
		// Vérifier si le joueur ne fait plus partie de l'équipe
		assertFalse(nouvelleListeSupression.contains(premierNouveauJoueur));
		// Vérifier que le joueur n'a plus d'équipe et l'attribut équipe est null
		assertNull(premierNouveauJoueur.getEquipe());
	}

	@Test(expected = JoueurNonMembreException.class)
	public void testJoueurNonMembreException() {
		ArrayList<Joueur> nouvelleListeSupression;
		try {
			nouvelleListeSupression = equipe.supprimerJoueur(premierNouveauJoueur);
			// Vérifier si le joueur ne fait plus partie de l'équipe
			assertFalse(nouvelleListeSupression.contains(premierNouveauJoueur));
			// Vérifier que le joueur n'a plus d'équipe et l'attribut équipe est null
			assertNull(premierNouveauJoueur.getEquipe());
		} catch (JoueurNonMembreException e) {
			e.printStackTrace();
		}
	}
}