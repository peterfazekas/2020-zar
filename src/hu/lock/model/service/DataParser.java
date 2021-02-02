package hu.lock.model.service;

import hu.lock.model.domain.Key;

import java.util.List;
import java.util.stream.Collectors;

public class DataParser {

    private int id;

    public List<Key> parse(List<String> lines) {
        return lines.stream()
                .map(this::createKey)
                .collect(Collectors.toList());
    }

    private Key createKey(String line) {
        return new Key(++id, line);
    }
}
