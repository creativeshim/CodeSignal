#include <iostream>
#include <vector>
#include <map>

int possibleSums(std::vector<int> coins, std::vector<int> quantity) {
    /**
     * 문제 분석
     * 각 동전의 액수 및 갯수를 알고 있다. 각 동전을 사용 또는 사용하지 않아서 가능한 합의 갯수를 구하자
     * coins = [10, 50, 100] and quantity = [1, 2, 1]
     *  50 = 50;
        10 + 50 = 60;
        50 + 100 = 150;
        10 + 50 + 100 = 160;
        50 + 50 = 100;
        10 + 50 + 50 = 110;
        50 + 50 + 100 = 200;
        10 + 50 + 50 + 100 = 210;
        10 = 10;
        100 = 100;
        10 + 100 = 110.     total : 11개 중복 빼고 9
     */

    /**
     * 접근 방법
     * 일단 각 동전 별로 갯수의 map 구성
     * 경우의 수 : 각 동전의 갯수별 + 1 해서 전부 곱 - 1 (아예 안쓰는 경우 제외)
     * 중복 제외 시켜야함 -> map의 특성으로 해결 할 수 있을 것 같음..
     *
     */

    std::map<int, bool> m;

    int max = 0;
    for (int i = 0; i < quantity.size(); i++) {
        max += coins[i] * quantity[i];
    }


    std::vector<int> sums;
    sums.push_back(0);

    /**
     * coins 별로, sums을 구하되, max를 안넘는 선에서.
     * coin의 갯수로 만들 수 있는 수 s를 구해서
     * map 에 넣는다.
     */
    for (int j = 0; j < coins.size(); j++) {
        int coin = coins[j];
        int n = sums.size();
        for (int i = 0; i < n; i++) {
            int s = sums[i];
            for (int k = 0; k < quantity[j]; k++) {
                s += coin;
                if (max < s) break;
                if (m.count(s) == 0) {
                    m.insert(std::make_pair(s, true));
                    sums.push_back(s);
                }
            }
        }
    }

    return m.size();
}


int main() {

    std::vector<int> coins = { 10, 50, 100 };
    std::vector<int> quantity = { 1, 2, 1 };



    int ans = possibleSums(coins, quantity);
    std::cout << ans << std::endl;
    return 0;
}
