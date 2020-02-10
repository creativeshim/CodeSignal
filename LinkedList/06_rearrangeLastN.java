import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        int n = 3;
        int[] s1 = {1, 2, 3, 4,5};
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


        ListNode<Integer> ans = rearrangeLastN(l1, n);
        System.out.println("완료");
    }

    /**
     * Try to solve this O(list size), time using O(1)
     * 문제 분석
     * list l의  뒤 에서 부터 주어지는 n의 숫자 갯수만큼을 앞으로 옮긴다
     * ex) n = 3 , l = 1,2,3,4,5
     * 3,4,5를 1,2 앞으로
     * 3,4,5,1,2
     *
     * 0 ≤ n ≤ list size.
     * list size이면 같다는 의미 같음
     * */
    public static ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
        ListNode<Integer> frontList = new ListNode<Integer>(0);
        ListNode<Integer> tmpFrontList = frontList;
        ListNode<Integer> backList = new ListNode<Integer>(0);
        ListNode<Integer> tmpBackList = backList;
        /**
         * 풀이 과정 고민
         * 뒤에서 부터 보는 거니깐 스택에 전부 담아서, n 갯수만큼 꺼내서 front node에 넣고
         * 대신에 넣지만 pop 순서의 반대로 넣도록 하자.
         * 나머지는 back node에 넣어서 서로 붙여서 ans 시켜버리자. 물론 back node도 pop 순서의 반대로 넣도록 . 
         */
        Stack<Integer> st = new Stack<Integer>();
        ListNode<Integer> tmpList = l;
        while(!(tmpList == null)){
            st.push(tmpList.value);
            tmpList = tmpList.next;
        }
        int cnt = 0;
        int[] frontNum = new int[n];

        for(int i=n-1; i>=0; i--){
            frontNum[i] = st.pop();
        }
        for(int i=0; i<frontNum.length; i++){
            tmpFrontList.next = new ListNode<Integer>(frontNum[i]);
            tmpFrontList = tmpFrontList.next;
        }

        int size = st.size();
        int[] restNum = new int[size];

        for(int i=size-1; i>=0; i--){
            restNum[i] = st.pop();
        }
        for(int i=0; i<restNum.length; i++){
            tmpBackList.next = new ListNode<Integer>(restNum[i]);
            tmpBackList = tmpBackList.next;
        }

        tmpFrontList = frontList;
        while(!(tmpFrontList == null)){
            if(tmpFrontList.next == null){
                tmpFrontList.next = backList.next;
                break;
            }
            tmpFrontList = tmpFrontList.next;
        }

        return frontList.next;
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
