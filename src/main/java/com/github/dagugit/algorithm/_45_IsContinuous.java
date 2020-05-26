package com.github.dagugit.algorithm;

import java.util.Arrays;

/**
 * 扑克牌顺子
 * <p>
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大小 王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */
public class _45_IsContinuous {
    /**
     * 思路:
     * 1、特殊情况
     * -A:numbers==null||numbers.length!=5 return false
     * 2、含有大小王
     * -A、含有4个大小王，return true；
     * -B、含有3个大小王，有且剩余两个差值不能大于4
     * -C、含有2个大小王，连续差值最多有一个等于3或最多含有两个差值等2
     * -D、含有1个大小王，连续差值最多有一个等于2
     * 3、不含有大小王
     * -A、直接排序，每个数值+1判断
     *
     * @param numbers
     * @return
     */
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }

        int numWithZero = this.numWithZero(numbers);
        //不含有大小王
        if (numWithZero == 0) {
            Arrays.sort(numbers);
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i + 1] - numbers[i] != 1) {
                    return false;
                }
            }
            return true;
        }
        if (numWithZero == 1) {
            Arrays.sort(numbers);
            //除0外，其他只有一个差值等于2
            //差值等于0个数
            int countAbs1 = 0;
            //差值等于2个数
            int countAbs2 = 0;

            for (int i = 1; i < numbers.length - 1; i++) {
                if (numbers[i + 1] - numbers[i] == 1) {
                    countAbs1++;
                }
                if (numbers[i + 1] - numbers[i] == 2) {
                    countAbs2++;
                }
            }
            if (countAbs1 == 4) {
                return true;
            }
            if (countAbs1 == 2 && countAbs2 == 1) {
                return true;
            }
            return false;
        }
        if (numWithZero == 2) {
            Arrays.sort(numbers);

            //差值等于0个数
            int countAbs1 = 0;
            //差值等于3个数
            int countAbs2 = 0;
            int countAbs3 = 0;

            for (int i = 2; i < numbers.length - 1; i++) {
                if (numbers[i + 1] - numbers[i] == 1) {
                    countAbs1++;
                }
                if (numbers[i + 1] - numbers[i] == 3) {
                    countAbs3++;
                }
                if (numbers[i + 1] - numbers[i] == 2) {
                    countAbs2++;
                }
            }
            //差值全为1
            if (countAbs1 == 2) {
                return true;
            }
            //差值为2,1
            if (countAbs2 == 1 && countAbs1 == 1) {
                return true;
            }
            //差值为2,2
            if (countAbs2 == 2) {
                return true;
            }
            //除0外，其他只有一个差值等于2
            if (countAbs1 == 1 && countAbs3 == 1) {
                return true;
            }
            return false;
        }
        if (numWithZero == 3) {
            Arrays.sort(numbers);
            if (Math.abs(numbers[3] - numbers[4]) > 0 && Math.abs(numbers[3] - numbers[4]) <= 4) {
                return true;
            }
            return false;
        }
        if (numWithZero == 4) {
            return true;
        }
        return false;
    }

    private int numWithZero(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 借鉴网上的思路
     * 与以上思路大致相同，但思路更加简洁
     *
     * @param numbers
     * @return
     */
    public boolean isContinuous2(int[] numbers) {
        if (numbers == null) {
            return false;
        }
        //先排序
        Arrays.sort(numbers);
        int zero = 0, i = 0;
        //统计0的个数
        for (; i < numbers.length && numbers[i] == 0; i++) {
            zero++;
        }
        //有对子，则返回false
        for (; i < numbers.length - 1 && zero >= 0; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            //可以继续匹配
            if (numbers[i] + 1 + zero >= numbers[i + 1]) {
                zero -= numbers[i + 1] - numbers[i] - 1;
            } else {
                return false;
            }
        }
        if (i == numbers.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        _45_IsContinuous isContinuous = new _45_IsContinuous();
        int[] array = {1, 0, 0, 1, 0};
        boolean continuous = isContinuous.isContinuous(array);
        System.out.println(continuous);
    }
}
