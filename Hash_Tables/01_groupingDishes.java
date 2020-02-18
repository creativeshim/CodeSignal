package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        String[][] dishes = {{"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
                {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
                {"Quesadilla", "Chicken", "Cheese", "Sauce"},
                {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}};

        String[][] ansArr = groupingDishes(dishes);
    }

    public static String[][] groupingDishes(String[][] dishes) {
        HashMap<String, ArrayList<String>> m = new HashMap<>();

        /**
         * 일단 map을 선언하고 재료들 key를 먼저 만든다.
         * 근데 2개 이상일 때만 해당 되는데???
         */
        ArrayList<String> check = new ArrayList<String>();

        for(int i=0; i<dishes.length; i++){
            for(int j=1; j<dishes[i].length; j++){
                String temp = dishes[i][j];
                check.add(temp);
            }
        }

        for(int i=0; i<check.size(); i++){
            int cnt = 0;
            for(int j=1; j<check.size(); j++){
                if(check.get(i) == check.get(j)){
                    cnt++;
                }
            }
            if(cnt > 1){
                m.put(check.get(i), null);
            }
        }


        Iterator<String> mKeys = m.keySet().iterator();
        while(mKeys.hasNext()){
            ArrayList<String> list = new ArrayList<>();
            String key = mKeys.next();
            for(int i=0; i<dishes.length; i++){
                for(int j=1; j<dishes[i].length; j++){
                    if(key.equals(dishes[i][j])){
                        list.add(dishes[i][0]);
                    }
                }
            }
            list.sort(Comparator<String>);
            m.put(key, list);
        }

        return null;

    }

}
