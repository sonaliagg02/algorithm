import java.util.LinkedList;
import java.util.Queue;

public class QuickestWayUp {

    static class Graph{
        private int vertex;
        private int distance;

        Graph(){
            this.vertex = 1;
            this.distance = 0;
        }
    }

    private static int quickestWayUp(int[][] ladders, int[][] snakes) {
        int[] steps = new int[101];
        for (int[] ladder : ladders) {
            steps[ladder[0]] = ladder[1];
        }
        for (int[] snake : snakes) {
            steps[snake[0]] = snake[1];
        }

        Queue<Graph> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];

        Graph graph = new Graph();
        queue.add(graph);

        while(!queue.isEmpty()){
            graph = queue.remove();
            int node = graph.vertex;
            if (node == 100){
                break;
            }

            for(int i = node + 1; i <= node + 6 && i < 101; i++){
                if(!visited[i]){
                    visited[i] = true;

                    Graph graph1 = new Graph();
                    graph1.distance = graph.distance + 1;

                    if(steps[i] != 0){
                        graph1.vertex = steps[i];
                    }else{
                        graph1.vertex = i;
                    }
                    queue.add(graph1);
                }
            }
        }
        if(graph.vertex == 100){
            return graph.distance;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] ladders = new int[3][2];
        ladders[0][0] = 32;
        ladders[0][1] = 62;

        ladders[1][0] = 42;
        ladders[1][1] = 68;

        ladders[2][0] = 12;
        ladders[2][1] = 98;

        int[][] snakes = new int[7][2];
        snakes[0][0] = 95;
        snakes[0][1] = 13;

        snakes[1][0] = 97;
        snakes[1][1] = 25;

        snakes[2][0] = 93;
        snakes[2][1] = 37;

        snakes[3][0] = 79;
        snakes[3][1] = 27;

        snakes[4][0] = 75;
        snakes[4][1] = 19;

        snakes[5][0] = 49;
        snakes[5][1] = 47;

        snakes[6][0] = 67;
        snakes[6][1] = 17;
        System.out.println(quickestWayUp(ladders, snakes));
    }
}
