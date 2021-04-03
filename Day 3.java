/*
Longest Valid Parentheses
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
*/
class Solution {
    public int longestValidParentheses(String s) {
        char ch[] = s.toCharArray();
        int len = ch.length;
         if(len == 0)
            return 0;
        Stack <Integer> stack = new Stack<>();
        stack.push(-1);
        int count = 0;       
       
        
        for(int i = 0; i < len; i++){
            char elem = ch[i];
            if(elem == '(')
                stack.push(i);
            else {
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                else count = Math.max(count, i - stack.peek());

                }
        }                   
        return count;
    }
}
