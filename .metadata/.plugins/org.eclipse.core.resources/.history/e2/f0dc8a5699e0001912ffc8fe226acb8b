package leetcode;

import java.util.*;



public class Result {

    // Complete the 'PrintGardenLayout' function below.

    public static void PrintGardenLayout() {
        Scanner scanner = new Scanner(System.in);

        String mapSize = scanner.next();
        String[] tokens = mapSize.split(",");
        int x = Integer.valueOf(tokens[0]);
        int y = Integer.valueOf(tokens[1]);

        Map<Integer, Integer> flowers = new HashMap<>();
        Map<Integer, Integer> walls = new HashMap<>();

        while(scanner.hasNext()) {
            String temp = scanner.next();
            String[] tempTokens = temp.split(",");
            if(tempTokens[0] == "F") {
                flowers.put(Integer.valueOf(tempTokens[1]), Integer.valueOf(tempTokens[2]));
            } else {
                walls.put(Integer.valueOf(tempTokens[1]), Integer.valueOf(tempTokens[2]));
            }
        }

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(flowers.containsKey(i) && flowers.containsValue(j)) {
                    System.out.print("F");
                } else if(walls.containsKey(i) && walls.containsValue(j)) {
                    System.out.print("W");
                } else {
                    System.out.print("B");
                }
            }
            System.out.println();
        }
        scanner.close();
    }

}