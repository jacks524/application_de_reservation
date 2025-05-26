package com.example.Model.exception;

/*
 * il sagit de l une des 02 classes qui seront charge de gerer les exceptions , celle ci aura pour but
 * de ne plus admettre de particaipant une fois que la taille maximale de l effectif a ete atteint
 * pour ce faire nous declarerons 01 methode permettant de dire au particaipant qu il ne peut plus acceder a 
 * l evenement parceque c est deja complet
 */
public class CapaciteMaxAtteintException extends Exception {
    public CapaciteMaxAtteintException(String Message) {
        super(Message);
    }

}
