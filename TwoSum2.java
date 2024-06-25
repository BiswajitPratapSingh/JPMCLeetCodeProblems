
/* Two Pointer Algorithm

167. Two Sum II - Input Array Is Sorted
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.



Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].


Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.


Approach : Two Pointer Algorithm

[2,7,11,15], target = 9

  i= 0 and j = arr.length-1

  num[i]+num[j] : 2+15 = 17 >9, So j--

  2+11 = 13 > 9, So j--
  2+7 = 9 ==9 return {i+1, j+1}

  [1,2,4,6,8,9], target = 12
  i= 0 and j = arr.length-1

  num[i] + num[j] :
  1+9 = 10 < 12 , so i++ since we know array is sorted in non-decreasing order
  2+9 = 11 < 12, so i++
  4+9 = 13 > 12 , so j++
  4+8 = 12 == 12 , return {i+1, j+1} i.e., {3,5}


*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;

        while(i<j){
            int sum = numbers[i] + numbers[j];
            if(sum > target) {
                j--;
            } else if(sum < target) {
                i++;
            } else {
                return new int[]{i+1,j+1};
        }
    }

    return new int[2];
    }
}
