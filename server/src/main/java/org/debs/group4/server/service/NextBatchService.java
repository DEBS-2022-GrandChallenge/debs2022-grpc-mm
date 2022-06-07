package org.debs.group4.server.service;

import com.google.protobuf.Timestamp;
import de.tum.i13.bandency.Event;
import de.tum.i13.bandency.SecurityType;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.debs.group4.server.repository.SymbolRepository;
import org.debs.group4.server.util.Constants;
import org.debs.group4.server.util.FileAccessor;
import org.debs.group4.server.util.TextPostProcessor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NextBatchService {

    private final SymbolRepository symbolRepository;

    public List<Event> generateEventList(long fileId) {
        try {
            final String rawData = FileAccessor.readFileInString(fileId);
            final List<List<String>> processedData = TextPostProcessor.csvToList(rawData);
            return processedData.stream()
                                .map(this::buildEvent)
                                .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return List.of(Event.getDefaultInstance());
        }
    }

    public List<String> getRandomLookupSymbols() {
        return symbolRepository.getRandom10();
    }

    private Event buildEvent(List<String> row) {
        final String symbol = row.get(Constants.SYMBOL);
        symbolRepository.save(symbol);

        return Event.newBuilder()
                    .setSymbol(symbol)
                    .setSecurityType(getSecType(row.get(Constants.SEC_TYPE)))
                    .setLastTradePrice(Float.parseFloat(row.get(Constants.LAST_TRADE_PRICE)))
                    .setLastTrade(getLastTrade(row.get(Constants.SECONDS), row.get(Constants.NANOS)))
                    .build();
    }

    private SecurityType getSecType(String secType) {
        if (secType.equals("1")) {
            return SecurityType.Index;
        }
        return SecurityType.Equity;
    }

    private Timestamp getLastTrade(String seconds, String nanos) {
        return Timestamp.newBuilder()
                        .setSeconds(Long.parseLong(seconds))
                        .setNanos(Integer.parseInt(nanos))
                        .build();
    }
}
