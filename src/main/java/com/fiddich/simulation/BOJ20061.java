package com.fiddich.simulation;

import java.util.*;

public class BOJ20061 {

    static int n;
    static int[][] green = new int[6][4];
    static int[][] blue = new int[6][4];
    static int score = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int y = sc.nextInt();
            int x = sc.nextInt();

            move(green, t, x);
            move(blue, t != 1 ? t^1 : 1, y);
            checkFull(green);
            checkFull(blue);
            checkOut(green);
            checkOut(blue);
        }

        System.out.println(score);
        int ret = 0;
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 4; j++) {
                if(green[i][j] == 1) {
                    ret++;
                }
                if(blue[i][j] == 1) {
                    ret++;
                }
            }
        }
        System.out.println(ret);
    }

    static void checkOut(int[][] board) {
        for(int i = 0; i < 2; i++) {
            if(!isEmpty(board, 1)) {
                for(int j = 4; j >= 0; j--) {
                    board[j+1] = board[j].clone();
                }
                board[0] = new int[4];
            }
        }
    }

    static boolean isEmpty(int[][] board, int r) {
        for(int i = 0; i < 4; i++) {
            if(board[r][i] == 1) {
                return false;
            }
        }
        return true;
    }

    static void checkFull(int[][] board) {
        for(int i = 5; i >= 2; i--) {
            int cnt = 0;
            for(int j = 0; j < 4; j++) {
                if(board[i][j] == 1) {
                    cnt++;
                }
            }
            if(cnt == 4) {
                score++;
                for(int j = i; j > 0; j--) {
                    board[j] = board[j-1].clone();
                }
                board[0] = new int[4];
                i++;
            }
        }
    }

    static void move(int[][] board, int t, int fixed) {
        int r = -1;
        if(t == 1) {
            for(int i = 0; i < 6; i++) {
                if(board[i][fixed] == 1) {
                    break;
                }
                r = i;
            }
            board[r][fixed] = 1;
        }
        else if(t == 2) {
            for(int i = 0; i < 6; i++) {
                if(board[i][fixed] == 1 || board[i][fixed+1] == 1) {
                    break;
                }
                r = i;
            }
            board[r][fixed] = 1;
            board[r][fixed+1] = 1;
        }
        else if(t == 3) {
            for(int i = 1; i < 6; i++) {
                if(board[i][fixed] == 1) {
                    break;
                }
                r = i;
            }
            board[r][fixed] = 1;
            board[r-1][fixed] = 1;
        }
    }
}
// 초록색 보드의 0, 1번 행에 블록이 있으면, 블록이 있는 행의 수만큼 아래 행에 있는 타일이 사라지고, 초록색 보드의 모든 블록이 사라진 행의 수만큼 아래로 이동하고
// 파란색 보드의 0, 1번 열에 블록이 있으면, 블록이 있는 열의 수만큼 오른쪽 열에 있는 타일이 사라지고, 파란색 보드의 모든 블록이 사라진 열의 수만큼 이동하게 된다
// 행이나 열이 타일로 가득찬 경우와, 연한 칸에 블록이 있는 경우가 동시에 발생할 수 있다. 이 경우에는 행이나 열이 타일로 가득 찬 경우가 없을 때까지 점수를 획득하는 과정이 모두 진행된 후, 연한 칸에 블록이 있는 경우를 처리해야 한다.
