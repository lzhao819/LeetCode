//practise10
//Implementation of capacity limited min heap
public class MinHeap{
	private int[] array;
	private int size;

	public MinHeap(int[] array){
		if(array==null || array.length==0){
			throw new IlligalArgumentException("input array cannot null or empty");
		}
		this array = array;
		size = array.length;
		heapity();
	}

	public MinHeap(int cap){
		if(cap<=0){
			throw new IlligalArgumentException("capacity cannot be <=0");
		}
		array = new int[cap];
		size = cap;
	}

	//heapify
	private void heapity(){
		for(int i=size/2 -1;i>=0;i--){
			preculateDown(i);
		}
	} 

	private void percolateUp(int index){
		while(index>0){
			int parentIndex = (index-1)/2;
			if(array[parentIndex]>array[index]){
				swap(array, parentIndex, index);
			}else{
				break;
			}
			index = parentIndex;
		}
	}

	private void percolateDown(){
		//check if index is legal
		while(index<=size/2-1){
			int leftChildIndex = index *2 +1;
			int rightChildIndex = index*2 +2;
			int swapCandidate = leftChildIndex;//smallest one among leftchild and right child
			//update swapCadidate if rightchild exist ans it is smaller than leftChild
			if(rightChildIndex<=size-1 && array[leftChildIndex]>=array[rightChildIndex]){
				swapCandidate = rightChildIndex;
			}
			//swap if necessary
			if(array[index]>array[swapCandidate]){
				swap(array, index, swapCandidate);
			}else{
				break;
			}
			index = swapCandidate;
		}

	}

	private void swap(int[] array, int a, int b){
	 int tmp = array[a];
	 array[a] = array[b];
	 array[b] = tmp;
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size==0;
	}

	public boolean isFull(){
		return size==array.length;
	}

	public int peek(){
		if(size==0){
			throw new NoSuchElementException("heap is empty");
		}
		return array[0];
	}

	public int poll(){
		if(size==0){
			throw new NoSuchElementException("heap is empty");
		}
		int result = array[0];
		array[0] = array[size-1];
		size--;
		percolateDown(0);
		return result;
	}

	public void offer(int ele){
		if(size==array.length){
			array = Arrays.copyOf(array, (int)(array.length*1.5));
		}
		array[size] = ele;
		size++;
		percolateUp(size-1);
	}

	//return the original value
	public int update(int index, int ele){
		if(index <0 || index> size -1){
			throw new ArrayIndexOutOfBoundsException("invalid index range");
		}
		int result = array[index];
		array[index] = ele;
		if(result>ele){
			preculateUp(index);
		}else{
			perculateDown(index);
		}
		return result;
	}


}