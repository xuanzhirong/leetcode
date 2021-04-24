package com.leetcode.study.week4;

/**
 * 860. 柠檬水找零
 */
public class LemonadeChange {
    /**
     * 顾客只能有3种纸币，5元，10元，20元。我们要统计5元和10元的数量，20元的不需要统计，因为20元没法找零。
     * 1，顾客给5元，5元的数量加1
     * 2，顾客给10元，5元的数量减1（减完之后再判断5元的数量，如果小于0，说明5元的不够了，没法给顾客找零了，直接返回false）
     * 3，顾客给20元，根据生活常识，如果有10元的，应该先找他10元的，然后再找他一个5元的。如果没有10元的就找他3个5元的，然后再判断5元的数量，如果小于0直接返回false。
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0; // 5元的数量
        int ten = 0; // 10元的数量
        for (int bill : bills) {
            if (bill == 5) { // 顾客给5元，5元的数量加1
                five++;
            } else if (bill == 10) { // 顾客给10元，5元的数量减1
                five--;
                ten++;
            } else if (ten > 0) { //顾客给20元，如果有10元的，应该先找他10元的，然后再找他一个5元的
                ten--;
                five--;
            } else { //顾客给20元，没有10元的，找他3个5元的
                five -= 3;
            }
            if (five < 0) { // 5元数量少于0，无法找零
                return false;
            }
        }
        return true;
    }
}
