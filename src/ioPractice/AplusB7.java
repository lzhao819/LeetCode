package ioPractice;

import java.util.*;
import java.io.*;
class AplusB7{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=null;
        List<Integer> list = new ArrayList<>();
        while((str = br.readLine())!=null){
            String[] strs = str.split(" ");
            int sum=0;
            for(String s:strs){
                sum+=Integer.parseInt(s);
            }
            list.add(sum);
        }
        for(int i: list){
            System.out.println(i);
        }
    }
}
