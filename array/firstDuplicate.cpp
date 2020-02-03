//============================================================================
// Name        : array_01_firstDuplicate.cpp
// Author      : creativeshim
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <bits/stdc++.h>
#include <Math.h>
using namespace std;
int firstDuplicate(vector<int> a) {
	/*접근방법
	 *처음부터 탐색 -> 같은 숫자 나오는데까지의 거리
	 *없으면 max값
	 *같은 숫자 발견시 answer 값 갱신
	 *answer값과 비교 하면서 최소값 구하기
	 *answer값 출력.
		현재 이코드는 time limit : cpp 기준 0.5s max, O(N^2)는 힘들다는 말임.. 이걸 어케 줄이지..
	 */
	int ans = 0;
	map<int,int> m;

	for(int i=0; i<a.size(); i++){
		int pick = a[i];
		int cnt = 1; // 선택된 숫자 옆부터 검색할 것이기 때문에
		for(int j=i+1; j<a.size(); j++){
			if(pick == a[j]){ //발견시
				if(ans == 0){ //초기에 값 넣어주기
					ans = cnt;
					if(!m.empty()){
						m.clear();
						m.insert({ans,pick});
					}else{
						m.insert({ans,pick});
					}
				}else{
					if(cnt <= ans){
						//count가 서로 같은데 두번째에 등장하는 놈이 생길 수 있으니 예외처리
						//1 1 2 2 1 인 경우엔 2대신에 1이 반환되어야 한다.
						//그치만 2 2 1 1 2 인 경우엔? 1이 반환 되어야 하지
						// 그럼 같은 거리에 있는 애들이어도 숫자 비교를 해줘야 된다는 뜻
						if(m.count(cnt) == 0){
							ans = cnt;
							if(!m.empty()){
								m.clear();
								m.insert({ans,pick});
							}else{
								m.insert({ans,pick});
							}
						}else{
							//같은 거리에 있는 애들이 존재 할 때,
							int org = m[cnt];
							if(org < pick){//기존 것이 현재보다 작으면 stay.
								continue;
							}else{//신규가 기존것 보다 작으면
								ans = cnt;
								if(!m.empty()){
									m.clear();
									m.insert({ans,pick});
								}else{
									m.insert({ans,pick});
								}
							}
						}
					}
				}
				break;
			}
			cnt++;
		}
	}
	//발견 안될 시 예외처리
	if(m.empty()){
		ans = -1;
	}else{
		ans = m[ans];
	}
	return ans;
}

int main() {
	vector<int> tmp;
	tmp.push_back(2);
	tmp.push_back(2);
	tmp.push_back(1);
	tmp.push_back(1);
	tmp.push_back(2);

	int ans = 0;
	ans = firstDuplicate(tmp);
//	for(int i=0; i<tmp.size(); i++){
//		cout << tmp[i] << endl;
//	}
	cout << ans << endl;
	return 0;
}
