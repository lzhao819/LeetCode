/**
 * //LeetCode1265
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 *
 */

interface ImmutableListNode {
      void printValue(); // print the value of this node.
      ImmutableListNode getNext(); // return the next node.
  }

public class PrintLinkedListReverse {
    public void printLinkedListInReverse(ImmutableListNode head) {
        if(head==null)  return;
        printLinkedListInReverse(head.getNext()) ;
        head.printValue();
    }
}
