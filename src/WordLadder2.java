import java.util.*;

public class WordLadder2 {

    private List<List<String>> result = new ArrayList<>();
    private HashMap<String, Set<String>> graph = new HashMap<>();

    private List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> sequence = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(wordList);
        createGraph(beginWord, endWord, graph, dict);
        createSequence(beginWord, endWord, graph, sequence);
        return result;
    }

    private void createGraph(String beginWord, String endWord, HashMap<String, Set<String>> graph, HashSet<String> dictionary) {
        HashSet<String> visited = new HashSet<>();
        HashSet<String> remaining = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        remaining.add(beginWord);
        boolean end = false;

        while(q.size()!=0) {
            int qSize = q.size();
            visited.addAll(remaining);
            remaining.clear();
            while(qSize!=0) {
                String current = q.poll();
                List<String> neighbours = getNeighbours(current, dictionary);
                for(String neigh : neighbours) {
                    if(neigh.equals(endWord)) {
                        end = true;
                    }
                    if(!visited.contains(neigh)) {
                        if (!graph.containsKey(current)) {
                            graph.put(current, new HashSet<>());
                        }
                        graph.get(current).add(neigh);
                    }
                    if(!visited.contains(neigh) && !remaining.contains(neigh)) {
                        q.offer(neigh);
                        remaining.add(neigh);
                    }
                }
                qSize--;
            }
            if(end) {
                break;
            }
        }
    }

    private void createSequence(String beginWord, String endWord, HashMap<String, Set<String>> graph, List<String> sequence) {
        sequence.add(beginWord);
        if(beginWord.equals(endWord)) {
            result.add(new ArrayList<>(sequence));
        } else {
            if(graph.containsKey(beginWord)) {
                Set<String> path = graph.get(beginWord);
                for(String node : path) {
                    createSequence(node, endWord, graph, sequence);
                }
            }
        }
        sequence.remove(sequence.size()-1);
    }

    private List<String> getNeighbours(String current, HashSet<String> dictionary) {
        List<String> neigh = new ArrayList<>();
        char[] ch = current.toCharArray();
        for(int index = 0; index < current.length(); index++) {
            for(int c = 'a'; c <= 'z'; c++) {
                char currentChar = ch[index];
                ch[index] = (char)c;
                String newString = new String(ch);
                if(dictionary.contains(newString) && !newString.equals(current)) {
                    neigh.add(newString);
                }
                ch[index] = currentChar;
            }
        }

        return neigh;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        WordLadder2 s = new WordLadder2();
        List<List<String>> solution = s.findLadders(beginWord, endWord, wordList);

        for(List<String> l : solution) {
            for(String ans : l) {
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }
}