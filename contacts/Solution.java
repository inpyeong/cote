import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'contacts' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_STRING_ARRAY queries as parameter.
     */

    static final String ADD = "add";
    static final String FIND = "find";

    static class Node {
        Map<Character, Node> child;
        int cnt;
        boolean endOfWord;

        Node() {
            this.child = new HashMap<>();
            this.cnt = 0;
            this.endOfWord = false;
        }
    }

    static class Trie {
        Node root;

        Trie() {
            this.root = new Node();
        }

        void insert(String str) {
            Node node = this.root;
            node.cnt++;

            for (int i = 0; i < str.length(); i++){
                char c = str.charAt(i);

                node.child.putIfAbsent(c,new Node());
                node = node.child.get(c);
                node.cnt++;
            }

            node.endOfWord = true;
        }

        int findPartial(String str) {
            Node node = this.root;

            for (int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);

                if (node.child.containsKey(c)) {
                    node = node.child.get(c);
                } else {
                    return 0;
                }
            }

            return node.cnt;
        }
    }

    public static List<Integer> contacts(List<List<String>> queries) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        Trie contacts = new Trie();

        for (int i = 0; i < queries.size(); ++i) {
            List<String> query = queries.get(i);

            String operation = query.get(0);
            String value = query.get(1);

            if (operation.equals(ADD)) {
                contacts.insert(value);
            } else {
                result.add(contacts.findPartial(value));
            }
        }

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        IntStream.range(0, queriesRows).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.contacts(queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

