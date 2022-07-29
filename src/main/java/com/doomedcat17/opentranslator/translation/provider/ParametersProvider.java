package com.doomedcat17.opentranslator.translation.provider;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * An interface containing all necessary parameters for library to work.
 *
 * @author doomedcat17
 * @since 1.0.0
 */
public interface ParametersProvider {
    // all necessary parameters to perform request
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

    // some goofy arguments from https://github.com/ssut/py-googletrans
    List<String> goofyParameters = Arrays.asList("at", "bd", "ex", "ld", "md", "qca", "rw", "rm", "ss", "t");


}
