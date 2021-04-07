package com.leetcode.study.secondweek.map;

import java.util.*;

/**
 * 49. 字母异位词分组
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["ate","eat","tea"],["nat","tan"],["bat"]]
 * <p>
 * 说明：所有输入均为小写字母。不考虑答案输出的顺序
 */
public class GroupAnagrams {
    /**
     * 排序
     * 由于互为字母异位词的两个字符串包含的字母相同，
     * 因此对两个字符串分别进行排序之后得到的字符串一定是相同的，
     * 故可以将排序之后的字符串作为哈希表的键
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length ; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
