package com.example.observer;

import com.example.Model.Participant;

public interface EvenementObservable {

    void ajouterEvenementObservable(Participant p);

    void SupprimerEvenementObservable(Participant p);

    void notifierEvenementObservable(String p);

}
