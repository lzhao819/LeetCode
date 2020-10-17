package ioPractice;

import java.util.*;
import java.io.*;
public class SortString1{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String[] result = br.readLine().split(" ");
        Arrays.sort(result);
        String s = String.join(" ",result);
        System.out.println(s);
    }
}
