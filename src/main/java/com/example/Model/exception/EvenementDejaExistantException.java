package com.example.Model.exception;

/*
 * il sagit de l une des 02 classes qui seront charge de gerer les exceptions , celle ci aura pour but
 * de ne plus creer d autres evenements parceque l evenement qui a ete rentre existe deja 
*/
public class EvenementDejaExistantException extends Exception {
    public EvenementDejaExistantException(String Message) {
        super(Message);
    }

}
