package _15_神秘字符;

import java.util.Scanner;

// 第⼀⾏是⼀个整数n，然后是n组数据，每组数据2⾏，每⾏为⼀个字符串，为每组数据输出⼀个字符串，每组输出占⼀⾏
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 读光标标记到token后面, 但是后面的空白内容会被nextLine读到, 但next不会读到(next读的也是一个token)
        while (n-- > 0) {
            String a = sc.next();
            String b = sc.next();
            a = a.substring(0, a.length() / 2) + b + a.substring(a.length() / 2);
            System.out.println(a);
        }
    }
}
