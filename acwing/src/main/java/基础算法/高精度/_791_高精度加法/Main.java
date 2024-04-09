package 基础算法.高精度._791_高精度加法;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author gallantsa
 * @date 2024年04月09日 14:48
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        List<Integer> arrA = new ArrayList<>();
        List<Integer> arrB = new ArrayList<>();

        for (int i = 0; i < a.length(); i++) {
            arrA.add(a.charAt(a.length() - i - 1) - '0');
        }
        for (int i = 0; i < b.length(); i++) {
            arrB.add(b.charAt(b.length() - i - 1) - '0');
        }

        List<Integer> arrC = add(arrA, arrB);
        for (int i = arrC.size() - 1; i >= 0; i--) {
            System.out.print(arrC.get(i));
        }
    }

    private static List<Integer> add(List<Integer> arrA, List<Integer> arrB) {

        List<Integer> arrC = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < arrA.size() || i < arrB.size(); i++) {
            if (i < arrA.size()) t += arrA.get(i);
            if (i < arrB.size()) t += arrB.get(i);
            arrC.add(t % 10);
            t /= 10;
        }

        if (t != 0) arrC.add(t);
        return arrC;
    }
}
