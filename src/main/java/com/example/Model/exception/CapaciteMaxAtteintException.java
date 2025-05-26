package com.example.Model.exception;

public class CapaciteMaxAtteintException extends Exception {
    public CapaciteMaxAtteintException(String Message) {
        super(Message);
    }

    public CapaciteMaxAtteintException(String Message, Throwable error) {
        super(Message, error);
    }

}
