#include <iostream>
#include <vector>
#include <map>
#include <iterator>
#include <algorithm>
/**
 * 문제분석
 * hash table 의 개념 공부
 * pattern에 들어온 형태가 string의 형태와 유사할 경우 true, 아니면 false
 * pattern : a, b, b // strings : cat, dog, dog 인 경우 스트링의 패턴이 pattern과 같기 때문에
 * return : true가 된다.ㅅ
 * string의 길이는 10^5
 * string[i] 길이는 max 10 min 1
 *
 */
bool areFollowingPatterns(std::vector<std::string> strings, std::vector<std::string> patterns) {
    /**
     * string과 pattern vector에서 서로 비교시 false 케이스
     * 1. strings의 i, i+1 값이 서로 같을 때, pattern의 i, i+1의 값이 서로 다르면 false
     * ex) cat cat // a b
     * 2. pattern의 i, i+1의 값이 서로 같을 때, strings의 i, i+1의 값이 서로 다르면 false
     * ex) a b // cat cat
     */
    for(int i=0; i<strings.size()-1;i++)
    {
        for(int j=i+1; j<strings.size();j++)
        {
            if(strings[i]==strings[j] && patterns[i] != patterns[j]){
                return false;
            }
            if(patterns[i]==patterns[j] && strings[i] != strings[j]){
                return false;
            }
        }
    }
    return true;
    
    /**
     * 개쩌는 솔루션 map 활용
     */
     //    bool areFollowingPatterns(std::vector<std::string> strings, std::vector<std::string> patterns) {
     //        map<string,string> mp12;
     //        map<string,string> mp21;
     //        for(int i=0;i<strings.size();i++){
     //            if(mp12.find(strings[i]) != mp12.end() && mp12[strings[i]] != patterns[i]) return false;
     //            if(mp21.find(patterns[i]) != mp21.end() && mp21[patterns[i]] != strings[i]) return false;
     //            mp12[strings[i]] = patterns[i];
     //            mp21[patterns[i]] = strings[i];
     //        }
     //        return true;
     //    }
}

int main() {

    std::vector<std::string> strings = {"aaa",
                                        "aaa",
                                        "aaa"};
    std::vector<std::string> patterns ={"aaa",
                                        "bbb",
                                        "aaa"};


    bool ans = areFollowingPatterns(strings, patterns);

    return 0;
}




