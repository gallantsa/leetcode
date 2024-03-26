package _11_共同祖先;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 多组测试数据，⾸先输⼊⼀个整数N，接下来N⾏每⾏输⼊两个整数a和b, 读取输⼊数据到Map
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            while (n-- > 0) {
                Integer c = sc.nextInt();
                Integer p = sc.nextInt();
                map.put(c, p);
            }
            Integer c1 = 1;
            Integer c2 = 2;
            while (true) {
                Integer p1 = map.get(c1);
                Integer p2 = map.get(c2);
                if (p1 == p2) {
                    System.out.println("You are my brother");
                    break;
                } else if (p2 == map.get(p1)) {
                    System.out.println("You are my elder");
                    break;
                } else if (p1 == map.get(p2)) {
                    System.out.println("You are my younger");
                    break;
                } else {
                    c1 = p1;
                    c2 = p2;
                }
            }
        }
    }
}
