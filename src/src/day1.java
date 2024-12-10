import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Stream;

public class day1 {

    public static void main(String args[]) throws IOException {
        Stream<String> input = Files.lines(Path.of("src/input/day1.txt"));

        ArrayList<Integer> leftNums = new ArrayList<Integer>();
        ArrayList<Integer> rightNums = new ArrayList<Integer>();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        input.forEach(line -> {
            int newLeftNum = Integer.parseInt(line.split("   ")[0]);
            if (!map.containsKey(newLeftNum)) {
                map.put(newLeftNum, 0);
            }
            leftNums.add(newLeftNum);

            int newRightNum = Integer.parseInt(line.split("   ")[1]);
            if (map.containsKey(newRightNum)) {
                int newValue = map.get(newRightNum) + 1;
                map.put(newRightNum, newValue);
            } else {
                map.put(newRightNum, 1);
            }
            rightNums.add(newRightNum);
        });

        Collections.sort(leftNums);
        Collections.sort(rightNums);

        int part1Output = 0;
        int part2Output = 0;
        for (int i = 0; i < 1000; i++) {
            part1Output += Math.abs(leftNums.get(i) - rightNums.get(i));
            part2Output += leftNums.get(i) * map.get(leftNums.get(i));
        }

        System.out.println("Part 1: " + part1Output);
        System.out.println("Part 2: " + part2Output);
    }
}
