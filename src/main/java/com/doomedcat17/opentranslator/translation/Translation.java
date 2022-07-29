package com.doomedcat17.opentranslator.translation;

import com.doomedcat17.opentranslator.language.Language;;
import java.net.URI;

/**
 * A class containing the results of a translation request.
 *
 * @author doomedcat17
 * @since 1.0.0
 */
public class Translation {
    /**
     * The language translated to.
     */
    private String translatedText;
    /**
     * The original, untranslated text.
     */
    private String sourceText;
    /**
     * The raw data received from Google's API.
     */
    private String rawData;
    /**
     * The source text original language.
     */
    private Language sourceLanguage;
    /**
     * The language translated to.
     */
    private Language targetLanguage;
    /**
     * The uri that the translation request was made to.
     */
    private URI uri;

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public String getSourceText() {
        return sourceText;
    }

    public void setSourceText(String sourceText) {
        this.sourceText = sourceText;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public Language getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(Language sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }

    public Language getTargetLanguage() {
        return targetLanguage;
    }

    public void setTargetLanguage(Language targetLanguage) {
        this.targetLanguage = targetLanguage;
    }
}
