public class IntNode {
   private int sequenceNumber;
   private int data;
   private IntNode link;

   public IntNode(int initialsequenceNumber, int initialdata, IntNode initialLink) {
      sequenceNumber = initialsequenceNumber;
      data = initialdata;
      link = initialLink;
   }

   public void addNodeAfter(int item, int data) {
      link = new IntNode(item, data, link);
   }

   public void removeNodeAfter() {
      if (link != null) {
         link = link.link;
      }
   }

   public int getsequenceNumber() {
      return sequenceNumber;
   }

   public IntNode getLink() {
      return link;
   }

   public void displayNodeData(IntNode head) {
      IntNode current = head;
      String temp_string = "";
      while (current != null) {
         temp_string = temp_string + "(" + current.sequenceNumber + "," + current.data + ") ";
         current = current.link;
      }
      System.out.print("The (sequence number, data) pairs in the linked list are: " + temp_string);
      System.out.println();
   }

   public IntNode findPrevious(IntNode head, int target) {
      IntNode current = head;
      IntNode previous = null;

      while (current != null && current.sequenceNumber != target) {
         previous = current;
         current = current.link;
      }

      return previous;
   }

   public IntNode locatePredecessor(IntNode head, int target) {
      IntNode current = head;
      IntNode previous = null;

      while (current != null && current.sequenceNumber <= target) {
         previous = current;
         current = current.link;
      }

      return previous;
   }
}