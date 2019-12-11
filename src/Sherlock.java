import java.util.*;

public class Sherlock {

    private static String isValid(String s) {
        String result = "YES";
        HashSet<Integer> set = new HashSet<>();

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(map2.containsKey(entry.getValue())){
                map2.put(entry.getValue(), map2.get(entry.getValue()) + 1);
            }else{
                map2.put(entry.getValue(), 1);
            }
        }

        if(map2.size() == 2){
            if(!map2.containsValue(1)){
                result = "NO";
            }
        }else if(map2.size() > 2){
            result = "NO";
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(isValid(s));
    }
}
