package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.exceptions.NomVilleException;

/**
 * Recherche et affichage de la population d'une ville
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationVilleService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws NomVilleException {

		System.out.println("Quel est le nom de la ville recherchée ? ");
		String choix = scanner.nextLine();

		List<Ville> villes = rec.getVilles();

		boolean villeExiste = false;
		for (Ville ville : villes) {
			if (ville.getNom().equalsIgnoreCase(choix)) {
				villeExiste = true;
				break;
			}
		}
		if (!villeExiste) {
			throw new NomVilleException("Le nom saisie \"" + choix + "\" n'existe pas.");
		}

		for (Ville ville : villes) {
			if (ville.getNom().equalsIgnoreCase(choix)
					|| ville.getNom().toLowerCase().startsWith(choix.toLowerCase())) {
				System.out.println(ville);
			}
		}
	}

}
