/*
GFG Question : Factorials of large numbers
Difficulty: Medium
Company : Adobe, Microsoft, Morgan Stanley

Given an integer N, find its factorial. return a list of integers denoting the digits that make up the factorial of N.

Example 1:

Input: N = 5
Output: [1,2,0]
Explanation : 5! = 1*2*3*4*5 = 120
Example 2:

Input: N = 10
Output: [3,6,2,8,8,0,0]
Explanation :
10! = 1*2*3*4*5*6*7*8*9*10 = 3628800

Your Task:
You don't need to read input or print anything. Complete the function factorial() that takes integer N as input parameter and returns a list of integers denoting the digits that make up the factorial of N.


Expected Time Complexity : O(N2)
Expected Auxilliary Space : O(1)


Constraints:
1 ≤ N ≤ 1000

*/


class Solution {
    static ArrayList<Integer> factorial(int N) {
        int [] arr = new int[100000];
        arr[0] = 1;
        int size = 1;

        for(int multiplier = 2; multiplier <= N; multiplier++) {
            int carry = 0;

            for(int i = 0; i < size; i++) {
                int res = multiplier * arr[i];
                res = res + carry;
                arr[i] = res % 10;
                carry = res / 10;
            }

            //Carry can be two, three digits i.e. 12, 100

            while(carry > 0) {
                arr[size] = carry % 10;
                size++;
                carry = carry / 10;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = size-1; i>=0; i--) {
            result.add(arr[i]);
        }

        return result;
    }
}
