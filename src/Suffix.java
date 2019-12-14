import java.util.*;

public class Suffix {

    private static List<Integer> result = new ArrayList<>();
    private static HashMap<String, Integer> map = new HashMap<>();;

    private static int findMoves(char[] arr, int pointer) {
        int count = Integer.MAX_VALUE;
        if(pointer == arr.length) {
            return 0;
        }
        String postfix = String.valueOf(arr, pointer, arr.length - pointer);
        if(map.containsKey(postfix)){
            return map.get(postfix);
        }
        List<Integer> occurrences = getNextLowestCharacter(arr, pointer);
        for(int i = 0; i < occurrences.size(); i++) {
            int low = occurrences.get(i);
            if(low != pointer) {
                count = Math.min(findMoves(rotate(arr, pointer, low), pointer + 1) + 1, count);
            }else {
                count = Math.min(findMoves(arr, pointer + 1), count);
            }
        }
        map.put(postfix, count);
        return count;
    }

    private static char[] rotate(char[] s, int pointer, int lowestIdx) {
        char[] copy = Arrays.copyOf(s, s.length);
        int current = pointer;

        for(int i = lowestIdx; i < s.length; i++) {
            copy[current++] = s[i];
        }

        for(int i = pointer; i < lowestIdx; i++) {
            copy[current++] = s[i];
        }
        return copy;
    }

    private static List<Integer> getNextLowestCharacter(char[] s, int pointer) {
        int nextMin = pointer;
        for(int i = pointer + 1; i < s.length; i++) {
            if(s[nextMin] > s[i]) {
                nextMin = i;
            }
        }
        List<Integer> sameChar = new ArrayList<>();
        for(int i = pointer; i < s.length; i++) {
            if(s[nextMin] == s[i]) {
                sameChar.add(i);
            }
        }
        return sameChar;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();

        for(int i = 0; i < g; i++) {
            String s = sc.next();
            char[] c = s.toCharArray();
            result.add(findMoves(c,0));
        }

        for(Integer ans : result) {
            System.out.println(ans);
        }
    }
}