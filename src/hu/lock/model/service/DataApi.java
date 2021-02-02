package hu.lock.model.service;

import hu.lock.model.domain.Key;

import java.util.List;

public class DataApi {

    private final FileReader reader;
    private final DataParser parser;

    public DataApi(FileReader reader, DataParser parser) {
        this.reader = reader;
        this.parser = parser;
    }

    public List<Key> getData(String input) {
        return parser.parse(reader.read(input));
    }
}
