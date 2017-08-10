/*
  Check if classes being extended exist later or not
*/

class ExtendClassCheck{
    public static void main(String[] a){
        System.out.println(new Test1().Something());
    }
}

class Test3 extends Test4{
   public int SomethingEvenMore(){
       return 0;
   }
}

class Test2 extends Test1{
   public int SomethingMore(){
       return 0;
   }
}

class Test1{
   public int Something(){
      return 0;
   }
}

