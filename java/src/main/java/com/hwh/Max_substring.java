package com.hwh;

/**
 * Created by huangwanhong on 2017/3/10.
 *
 * 找出字符串的最长不重复子串，输出长度和子串
 方法一：穷举法，空间复杂度是O(1)，时间复杂度是O(N^4)
 */

public class Max_substring {
    public int max_unique_substring(char[] str) {
        int maxlen = 0;
        int begin = 0;
        int n = str.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int flag = 0;
                //判断子串是否有重复字符
                for (int m = i; m < j; ++m) {
                    for (int k = m + 1; k < j; ++k) {
                        if (str[m] == str[k]) {
                            flag = 1;
                            break;
                        }
                    }
                    if (1 == flag) break;
                }
                if (0 == flag && j - i + 1 > maxlen) {
                    maxlen = j - i + 1;
                    begin = i;
                }
            }

        }
        StringBuffer s = new StringBuffer();
        for (int g = 0; g < n; ++g) {
            s.append(str[g]);
        }
        System.out.println(s.toString().substring(begin, begin + maxlen) + "," + maxlen + "," + begin + "," + (begin + maxlen));
        return maxlen;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Max_substring max = new Max_substring();
        char[] s = {'a', 'x', 'b', 'd', 'e', 'b', 'p', 'q', 'a', 'w', 'u', 'v', 'a'};
        max.max_unique_substring(s);
    }
}
