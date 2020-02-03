#include <iostream>
#include <map>
using namespace std;
char firstNotRepeatingCharacter(std::string s) {
	char ans = '_';
	int ansNum = 0;
	map<int,char> m;

    int order = 0;
	for(int i=0; i<s.length(); i++){
		char currentChar = s[i];
		int charNum = 0;
		for(int j=0; j<s.length(); j++){
			char nextChar = s[j];
			if(charNum == 0 || charNum == 1){
				if(currentChar == nextChar){
					charNum++;
				}
			}else if(charNum > 1){
				break;
			}
		}
		if(charNum == 1){
			ansNum++;
			order++;
			m.insert({order,currentChar});
		}
	}

	if(!(ansNum == 0)){
		ans = m[1];
	}

	return ans;
}

int main(){
	std::string s = "ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof";
	char ans = firstNotRepeatingCharacter(s);

	std::cout<<ans<<std::endl;
}
