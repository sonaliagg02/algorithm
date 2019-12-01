import java.util.Scanner;

public class Floyd {

    private static final Scanner scanner = new Scanner(System.in);

    private static void floyd(int[][] graph, int x, int y){
        int length = graph.length;
        for(int k = 0; k < length; k++){
            for(int i = 0; i < length; i++){
                for(int j = 0; j < length; j++){
                    if(graph[i][k] < Integer.MAX_VALUE && graph[k][j] < Integer.MAX_VALUE){
                        if(graph[i][k] + graph[k][j] < graph[i][j]){
                            graph[i][j] = graph[i][k] + graph[k][j];
                        }
                    }
                }
            }
        }
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] >= Integer.MAX_VALUE){
                    graph[i][j] = -1;
                }
            }
        }
        System.out.println("Shortest distance from " + x + " to " + y +": " + graph[x - 1][y - 1]);
    }

    public static void main(String[] args) {
        String[] roadNodesEdges = scanner.nextLine().split(" ");
        int roadNodes = Integer.parseInt(roadNodesEdges[0].trim());
        int roadEdges = Integer.parseInt(roadNodesEdges[1].trim());

        int[][] graph = new int[roadNodes][roadNodes];
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        int[] roadFrom = new int[roadEdges];
        int[] roadTo = new int[roadEdges];
        int[] roadWeight = new int[roadEdges];

        for (int i = 0; i < roadEdges; i++) {
            String[] roadFromToWeight = scanner.nextLine().split(" ");
            roadFrom[i] = Integer.parseInt(roadFromToWeight[0].trim());
            roadTo[i] = Integer.parseInt(roadFromToWeight[1].trim());
            roadWeight[i] = Integer.parseInt(roadFromToWeight[2].trim());
            graph[roadFrom[i] - 1][roadTo[i] - 1] = roadWeight[i];
        }

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xy = scanner.nextLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            floyd(graph, x, y);
        }
        scanner.close();
    }
}
