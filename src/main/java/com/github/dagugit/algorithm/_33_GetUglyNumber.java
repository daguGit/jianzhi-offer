package com.github.dagugit.algorithm;

/**
 * 丑数
 * <p>
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class _33_GetUglyNumber {
    /**
     * 思路1
     * 暴力法（逆向思维），直接判断某个数是否是丑数，然后count计数
     * 1、特殊情况
     *  index<=0 return 0;
     * 2、判断某个数 t 是否是丑数
     *  -A：使用当前数 t 模除2，if(t%2==0) t=t/2，并循环
     *  -B：使用当前数 t 模除3，if(t%3==0) t=t/3，并循环
     *  -C：使用当前数 t 模除4，if(t%4==0) t=t/4，并循环
     * 3、声明count记录当前丑数的个数
     * -A：if(count==index) return t
     *
     * 思路2
     * 顺向思维，
     * 存放丑数数组res,res数组里的第一个元素为1。因为我们要让丑数数列有序，所以要每次使这三个因子组成的最小的数进入数组。
     * t2表示乘以2得到的丑数，t3表示乘以3得到的丑数，t5是乘以5得到的丑数，
     * 把最小的进入丑数数组res
     *  res： 1
     *
     * t2: 2
     * t3: 3
     * t5: 5
     * 比较（2，3，5）->min_n = 2,   2进入 res
     *
     *  res:1 2
     *
     * t 2:   4
     * t 3:   3 6
     * t 5:   5 10
     *
     * 然后比较当前的值(4，3，5)，3再进入res
     *
     * res 1 2 3
     *
     * t 2:   4
     * t 3:   6 9
     * t 5:   5 10
     *
     * (4, 5, 6)  得到4进入res
     *
     * @param index
     * @return
     */
    int GetUglyNumber(int index) {
        if(index<=0){
            return 0;
        }
        // 1--6都是丑数
        if(index < 7) {
            return index;
        }
        int[] res = new int[index];
        res[0] = 1;
        // t2 就是乘以2的丑数，t3就是乘以3的丑数，t5就是乘以5的丑数
        int t2 = 0, t3 = 0, t5 = 0;
        for(int i=1;i<index;i++){
            //这里的思路太妙了
            // 三个丑数中选取最小的(2,3,5) 作为下一个丑数
            res[i] = Math.min(res[t2]*2, Math.min(res[t3]*3, res[t5]*5));
            if(res[i] == res[t2] * 2) {
                t2++;
            }
            if(res[i] == res[t3] * 3) {
                t3++;
            }
            if(res[i] == res[t5] * 5) {
                t5++;
            }
        }
        return res[index-1];
    }
    // 这里是暴力的解法

    /**
     *
     * @param index
     * @return
     */
    public int GetUglyNumber2(int index) {
        if(index<=0){
            return 0;
        }
        if(index<7){
            return  index;
        }
        int count =0;
        int i = 1;
        while (true){
            if(this.isUglyNumber(i)){
                count++;
                if(count==index){
                 return i;
                }
            }
            i++;
        }
    }
    private boolean isUglyNumber(int t){
        while(t%2==0){
            t=t/2;
        }
        while(t%3==0){
            t = t/3;
        }
        while(t%5==0){
            t=t/5;
        }
        if(t==1){
            return true;
        }
        return  false;
    }

    public static void main(String[] args) {
        _33_GetUglyNumber getUglyNumber = new _33_GetUglyNumber();
        int i = getUglyNumber.GetUglyNumber2(8);
        System.out.println(i);
    }
}
