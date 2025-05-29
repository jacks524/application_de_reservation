/*
 * Dans cette classe nous administrerons les evenements
 */
package com.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import com.example.Model.Concert;
import com.example.Model.Conference;
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
        /*
         * objectMapper.activateDefaultTyping(
         * 
         * objectMapper.getPolymorphicTypeValidator(),
         * ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE,
         * JsonTypeInfo.As.PROPERTY
         * 
         * );
         */
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
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        // Lecture brute du JSON
        Map<String, Map<String, Object>> brut = mapper.readValue(
                new File(path),
                new TypeReference<Map<String, Map<String, Object>>>() {
                });

        evenements.clear();

        for (Map.Entry<String, Map<String, Object>> entry : brut.entrySet()) {
            String id = entry.getKey();
            Map<String, Object> props = entry.getValue();
            String type = (String) props.get("type");

            Evenement e = null;

            if ("concert".equals(type)) {
                e = mapper.convertValue(props, Concert.class);
            } else if ("conference".equals(type)) {
                e = mapper.convertValue(props, Conference.class);
            }

            if (e != null) {
                evenements.put(id, e);
            }
        }

        System.out.println("Événements chargés avec succès.");
    }

    public Map<String, Evenement> getEvenements() {
        return evenements;
    }

    public void resetEvenements() {
        evenements.clear();
    }

}
