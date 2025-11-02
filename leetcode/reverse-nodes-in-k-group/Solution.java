/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        ListNode tmp = null;
        ListNode answer = null;
        while (true) {
            List<ListNode> nodes = new ArrayList<>();

            boolean done = false;
            for (int i = 0; i < k; ++i) {
                if (curr == null) {
                    if (nodes.size() > 0 && tmp != null) {
                        tmp.next = nodes.get(0);
                    }
                    done = true;
                    break;
                }
                nodes.add(curr);
                curr = curr.next;
            }
            if (done) {
                break;
            }

            Collections.reverse(nodes);
            for (int i = 0; i < nodes.size() - 1; ++i) {
                ListNode left = nodes.get(i);
                ListNode right = nodes.get(i + 1);

                left.next = right;

                if (i == nodes.size() - 2) {
                    right.next = null;
                }
            }
            if (tmp != null) {
                tmp.next = nodes.get(0);
            } else {
                answer = nodes.get(0);
            }
            tmp = nodes.get(nodes.size() - 1);
        }
        return answer;
    }
}
