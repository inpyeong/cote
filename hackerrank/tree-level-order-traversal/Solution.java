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

	public static void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		List<String> visited = new ArrayList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			visited.add(String.valueOf(current.data));

			if (current.left != null) {
				queue.offer(current.left);
			}
			if (current.right != null) {
				queue.offer(current.right);
			}
		}

		String result = String.join(" ", visited);
		System.out.println(result);
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
        levelOrder(root);
    }	
}
