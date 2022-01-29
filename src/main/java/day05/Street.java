package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Street {
    private Map<String, List<Integer>> houses = new HashMap<>();

    private List<String> readFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("File not found", ioe);
        }
    }

    public void mapper (Path path){
        List<String> input = readFromFile(path);

        for (String s: input) {
            String[] temp = s.split(" ");
            String street = temp[0];
            int side = Integer.parseInt(temp[1]);

            if (!houses.containsKey(street)) {
                if (side == 0) {
                    houses.put(street, new ArrayList<>(Arrays.asList(2)));
                } else {
                    houses.put(street, new ArrayList<>(Arrays.asList(1)));
                }
            } else {
                maxFinder(street, side);
            }

        }
    }

    private void maxFinder(String street, int side){
        int maxValue = houses.get(street).stream()
                .mapToInt(i -> i)
                .filter(h -> h % 2 == side)
                .max()
                .orElse(-side);
        houses.get(street).add(maxValue +2);
    }

    public static void main(String[] args) {
        Street s = new Street();
        s.mapper(Paths.get("src/test/resources/streets.txt"));
        System.out.println(s.houses);

    }
}
