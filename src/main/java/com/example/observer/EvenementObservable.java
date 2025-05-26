/*
 *Ici nous creerons un design patern observable du nom de evenement observable
 * Cette interface sert a creer un observer qui permettra de preciser qu un evenement a ete ajouter , supprimer
 * ou notifier un message au(x) particiapnts d un evenement  
 */
package com.example.observer;

import com.example.Model.Participant;

public interface EvenementObservable {

    void ajouterEvenementObservable(Participant p);

    void SupprimerEvenementObservable(Participant p);

    void notifierEvenementObservable(String p);

}
