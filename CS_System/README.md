```
int[] node = new int[nodes+1];
int[] parent = new int[branches+1];
for(){
    node[i]++;
    parent[i] = i-1;
}
for(int i = 0; i<node.length;i++){
    if(node[i]==1 && node[i+1]==1 && parent[i]==parent[i+1]){
        count++;
    }  
}
return count; 
    