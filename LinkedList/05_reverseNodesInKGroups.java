import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        int k = 2;
        int[] s1 = {1, 2, 3, 4};
        //int[] s2 = {1, 1, 2, 2, 4, 7, 7, 8};

        ListNode<Integer> l1 = null;
        //ListNode<Integer> l2 = null;

        l1 = new ListNode<Integer>(s1[0]);
        //l2 = new ListNode<Integer>(s2[0]);
        ListNode<Integer> tempAns = l1;
        for(int i=1; i<s1.length; i++){
            tempAns.next  = new ListNode<Integer>(s1[i]);
            tempAns = tempAns.next;
        }
//        tempAns = l2;
//        for(int i=1; i<s2.length; i++){
//            tempAns.next  = new ListNode<Integer>(s2[i]);
//            tempAns = tempAns.next;
//        }


        ListNode<Integer> ans = reverseNodesInKGroups(l1, k);
        System.out.println("완료");
    }

    /**
     * O(N) 시간복잡도를 가져야 한다.
     * k 숫자 만큼 reverse에서 node새로 만들어야 함
     * ex) k=2 1,2,3,4,5
     * 2,1 // 4, 3 // 5  ㅁㅊ...
     */
    public static ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
        ListNode<Integer> ansList = new ListNode<Integer>(0);
        ListNode<Integer> tmpAnsList = ansList;
        /**
         * 접근 방법을 알아보자. 개인적으로 Stack을 쓰면 편해 보임
         * 1,2 순으로 답고 2,1 쓰면 되니깐 / 한번 해봅시다
         * k만큼 안되면 그냥 원래 순으로 넣어야함..
         * 갯수를 어떻게 알지
         *
         */
        Stack<Integer> st = new Stack<Integer>();
        ListNode<Integer> temp = l;
        int cnt = 0;
        while(!(temp == null)){
            if(cnt <= k){
                st.push(temp.value);
                temp = temp.next;
                cnt++;
            }
            if((cnt == k && temp!=null) || (cnt == k && temp==null)){
                while(!st.empty()){
                    tmpAnsList.next = new ListNode<Integer>(st.pop());
                    tmpAnsList = tmpAnsList.next;
                }
                cnt = 0;
            }
            if(temp == null && cnt < k){
                int size = st.size();
                int[] restNum = new int[size];

                for(int i=size-1; i>=0; i--){
                    restNum[i] = st.pop();
                }
                for(int i=0; i<restNum.length; i++){
                    tmpAnsList.next = new ListNode<Integer>(restNum[i]);
                    tmpAnsList = tmpAnsList.next;
                }

            }
        }

        return ansList.next;
    }


}



//    public static void print(char[][] grid){
//        for(int i=0; i<9; i++){
//            for(int j=0; j<9; j++){
//                System.out.print(grid[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }

 class ListNode<T> {
   ListNode(T x) {
     value = x;
   }
   T value;
   ListNode<T> next;
 }
