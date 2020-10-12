class QuickSort {
    public int[] quickSort(int[] array){
        //check null
        if(array==null) return array;
        quickSort(array, 0, array.length-1);
        return array;
    }
    public void quickSort(int[] array, int left, int right){
        if(left>=right){
            return;
        }
        //define a pivot ans use the pivot partition the array
        int pivotPos = partition(array,left, right);
        quickSort(array, left, pivotPos-1);
        quickSort(array, pivotPos+1, right);
    }
    private int partition(int[] array, int left, int right){
        int pi

    }



}
