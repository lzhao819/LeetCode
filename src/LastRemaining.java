import java.util.ArrayList;
import java.util.List;

class LastRemainingRecur {
    //Time O(n)
    //Space O(n)
    public int lastRemaining(int n, int m) {
        if(n==1){
            return 0;
        }
        int index = lastRemaining(n-1, m);
        return (index+m)%n;
    }
}

class LastRemainingList {
    //每次删除的时间复杂度是 O(n)，删除了 n−1 次，所以整体时间复杂度是 O(n^2)
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int index =0;
        while(n>1){
            index = (index+m-1)%n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }
}
