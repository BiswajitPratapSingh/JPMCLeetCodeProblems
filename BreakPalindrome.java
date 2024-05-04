/* 1328 Break a Palindrome
Given a palindromic string of lowercase English letters palindrome,
 replace exactly one character with any lowercase English letter so that the resulting string is not a palindrome and
 that it is the lexicographically smallest one possible.

Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.

A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ,
a has a character strictly smaller than the corresponding character in b.
 For example, "abcc" is lexicographically smaller than "abcd" because the first position they differ is at the fourth character,
  and 'c' is smaller than 'd'.



Example 1:

Input: palindrome = "abccba"
Output: "aaccba"
Explanation: There are many ways to make "abccba" not a palindrome, such as "zbccba", "aaccba", and "abacba".
Of all the ways, "aaccba" is the lexicographically smallest.
Example 2:

Input: palindrome = "a"
Output: ""
Explanation: There is no way to replace a single character to make "a" not a palindrome, so return an empty string.


Constraints:

1 <= palindrome.length <= 1000
palindrome consists of only lowercase English letters.


Approach :

Total 3 case we have :

Case 1: if String Size is 1 or less than one then we cannot break the String, Return ""

Case 2: If String Contains any Non-'a' characters,
find it and replace it with 'a' to break the Plaindrome and make it Lexicographical smaller.

Case 3 : If String Contains only 'a' characters like "aaaaaaaa"
then replace last character with 'b' to break palindrome and make it Lexicographical smaller.
*/


class Solution {
    public String breakPalindrome(String palindrome) {
        int start = 0;
        int end = palindrome.length() - 1;

        char[] c = palindrome.toCharArray();

        // First we will check if String Size is 1 or less than 1, then return ""
        if(palindrome.length() <= 1) {
            return "";
        }

        int count = 0;
        //Case 1 : For String Which are not like 'aaaaaaaa' ,
        //Find out the Character which is Non-'a' Character and Replace with 'a'
        while(start < end) {
            if(c[start] != 'a' && c[end] != 'a') {
                c[start] = 'a';
                count ++;
                return new String(c);
            } else {
                start++;
                end--;
            }
        }
        //If Counter Increased its Value form 0 to any other value then the String is not 'aaaaaaaaa'
        if(count == 0) {
            c[palindrome.length() - 1] = 'b';
        }
        return new String(c);

    }
}
