package com.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import com.example.Model.Evenement;
import com.example.Model.exception.EvenementDejaExistantException;

public class GestionEvenements {
    private static GestionEvenements instance;
    Map<String, Evenement> evenements = new HashMap<>();// garce a ce dictionnaire nous utiliserons la serialisation
                                                        // afin de creer un fichier json contenant les details de l
                                                        // evenement
    private ObjectMapper objectMapper;

    private GestionEvenements() {
        evenements = new HashMap<>();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public static GestionEvenements getInstance() {
        if (instance == null) {
            instance = new GestionEvenements();
        }
        return instance;
    }

    public boolean ajouterEvenement(Evenement e) throws EvenementDejaExistantException {
        if (evenements.containsKey(e.getId())) {
            throw new EvenementDejaExistantException("Cet evenement du nom de " + e.getId() + "existe deja");

        } else {
            evenements.put(e.getId(), e);
            System.out.println("L'évenement " + e.getNom() + "a ete ajoute");
            return true;
        }

    }

    public boolean SupprimerEvenement(String Id) {
        if (evenements.containsKey(Id)) {
            evenements.remove(Id);
            return true;
        } else {
            return false;
        }

    }

    public Evenement rechercherEvenement(String id) {
        return evenements.get(id);
    }

    public void EvenementJSON(String path) throws IOException {
        objectMapper.writeValue(new File(path), evenements);
        System.out.println("Evenement sauvegarde");
    }

    public void chargerEvenementJSON(String path) throws IOException {
        Map<String, Evenement> ChargerEvenemnt = objectMapper.readValue(new File(path),
                objectMapper.getTypeFactory().constructMapType(HashMap.class, String.class, Evenement.class));
        this.evenements = ChargerEvenemnt;
        System.out.println("Evenement chargé");
    }

    public Map<String, Evenement> getEvenements() {
        return evenements;
    }

    public void resetEvenements() {
        evenements.clear();
    }

}
