import java.util.*;

public class JoggingCats {

    private static void function(int edges, int intersections, int[][] paths){
        int factor = 5;
        long[] neighborsCalculations = new long[edges * factor];
        int len = 0;
        long pathCount = 0;
        for (int i = 0; i < intersections; i++) {
            if (paths[i].length > factor) {
                boolean[] overFactor = new boolean[intersections];
                for (int j: paths[i]) {
                    overFactor[j] = true;
                }
                for (int j = 0; j < intersections; j++) {
                    if (paths[j].length > factor && j <= i) {
                        continue;
                    }
                    long num = 0;
                    for (int k: paths[j]) {
                        if (overFactor[k]) {
                            num++;
                        }
                    }
                    pathCount += (num * (num - 1)) / 2;
                }
            } else {
                for (int j = 0; j < paths[i].length; j++) {
                    for (int k = j + 1; k < paths[i].length; k++) {
                        long path = intersections * paths[i][j];
                        neighborsCalculations[len] = path + paths[i][k];
                        len++;
                    }
                }
            }
        }
        Arrays.sort(neighborsCalculations, 0, len);

        int a = 0;
        while (a < len) {
            int j = a;
            while (j < neighborsCalculations.length && neighborsCalculations[a] == neighborsCalculations[j]) {
                j++;
            }
            int num = j - a;
            pathCount += (num * (num - 1)) / 2;
            a = j;
        }
        if (pathCount % 2 == 0) {
            long ans = pathCount / 2;
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intersections = sc.nextInt();
        int edges = sc.nextInt();

        ArrayList<List<Integer>> neighbors = new ArrayList<>();

        for (int i = 0; i < intersections; ++i) {
            neighbors.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            int src = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            neighbors.get(src).add(dest);
            neighbors.get(dest).add(src);
        }

        int[][] paths = new int[intersections][];
        for (int i = 0; i < intersections; i++) {
            paths[i] = new int[neighbors.get(i).size()];
            int index = 0;
            for (int item : neighbors.get(i)) {
                paths[i][index] = item;
                index++;
            }
            Arrays.sort(paths[i]);
        }
        function(edges, intersections, paths);
    }
}


