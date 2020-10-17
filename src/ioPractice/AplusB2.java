/**
 * https://ac.nowcoder.com/acm/contest/5650/B
 * 输入
 * 2
 * 1 5
 * 10 20
 * 输出
 * 6
 * 30
 */
package ioPractice;

import java.util.*;
import java.io.*;
class AplusB2br{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
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

class AplusB2sc {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[][] arr = new int[size][2];
        for(int i=0;i<size;i++){
            arr[i][0] = s.nextInt();
            arr[i][1] = s.nextInt();
        }
        int[] result = new int[size];
        for(int i=0;i<size;i++){
            result[i] = arr[i][0]+arr[i][1];
            System.out.println(result[i]);
        }
    }
}
