package com.doomedcat17.opentranslator.translation.provider;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public interface ParametersProvider {

    Map<String, String> params =
            Map.ofEntries(
                    Map.entry("client", "gtx"),
                    Map.entry("ie", "UTF-8"),
                    Map.entry("oe", "UTF-8"),
                    Map.entry("otf", "1"),
                    Map.entry("ssel", "0"),
                    Map.entry("tsel", "0"),
                    Map.entry("tk", "blanchett_graves")
                    );

    List<String> goofyParameters = Arrays.asList("at", "bd", "ex", "ld", "md", "qca", "rw", "rm", "ss", "t");


}
