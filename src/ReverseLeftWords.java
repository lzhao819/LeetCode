public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        //先分开swap再合起来swap
        char[] arr= s.toCharArray();
        reverse(arr, 0, n-1);
        reverse(arr, n, arr.length-1);
        reverse(arr, 0, arr.length-1);
        return new String(arr, 0, arr.length);

    }
    private void reverse(char[] arr, int l, int r){
        while(l<r){
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }
}
