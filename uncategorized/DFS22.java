class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n<=0) return result;
        char[] combi = new char[n*2];
        helper(result, combi, n, 0,0,0);
        return result;
    }
    
    private void helper(List<String> result, char[] combi, int n, int index, int l, int r){
        //ternimation condition
        if(l==n && r==n){
            result.add(new String(combi));
            return;
        }
        //case1: add'('
        if(l<n){
            combi[index]='(';
            helper(result, combi, n, index+1, l+1, r);  
        }
        
        if(l>r){
            combi[index]=')';
            helper(result, combi, n, index+1, l ,r+1);
        }  
    }
}