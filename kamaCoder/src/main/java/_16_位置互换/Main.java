package _16_位置互换;

import java.util.Scanner;

// 多组测试数据，第⼀⾏是⼀个整数n，接下来是n组字符串，输出字符串
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            String s = sc.next();
            char[] chars = s.toCharArray();
            for (int i = 0, j = 1; i < chars.length && j < chars.length; i += 2, j += 2) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            System.out.println(new String(chars));
        }
    }
}
