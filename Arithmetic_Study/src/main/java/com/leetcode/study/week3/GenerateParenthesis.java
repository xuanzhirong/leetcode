package com.leetcode.study.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recur(0, 0, n, "", res);
        return res;
    }

    private void recur(int left, int right, int n, String s, List<String> res) {
        // terminator
        if (left == n && right == n) { // 已有n个"(" 和 n个")"
            res.add(s);
            return;
        }
        //drill down
        if (left < n) { // 对于n个括号，就有n个"("
            recur(left + 1, right, n, s + "(", res);
        }
        if (right < left) { // ")"的个数等于"("
            recur(left, right + 1, n, s + ")", res);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
