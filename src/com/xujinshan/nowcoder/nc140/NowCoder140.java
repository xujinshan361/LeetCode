package com.xujinshan.nowcoder.nc140;



import java.util.Arrays;

/**
 * @Author: xujinshan361@163.com
 * NowCoder140 -- 排序
 */

/**
 * 冒泡排序，时间复杂度过高，牛客网不能通过
 * 思想：
 * 首先拿第一个元素和后面的所有一个个的比较，如果后面的大就交换，所以始终保证第一个
 * 元素是最小的，然后再第二第三，以此类推。
 */
class Solution01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort(int[] arr) {
        // write code here
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}

/**
 * 直接调用Arrays.sort() 函数直接通过牛客网测试
 */
class Solution02 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }
}

/**
 * 选择排序：无法通过牛客网测试，时间复杂度过高
 * 选择排序与冒泡排序有一点像，选择排序是默认前面都是已经排好序的，然后从后面选择
 * 最小的放在前面拍好的后面，首先第一轮循环的时候默认的排序好的为空，然后从后选择
 * 最小的放在数组的第一个位置，然后从剩下的找出最小的放到数组的第二个位置，第三轮
 * 的时候默认前面俩个已经拍好序了，然后一直进行下去。
 */
class Solution03 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort(int[] arr) {
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }

        }
        return arr;
    }
}


/**
 * 插入排序：通过牛客测试，效率贼低
 */
class Solution04 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort(int[] arr) {
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {

            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }

        }
        return arr;
    }
}

public class NowCoder140 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution04().MySort(new int[]{5, 2, 3, 1, 4})));
    }
}
