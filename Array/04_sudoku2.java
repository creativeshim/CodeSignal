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

    public static boolean sero(char[][] grid){
        boolean solvable = false;
        for(int i=0; i<9; i++){
            int[] visited = new int[9];
            for(int j=0; j<9; j++){
                if(i==3 && j==0){
                    System.out.println("BP");
                }
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

    public static boolean section(char[][] grid, int section){

        int max = section-1; //3,6,9 -> 2,5,8
        boolean solvable = false;
        for(int i=1; i<=3; i++){
            if(i==1 && max==2){
                System.out.println("");
            }
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
