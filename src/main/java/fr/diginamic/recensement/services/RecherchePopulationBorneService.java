package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.exceptions.CodeDeptException;
import org.apache.commons.lang3.math.NumberUtils;

import static fr.diginamic.recensement.services.existe.Existe.DepartementExiste;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws CodeDeptException {

		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine();

		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();

		if (!NumberUtils.isDigits(saisieMin)) {
			throw new IllegalArgumentException("La population doit être un nombre entier. Saisie : " +  saisieMin);
		}
		if (!NumberUtils.isDigits(saisieMax)) {
			throw new IllegalArgumentException("La population doit être un nombre entier. Saisie : " +  saisieMin);
		}

		int min = Integer.parseInt(saisieMin) * 1000;
		int max = Integer.parseInt(saisieMax) * 1000;

		if (min > max) {
			throw new IllegalArgumentException(
					"La population minimum (" + min + ") ne peut pas être supérieure à la population maximum (" + max + ")");
		}
		
		List<Ville> villes = rec.getVilles();

		DepartementExiste(choix, villes);

		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
			}
		}
	}

}
