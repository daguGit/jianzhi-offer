package com.github.dagugit.algorithm;

/**
 * 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如
 * ⎣ a b c e
 * s f c s
 * a d e e ⎡
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class _65_HasPath {

    /**
     * 思路
     * 1、特殊情况
     * -A：  if (matrix == null || rows < 1 || cols < 1 || str == null)     return false;
     * 2、声明是否访问过标记位数组 isVisited
     * 3、递归
     * -A:row < 0 || col < 0 || row >= rows || col >= cols return false
     * -B：matrix[index] != str[pathLength] return false
     * -C: isVisited[index] == true return false
     * -D:pathLength == str.length - 1)    return true;
     * 4、标记访问过
     * 5、对四个方向递归
     * 6、还原标记位
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }
        //标志位数组
        boolean[] isVisited = new boolean[rows * cols];

        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength,
                                boolean[] isVisited) {
        //先根据col和row计算第一个元素转一位数组的位置
        int index = row * cols + col;
        //递归终止条件
        if (row < 0 || col < 0 || row >= rows || col >= cols ||
                matrix[index] != str[pathLength]//如果不匹配返回false
                || isVisited[index] == true) {
            return false;
        }
        //若pathLength已经到str末尾,说明之前的匹配成功了,直接返回True即可
        if (pathLength == str.length - 1) {
            return true;
        }
        //表示已经走过了
        isVisited[index] = true;
        //回溯，递归寻找，每次找到了就给k加一，找不到，还原
        boolean hasPath = hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength + 1, isVisited)
                || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength + 1, isVisited)
                || hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength + 1, isVisited)
                || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength + 1, isVisited);
        if (hasPath) {
            return true;
        }
        //走到这，说明这一条路不通，还原，再试其他的路径
        isVisited[index] = false;
        return false;
    }


}
