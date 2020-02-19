#include <iostream>
#include <vector>
#include <map>
#include <iterator>
#include <algorithm>
#include <unordered_map>

bool containsCloseNums(std::vector<int> nums, int k) {
    /**
     * 문제 분석
     * array에서 같은 값을 가지는 i, j값을 있다. i와 j의 차이의 절대값이 k보다 작거나 같으면 true.
     * ex) 0,1,2,3,5,2 // 같은 값이 있는 case가 2, i = 2, j = 5, 5-2 = 3, k = 3 => true
     * ex) 0,1,2,3,5,2 // 같은 값이 있는 case가 2, i = 2, j = 5, 5-2 = 3, k = 2 => false (차이값 3이 k보다 크기 때문에)
     *
     * nums: [1, 0, 1, 1]
       k: 1 일때 diff 값은 1,1 = 1 이어야 한다.
     */
     /**
      *  선택된 값과 똑같은 값을 가진 녀석과의 diff(차이)를 구해서 
      *  (어차피 끝까지 돌게 되면 1,0,1,1인 케이스도 diff값이 2에서 1로 갱신됨)
      *  diff값이 k보다 작을 경우(0이면 중복되는 케이스가 없다는 뜻) true return.
      *  다만.. 해당 로직은 22/24로써 comments 확인해보니 굉장히 큰 array 케이스가 input으로 들어 와서 0.5초
      *  0.5초 컷에 걸리는 것 같음..
      */

    // int diff = 0;
    // for(int i=0; i<nums.size(); i++){
    //     int selected = nums[i];
    //     for(int j=i+1; j<nums.size(); j++){
    //            if(selected == nums[j]){
    //                diff = j-i;
    //            }
    //     }
    // }
    // if(diff != 0 && diff<= k){
    //     return true;
    // }else{
    //     return false;
    // }

    /**
     * 기존 map은 자동 ordered해주기 때문에 unordered_map을 사용하였고
     * 해당 숫자에 대해 second로 위치값을 담는다.
     * 각 map 별로 second 사이즈가 0 이상인 경우엔(중복숫자 존재로 판단)
     * 위치 차이의 값이 k보다 작을 경우 true return.
     */
    std::unordered_map <int, std::vector <int>> m;
    for (int i = 0; i < nums.size(); ++i) {
        int temp = nums[i];
        //해당 위치값을 push back.
        m[temp].push_back(i);
    }

    for (std::pair <int, std::vector <int>> v : m) {
        for (int i = 0; i < v.second.size(); ++i) {
            if (i==0) continue;
            if (v.second[i] - v.second[i-1] <= k) {
                return true;
            }
        }
    }

    return false;
}

int main() {

    std::vector<int> nums = {1, 0, 1, 1};
    int k = 1;


    bool ans = containsCloseNums(nums, k);
    std::cout<<ans<<std::endl;
    return 0;
}

