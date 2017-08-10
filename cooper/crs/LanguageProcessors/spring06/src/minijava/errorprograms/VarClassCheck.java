/*
  Check for multiple variable declarations in classes
*/

class VarClassCheck{
    public static void main(String[] a){
        System.out.println(new Test1().Something());
    }
}

class Test1 {
    int iVal3;
    int [] arr1;
    int iVal3;
    int [] arr1;
    boolean bVal1;
    
    public int Something(){
	boolean bVal1;
	int [] arr1;
       
	bVal1 = true;
        return 0;
    }
}

class Test2 extends Test1{
    int iVal3;
    int [] arr1;
    boolean bVal1;

    public int SomethingMore(){
	return 0;
    }
}


