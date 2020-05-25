package com.github.dagugit.algorithm;

/**
 * 数字在排序数组中出现的次数
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 */
public class _37_GetNumberOfK {
    /**
     * 思路1：
     * 忽略题目中排序数组，直接使用map统计
     * 1、特殊情况
     * -A：array==null return 0;
     * -B: array.length==0 return 0;
     * 2、声明 map 统计数组中每个数字出现的次数
     * 3、输出当前 k 在数组中出现的次数
     * <p>
     * 思路2：
     * 充分利用题目的已知条件：排序数组，可以使用二分查找找到 k 出现的第一个位置和最后一个位置
     * 1。特殊情况，array==null||array.length==0 return 0;
     * 2、在array中找K的起始节点 firstK
     * -A: 声明 middleIndex = (start+end)/2 , middleData= arrays[middleIndex]
     * -B: 如果 middleData==k，
     * --B1：如果(middleIndex>0&& arrays[middleIndex-1]!=k ) || middleIndex ==0 return middleIndex
     * --B2: 其他情况，另end = middleIndex-1，继续递归
     * -C：如果middleData>k, end = middleIndex-1,继续递归
     * -D：如果middleData<k ，start = middleIndex+1；
     * -E：继续递归
     * 3、按照第1步的方式继续寻找K的结束节点，lastK
     * 4、使用lastK-firstK+1
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] array, int k) {
        int number = 0;
        int len = array.length;
        if(array != null && len > 0){
            int firstK = getFirstK(array, k, 0, len-1);
            int lastK = getLastK(array, k, 0, len-1);
            if(firstK > -1 && lastK > -1){
                number = lastK - firstK + 1;
            }
        }
        return number;
    }
    //获取第一个K出现的位置
    private int getFirstK(int[] nums,int k,int start,int end){
        if(start > end){
            return -1;
        }
        int middleIndex = (start+end)/2;
        int middleData = nums[middleIndex];
        if(middleData==k){
            if((middleIndex>0&&nums[middleIndex-1]!=k)||middleIndex==0){
                return middleIndex;
            }else{
                end = middleIndex-1;
            }
        }else if(middleData>k){
            end = middleIndex-1;
        }else if(middleData<k){
            start = middleIndex+1;
        }

        return getFirstK(nums,k,start,end);
    }
    //获取最后一个K出现的位置
    private int getLastK(int[] nums,int k,int start,int end){
        if(start > end){
            return -1;
        }
        int middleIndex = (start+end)/2;
        int middleData = nums[middleIndex];
        if(middleData==k){
            if((middleIndex<nums.length-1&&nums[middleIndex+1]!=k)||middleIndex==nums.length-1){
                return middleIndex;
            }else{
                start = middleIndex+1;
            }
        }else if(middleData>k){
            end = middleIndex-1;
        }else if(middleData<k){
            start = middleIndex+1;
        }

        return getLastK(nums,k,start,end);
    }

    public static void main(String[] args) {
        int[] arrays={1,2,3,3,4,4,4,5};
        _37_GetNumberOfK getNumberOfK = new _37_GetNumberOfK();
        int i = getNumberOfK.GetNumberOfK(arrays, 4);
        System.out.println(i);
    }
}
