package com.youyuan.arithmetic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 类名称：TwoSumTest <br>
 * 类描述： 两数之和算法 <br>
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/3/5 21:43<br>
 */
public class TwoSumTest {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        //暴力破解
        System.out.println(Arrays.toString(twoSum1(nums, target)));

        //优雅解题
        System.out.println(Arrays.toString(twoSum2(nums, target)));
    }

    /**
     * 方法名: twoSum1 <br>
     * 方法描述: 暴力破解方式 <br>
     *
     * @param nums   数组
     * @param target 目标值
     * @return {@link int[] 返回符合条件的数组下标集合 }
     * @date 创建时间: 2021/3/5 21:45 <br>
     * @author zhangyu
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 方法名: twoSum2 <br>
     * 方法描述: 优化解题思路 <br>
     * <p>
     * 注意到方法一的时间复杂度较高的原因是寻找 target - x 的时间复杂度过高。因此，我们需要一种更优秀的方法，能够快速寻找数组中是否存在目标元素。如果存在，我们需要找出它的索引。
     * <p>
     * 使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N)O(N) 降低到 O(1)O(1)。
     * <p>
     * 这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配
     *
     * @return {@link int[] 返回结果 }
     * @date 创建时间: 2021/3/5 22:19 <br>
     * @author zhangyu
     */
    public static int[] twoSum2(int[] nums, int target) {
        //key:值 value:数组下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int partterNum = target - nums[i];
            if (map.containsKey(partterNum)) {
                return new int[]{map.get(partterNum), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
