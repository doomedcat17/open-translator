package com.doomedcat17.opentranslator.exception;

/**
 * Main and only exception to the library. Thrown when something goes wrong
 *
 * @author doomedcat17
 * @since 1.0.0
 */
public class TranslationException extends Exception {
    public TranslationException(String message) {
        super(message);
    }

    public TranslationException(Throwable cause) {
        super(cause);
    }
}
