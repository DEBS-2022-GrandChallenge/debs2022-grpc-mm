package org.debs.group4.server.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class SymbolRepository {

    private final Set<String> symbols;

    public SymbolRepository() {
        this.symbols = new HashSet<>();
    }

    public void save(String symbol) {
        symbols.add(symbol);
    }

    public List<String> getRandom10() {
        final List<String> list = new ArrayList<>(symbols);
        Collections.shuffle(list);

        if (list.size() < 10) {
            return list;
        }
        return new ArrayList<>(list.subList(0, 10));
    }
}
