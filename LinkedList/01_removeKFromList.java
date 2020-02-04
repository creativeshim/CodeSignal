public class Main {
    public static void main(String[] args) throws Exception{
        int k = 13;
        int[] sample = {13, 85, 38, 45, 44, 37, 15, 48, 70, 2, 75, 91, 10, 29, 78, 59, 90, 24, 13, 91, 5, 31, 53, 76, 3, 59, 19, 27, 10, 23, 95, 85, 30, 28, 78, 92, 43, 6, 53, 91, 29, -8, 28, 98, 94, -2, 50, 28, 96, 55, 14, 83, 79, 96, 21, 35, 73, 79, 12, 18, 13, 83, 0, 61, 34, 7, 23, 72, -8, 11, 53, 38, 16, 89, 47, 3, -5, 17, 5, 68, 65, 54, 37, 33, 72, 20, 8, 41, -2, 12, 60, 99, 48, 70, 99, 50, -1, 62, 52, -9};

        ListNode<Integer> ansList = null;
        ansList = new ListNode<Integer>(sample[0]);
        ListNode<Integer> tempAns = ansList;
        for(int i=1; i<sample.length; i++){
            tempAns.next  = new ListNode<Integer>(sample[i]);
            tempAns = tempAns.next;
        }

        ListNode<Integer> ans = removeKFromList(ansList, k);
    }
    public static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        ListNode list = new ListNode(0);
        ListNode temp=list;
        while(l!=null){
            if(l.value!=k){
                temp.next = l;
                temp= temp.next;
            }
            l = l.next;
        }
        temp.next=null;
        return list.next;
        
        ///////////////////// 원래답
//        if(l == null){
//            return l;
//        }
//        LinkedList<Integer> list = new LinkedList<Integer>();
//        ListNode<Integer> lTemp = l;
//        list.add(l.value);
//        while(!(lTemp.next == null)){
//            lTemp = lTemp.next;
//            list.add(lTemp.value);
//        }
//        for(int i=list.size()-1; i>=0; i--){
//            if(list.get(i) == k){
//                list.remove(i);
//            }
//        }
//        ListNode<Integer> ansList = null;
//        if(list.size() != 0){
//            ansList = new ListNode<Integer>(list.get(0));
//            ListNode<Integer> tempAns = ansList;
//            for(int i=1; i<list.size(); i++){
//                tempAns.next  = new ListNode<Integer>(list.get(i));
//                tempAns = tempAns.next;
//            }
//        }
//        //showResult(ansList);
//        return ansList;
        
        //10만개의 input을 처리를 못하는 단점이 있었음        
        /////////////////////
    }

}

 class ListNode<T> {
   ListNode(T x) {
     value = x;
   }
   T value;
   ListNode<T> next;
 }
