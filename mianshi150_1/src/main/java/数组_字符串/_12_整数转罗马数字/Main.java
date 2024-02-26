package 数组_字符串._12_整数转罗马数字;

public class Main {
}

// 关键在于找出罗马数字的所有原子组合
class Solution {
    int[] val = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] str = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < val.length && num > 0; i++) {
            int cv = val[i];
            String cs = str[i];
            while (num >= cv) {
                sb.append(cs);
                num -= cv;
            }
        }
        return sb.toString();
    }
}
