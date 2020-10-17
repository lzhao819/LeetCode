/**
 * 链接：https://ac.nowcoder.com/acm/contest/5650/C
 * 来源：牛客网
 *
 * 输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据有多组, 如果输入为0 0则结束输入
 * 输入
 * 1 5
 * 10 20
 * 0 0
 * 输出
 * 6
 * 30
 */
package ioPractice;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class AplusB3 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();
        while(s.hasNextLine()){
            String[] str = s.nextLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            if(a==0&&b==0){
                break;
            }else{
                result.add(a+b);
            }
        }
        for(int i: result){
            System.out.println(i);
        }
    }
}
