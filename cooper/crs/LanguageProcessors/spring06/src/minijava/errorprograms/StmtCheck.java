/*
  Check if errors flagged when print not passed int and while and if not 
  passed bool types
*/

class StmtCheck{
    public static void main(String[] a){
        System.out.println(new Test1().Something()); 
    }
}


class Test1 {
   public int Something(){
       boolean bVal1;
       boolean bVal2;

       int iVal3;
       int iVal4;
       int [] arr;

       bVal1 = true;
       bVal2 = false;

       iVal3 = 1;
       iVal4 = 2;

       arr = new int[10];
       arr[1] = 5;
       
       System.out.println( bVal1 && !bVal2 );
       System.out.println( arr );
       System.out.println( true );
       
       while( iVal4 + iVal3 )
	   {
	       iVal4 = iVal4 - 1;
	   }
       
       while( arr )
	   {
	       iVal4 = iVal4 - 1;
	   }
       
       if( iVal4 + iVal3 )
	   {
	       iVal4 = iVal4 - 1;
	   }
       else
	   {
	       iVal3 = iVal3 - 1;
	   }
       
       if( arr )
	   {
	       iVal4 = iVal4 - 1;
	   }
       else
	   {
	       iVal3 = iVal3 - 1;
	   }

       return 0;
   }
}
