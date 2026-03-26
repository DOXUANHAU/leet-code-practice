package array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch {
public boolean result= false;
     public boolean exist(char[][] board, String word) {
        if( word == null || word.length() == 0) return false;

        // get the first char of the word 
        // init value 
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        char first = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == first){
                     if
                    backtracking(board, visited, i, j, word, 0)  ;
                }
            }
        }

        return result;

    }

    // backtracking function 
    private void backtracking(char[][] board , boolean visited[][] , int rowStart , int columnStart , String word ,int currnetCharIndex){

        if(currnetCharIndex == word.length() - 1 && board[rowStart][columnStart] == word.charAt(currnetCharIndex) ) {
             result = true ;
             return;
        }

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for (int i = 0; i < 4; i++) {
            int x = rowStart + dx[i];
            int y = columnStart + dy[i];

            // if the row is higher or lower than the lenght 
            if(x > board.length - 1 || x < 0) continue;

            // if the column is the same 

            if(y > board[columnStart].length -  1 || y < 0) continue;

            // if the char wax checked continue
            if(visited[x][y]) continue;

            // if not the word continue
            if(board[x][y] != word.charAt(currnetCharIndex) ) continue;

            // last case the same word ==> do 
            visited[x][y] = true;
            currnetCharIndex+=1;
            backtracking(board, visited, x, y, word, currnetCharIndex );

             visited[x][y] = false;
             currnetCharIndex-=1;

        }


        
        
    }
    
public static void main(String[] args) {
    char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    WordSearch wordSearch = new WordSearch();
    System.out.println(wordSearch.exist(board, "ABCCED"));
}
}
