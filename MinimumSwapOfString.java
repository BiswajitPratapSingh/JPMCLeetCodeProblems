/*1247. Minimum Swap to make String equal.

You are given two strings s1 and s2 of equal length consisting of letters "x" and "y" only.
Your task is to make these two strings equal to each other. You can swap any two characters that belong to different strings,
 which means: swap s1[i] and s2[j].

Return the minimum number of swaps required to make s1 and s2 equal, or return -1 if it is impossible to do so.



Example 1:

Input: s1 = "xx", s2 = "yy"
Output: 1
Explanation: Swap s1[0] and s2[1], s1 = "yx", s2 = "yx".
Example 2:

Input: s1 = "xy", s2 = "yx"
Output: 2
Explanation: Swap s1[0] and s2[0], s1 = "yy", s2 = "xx".
Swap s1[0] and s2[1], s1 = "xy", s2 = "xy".
Note that you cannot swap s1[0] and s1[1] to make s1 equal to "yx", cause we can only swap chars in different strings.
Example 3:

Input: s1 = "xx", s2 = "xy"
Output: -1


Constraints:

1 <= s1.length, s2.length <= 1000
s1.length == s2.length
s1, s2 only contain 'x' or 'y'.


Below documents a thought process to arrive at a linear time solution, with a constant space requirement.

Let us consider an example of s1 = "xxyyxyxyxx" and s2 = "xyyxyxxxyx".

index	0	1	2	3	4	5	6	7	8	9
letter of s1	x	x	y	y	x	y	x	y	x	x
letter of s2	x	y	y	x	y	x	x	x	y	x
An observation: we actually don't have to swap the letters. We are simply interested in the minimum number of swaps.

With that in mind, let us fo through the letters from the index 0 to 9.

At 0, we find a match. Let's move on for now.
At 1, we find a mismatch. Concretely, s1 has x and s2 has y.
How can we resolve the mismatch at the position 1? There are two strategies:

Find another mismatch where s1 has x and s2 has y. We can resolve the mismatch with one exchange.
Find another mismatch where s1 has y and s2 has x. We can resolve the mismatch with two exchanges.
Why?

An example of the first strategy is a situation: s1 = xx and s2 = yy. We swap s1[0] with s2[1] to make both strings equal to yx.
An example of the second strategy is a situation s1 = xy and s2 = yx. We swap s1[0] with s2[0], then s1[0] with s2[1] to make both strings equal to xy.
With these strategies in mind, let us count the number of two types of mismatches: (1) where s1 has x (2) s1 has y.

Then, we can try to resolve the mismatches by applying the first strategy, then the second strategy if necessary.
If, after resolving, any mismatches remain, we know that it is impossible to make the strings equal.*/

class Solution {
    public int minimumSwap(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

		// validate the input
        if (n != m) {
            return -1;
        }

        int xmis = 0;  // mismatch where s1[i] has 'x'
        int ymis = 0;  // mismatch where s1[i] has 'y'

		// count mismatches
        for (int i = n-1; i >= 0; i--) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xmis++;
            } else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                ymis++;
            }
        }

		// impossible
		// (1) there should be even numbers of those types of exchanges, in which the first strategy suffices. OR
		// (2) there should be odd numbers of those types of exchanges, in which we apply the fisrt strategy
		// then we apply the second strategy to finish things off
        if (xmis % 2 != ymis % 2) {
            return -1;
        }

        int ans = xmis / 2 + ymis / 2; // apply the first strategy
        if (xmis % 2 == 1) {
            ans += 2; // if a mismatch remains, we apply the second strategy
        }

        return ans;
    }
}
//Please note that the order of exchange is not important. Therefore we can simply count and use the counts to resolve the mismatches.

//We loop through the strings once, and the time complexity is ~O(N) where N is the length of s1 and s2. The space complexity is ~O(1).
