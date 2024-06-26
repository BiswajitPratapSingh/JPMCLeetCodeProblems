/*
  Two Sum Problem
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

Time Complexity : O(n)
Space Complexity : O(n)

1st Approach : Brute Force Approach :

arr {2,7,11,15}

target : 9

i at 0 index and j at i+1 indexe
if(nums[j]+nums[i] == target)

  then return the Indexes in array


2nd Approach : using Map
define Map<value, index>
target-num[i] = remaining is available in map
  if Yes then Return the {map[remaining], i}

otherwise add the value and index to the map

*/


class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        int[] result;
        for(int i = 0; i < nums.length ; i++) {
            int remaining = target - nums[i];

            if(m.containsKey(remaining)) {
               result = new int[]{m.get(remaining),i};
                return result;
            }

            m.put(nums[i],i);
        }
        result = new int[2];
        return result;
    }
}
