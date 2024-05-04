/*20. Valid Paranthese
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.


Intuition
The problem requires us to determine if the given string of brackets is valid or not.
 We can use a stack data structure to keep track of opening brackets encountered and check if they match with the corresponding closing brackets.

Approach
Here is the step-by-step approach of the algorithm:

Initialize an empty stack.

Traverse the input string character by character.

If the current character is an opening bracket (i.e., '(', '{', '['), push it onto the stack.

If the current character is a closing bracket (i.e., ')', '}', ']'), check if the stack is empty.
If it is empty, return false, because the closing bracket does not have a corresponding opening bracket.
Otherwise, pop the top element from the stack and check if it matches the current closing bracket.
If it does not match, return false, because the brackets are not valid.

After traversing the entire input string, if the stack is empty, return true,
because all opening brackets have been matched with their corresponding closing brackets.
Otherwise, return false, because some opening brackets have not been matched with their corresponding closing brackets.

Complexity
Time complexity:
The time complexity of the solution is O(n)O(n)O(n), where n is the length of the input string.
This is because we traverse the string once and perform constant time operations for each character.

Space complexity:
The space complexity of the solution is O(n)O(n)O(n), where n is the length of the input string.
This is because the worst-case scenario is when all opening brackets are present in the string and the stack will have to store them all.
*/

Class Solution {
  public boolean isValid(String s) {
    //Create a Empty Stack to keep track of opening bracket
    Stack<Character> stack = new Stack<Character>();

    //loop through Every Character of string
    for(char c : s.tocharArray()) {
      //if the Character is an opening Bracket, then Push into stack
      if(c=='(' || c == '[' || c == '{') {
        stack.push(c);
      } else {
        //if the character is a closing bracket

        //if Stack is Empty, then there is no matching opening Bracket, so return false
        if(stack.isEmpty()) {
          return false;
        }

        //otherwise, get the top of the Stack and Check if it is matching opening bracket

        char top = stack.peek();
        if((c == ')' && top == '(') || (c ==']' && top == '[') || (c == '}' && top == '{')) {
          //if it is, pop the opening bracket from the stack

          stack.pop();
        } eles {
          // otherwise bracket didn't matched, so return false
          return false;
        }
      }
    }
    //if Stack is Empty, All the Opening Bracket has its Closing Brackets so Return true
    // Otherwise, there are unmatched opening Brackets, so Retrun false
    return stack.isEmpty()
  }
}
