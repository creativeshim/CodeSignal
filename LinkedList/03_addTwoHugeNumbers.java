public class Main {
    public static void main(String[] args) throws Exception{
//
//        int[] sampleA = {9876, 5432, 1999};
//        int[] sampleB = {1, 8001};
        int[] sampleA = {626, 6726, 9980, 9738, 4562, 6376, 8940, 6921, 1676, 1107, 8959, 4623, 4324, 9083, 7716, 7800, 8042, 4337, 3616, 7983, 9701, 3275, 5680, 802, 2485, 4473, 7661, 9235, 5797, 5042, 7365, 3106, 7361, 2724, 5328, 8525, 7103, 755, 947, 7898};
        int[] sampleB = {9651, 8173, 5384, 7798, 8467, 2360, 3375, 9054, 1161, 9880, 1427, 6573, 5907, 9061, 7900, 6516, 6546, 293, 3877, 9453, 4289, 4829, 7563, 4308, 7845, 4840, 3279, 7186, 9917, 25, 4220, 9052, 6867, 8567, 8308, 5917, 7251, 7236, 2581, 8901, 8372};


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
        //입력 받은 값을 String으로 합칩니다.
        String strA = "";
        String strB = "";
        ListNode numA = a;
        ListNode numB = b;
        //첫번째 숫자를 제외하고 나머지 숫자들은 digit을 4로 꼭 채워야 한다.

        strA += numA.value;
        while(numA.next != null){
            numA = numA.next;
            String numAstr = "";
            numAstr = String.valueOf(numA.value);
            while(!(numAstr.length() == 4)){
                numAstr = "0"+numAstr;
            }
            strA += numAstr;

        }
        strB += numB.value;
        while(numB.next != null){
            numB = numB.next;
            String numBstr = "";
            numBstr = String.valueOf(numB.value);
            while(!(numBstr.length() == 4)){
                numBstr = "0"+numBstr;
            }
            strB += numBstr;

        }
        int arrLen = 0;
        if(strA.length()>strB.length()) arrLen = strA.length()+2;
        else if(strA.length()<strB.length()) arrLen = strB.length()+2;
        else arrLen = strA.length()+2;
        //덧셈을 위해 뒤로 부터 int 배열에 담습니다.
        int[] revA = new int[arrLen];
        int[] revB = new int[arrLen];
        for(int i=strA.length(); i>0; i--){
            revA[strA.length()-i+1] = strA.charAt(i-1)-'0';
        }
        for(int i=strB.length(); i>0; i--){
            revB[strB.length()-i+1] = strB.charAt(i-1)-'0';
        }

        //덧셈 결과를 닮을 배열 크기를 정함.
        //int cutA = findFirst(revA);
        int cutA = 0;
        for(int i=revA.length-1; i>=0; i--){
            if(revA[i] != 0){
                cutA = i;
                break;
            }
        }
//        int cutB = findFirst(revB);
        int cutB = 0;
        for(int i=revB.length-1; i>=0; i--){
            if(revB[i] != 0){
                cutB = i;
                break;
            }
        }
        int maxCut = 0;
        if(cutA<cutB) maxCut = cutB+1;
        else if(cutA>cutB) maxCut = cutA+1;
        else if(cutA==cutB) maxCut = cutA+1;

        //덧셈
        int[] ans = new int[maxCut+1];
        int next = 0;

        for(int i=1; i<=maxCut; i++){
            int add = revA[i] +revB[i] + next;
            next = 0;
            next = add/10;
            ans[i] = add%10;
        }

        //덧셈 결과 출력.
//        int cut = findFirst(ans);
        // all 0일때 1자리임을 어떻게 증명할 수 있나.

        int cut = 0;
        for(int i=ans.length-1; i>=0; i--){
            if(ans[i] != 0){
                cut = i;
                break;
            }
        }
        String answer = "";
        if(cut==0) cut =1;
        for(int i=cut; i>0; i--){
            answer += String.valueOf(ans[i]);
        }

        int len = 0;
        if(answer.length()%4 == 0) len = answer.length()/4;
        else len = answer.length()/4 + 1;
        int[] digitArr = new int[len];
        String digit = "";
        int aa = 1;
        while(!(aa>cut)){
            digit += String.valueOf(ans[aa]);
            if(aa%4 == 0){
                String temp = "";
                for(int j=3; j>=0; j--){
                    temp += String.valueOf(digit.charAt(j));
                }
                digitArr[aa/4 -1] = Integer.parseInt(temp);
                digit = "";
            }
            if(aa==cut){
                if(digit == ""){
                    break;
                }else{
                    String temp = "";
                    for(int j=digit.length()-1; j>=0; j--){
                        temp += String.valueOf(digit.charAt(j));
                    }
                    digitArr[aa/4] = Integer.parseInt(temp);
                }
            }
            aa++;
        }

//        ListNode ansTemp = new ListNode(digitArr[digitArr.length-1]);
//        ListNode ans1 = ansTemp;
//        for(int i=digitArr.length-2; i>=0; i--){
//            ans1.next = new ListNode(digitArr[i]);
//            ans1 = ans1.next;
//        }


        ListNode<Integer> ans1 = new ListNode<Integer>(digitArr[digitArr.length-1]);
        ListNode<Integer> ans1Temp = ans1;
        for(int i=digitArr.length-2; i>=0; i--){
            ans1Temp.next  = new ListNode<Integer>(digitArr[i]);
            ans1Temp = ans1Temp.next;
        }
//        for(int i=1; i<=cut; i++){
//
//            digit += String.valueOf(ans[i]);
//            if(i%4 == 0){
//                String temp = "";
//                for(int j=3; j>=0; j--){
//                    temp += String.valueOf(digit.charAt(j));
//                }
//                digitArr[i/4 -1] = temp;
//                digit = "";
//            }
//        }

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


        return ans1;
    }

    public static void showResult(ListNode<Integer> a){

        ListNode<Integer> lTemp = a;

        while(!(lTemp.next == null)){
            System.out.print(lTemp.value+", ");
            lTemp = lTemp.next;

        }
    }
    public static int findFirst(int[] a){
        int cut = 0;
        for(int i=a.length-1; i>=0; i--){
            if(a[i] != 0){
                cut = i;
                break;
            }
        }
        return cut;
    }

}

 class ListNode<T> {
   ListNode(T x) {
     value = x;
   }
   T value;
   ListNode<T> next;
 }
