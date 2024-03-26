package _17_出栈合法性;

import java.util.Scanner;
import java.util.Stack;

// 多组测试数据，每组测试数据的第⼀⾏为整数N（1<=N<=100），当N=0时，输⼊结束，第⼆⾏为N个正整数，以空格隔开，输出结果为字符串
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            if (n == 0) return;
            String[] s = sc.nextLine().split(" ");
            int index = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 1; i <= n; i++) {
                stack.push(i);

                while (!stack.isEmpty() && stack.peek() == Integer.parseInt(s[index])) {
                    stack.pop();
                    index++;
                }
            }
            if (stack.isEmpty()) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
