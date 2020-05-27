# 
## 摘要
本项目主要记录剑指offer刷题过程，主要分为以下两个package：  
- algorithm： 记录剑指offer刷题代码与解题思路；
- think： 记录使用java过程的简单思考；

#### 当然，程序中存在许多问题和不足，希望看到的同学，提出宝贵意见，共同学习
  
## 目标

对于题目，页面会包含 题目-解题思路-代码 三个部分  
对于wiki，大部分题目会在本项目的wiki页面详细解释解题思路；

第一版  先完成题目的编写；  
第二版  增加题目wiki的编写；  
第三版  题目增加不同的思路代码；  

## 专题列表
- 1、数组专题 
    > 01、50、51
    - 使用二分查找顺序数组可加快查找速度
    - 当0~n-1个数字时，可维护长度为n的数组，用于解决问题
- 2、字符串专题 
    > 02、52、53、54
    - 可以借鉴 声明一个0-256 ascii码的数组，来表示字符进而统计
    - 对于字符串的问题 可借鉴递归思路
- 3、链表专题
    > 03、55、56
    - 链表多使用快慢指针
- 4、树专题
    > 04、57、58、59、60、61、62、63、
    - 遍历尝试递归、同时使用队列数据结构正则表达式匹配
    - 递归函数参数中常添加，array,start,end 等变量，用于递归的方便性
- 5、栈和队列
    > 05、64
    - 滑动窗口可以使用双端队列的思路
- 6、查找和排序
   > 06
   - 此专题可以展开，查看 com.github.dagugit.think._2020_06_01_Sort.java
        - 排序
            - 交换排序：快速排序、 冒泡排序
            - 插入排序：简单插入排序、希尔排序
            - 选择排序：简单选择排序、堆排序
            - 归并选择：二路归并
      - 查找，查看 com.github.dagugit.think._2020_06_02_Search.java 
        - 顺序查找
        - 二分查找
        - 差值查找
        - 斐波那契查找
        - 二叉树查找：搜索二叉树、平衡二叉树、红黑树、B+树
        - 分块查找
        - 哈希查找
      
- 7、递归或循环
    > 07、08、09、10
    - 此类问题一般 使用数学归纳法，找到 fn 与 fn-1 的关系
    - 添加 此专题与动态规划关系（待）
- 8、位运算
    > 11
    - Integer提供了简单的API将int转换成位字符串
- 9、代码的完整性
    > 12、13
    - 添加参数非空、特殊校验，参数种类判断
- 10、代码的鲁棒性
    > 14、15、16、17
    - 参数校验、首先考虑程序的特殊情况
- 11、面试思路
    > 18 
- 12、画图让抽象形象化
    >19
- 13、画图让抽象具体化
    >20、21、22、23、24
    - 对于树找到和为target的路径，这样的题目可以考虑使用递归，参数中传递list，保存使用 new(list)
    - 递归考虑边界条件，递归树的左子树、右子树
- 14、分解让复杂问题简单
    >25、26、27
    - 此专题暂无好思路，待整理
- 15、时间效率
    >28、29、30、31、32
    - 此专题暂无好思路，待整理
- 16、时间空间效率平衡
    >33、34、35、36
    - 考虑问题顺向、逆向同时进行，例如丑数，在考虑n能够被模除比较复杂后，可以考虑方程思想组成n
    - 暴力 O(n2)->快速排序 nLog(n)||归并排序||二分查找->添加空间Map O(1)
- 17、知识迁移能力
    >37、38、39、40、41、42、43、44
    - 排序数组，固定和，使用双指针这种思路想不到
- 18、抽象建模能力
    > 45、46
- 19、发散思维能力
    >47、48
    - 48题充分体现了使用信号的思想实现加法，很巧妙 
- 20、综合
    >49
- 21、回溯法
    >65、66
    - 回溯法不是很明白，待分析
- 22、动态规划与贪婪
    >67
    - 动态规划没掌握

## 题目列表
1. 二维数组中的查找
2. 替换空格
3. 从尾到头打印链表
4. 重建二叉树
5. 用两个栈实现队列
6. 旋转数组的最小数字
7. 斐波那契数列
8. 跳台阶
9. 变态跳台阶
10. 矩形覆盖
11. 二进制中1的个数
12. 数值的整数次方
13. 调整数组顺序使奇数位于偶数前面
14. 链表中倒数第k个结点
15. 反转链表
16. 合并两个排序的链表
17. *树的子结构
18. 二叉树的镜像
19. 顺时针打印矩阵
20. 包含min函数的栈
21. *栈的压入、弹出序列
22. 从上往下打印二叉树
23. *二叉搜索树的后序遍历序列
24. *二叉树中和为某一值的路径
25. *复杂链表的复制
26. *二叉搜索树与双向链表
27. 字符串的排列
28. 数组中出现次数超过一半的数字
29. *最小的K个数
30. *连续子数组的最大和
31. 整数中1出现的次数（从1到n整数中1出现的次数）
32. *把数组排成最小的数
33. *丑数
34. 第一个只出现一次的字符位置
35. *数组中的逆序对
36. 两个链表的第一个公共结点
37. 数字在排序数组中出现的次数
38. 二叉树的深度
39. 平衡二叉树
40. 数组中只出现一次的数字
41. *和为S的连续正数序列
42. *和为S的两个数字
43. 左旋转字符串
44. 翻转单词顺序列
45. 扑克牌顺子
46. 孩子们的游戏(圆圈中最后剩下的数)
47. 求1+2+3+...+n
48. 不用加减乘除做加法
49. 把字符串转换成整数
50. 数组中重复的数字
51. 构建乘积数组
52. *正则表达式匹配
53. 表示数值的字符串
54. 字符流中第一个不重复的字符
55. *链表中环的入口结点
56. 删除链表中重复的结点
57. 二叉树的下一个结点
58. 对称的二叉树
59. 按之字形顺序打印二叉树
60. 把二叉树打印成多行
61. *序列化二叉树
62. 二叉搜索树的第k个结点
63. *数据流中的中位数
64. *滑动窗口的最大值
65. *矩阵中的路径
66. *机器人的运动范围
67. *剪绳子
