package org.debs.group4.server.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import org.springframework.core.io.ClassPathResource;

public final class FileAccessor {
    private FileAccessor() {
    }

    public static String readFileInString(long id) throws IOException {
        final ClassPathResource resource = new ClassPathResource(FilePathGenerator.getCsvPath(id));

        return new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))
            .lines()
            .collect(Collectors.joining(Constants.CSV_DELIMITER));
    }
}
