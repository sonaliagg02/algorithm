public class Clique {

    private static int clique(int n, int m) {
        int cliqueCount = 1;
        int edge = 0;
        while (edge < m) {
            cliqueCount++;
            int a = n / cliqueCount;
            if (a == 0) {
                break;
            }

            int r = n % cliqueCount;
            int l = cliqueCount - r;

            edge  = (a + 1) * l * a * r + (a + 1) * (r - 1) * (a + 1) * r;
            edge += a * (l - 1) * a * l + a * r * (a + 1) * l;
            edge = edge / 2;
        }
        return cliqueCount;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        System.out.println(clique(n, m));
    }
}
