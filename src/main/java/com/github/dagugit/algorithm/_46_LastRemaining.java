package com.github.dagugit.algorithm;

/**
 * 孩子们的游戏(圆圈中最后剩下的数)
 * <p>
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 * 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * 如果没有小朋友，请返回-1
 */
public class _46_LastRemaining {
    /**
     * 思路：
     * 1、特殊情况
     * -A、n==0||m==0 return -1
     * 2、使用队列的方式
     * -A、声明一个 list，并插入0~n-1
     * -B、对于 list的长度，对m取模，并removeIndex(list.size%m)
     * -C、循环，直到 list.size==1
     *
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        /**
         * 1、特殊情况
         * -A：if(n==0||m<=0)return -1;
         * -B: if(n==1) return 0;
         * 2、声明 boolean[n] 表示是否出列、outCount，表示已出列个数、circle ：循环标记、pointer = pointer%n ：数组指针标价
         * 3、当前标记没有出列时即 outs[pointer]==false
         * -A：如果circle==m，boolean true，outCount++,circe=0;
         *  circle++
         *  pointer++，pointer = pointer%n
         * -B：circle!=m continue
         * 4、当前标记含有出列标记
         * pointer++，pointer = pointer%n
         * 5、当outCount=n-1时，结束循环
         *
         */
        if (n == 0 || m <= 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        //表示出队列标记
        boolean[] outs = new boolean[n];
        //有多少一出队列
        int outCount = 0;
        //数组指针标记
        int pointer = 0;
        //循环计数标记
        int circle = 1;
        while (true) {
            if (outs[pointer] == false) {
                if (circle == m) {
                    outs[pointer] = true;
                    outCount++;
                    circle = 0;
                }
                circle++;
                pointer++;
                pointer = pointer % n;
            }
            if (outs[pointer] == true) {
                pointer++;
                pointer = pointer % n;
            }
            if (outCount == n - 1) {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (outs[i] == false) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _46_LastRemaining lastRemaining = new _46_LastRemaining();
        int i = lastRemaining.LastRemaining_Solution(5, 2);
        System.out.println(i);
    }
}
