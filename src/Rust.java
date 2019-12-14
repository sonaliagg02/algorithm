import java.util.*;

public class Rust {

    private static ArrayList<Integer>[] data;

    private static int[] rustMurdered(int n, int[][] roads, int s) {
        data = new ArrayList[n];
        for (int j = 0; j < n; j++) {
            data[j] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int node1 = road[0] - 1;
            int node2 = road[1] - 1;

            data[node1].add(node2);
            data[node2].add(node1);
        }
        return performBFS(s);
    }

    private static int[] performBFS(int s) {
        LinkedList<Integer> q = new java.util.LinkedList<>();
        int[] dataArray = new int[data.length];
        q.add(s);

        while (q.size() != 0) {
            int first = q.removeFirst();
            for (int i = 0; i < data.length; i++) {
                if (!data[first].contains(i)) {
                    q.add(i);
                    dataArray[i] = dataArray[first] + 1;
                }
            }

            for (int i = 0; i < dataArray.length; i++) {
                if(dataArray[i] == -1) {
                    break;
                }
                if(i == dataArray.length-1) {
                    return dataArray;
                }
            }
        }
        return dataArray;
    }
}
