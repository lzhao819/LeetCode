// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

// The cache is initialized with a positive capacity.

public class Solution<K, V> {
    //each node contains the key value pair
  //and it is also a doubled linked list node
  static class Node<K, V>{
    Node<K,V> next;
    Node<K,V> prev;
    K key;
    V value;

    Node(K key, V value){
      this.key = key;
      this.value = value;
    }

    void update(K key, V value){
      this.key = key;
      this.value = value;
    }
  }
  //make it final for the pre-defined size limit of chache
  private final int limit;
  //record tail and head of double linked list
  private Node<K,V> head;
  private Node<K,V> tail;
  //map
  private Map<K, Node<K,V>> map;

  // limit is the max capacity of the cache
  public Solution(int limit) {
    this.limit = limit;
    this.map = new HashMap<K, Node<K, V>>();
  }
  
  public void set(K key, V value) {
    Node<K,V> node =null;
    if(map.containsKey(key)){
      node = map.get(key);
      node.value = value;
      remove(node);
    }else if(map.size()<limit){
      node = new Node<K,V>(key,value);
    }else{
      node = tail;
      remove(node);
      node.update(key, value);
    }
    append(node);
  }
  
  public V get(K key) {
    Node<K,V> node = map.get(key);
    if(node ==null){
      return null;
    }
    remove(node);
    append(node);
    return node.value;
  }

  private Node<K,V> remove(Node<K,V> node){
    map.remove(node.key);
    if(node.prev!=null){
      node.prev.next = node.next;
    }
    if(node.next!=null){
      node.next.prev = node.prev;
    }
    if(node==head){
      head=head.next;
    }
    if(node ==tail){
      tail=tail.prev;
    }
    node.next = node.prev = null;
    return node;
  }

  private Node<K,V> append(Node<K,V> node){
    map.put(node.key, node);
    if(head==null){
      head=tail = node;
    }else{
      node.next = head;
      head.prev=node;
      head=node;
    }
    return node;
  }  
}