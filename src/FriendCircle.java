import java.util.LinkedList;
import java.util.Queue;

public class FriendCircle {

    private Queue<Integer> queue = new LinkedList<>();
    private int count = 0;

    private int findCircleNum(int[][] M) {
        int length = M.length;
        int[] visited = new int[length];
        for (int i = 0; i < length; i++) {
            performBFS(i, visited, length, M);
        }
        return count;
    }

    private void performBFS(int student, int[] visited, int len, int[][] M){
        if (visited[student] == 0) {
            queue.add(student);
            while (!queue.isEmpty()) {
                int current = queue.remove();
                visited[current] = 1;
                for (int j = 0; j < len; j++) {
                    if (M[current][j] == 1 && visited[j] == 0){
                        queue.add(j);
                    }
                }
            }
            count++;
        }
    }

    public static void main(String[] args) {
        FriendCircle friendCircle = new FriendCircle();

        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        matrix[1][0] = 1;
        matrix[1][1] = 1;
        matrix[2][2] = 1;

        int count = friendCircle.findCircleNum(matrix);
        System.out.println(count);
    }
}
