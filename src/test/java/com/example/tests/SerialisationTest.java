package com.example.tests;

import java.io.File;
import java.time.LocalDateTime;

import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import com.example.Model.Conference;
import com.example.Model.Evenement;
import com.example.service.GestionEvenements;

public class SerialisationTest {
    @Before
    public void resetData() {
        GestionEvenements.getInstance().resetEvenements();
    }

    @Test
    @SuppressWarnings("UseSpecificCatch")
    public void test_de_serialisation() {
        try {
            Conference conference = new Conference("Conf2", "Seminaire", LocalDateTime.now(), "Yaounde", 100,
                    "Le devellopement de l'afrique");
            GestionEvenements gestion = GestionEvenements.getInstance();
            gestion.ajouterEvenement(conference);

            String path = "liste.json";
            gestion.EvenementJSON(path);
            gestion.resetEvenements();
            gestion.chargerEvenementJSON(path);
            Evenement e = gestion.rechercherEvenement("Conf2");
            assertNotNull("l evenement a ete charge avec succes", e);
            new File(path).delete();

        } catch (Exception e) {
            org.junit.Assert.fail("il y a eu erreur" + e.getMessage());
        }
    }

}
