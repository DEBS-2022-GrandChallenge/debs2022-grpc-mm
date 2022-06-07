package org.debs.group4.server.util;

public final class Constants {
    private Constants() {
    }

    public static final long LAST_FILE_INDEX = 735;

    public static final String CSV_DELIMITER = "#";

    public static final String DIR_NAME = "nano_second_stream";
    public static final String CSV_PREFIX = "stock_stream-";
    public static final String CSV_EXT = ".csv";

    // CSV Field names = list index
    public static final int ID = 0;
    public static final int SYMBOL = 1;
    public static final int SEC_TYPE = 2;
    public static final int LAST_TRADE_PRICE = 3;
    public static final int LAST_TRADE = 4;
    public static final int SECONDS = 5;
    public static final int NANOS = 6;

    // Exceptions
    public static final String FILE_READ_EXCEPTION = "파일을 읽는 과정에서 문제가 발생했습니다.";
}
