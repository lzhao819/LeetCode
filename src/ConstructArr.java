class ConstructArr {
    public int[] constructArr(int[] a) {
        if(a==null || a.length<1) return a;
        int[] left = new int[a.length];//左边所有数的乘积
        int[] right = new int[a.length];
        left[0]=1;
        right[a.length-1]=1;
        for(int i=1;i<a.length;i++){
            left[i]=a[i-1]*left[i-1];
        }
        for(int i=a.length-2;i>=0;i--){
            right[i] =a[i+1]*right[i+1];
        }
        for(int i=0;i<a.length;i++){
            a[i] = left[i]*right[i];
        }
        return a;
    }
}

//优化了空间，少了一个space
class ConstructArrOptimizedSpace {
    public int[] constructArr(int[] a) {
        if(a==null || a.length<1) return a;
        int[] result = new int[a.length];//左边所有数的乘积
        int tmp = 1;
        result[0]=1;
        for(int i = 1; i < a.length; i++) {
            result[i] = result[i - 1] * a[i - 1];
        }
        for(int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            result[i] *= tmp;
        }
        return result;
    }
}
