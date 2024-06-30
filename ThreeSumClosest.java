/* 16. 3Sum Closest
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).


Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104

Approach :

When Index is not asked we will sort the Arrays

Arr = [-1,2,1,-4]

       0  1  2 3
   = [-4,-1,1,2] : Target = 1
       k  i   j

   Fixing k index element i.e, -4

   i = 1 and j = 3, So -4 + (-1) + 2 = -3

   i= 2 and j =3 So -4 + 1 + 2 = -1

   now we cannot move i and j, now we will shift k to 1 and i to 2 and j to 3

   so -1+1+2 = 2

   Math.abs(target - sum ) = (1-(-3)) = 4
                             (1-(-1)) = 2
                             (1-2) = 1 So Output is 2


*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        //Sort
        Arrays.sort(nums);

        //Initially Define the Closet Sum to Some Big Integer value
        int closetSum = 1000000;

        //Fixing first value
        for(int k = 0; k <= nums.length-3; k++) {

            int i = k+1;
            int j = nums.length-1;

            //Apply Two Pointer
            while(i<j) {
                int sum = nums[k] + nums[i] + nums[j];

                if(Math.abs(target-sum) < Math.abs(target-closetSum)) {
                    closetSum = sum;
                }

                if(sum < target)
                    i++;
                else
                   j--;
            }
        }
        return closetSum;
    }
}
