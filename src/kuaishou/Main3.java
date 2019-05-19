package kuaishou;

import java.util.Scanner;
/*
题目描述
        地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
        解析
        定义一个黑盒 walk(intthreshold,introws,intcols,inti,intj,boolean[]visited)，它表示统计从 rows行 cols列的矩阵中的 (i,j)开始所能到达的格子并返回，对于当前位置 (i,j)有如下判断：
        (i,j)是否越界矩阵了
        (i,j)是否已被统计过了
        (i,j)的行坐标和列坐标的数位之和是否大于 k
        如果通过了上面三重检查，则认为 (i,j)是可以到达的（ res=1），并标记 (i,j)的 visited为 true表示已被统计过了，然后对 (i,j)的上下左右的格子调用黑盒进行统计。
        这里要注意的是，与上一题不同， visited不会在递归计算完子状态后被重置回 false，因为每个格子只能被统计一次。 visited的含义不一样
public int movingCount(int threshold, int rows, int cols){
        if(threshold < 0 || rows < 0 || cols < 0){
        return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        return walk(threshold, rows, cols, 0, 0, visited);
        }

private int walk(int threshold, int rows, int cols, int i, int j, boolean[] visited){
        if(!isLegalPosition(rows, cols, i, j) || visited[i * cols + j] == true
        || bitSum(i) + bitSum(j) > threshold){
        return 0;
        }
        int res = 1;
        visited[i * cols + j] = true;
        res += walk(threshold, rows, cols, i + 1, j, visited) +
        walk(threshold, rows, cols, i - 1, j, visited) +
        walk(threshold, rows, cols, i, j + 1, visited) +
        walk(threshold, rows, cols, i, j - 1, visited);
        return res;
        }

private boolean isLegalPosition(int rows, int cols, int i, int j){
        if(i < 0 || j < 0 || i > rows - 1 || j > cols - 1){
        return false;
        }
        return true;
        }

public int bitSum(int num){
        int res = num % 10;
        while((num /= 10) != 0){
        res += num % 10;
        }
        return res;
        }
*/
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        if(m < 0 || n < 0 || k < 0){
            System.out.println(0);
        }
        Main3 a = new Main3();
        System.out.println(a.movingCount(m,n,k));

    }

    public int movingCount(int threshold, int rows, int cols){
        if(threshold < 0 || rows < 0 || cols < 0){
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        return walk(threshold, rows, cols, 0, 0, visited);
    }

    private int walk(int threshold, int rows, int cols, int i, int j, boolean[] visited){
        if(!isLegalPosition(rows, cols, i, j) || visited[i * cols + j] == true
                || bitSum(i) + bitSum(j) > threshold){
            return 0;
        }
        int res = 1;
        visited[i * cols + j] = true;
        res += walk(threshold, rows, cols, i + 1, j, visited) +
                walk(threshold, rows, cols, i - 1, j, visited) +
                walk(threshold, rows, cols, i, j + 1, visited) +
                walk(threshold, rows, cols, i, j - 1, visited);
        return res;
    }

    private boolean isLegalPosition(int rows, int cols, int i, int j){
        if(i < 0 || j < 0 || i > rows - 1 || j > cols - 1){
            return false;
        }
        return true;
    }

    public int bitSum(int num){
        int res = num % 10;
        while((num /= 10) != 0){
            res += num % 10;
        }
        return res;
    }
}

