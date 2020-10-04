import java.util.ArrayList;
import java.util.List;

public class PrintNumbers {
    /**
     * 考虑largeNumber，使用全排列
     * Time O(10^n)
     * Space O(10^n)
     */
    public int[] printNumbers(int n) {
        List<Integer> list = new ArrayList<>();
        dfs(list, n, new StringBuilder(), 0);
        int[] result = new int[list.size()];
        for(int i=0;i<result.length;i++){
            result[i] = list.get(i);
        }
        return result;
    }
    private void dfs(List<Integer> list, int n, StringBuilder sb, int index){
        if(index==n){
            //去掉前面的0
            while(sb.length()!=0 && sb.charAt(0)=='0'){
                sb.deleteCharAt(0);
            }
            if(sb.length()!=0){
                list.add(Integer.valueOf(sb.toString()));
            }
            return;
        }
        for(int i=0; i<10;i++){
            //public StringBuilder append(int val) --> 将int append成为了string
            sb.append(i);
            dfs(list, n, sb, index+1);
            if(sb.length()!=0){
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    class simpleSolution{
        //如果不考虑大数
        public int[] printNumbersEasy(int n){
            if(n==0) return new int[1];
            int max = 0;
            while(n>0){
                max=max*10+9;
                n--;
            }
            int[] result = new int[max];
            for(int i=0; i<max;i++){
                result[i]=i+1;
            }
            return result;
        }
    }//
}
