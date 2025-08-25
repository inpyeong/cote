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

    static class Node {
        int data;
        int depth;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static final int MAX_N = 1024;
    static final int MAX_NODES = MAX_N * 2 + 1;

    static Node[] nodes = new Node[MAX_NODES];
    static List<List<Node>> nodesByDepth = new ArrayList<>();
    static List<Integer> inOrderTraversal = new ArrayList<>();

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {

        initNodes(indexes.size());

        buildTree(indexes);

        List<List<Integer>> result = new ArrayList<>();
        Node root = nodes[1];

        for (int query : queries) {
            inOrderTraversal.clear();
            swapAtDepthMultiples(query, indexes.size());
            inOrderTraversal(root);
            result.add(new ArrayList<>(inOrderTraversal));
        }

        return result;
    }

    private static void initNodes(int size) {
        nodesByDepth.clear();
        for (int i = 0; i <= size; i++) {
            nodesByDepth.add(new ArrayList<>());
        }
        for (int i = 1; i <= size; i++) {
            nodes[i] = new Node(i);
        }
    }

    private static void buildTree(List<List<Integer>> indexes) {
        nodes[1].depth = 1;
        nodesByDepth.get(1).add(nodes[1]);

        for (int i = 0; i < indexes.size(); i++) {
            int parentIndex = i + 1;
            List<Integer> children = indexes.get(i);

            int leftIndex = children.get(0);
            int rightIndex = children.get(1);
            int childDepth = nodes[parentIndex].depth + 1;

            if (leftIndex != -1) {
                nodes[leftIndex].depth = childDepth;
                nodes[parentIndex].left = nodes[leftIndex];
                nodesByDepth.get(childDepth).add(nodes[leftIndex]);
            }
            if (rightIndex != -1) {
                nodes[rightIndex].depth = childDepth;
                nodes[parentIndex].right = nodes[rightIndex];
                nodesByDepth.get(childDepth).add(nodes[rightIndex]);
            }
        }
    }

    private static void swapAtDepthMultiples(int k, int maxDepth) {
        for (int depth = k; depth <= maxDepth; depth += k) {
            for (Node node : nodesByDepth.get(depth)) {
                Node temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }
    }

    private static void inOrderTraversal(Node node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        inOrderTraversal.add(node.data);
        inOrderTraversal(node.right);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<List<Integer>> result = Result.swapNodes(indexes, queries);

        result.stream()
            .map(
                r -> r.stream()
                    .map(Object::toString)
                    .collect(joining(" "))
            )
            .map(r -> r + "\n")
            .collect(toList())
            .forEach(e -> {
                try {
                    bufferedWriter.write(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

