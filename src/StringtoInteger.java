public class StringtoInteger {
    public int strToInt(String str) {
        if(str==null|| str.length()<1) return 0;
        char[] arr = str.toCharArray();
        long sum = 0;
        int i=0;
        boolean flag=false;
        //去空格
        while(i<arr.length && arr[i]==' '){
            i++;
        }
        if(i>=arr.length){
            return 0;
        }
        //符号位
        if(arr[i]=='-'){
            flag=true;
            i++;
        }else if(arr[i]=='+'){
            i++;
        }else if(arr[i]<'0'||arr[i]>'9'){
            return 0;
        }
        for(int j=i;j<arr.length;j++){
            if(arr[j]<'0'||arr[j]>'9') break;
            sum = sum*10+(arr[j]-'0');
            if(!flag && sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(flag && sum*(-1)<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        if(flag){
            sum*=-1;
        }
        return (int)sum;
    }
}
