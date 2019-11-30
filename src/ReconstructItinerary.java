import java.util.*;

public class ReconstructItinerary {

    private static List<String> findItinerary(List<List<String>> tickets) {

        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> cities: tickets){
            if(!map.containsKey(cities.get(0))){
                map.put(cities.get(0), new PriorityQueue<>());
                map.get(cities.get(0)).add(cities.get(1));
            }else{
                map.get(cities.get(0)).add(cities.get(1));
            }
        }
        performDFS("JFK", result, map);
        return result;
    }

    private static void performDFS(String start, List<String> result, Map<String, PriorityQueue<String>> map){
        PriorityQueue<String> queue = map.get(start);
        while (queue != null && !queue.isEmpty()) {
            performDFS(queue.poll(), result, map);
        }
        result.add(0, start);
    }

    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>();
        List<String> it1 = new ArrayList<>();
        it1.add("JFK");
        it1.add("KUL");
        input.add(it1);

        List<String> it2 = new ArrayList<>();
        it2.add("JFK");
        it2.add("NRT");
        input.add(it2);

        List<String> it3 = new ArrayList<>();
        it3.add("NRT");
        it3.add("JFK");
        input.add(it3);

//        List<String> it4 = new ArrayList<>();
//        it4.add("ATL");
//        it4.add("JFK");
//        input.add(it4);
//
//        List<String> it5 = new ArrayList<>();
//        it5.add("ATL");
//        it5.add("SFO");
//        input.add(it5);

        List<String> result = findItinerary(input);
        System.out.println(result);
    }

}
