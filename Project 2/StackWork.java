public class StackWork {
   private int[] S0;
   private int S0top;
   private int S0length;

   private int[] S1;
   private int S1top;
   private int S1length;

   private int[] S2;
   private int S2top;
   private int S2length;

   public StackWork(int S0size, int S1size, int S2size)
   {
      S0 = new int[S0size];
      S0length = S0size;
      S0top = -1;

      S1 = new int[S1size];
      S1length = S1size;
      S1top = -1;

      S2 = new int[S2size];
      S2length = S2size;
      S2top = -1;
   }

   public void Push(int x, int StackSelector) {
      if (StackSelector == 0) {
         if (S0top < S0length - 1) {
            S0[++S0top] = x;
         }
      } else if (StackSelector == 1) {
         if (S1top < S1length - 1) {
            S1[++S1top] = x;
         }
      } else if (StackSelector == 2) {
         if (S2top < S2length - 1) {
            S2[++S2top] = x;
         }
      }
   }

   public int Pop(int StackSelector) {
      if (StackSelector == 0) {
         if (S0top >= 0) {
            return S0[S0top--];
         }
      } else if (StackSelector == 1) {
         if (S1top >= 0) {
            return S1[S1top--];
         }
      } else if (StackSelector == 2) {
         if (S2top >= 0) {
            return S2[S2top--];
         }
      }
      return -1; // Return -1 if the stack is empty.
   }

   public void displayStackData() {
      System.out.println("Data in S0:");
      for (int i = 0; i <= S0top; i++) {
         System.out.print(S0[i] + " ");
      }
      System.out.println();

      System.out.println("Data in S1:");
      for (int i = 0; i <= S1top; i++) {
         System.out.print(S1[i] + " ");
      }
      System.out.println();

      System.out.println("Data in S2:");
      for (int i = 0; i <= S2top; i++) {
         System.out.print(S2[i] + " ");
      }
      System.out.println();
   }

   public int getS0top() {
      return S0top;
   }

   public int getS1top() {
      return S1top;
   }

   public int getS2top() {
      return S2top;
   }
}