public class Main {
    public static void main(String[] args) throws Exception{

        int[] sampleA = {9876, 5432, 1999};
        int[] sampleB = {1, 8001};


        ListNode<Integer> a = new ListNode<Integer>(sampleA[0]);
        ListNode<Integer> tempAns = a;
        for(int i=1; i<sampleA.length; i++){
            tempAns.next  = new ListNode<Integer>(sampleA[i]);
            tempAns = tempAns.next;
        }
        ListNode<Integer> b = new ListNode<Integer>(sampleB[0]);
        tempAns = b;
        for(int i=1; i<sampleB.length; i++){
            tempAns.next  = new ListNode<Integer>(sampleB[i]);
            tempAns = tempAns.next;
        }

        ListNode ans = addTwoHugeNumbers(a, b);
        System.out.println(ans.value);
    }
    public static ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        String strA = "";
        String strB = "";
        ListNode numA = a;
        ListNode numB = b;
        while(numA != null){
            strA += numA.value;
            numA = numA.next;
        }
        while(numB != null){
            strB += numB.value;
            numB = numB.next;
        }
        int[] revA = new int[100];
        int[] revB = new int[100];
        int[] ans = new int[100];

//        System.out.println("lengthA:"+strA.length());
//        for(int i=0; i<strA.length(); i++){
//            System.out.println(i+":"+strA.charAt(i));
//        }
        for(int i=strA.length()-1; i>=0; i--){
            revA[strA.length()-1-i] = strA.charAt(i)-'0';
        }
        for(int i=strB.length()-1; i>=0; i--){
            revB[strB.length()-1-i] = strB.charAt(i)-'0';
        }

        int next = 0;
        for(int i=0; i<100; i++){
            int add = revA[i] +revB[i] + next;
            next = 0;
            if(add/10 > 0){
                next = add/10;
            }else{
                next = 0;
            }

            ans[i] = add%10;
        }

        int cut = 0;
        for(int i=ans.length-1; i>=0; i--){
            if(ans[i] != 0){
                cut = i;
                break;
            }
        }
        String answer = "";
        for(int i=cut; i>=0; i--){
            answer += String.valueOf(ans[i]);
        }

        //System.out.println(answer);

//        String strA = "";
//        ListNode numA = a;
//        while(numA != null){
//            strA += numA.value;
//            numA = numA.next;
//        }
//        BigInteger bigA = new BigInteger(strA);
//        String strB = "";
//        ListNode numB = b;
//        while(numB != null){
//            strB += numB.value;
//            numB = numB.next;
//        }
//        BigInteger bigB = new BigInteger(strB);
//
        ListNode ans1 = new ListNode(answer);

        return ans1;
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
