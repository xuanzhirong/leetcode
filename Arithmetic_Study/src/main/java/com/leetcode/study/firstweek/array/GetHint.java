package com.leetcode.study.firstweek.array;

/**
 * 299. 猜数字游戏
 * <p>
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 * 你写出一个秘密数字，并请朋友猜这个数字是多少。
 * 朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），
 * 有多少位属于数字猜对了但是位置不对（称为“Cows”, 奶牛）。
 * 朋友根据提示继续猜，直到猜出秘密数字。
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用 B 表示奶牛。
 * xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
 * yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。
 * <p>
 * 示例 1:
 * 输入: secret = "1807", guess = "7810"
 * 输出: "1A3B"
 * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 */
public class GetHint {
    public String getHint(String secret, String guess) {
        int[] secretArray = new int[10];
        int[] guessArray = new int[10];
        // 公牛
        int A = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                secretArray[secret.charAt(i) - '0']++;
                guessArray[guess.charAt(i) - '0']++;
            }

        }
        // 奶牛
        int B = 0;
        for (int i = 0; i < 10; i++) {
            // 不同位上的相同数字的数量
            B += Math.min(secretArray[i], guessArray[i]);
        }
        StringBuilder sb = new StringBuilder();
        return sb.append(A).append("A").append(B).append("B").toString();
    }

    public String getHint2(String secret, String guess) {
        int[] array = new int[10];
        int A = 0;
        int B = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                // 判断 guess 在 i 之前是否有该数字
                if (array[secret.charAt(i) - '0']++ < 0) {
                    B++;
                }
                // 判断 secret 在 i 之前是否有该数字
                if (array[guess.charAt(i) - '0']-- > 0) {
                    B++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        return sb.append(A).append("A").append(B).append("B").toString();
    }
}
