// package array;


// public class WordSearch {
//  boolean result= false;
//      public boolean exist(char[][] board, String word) {
//         if( word == null || word.length() == 0) return false;

//         // get the first char of the word 
//         // init value 
//         boolean[][] visited = new boolean[board.length][board[0].length];
        
//         char first = word.charAt(0);
//         for (int i = 0; i < board.length; i++) {
//             for (int j = 0; j < board[i].length; j++) {
//                 if(board[i][j] == first){
//                     backtracking(board, visited, i, j, word, 0);
//                     if(this.result) break;

//                 }
//             }
//         }

//         return this.result;

//     }

//     // backtracking function 
//     private void backtracking(char[][] board , boolean visited[][] , int rowStart , int columnStart , String word ,int currnetCharIndex){
//         visited[rowStart][columnStart] = true;
//         if( currnetCharIndex == word.length() - 1) {
//              this.result = true ;
//              return;
//         }

//         int[] dx = {-1,1,0,0};
//         int[] dy = {0,0,-1,1};
//         char charCompare = word.charAt(currnetCharIndex);
//         for (int i = 0; i < 4; i++) {
//             int x = rowStart + dx[i];
//             int y = columnStart + dy[i];
            
            
//             // if the row is higher or lower than the lenght 
//             if(x > board.length - 1 || x < 0) continue;
            
//             // if the column is the same 
            
//             if(y > board[columnStart].length -  1 || y < 0) continue;

//             char charBoard = board[x][y];
            
//             // if the char wax checked continue
//             if(visited[x][y]) continue;
            
//             // if not the word continue
//             if(charBoard != charCompare ) continue;
            
//             // last case the same word ==> do 
//             currnetCharIndex+=1;
//             backtracking(board, visited, x, y, word, currnetCharIndex );
//              visited[x][y] = false;
//              currnetCharIndex-=1;

//         }


        
        
//     }
    
// public static void main(String[] args) {
//     char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//     WordSearch wordSearch = new WordSearch();
//     System.out.println(wordSearch.exist(board, "ABCCED"));
// }
// }

package array;

public class WordSearch {
    boolean result = false;

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;

        boolean[][] visited = new boolean[board.length][board[0].length];
        char first = word.charAt(0);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == first) {
                    backtracking(board, visited, i, j, word, 0);
                    if (result) return true; // early return
                }
            }
        }

        return false;
    }

    private void backtracking(char[][] board, boolean[][] visited,
                              int row, int col, String word, int index) {

        if (index == word.length() - 1) {
            result = true;
            return;
        }

        visited[row][col] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int x = row + dx[i];
            int y = col + dy[i];

            // boundary check
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
                continue;

            if (visited[x][y]) continue;

            // compare NEXT char
            if (board[x][y] != word.charAt(index + 1)) continue;

            backtracking(board, visited, x, y, word, index + 1);

            if (result) return; // stop early
        }

        visited[row][col] = false; // backtrack
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, "OBCCFD")); // false
    }
}