package com.example.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.example.Model.Concert;
import com.example.Model.Conference;
import com.example.Model.Participant;
import com.example.service.GestionEvenements;

public class GestionEvenementsTest {
    @Before
    public void resetData() {
        GestionEvenements.getInstance().resetEvenements();
    }

    @Test
    public void tester_inscription() {
        Conference conference = new Conference("Conf1", "Seminaire", LocalDateTime.now(), "Yaounde", 100,
                "La vie en Societe");
        Participant participant = new Participant("p1", "NGONGA", "joasdja@gmail.com");
        try {
            boolean inscrit = conference.ajouterParticiapant(participant);
            assertTrue("Le particaipant est inscrit", inscrit);
        } catch (Exception e) {
            fail("il n est pas inscrit" + e.getMessage());
        }

    }

    public void tester_desinscription() {
        Concert concert = new Concert("Conc1", "soul Makossa", LocalDateTime.now(), "Baffoussam", 200,
                "Prince Ndedi Eyango", "Makossa");
        Participant participant = new Participant("p1", "NGONGA", "joasdja@gmail.com");
        try {
            boolean inscrit = concert.ajouterParticiapant(participant);
            assertTrue("Le participant doit être inscrit", inscrit);

            boolean desinscrire = concert.supprimerParicipant(participant);
            assertTrue(desinscrire);
        } catch (Exception e) {
            fail("il y a eu une erreur" + e.getMessage());
        }
    }

}
