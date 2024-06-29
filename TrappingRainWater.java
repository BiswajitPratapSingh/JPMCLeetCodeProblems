/* 42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

Approach :

Example {4,0,6} -- min(4,6) == 4- 0(height of Current Building) == 4- We will Ignore the starting and Last Building as it will not store any water
{4,1,6} -- min(4,6)  == 4 - 1 (height of Current Building) == 3 We will Ignore the starting and Last Building as it will not store any water

so Water[i] = min(left_max_i, right_max_i) - height[i]

O(n) : Space and Time Complexity
*/

class Solution {
    public int trap(int[] height) {

        int[] leftMax = getleftMax(height);
        int[] rightMax = getRightMax(height);

        int sum = 0;
        for(int i = 0; i < height.length-1; i++) {
           int h = Math.min(leftMax[i],rightMax[i]) - height[i];
           sum += h;
        }
        return sum;
    }

    public int[] getleftMax(int[]height) {
        int[] leftMax = new int[height.length];

        leftMax[0] = height[0];

        for(int i = 1; i<height.length-1; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }

        return leftMax;

    }

    public int[] getRightMax(int[]height) {
        int[] rightMax = new int[height.length];

        rightMax[height.length-1] = height[height.length-1];

        for(int i = height.length-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }

        return rightMax;

    }
}
