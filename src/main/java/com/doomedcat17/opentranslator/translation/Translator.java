package com.doomedcat17.opentranslator.translation;

import com.doomedcat17.opentranslator.exception.TranslationException;
import com.doomedcat17.opentranslator.language.Language;
import com.doomedcat17.opentranslator.translation.mapper.TranslationBodyMapper;
import com.doomedcat17.opentranslator.translation.provider.ParametersProvider;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

/**
 *
 * Free Google Translator library for Java, based on therealbush's translator
 * @author doomedcat17, bush, py-googletrans + contributors
 * @since 1.0.0
 *
 */
public class Translator {

    private final String GOOGLE_ENDPOINT_URL = "https://translate.googleapis.com/translate_a/single";
    private final TranslationBodyMapper translationBodyMapper = new TranslationBodyMapper();

    private HttpClient client;

    public Translator() {
        this.client = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
    }

    public Translator(HttpClient client) {
        this.client = client;
    }

    /**
     * Translates the given string to the desired language.

     * @param sourceText   The text to be translated.
     * @param targetLanguage The language to translate [text] to. @see Language
     * @param source The language of [text]. By default, this is [Language.AUTO].
     *
     * @return A [Translation] containing the translated text and other related data.
     * @throws TranslationException If something goes wrong.
     *
     * @see Language
     * @see Translation
     */
    public Translation translate(String sourceText, Language targetLanguage) throws TranslationException {
        return translate(sourceText, Language.AUTO, targetLanguage);
    }

    /**
     * Translates the given string to the desired language.

     * @param sourceText   The text to be translated.
     * @param sourceLanguage The language of [text].
     * @param targetLanguage The language to translate [text] to. @see Language
     *
     * @return A [Translation] containing the translated text and other related data.
     * @throws TranslationException If something goes wrong.
     *
     * @see Language
     * @see Translation
     */
    public Translation translate(String sourceText, Language sourceLanguage, Language targetLanguage) throws TranslationException {
        try {
            URI uri = URI.create(attachParameters(sourceText, sourceLanguage, targetLanguage));
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .uri(uri)
                    .GET()
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                    .build();
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new TranslationException(response.statusCode()+" status code");
            }
            Translation translation = translationBodyMapper.map(response.body());
            translation.setSourceText(sourceText);
            translation.setTargetLanguage(targetLanguage);
            translation.setUri(uri);
            return translation;
        }
        catch (TranslationException e) {
            throw e;
        } catch (Exception e) {
            throw new TranslationException(e);
        }
    }



    private String attachParameters(String text, Language sourceLanguage, Language targetLanguage) {
        StringBuilder sb = new StringBuilder(GOOGLE_ENDPOINT_URL+"?");
        ParametersProvider.params.forEach((key, value) ->
                sb.append(key).append("=").append(value).append("&"));
        ParametersProvider.goofyParameters.forEach(value ->
                sb.append("dt").append("=").append(value).append("&"));
        sb.append("sl=").append(sourceLanguage.id);
        sb.append("&tl=").append(targetLanguage.id);
        sb.append("&hl=").append(targetLanguage.id);
        sb.append("&q=").append(URLEncoder.encode(text, StandardCharsets.UTF_8));
        return sb.toString();
    }

    public void setClient(HttpClient client) {
        this.client = client;
    }
}
