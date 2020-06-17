//Laicode112 Random1000 Using Random5
//Given a random generator random5(), the return value of random5() is 0 - 4 with equal probability. Use random5() to implement random1000()
public class Solution {
  public int random1000() {
    // Write your solution here.
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    //5^5=3125
    while(true){
      int r=0;
      for(int i=0;i<5;i++){
        r += RandomFive.random5()*Math.pow(5,i);
        //也可以
        //r = r*5 + RandomFive.random5();
      }
      if(r<3000) return r%1000;
    }
  }
}
