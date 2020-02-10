/**
     * 제약사항 : O(l1.length + l2.length) time complexity = O(2N)
     *  also sorted in non-decreasing order (오름차순 정리)
     * 0 ≤ list size ≤ 104,
     * -109 ≤ element value ≤ 109
     * 주어지는 것도 오름차순으로 주어지기 때문에 answer list에 서로 비교해가면서 넣는 것이 어떨지 생각해봄.
     * l1, l2 사이즈는 서로 다르기 때문에 접근 방법을 고민해볼 필요가 있음
     * list size가 없을 수도 있네?
     */
    public static ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        //처음만 서로 비교해서 answer에 넣고 그 다음부터 while로 조져보자
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int l1First = l1.value;
        int l2First = l2.value;
        int ansFirst = 0;
        ListNode<Integer> templ1 = l1;
        ListNode<Integer> templ2 = l2;
        if(l1First < l2First) {
            ansFirst = l1First;
            templ1 = l1.next; // 선택된 숫자 제외 나머지
        }
        else if(l1First > l2First){
            ansFirst = l2First;
            templ2 = l2.next; // 선택된 숫자 제외 나머지
        }
        else if(l1First == l2First){
            ansFirst = l1First;
            templ1 = l1.next; // 선택된 숫자 제외 나머지
        }
        ListNode<Integer> ansList = new ListNode<Integer>(ansFirst);
        ListNode<Integer> tempAns = ansList;
        int curNum1 = 0;
        int curNum2 = 0;
        while(!(templ1 == null && templ2 == null)){
            /**
            l1. l2 둘다 종료되는 시점까지 무한 반복
             그럼 발생되는 시나리오
             1. l1, l2 둘다 next가 존재 할 때
             2. l1만 next가 존재하고 l2는 끝났을 때
             3. l2만 next가 존재하고 l1은 끝났을 때
             */
            if(templ1 != null && templ2 != null){
                curNum1 = templ1.value;
                curNum2 = templ2.value;

                if(curNum1 < curNum2){
                    tempAns.next = new ListNode<Integer>(curNum1);
                    templ1 = templ1.next;
                }else if(curNum1 > curNum2){
                    tempAns.next = new ListNode<Integer>(curNum2);
                    templ2 = templ2.next;
                }else if(curNum1 == curNum2){
                    tempAns.next = new ListNode<Integer>(curNum1);
                    templ1 = templ1.next;
                }
                tempAns = tempAns.next;
            }else if(templ1 != null && templ2 == null){
                curNum1 = templ1.value;
                tempAns.next = new ListNode<Integer>(curNum1);
                templ1 = templ1.next;
                tempAns = tempAns.next;
            }else if(templ1 == null && templ2 != null){
                curNum2 = templ2.value;
                tempAns.next = new ListNode<Integer>(curNum2);
                templ2 = templ2.next;
                tempAns = tempAns.next;
            }
        }
        return ansList;
    }

}
