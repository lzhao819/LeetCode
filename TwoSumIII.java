// Design and implement a TwoSum class. It should support the following operations: add and find.

// add - Add the number to an internal data structure.
// find - Find if there exists any pair of numbers which sum is equal to the value.

//add O(1)
//find O(nlogn + n)

class TwoSum {
    private ArrayList<Integer> nums;
    private boolean is_sorted;

    /** Initialize your data structure here. */
    public TwoSum() {
        this.nums = new ArrayList<Integer>();
        this.is_sorted = false;  
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        this.nums.add(number);
        this.is_sorted = false;  
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if(!this.is_sorted){
            Collections.sort(this.nums);
        }
        int l = 0, r = nums.size()-1;
        while(l<r){
            int sum = nums.get(l)+nums.get(r);
            if(sum==value){
                return true;
            }else if(sum<value){
                l++;
            }else{
                r--;
            }
        }
        return false;
        
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */