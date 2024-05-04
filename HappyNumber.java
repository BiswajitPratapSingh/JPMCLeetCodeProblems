/* 202. Happy number
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.



Example 1:

Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
Example 2:

Input: n = 2
Output: false


Constraints:

1 <= n <= 231 - 1

Solution : FLoyd's Tortoise and Hare method will be used as there is something to do with the cycle

number - 12

1^2 + 2^2 = 1+4 = 5
5^2 = 25
2^2 + 5^2 = 4+25 = 29
2^2 + 9^2 = 4+81 = 85
8^2 + 5^2 = 64 + 25 = 89
8^2 + 9^2 = 64 + 81 = 145
1^2 + 4^2 + 5^2 = 1 + 16 + 25 = 42
4^2 + 2^2 = 16 + 4 = 20
2^2 + 0 ^2 = 4
4^2 = 16
1^2 + 6^2 = 1 + 36 = 37
3^2 + 7^2 = 9 + 49 = 58
5^2 + 8^2 = 25 + 64 = 89
8^2 + 9^2 = 64 +81  = 145 ---- Again it Came to Step 41 and same pattern will follow ---> Followed a Cycle in a Linked List

So, if a Cycle Detected, it is not a Happy number
else
Slow Pointer will point to value of 1

Time Complexity : O(n) ---as One Iteration
Space Complexity : O(1)

*/

class Solution {
    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;
        //While loop is not used as intially slow and fast pointer will be Equal, So loop won't run.
        do{
            //Slow moving one step ahead and Fast Moving two step ahead
            slow = square(slow);
            fast = square(square(fast));
        }while(slow != fast);

        //if a cycle Exist, then the number is not happy
        // slow will have a value other than 1

        return slow == 1;
    }

    // Finding the Square of the Digits of a number
    public int square(int num) {
        int ans = 0;
         while (num > 0) {
            int remainder = num % 10 ;
            ans+= remainder * remainder;
            num /= 10;
         }

         return ans;
    }
}
