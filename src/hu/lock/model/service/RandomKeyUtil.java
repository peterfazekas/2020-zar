package hu.lock.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomKeyUtil {

    private static final Random random = new Random();

    public static String generateKey(int length) {
        StringBuilder generatedKey = new StringBuilder();
        List<Integer> numbers = new ArrayList<>(numbers());
        IntStream.range(0, length).forEach(i -> {
            int num = random.nextInt(numbers.size());
            generatedKey.append(numbers.get(num));
            numbers.remove(num);
        });
        return generatedKey.toString();
    }

    private static List<Integer> numbers() {
        return IntStream.range(0, 10)
                .boxed()
                .collect(Collectors.toList());
    }
}
