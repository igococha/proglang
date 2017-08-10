/*
  Check if arithmetic operators have integer arguments and boolean operators 
  have boolean arguments 
*/

class OperatorCheck{
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
       int [] arr1;
       int [] arr2;

       bVal1 = true;
       bVal2 = false;

       iVal3 = 1;
       iVal4 = 2;

       arr1 = new int[ 10 ];
       arr2 = new int[ 10 ];
       
       arr1[1] = 2;
       arr2[1] = 3;

       iVal3 = bVal1 + iVal4;
       iVal3 = bVal1 - iVal4;
       iVal3 = bVal1 * arr2[1];
	
       iVal3 = arr1 + iVal4;
       iVal3 = arr1 - arr1[1];
       iVal3 = arr2 * arr2[1];

       bVal1 = iVal3 && iVal4;
       bVal1 = arr2 && bVal2;
       bVal1 = iVal3 < iVal4;
       bVal1 = arr2 < bVal2; 
       bVal1 = bVal1 < bVal2;
       bVal1 = ! arr1[1];
       bVal1 = ! arr2;

       return iVal4;
   }
} 


