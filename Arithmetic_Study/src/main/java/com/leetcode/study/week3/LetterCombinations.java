package com.leetcode.study.week3;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，数字到字母的映射与电话按键相同。注意 1 不对应任何字母。
 * 返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 示例 1：
 * 输入：digits = "23"  输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 示例 2：
 * 输入：digits = "" 输出：[]
 * <p>
 * 示例 3：
 * 输入：digits = "2"  输出：["a","b","c"]
 */
public class LetterCombinations {
    private static Map<Character, List> map = new HashMap<>();

    {
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        letterCombinations(digits, 0, "", res);
        return res;
    }

    private void letterCombinations(String digits, int index, String sub, List<String> res) {
        if (index >= digits.length()) {
            res.add(sub);
            return;
        }
        char c = digits.charAt(index);
        List<String> list = map.get(c);
        for (String s : list) {
            letterCombinations(digits, index + 1, sub + s, res);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
    }
}
