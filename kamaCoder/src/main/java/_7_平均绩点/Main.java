package _7_平均绩点;

import java.util.Scanner;

// 多组测试样例，每组输⼊数据为字符串，字符⽤空格分隔,输出为⼩数点后两位
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] s = str.split(" ");
            int sum = 0;
            boolean flag = true;
            for (String s1 : s) {
                switch (s1) {
                    case "A":
                        sum += 4;
                        continue;
                    case "B":
                        sum += 3;
                        continue;
                    case "C":
                        sum += 2;
                        continue;
                    case "D":
                        sum += 1;
                        continue;
                    case "F":
                        continue;
                    default:
                        flag = false;   // 不存在五个等级中停止循环
                        break;
                }
            }
            if (!flag) System.out.println("Unknown");
            else System.out.printf("%.2f\n", 1.0 * sum / s.length);
        }
    }
}
