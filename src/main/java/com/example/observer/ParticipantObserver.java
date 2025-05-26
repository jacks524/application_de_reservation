package com.example.observer;

/*
 *Ici nous creerons un design patern observer du nom de participant observer
 * Cette interface sert a creer un observer qui permettra d envoyer un message de notification aux participants d un evenement  
 */
public interface ParticipantObserver {
    void RecevoirMessage(String message);

}
