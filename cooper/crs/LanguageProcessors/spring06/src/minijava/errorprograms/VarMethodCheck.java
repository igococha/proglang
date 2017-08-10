/*
  Check for multiple variable declarations in methods
*/

class VarMethodCheck{
    public static void main(String[] a){
        System.out.println(new Test1().Something());
    }
}

class Test1 {
    int iVal3;
    int [] arr1;

    public int Something(){
	
	boolean bVal1;
	int iVal3;
	boolean bVal1;
	int [] arr1;
	int [] arr1;

	bVal1 = true;

	iVal3 = 1;
	return 0;
    }
}

