package org.debs.group4.server.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

@Slf4j
public final class FileAccessor {
    private FileAccessor() {
    }

    public static String readFileInString(long id) throws IOException {
        final String csvPath = FilePathGenerator.getCsvPath(id);
        final ClassPathResource resource = new ClassPathResource(csvPath);
        log.info("Access file : {}", csvPath);

        return new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))
            .lines()
            .collect(Collectors.joining(Constants.CSV_DELIMITER));
    }
}
