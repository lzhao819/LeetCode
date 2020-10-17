/**
 * https://ac.nowcoder.com/acm/contest/5650/D
 */
package ioPractice;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class AplusB4 {
    public static void main(String[] args){
        List<Integer> result = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()){
            String[] str = s.nextLine().split(" ");
            int sum=0;
            if(str[0]=="0"){
                break;
            }else{
                for(String num:str){
                    sum +=Integer.parseInt(num);
                }
                sum-=Integer.parseInt(str[0]);
                result.add(sum);
            }
        }
        for(int num:result){
            System.out.println(num);
        }
    }
}
