package ioPractice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class AplusB5br{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(size);
        for(int i=0;i<size;i++){
            String[] str = br.readLine().split(" ");
            int sum = 0;
            for(String num:str){
                sum+=Integer.parseInt(num);
            }
            sum-=Integer.parseInt(str[0]);
            list.add(sum);
        }
        for(int num:list){
            System.out.println(num);
        }
    }
}
class AplusB5sc {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = Integer.parseInt(s.nextLine());
        List<Integer> list = new ArrayList<>(size);
        for(int i=0;i<size;i++){
            String[] str = s.nextLine().split(" ");
            int sum = 0;
            for(String num:str){
                sum+=Integer.parseInt(num);
            }
            sum-=Integer.parseInt(str[0]);
            list.add(sum);
        }
        for(int num:list){
            System.out.println(num);
        }
    }
}
