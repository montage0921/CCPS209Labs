import java.util.*;

public class Towers {
    public static int minimizeTowers(int[] blocks) {

        TreeMap<Integer, Integer> towers = new TreeMap<>();

        for (int block : blocks) {
            Map.Entry<Integer, Integer> higherTower = towers.higherEntry(block);
            if (higherTower != null) {
                if (higherTower.getValue() == 1) {
                    towers.remove(higherTower.getKey());
                } else {
                    towers.put(higherTower.getKey(), higherTower.getValue() - 1);
                }
            }

            towers.put(block, towers.getOrDefault(block, 0) + 1);
        }


        return towers.values().stream().mapToInt(Integer::intValue).sum();
    }

}
