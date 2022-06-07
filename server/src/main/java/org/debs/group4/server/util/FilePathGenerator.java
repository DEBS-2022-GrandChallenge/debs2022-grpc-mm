package org.debs.group4.server.util;

import static org.debs.group4.server.util.Constants.*;

public final class FilePathGenerator {
    private FilePathGenerator() {
    }

    public static String getCsvPath(long id) {
        return String.format("%s/%s%d%s", DIR_NAME, CSV_PREFIX, id, CSV_EXT);
    }
}
