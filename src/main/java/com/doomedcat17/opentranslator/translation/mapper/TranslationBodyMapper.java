package com.doomedcat17.opentranslator.translation.mapper;

import com.doomedcat17.opentranslator.language.Language;
import com.doomedcat17.opentranslator.translation.Translation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class TranslationBodyMapper {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Translation map(String body) throws JsonProcessingException {
        Translation translation = new Translation();
        ArrayNode arrayNode = (ArrayNode) objectMapper.readTree(body);
        translation.setTranslatedText(mapContent((ArrayNode) arrayNode.get(0)));
        translation.setSourceLanguage(mapSourceLanguage(arrayNode));
        translation.setRawData(body);
        return translation;

    }

    private String mapContent(ArrayNode arrayNode) {
        StringBuilder stringBuilder = new StringBuilder();
        arrayNode.forEach(
                node -> stringBuilder.append(node.get(0).asText())
        );
        return stringBuilder.toString();
    }

    private Language mapSourceLanguage(ArrayNode arrayNode) {
        JsonNode langElement = arrayNode.get(arrayNode.size()-1).get(0);
        return Language.byId(langElement.get(0).asText());
    }
}
