public class Main {
    static int MAX;
    public static void main(String[] args) throws Exception{
        char[][] grid = {{'.','4','.','.','.','.','.','.','.'},
                         {'.','.','4','.','.','.','.','.','.'},
                         {'.','.','.','1','.','.','7','.','.'},
                         {'.','.','.','.','.','.','.','.','.'},
                         {'.','.','.','3','.','.','.','6','.'},
                         {'.','.','.','.','.','6','.','9','.'},
                         {'.','.','.','.','1','.','.','.','.'},
                         {'.','.','.','.','.','.','2','.','.'},
                         {'.','.','.','8','.','.','.','.','.'}};
        boolean ans = sudoku2(grid);
        System.out.println(ans);

    }

    /**
     * solvable sudoku check function
     * 가로, 세로, 3x3 방식으로 전부 체크 후
     * 모두 true 일 때 true, 하나라도 false라면 false return.
     */
    public static boolean sudoku2(char[][] grid) {
        boolean garo = garo(grid);
        boolean sero = sero(grid);
        boolean by33 = false;
        for(int i=1; i<=3; i++){
            by33 = section(grid,i*3);
            if(by33 == false){
                break;
            }
        }

        if(garo && sero && by33){
            return true;
        }else{
            return false;
        }
    }

    /**
     * boolean garo function
     * 가로줄 검색
     * 모든 가로줄을 검색해서 visited[9] 배열에 각 숫자별 배열에 카운트, 카운트가 2 이상일 때 false return.
     * O(N^2)
     */
    public static boolean garo(char[][] grid){
        boolean solvable = false;
        for(int i=0; i<9; i++){
            int[] visited = new int[9];
            for(int j=0; j<9; j++){
                char pick = grid[i][j];
                if(pick != '.'){
                    visited[pick-'0'-1] = visited[pick-'0'-1] + 1;
                }
            }
            for(int k=0; k<9; k++){
                if(visited[k] > 1){
                    solvable = false;
                    break;
                }else{
                    solvable = true;
                }
            }
            if(solvable == false){
                break;
            }
        }
        return solvable;
    }
    /**
     * boolean garo function
     * 세로줄 검색
     * 모든 세로줄을 검색해서 visited[9] 배열에 각 숫자별 배열에 카운트, 카운트가 2 이상일 때 false return.
     * O(N^2)
     */
    public static boolean sero(char[][] grid){
        boolean solvable = false;
        for(int i=0; i<9; i++){
            int[] visited = new int[9];
            for(int j=0; j<9; j++){
                char pick = grid[j][i];
                if(pick != '.'){
                    visited[pick-'0'-1] = visited[pick-'0'-1] + 1;
                }
            }
            for(int k=0; k<9; k++){
                if(visited[k] > 1){
                    solvable = false;
                    break;
                }else{
                    solvable = true;
                }
            }
            if(solvable == false){
                break;
            }
        }
        return solvable;
    }

    /**
     * boolean section function
     * 3x3 구간 별로 탐색
     * 각 3x3 구간내의 배열을 검색해서 visited[9] 배열에 각 숫자별 배열에 카운트, 카운트가 2 이상일 때 false return.     *
     * O(N^2)
     * x축을 3등분 해서 각 섹션별 max값 추출 :3,6,9 -> 2,5,8
     * 검색 범위가 3x3 이기 때문에 굳이 배열 숫자를 기준으로 3을 계산할 필요 없이 단순 cnt가 3이 될때까지 검색(while)
     */
    public static boolean section(char[][] grid, int section){

        int max = section-1; //3,6,9 -> 2,5,8
        boolean solvable = false;
        for(int i=1; i<=3; i++){
            int times = i*3 - 3;
            int cnt = 0;
            int[] visited = new int[9];
            while(!(cnt == 3)){
                //i 구역 가로 기준
                for(int x=max; x>=max-2; x--){
                    char pick = grid[times][x];
                    if(pick != '.'){
                        visited[pick-'0'-1] = visited[pick-'0'-1] + 1;
                    }
                }
                times++;
                cnt++;
            }
            for(int k=0; k<9; k++){
                if(visited[k] > 1){
                    solvable = false;
                    break;
                }else{
                    solvable = true;
                }
            }
            if(solvable == false){
                break;
            }
        }
        return solvable;
    }

    public static void print(char[][] grid){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
