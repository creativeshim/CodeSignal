public class Main {
    static int MAX;
    public static void main(String[] args) throws Exception{
        char[][] grid = {{'.','.','.','1','4','.','.','2','.'},
                         {'.','.','6','.','.','.','.','.','.'},
                         {'.','.','.','.','.','.','.','.','.'},
                         {'.','.','1','.','.','.','.','.','.'},
                         {'.','6','7','.','.','.','.','.','9'},
                         {'.','.','.','.','.','.','8','1','.'},
                         {'.','3','.','.','.','.','.','.','6'},
                         {'.','.','.','.','.','7','.','.','.'},
                         {'.','.','.','5','.','.','.','7','.'}};
        boolean ans = sudoku2(grid);
        System.out.println(ans);

    }
    public static boolean sudoku2(char[][] grid) {
        boolean solvable = false;
        print(grid);
        //가로줄 점검
        for(int i=1; i<=3; i++){
            solvable = section(grid,i*3);
        }
        //세로줄 점검

        //3x3 점검
        return solvable;
    }
    public static boolean section(char[][] grid, int section){
        int max = section-1; //3,6,9 -> 2,5,8
        boolean solvable = false;
        for(int i=1; i<=3; i++){
            int times = i*3 - 3;
            int cnt = 0;
            int[] visited = new int[9];
            while(!(cnt == 3)){
                //i 구역 가로 기준
                for(int x=max; x>=0; x--){
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

 class ListNode<T> {
   ListNode(T x) {
     value = x;
   }
   T value;
   ListNode<T> next;
 }
