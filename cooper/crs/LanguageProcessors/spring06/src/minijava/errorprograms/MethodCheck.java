/*
  Check if method exists and if arguments match
*/

class VarMethodCheck{
    public static void main(String[] a){
	System.out.println(new Test3().Something());
    }
}

class Test3 {
    
    Test2 b;
    Test4 c;
    Test5 d;
	
    public int Something(){
	b = new Test2();
	c = new Test4();
	d = new Test5();
	
	System.out.println(new Test1().Something( 5 ));
        System.out.println( b.Something());
	System.out.println( b.SomethingMore( true ));
	System.out.println( b.SomethingMore( 78, false ));
	System.out.println( b.SomethingMore( 78, 79 ));	

	System.out.println( b.Operate( c ));
	System.out.println( b.Operate( d ));
	System.out.println( b.Apply( c ));
	System.out.println( b.Apply( d ));
	System.out.println( b.Check( c ));
	System.out.println( b.Check( d ));
	
	return 1;
    }
}
class Test1 {
    
    public int Something(){
	boolean bVal1;
	int [] arr1;

	bVal1 = true;
        return arr1[1];
    }
}

class Test2 extends Test1{

    int iVal3;
    int iVal4;
    int [] arr1;
    boolean bVal1;

    public int Something(){
	return 0;
    }
    
    public int SomethingMore( int i, int j ){
	iVal3 = iVal4 * i;
        return iVal3;
    }
    
    public int Operate( Test4 t4 )
    {
	return 0;
    }
    
    public int Operate( Test5 t5 )
    {
	return 0;
    }
    
    public int Apply( Test4 t4 )
    {
	return 0;
    }
    
    public int Check( Test5 t5 )
    {
	return 0;
    }
}


class Test4 {
    public int Something(){
	return 0;
    }
}

class Test5 extends Test4{

    int iVal3;

    public int Something(){
	return 0;
    }
    
    public int SomethingMore( int i, int j ){
        iVal3 = 5;
	return iVal3;
    }
}
