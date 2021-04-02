package com.leetcode.study.firstweek.stack;

import java.util.*;

/**
 * 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * <p>
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 */
public class ValidChar {
    // {}()[]}
    // 遇到 {([ 则入栈对应的 })]
    // 遇到 })] 则出栈pop()，比较是否相等
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
