public class Main {
    public static void main(String[] args) throws Exception{
        char[][] solution = {{'A','0'}};
        String[] crypt = {"A",
                        "A",
                        "A"};
        boolean ans = isCryptSolution(crypt, solution);
        System.out.println(ans);

    }
    public static boolean isCryptSolution(String[] crypt, char[][] solution) {
        boolean isCrypt = false;
        /**
         * 접근 방법
         *  일단 solution을 통해 crypt를 숫자로 변환
         *  0으로 시작하면 바로 false return
         *  더했을 때 변환된 숫자와 같으면 true return. 아니면 false return.
         */
        String[] numArr = new String[crypt.length];
        for(int i=0; i<crypt.length; i++){
            String word = crypt[i];
            String number = "";
            for(int j=0; j<word.length(); j++){
                for(int k=0; k<solution.length; k++){
                    if(word.charAt(j) == solution[k][0]){
                        number += solution[k][1];
                    }
                }
            }
            numArr[i] = number;
        }


        for(int i=0; i<numArr.length; i++){
            /**
             * 0으로 시작하는 숫자가 있는지 확인
             * 1자리의 수이면서 0인 경우는 숫자로 인정
             */
            if(numArr[i].charAt(0) == '0' && numArr[i].length()>1){
                return false;
            }
        }

        /**
         * 제약조건
         * 1 ≤ crypt[i].length ≤ 14 로 인하여 double 형 사
         */
        double num1 = Double.parseDouble(numArr[0]);
        double num2 = Double.parseDouble(numArr[1]);
        double resultNum = Double.parseDouble(numArr[2]);

        if((num1+num2) == resultNum){
            return  true;
        }else{
            return false;
        }

    }
}
