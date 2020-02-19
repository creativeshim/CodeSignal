#include <iostream>
#include <vector>
#include <map>
#include <iterator>
#include <algorithm>
/**
 * 문제분석
 * hash table 의 개념 공부
 * 각 음식의 이름과 그 음식의 재료(ingredient)가 값으로 들어옴
 * 그럼 재료 별 음식으로 출력하기
 *  ex) in : ["Quesadilla", "Chicken", "Cheese", "Sauce"], ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]
 *  out : ["Cheese", "Quesadilla", "Sandwich"] *
 */
std::vector<std::vector<std::string>> groupingDishes(std::vector<std::vector<std::string>> dishes) {

    /**
     * 먼저 check vector를 선언하여 재료들을 싹다 박아 넣는다.
     */
    std::vector<std::string> check;
    for(int i=0; i<dishes.size(); i++){
        for(int j=1; j<dishes[i].size(); j++){
            std::string temp = dishes[i][j];
            check.push_back(temp);
        }
    }

    /**
     * check를 이용하여 중복으로 된 재료들만 map을 선언하고 그 map의 key로 정의
     * 추가로 후에 검색을 위해 vector에 그 재료들을 리스트에 담음.
     */
    std::map<std::string, std::vector<std::string>> m;
    std::vector<std::string> ingList;
    for(int i=0; i<check.size(); i++){
        int cnt = 0;
        for(int j=0; j<check.size(); j++){
            if(check[i] == check[j]){
                cnt++;
            }
        }
        if(cnt > 1){
            std::string temp = check[i];
            m.insert(std::make_pair(temp, NULL));

        }
    }

    for(std::map<std::string, std::vector<std::string>>::iterator it = m.begin(); it != m.end(); ++it) {
        ingList.push_back(it->first);
    }

    /**
     * key에 해당하는 재료가 있는 음식들을 찾아서 map에 넣어주는 작업을 진행해보자.
     */
    for(int k=0; k<ingList.size(); k++){
        std::vector<std::string> temp;
        for(int i=0; i<dishes.size(); i++){
            for(int j=1; j<dishes[i].size(); j++){
                if(ingList[k] == dishes[i][j]){
                    temp.push_back(dishes[i][0]);
                }
            }
        }
        //정렬을 해줘야함.
        sort(temp.begin(), temp.end());
        m[ingList[k]] = temp;
    }

    /**
     * return 값 만들어 보자.
     */
    std::vector<std::vector<std::string>> ans;

    for(int i=0; i<ingList.size(); i++){
        std::vector<std::string> row;
        row.push_back(ingList[i]);
        std::vector<std::string> temp = m[ingList[i]];
        for(int j=0; j<temp.size(); j++){
            row.push_back(temp[j]);
        }
        ans.push_back(row);
    }

    // break point
    std::cout << "break point" << std::endl;
    return ans;
}

int main() {


    std::vector<std::vector<std::string>> dishes = {{"First","a","b","c","d","e","f","g","h","i"},
                                                    {"Second","i","h","g","f","e","x","c","b","a"}};

    groupingDishes(dishes);

    return 0;
}




