//check if given sudoku is valid or not

import java.util.HashSet;

public class validsudoku {
    public static void main(String[] args) {
        char[][] arr={
            {'5','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','.','.','.','8','.','.','7','9'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
        };
        boolean check=check(arr);
        System.out.println(check);
    }
    static boolean check(char[][] board)
    {
        for(int i=0;i<board.length;i++)
        {
            HashSet<Character> set=new HashSet<>();
            for(int j=0;j<board[i].length;j++)
            {
                if(Character.isDigit(board[i][j]))
                {
                    if(set.contains(board[i][j]))
                    return false;
                    else
                    set.add(board[i][j]);
                }
            }
        }


        for(int i=0;i<board.length;i++)
        {
            HashSet<Character> set=new HashSet<>();
            for(int j=0;j<board[i].length;j++)
            {
                if(Character.isDigit(board[j][i]))
                {
                    if(set.contains(board[j][i]))
                    return false;
                    else
                    set.add(board[j][i]);
                }
            }
        }


        for(int a=0;a<board.length;a++)
        {
            HashSet<Character> set=new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (a / 3) * 3 + i;
                    int col = (a % 3) * 3 + j;
                if(Character.isDigit(board[row][col]))
                {
                    if(set.contains(board[row][col]))
                    return false;
                    else
                    set.add(board[row][col]);
                }
                
                }}
        }
        return true;

    }
}
