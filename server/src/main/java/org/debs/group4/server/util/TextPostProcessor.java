package org.debs.group4.server.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class TextPostProcessor {
    private TextPostProcessor() {
    }

    public static List<List<String>> csvToList(String rawData) {
        final String[] csvRows = rawData.split(Constants.CSV_DELIMITER);
        return Arrays.stream(csvRows)
                     .skip(1) // skip fields
                     .map(s -> s.split(","))
                     .map(Arrays::asList)
                     .collect(Collectors.toList());
    }
}
