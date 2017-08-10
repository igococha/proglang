/*
   Check for circularities in inheritance
*/

class CircularInh{
    public static void main(String[] a){
        System.out.println(new Test1().Something()); 
    }
}

class Test3 extends Test2{
   public int SomethingEvenMore(){
       return 0;
   }
}

class Test2 extends Test1{
   public int SomethingMore(){
       return 0;
   }
} 

class Test1 extends Test3{
   public int Something(){
      return 0;
   }
}
