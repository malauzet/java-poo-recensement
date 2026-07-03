package fr.diginamic.recensement.services.existe;

import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.exceptions.CodeDeptException;
import fr.diginamic.recensement.exceptions.CodeRegionException;

import java.util.List;

public class Existe {

    public static void RegionExiste(String nbRegionsStr, List<Ville> villes) throws CodeRegionException {
        boolean regionExiste = false;
        for (Ville ville : villes) {
            if (ville.getCodeRegion().equalsIgnoreCase(nbRegionsStr)) {
                regionExiste = true;
                break;
            }
        }
        if (!regionExiste) {
            throw new CodeRegionException("Le code saisie \"" + nbRegionsStr + "\" n'existe pas.");
        }
    }

    public static void DepartementExiste(String nomDept, List<Ville> villes) throws CodeDeptException {
        boolean departementExiste = false;
        for (Ville ville : villes) {
            if (ville.getCodeDepartement().equalsIgnoreCase(nomDept)) {
                departementExiste = true;
                break;
            }
        }
        if (!departementExiste) {
            throw new CodeDeptException("Le code saisie \"" + nomDept + "\" n'existe pas.");
        }
    }
}
