import java.util.ArrayList;
import java.util.List;

public class ArithmeticExpression {

    private static List<String> list = new ArrayList<>();

    private static String arithmeticExpressions(int[] arr) {
        String result;

        helper("", arr, 0, 0);
        result = list.get(0);
        return result;
    }

    private static void helper(String path, int[] arr, int pos, long eval){
        if(pos == arr.length){
            if(eval % 101 == 0){
                list.add(path);
            }
        }

        for(int i = pos; i < arr.length; i++){
            if(i != pos && arr[pos] == 0){
                break;
            }
            long curr = arr[pos];
            if(pos == 0){
                helper(path + curr, arr, i + 1, curr);
            }else{
                helper(path + "+" + curr, arr, i + 1, eval + curr);
                helper(path + "-" + curr, arr, i + 1, eval - curr);
                helper(path + "*" + curr, arr, i + 1, eval * curr);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {22, 79, 21};
        String result = ArithmeticExpression.arithmeticExpressions(arr);
        System.out.println(result);
    }
}
