package _14_句子缩写;

import java.util.Scanner;

// 第⼀⾏是⼀个整数n，表示⼀共有n组测试数据, 之后输⼊n⾏字符串
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); // 这里注意要读整行, 不然会影响下面的读整行
        while (n-- > 0) {
            String str = sc.nextLine().trim();
            String[] s = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String s1 : s) {
                if (!s1.equals("")) sb.append(s1.charAt(0));
            }
            System.out.println(sb.toString().toUpperCase());
        }
    }
}