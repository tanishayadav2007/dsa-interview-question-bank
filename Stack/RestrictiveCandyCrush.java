// Problem: Restrictive Candy Crush
// Difficulty: Medium
// Company: Amazon, Microsoft

// Problem Statement:
// Given a string s and an integer k,
// remove groups of k consecutive identical characters.
// Repeat this process until no more removals are possible.
// Return the final reduced string.

// Approach: Stack of String Groups
//
// Idea:
// - Use a stack to store groups of same characters
// - If current character matches top group → extend the group
// - If group size becomes k → remove it
// - Otherwise push updated group back
//
// Steps:
// 1. Traverse each character of string
// 2. If stack is not empty and same character:
//      - Pop top group
//      - Add current character
//      - If length != k → push back
// 3. Else push new group
// 4. Build final string from stack

// Time Complexity: O(n)
// Space Complexity: O(n)

// Example:
// Input:  s = "geegsforgeeks", k = 2
// Output: "gksforgks"
// Explanation:
// "geegsforgeeks" → remove "ee" → "ggsforgeks"
// → remove "gg" → "sforgeks"


import java.util.*;
public class RestrictiveCandyCrush {
    public static String reduced_String(int k,String s){
        Stack<String> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(!stack.isEmpty() && stack.peek().charAt(0)==c){
                String top=stack.pop();
                top=top+c;
                if(top.length()!=k){
                    stack.push(top);
                }
            }else{
                stack.push(""+c);
            }
        }
        StringBuilder result=new StringBuilder();
        for(String str:stack){
            result.append(str);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String s="geegsforgeeks";
        System.out.println(reduced_String(2, s));
    }
}
