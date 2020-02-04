public class Main {
    public static void main(String[] args) throws Exception{
        int k = 1000;
        int[] sample = {1, 1000000000, -1000000000, -1000000000, 1000000000, 1};
        ListNode<Integer> spNode = new ListNode<Integer>(sample[0]);
        ListNode<Integer> tempAns = spNode;
        for(int i=1; i<sample.length; i++){
            tempAns.next  = new ListNode<Integer>(sample[i]);
            tempAns = tempAns.next;
        }
        boolean ans = isListPalindrome(spNode);
        System.out.println(ans);
    }
    public static boolean isListPalindrome(ListNode<Integer> l) {
        if(l == null){
            return true;
        }

        ListNode<Integer> p = l; // input List
        ListNode<Integer> prev = new ListNode<Integer>(l.value);

        while(p.next != null){
            ListNode<Integer> temp = new ListNode<Integer>(p.next.value);
            temp.next = prev;
            prev = temp;
            p = p.next;
        }

        ListNode<Integer> c1 = l;
        ListNode<Integer> c2 = prev;

        while(c1!=null){
            //if(c1.value != c2.value){ //숫자 비교인데 왜 이게 안먹을까요??
            if(!c1.value.equals(c2.value)){
                return false;
                //System.out.println("1:"+c1.value);
                //System.out.println("2:"+c2.value);
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        return true;
    }

    public static void showResult(ListNode<Integer> a){

        ListNode<Integer> lTemp = a;

        while(!(lTemp.next == null)){
            System.out.print(lTemp.value+", ");
            lTemp = lTemp.next;

        }
    }

}

 class ListNode<T> {
   ListNode(T x) {
     value = x;
   }
   T value;
   ListNode<T> next;
 }
