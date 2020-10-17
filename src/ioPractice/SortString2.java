package ioPractice;

import java.util.*;
import java.io.*;
//下一题和这个一样，把 " " 改成 "，" 即可
public class SortString2{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        List<String> result= new ArrayList<>();
        while((str=br.readLine())!=null){
            String[] strs = str.split(" ");
            Arrays.sort(strs);
            String s = String.join(" ",strs);
            result.add(s);
        }
        for(String s:result){
            System.out.println(s);
        }
    }
}
