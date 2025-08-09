import java.util.*;
import java.io.*;

class Solution {

	static class Node {
		Node left;
		Node right;
		int data;
		
		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	static class Pair<T> {
		T key;
		Integer value;

		Pair(T key, Integer value) {
			this.key = key;
			this.value = value;
		}
	}

	/*
	class Node 
		int data;
		Node left;
		Node right;
	*/
    
	public static int height(Node root) {
      	// Write your code here.

		int result = 0;
		Queue<Pair<Node>> queue = new LinkedList<>();

		queue.offer(new Pair<>(root, 0));

		while (!queue.isEmpty()) {
			Pair<Node> current = queue.poll();

			Node node = current.key;
			Integer height = current.value;

			if (result < height) {
				result = height;
			}

			if (node.left != null) {
				queue.offer(new Pair<>(node.left, height + 1));
			}
			if (node.right != null) {
				queue.offer(new Pair<>(node.right, height + 1));
			}
		}

		return result;
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}
