package com.github.dagugit.algorithm;

/**
 * 机器人的运动范围
 *
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class _66_MovingCount {
    /**
     * --不太会，借鉴网上的思路
     * 思路：
     * 使用回溯法
     * 声明visited标记数组
     * 在当前格子中能访问到的格子数 count =1+ f(向上)+f(向下)+f(向左)+f(向右)
     * f()需满足不越界、没有访问过、位置和小于阈值
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        if(rows<=0||cols<=0||threshold<0) {
            return 0;
        }
        int[] visited=new int[rows*cols];
        return MovingCount(threshold,rows,cols,0,0,visited);
    }

    private int MovingCount(int threshold,int rows,int cols,int row,int col,int[] visited){
        int count=0;
        if(canWalkInto(threshold, rows, cols, row, col, visited)){
            visited[row*cols+col]=1;
            count=1+MovingCount(threshold,rows,cols,row-1,col,visited)   //往上
                    +MovingCount(threshold,rows,cols,row+1,col,visited)  //往下
                    +MovingCount(threshold, rows, cols, row, col-1, visited)   //往左
                    +MovingCount(threshold, rows, cols, row, col+1, visited);  //往右
        }
        return count;
    }

    private boolean canWalkInto(int threshold,int rows,int cols,int row,int col,int[] visited){
        if(row>=0 && row<rows && col>=0 && col<cols
                && getSumOfDigits(row)+getSumOfDigits(col)<=threshold
                && visited[row*cols+col]==0)
            return true;
        else {
            return false;
        }
    }

    private int getSumOfDigits(int number){
        int sum=0;
        while(number!=0){
            sum+=number%10;
            number/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        _66_MovingCount movingCount = new _66_MovingCount();
        int i = movingCount.movingCount(18, 10, 10);
        System.out.println(i);
    }
}
