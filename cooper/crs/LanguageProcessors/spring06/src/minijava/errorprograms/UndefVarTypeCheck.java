/*
  Check if variable type is defined 
*/

class UndefVarTypeCheck{
    public static void main(String[] a){
	System.out.println(new Test1().Something());
	}
}

class Test1 {

    public int Something(){
	Test3 a;
	Test2 b;

	b = new Test2();
	
	return 0;
    }
}

class Test2{
    public int SomethingMore(){
	return 0;
    }
}
