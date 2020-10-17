/**
 * https://ac.nowcoder.com/acm/contest/5650/A
 * 输入
*         1 5
*         10 20
 * 输出
*         6
*         30
 */

package ioPractice;

import java.util.*;
import java.io.*;
public class AplusB1{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> result= new ArrayList<>();
        String str = null;
        while((str=br.readLine())!=null){
            String[] strs = str.split(" ");
            int sum =0;
            for(String s: strs){
                sum+= Integer.parseInt(s);
            }
            result.add(sum);
        }
        for(int s:result){
            System.out.println(s);
        }
    }
}