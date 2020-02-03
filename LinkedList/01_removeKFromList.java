public class Main {
    public static void main(String[] args) throws Exception{
        ListNode<Integer> a = new ListNode<Integer>(3);
        a.next.value = 1;
        a.next.next.value = 2;
        a.next.next.next.value = 3;
        a.next.next.next.next.value = 4;
        a.next.next.next.next.next.value = 5;
        int k = 3;

        ListNode<Integer> ans = removeKFromList(a, k);




    }
    public static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {


        return
    }

}

 class ListNode<T> {
   ListNode(T x) {
     value = x;
   }
   T value;
   ListNode<T> next;
 }
