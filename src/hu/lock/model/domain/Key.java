package hu.lock.model.domain;

import hu.lock.model.service.LockUtil;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Key {

    private final int id;
    private final String value;

    public Key(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public boolean isEqual(String pattern) {
        return value.equals(pattern);
    }

    public boolean hasSameDigit() {
        return getCharacterMap().values().stream()
                .anyMatch(i -> i > 1);
    }

    private Map<String, Long> getCharacterMap() {
        return value.chars()
                .mapToObj(Integer::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public String openResult(String pattern) {
        return String.format("%s %s", value, LockUtil.openResult(pattern, value));
    }
}
