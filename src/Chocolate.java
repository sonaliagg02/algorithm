import java.io.IOException;
import java.util.Scanner;

public class Chocolate {
    private static int chocolateInBox(int[] arr) {
        int val = 0;
        int result = 0;

        for (int value : arr) {
            val ^= value;
        }

        for (int value : arr) {
            if ((val ^ value) < value)
                result++;
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int arrCount = Integer.parseInt(scanner.nextLine().trim());

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        int result = chocolateInBox(arr);
        System.out.println(result);
    }
}