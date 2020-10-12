import java.util.PriorityQueue;

/**
 * Time
 * get O(1) ： 获取堆顶元素使用 O(1) 时间；
 * add O(logN) ： 堆的插入和弹出操作使用 O(logN) 时间。
 * Space O(N)
 *
 */
public class FindMedianfromDataStream {
    PriorityQueue<Integer> max;//represent small half
    PriorityQueue<Integer> min;//represent large half

    /** initialize your data structure here. */
    public FindMedianfromDataStream() {
        max = new PriorityQueue<>(11, (o1,o2) -> (o2-o1));
        min = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(max.isEmpty()|| num<=max.peek()){
            max.offer(num);
        }else{
            min.offer(num);
        }
        //balance to heap to make
        //max.size = min.size or max.size = min.size+1
        if(max.size()-min.size() >=2){
            min.offer(max.poll());
        }else if(max.size() < min.size()){
            max.offer(min.poll());
        }
    }

    public double findMedian() {
        if(max.isEmpty()) return -1;
        if(max.size()==min.size()){
            return (max.peek()+min.peek())/2.0;
        }else{
            return (double)max.peek();
        }
    }
}
