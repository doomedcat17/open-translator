package com.doomedcat17.opentranslator.exception;

public class TranslationException extends RuntimeException{
    public TranslationException(String message) {
        super(message);
    }

    public TranslationException(Throwable cause) {
        super(cause);
    }
}
