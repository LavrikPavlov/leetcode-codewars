package ru.kazan.level5.TicTacToeChecker;

import java.util.Arrays;

public class TicTacToeChecker {

    public static int isSolved(int[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] > 0)
                return board[i][0];
            else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] > 0)
                return board[0][i];
            else if ((board[1][1] == board[0][0] && board[0][0] == board[2][2] && board[1][1] > 0)
                    || board[1][1] == board[2][0] && board[2][0] == board[0][2] && board[1][1] > 0)
                return board[1][1];
        }
        if (Arrays.stream(board)
                .flatMapToInt(Arrays::stream)
                .anyMatch(n -> n == 0))
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {
        int[][] array = {{0, 0, 1},
                        {0, 1, 2},
                        {2, 1, 0}
        };

        System.out.println(isSolved(array));
    }
}
