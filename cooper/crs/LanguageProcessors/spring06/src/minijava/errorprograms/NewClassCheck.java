/*
  Check if new type is the same as the type the variable is defined or a
  subclass or an undefined class 
*/

class NewClassCheck{
    public static void main(String[] a){
	System.out.println(new Test1().Something());
	}
}

class Test1 {

    public int Something(){
	Test2 b;
	Test3 c;
	Test4 d;
	Test4 e;

	b = new Test3();
	c = new Test2();
	d = new Test2();
	e = new Test5();
	return 0;
    }
}

class Test2{
    public int SomethingMore(){
	return 0;
    }
}

class Test3 extends Test2{
    public int SomethingEvenMore(){
	return 0;
    }
}

class Test4{
    public int Nothing(){
	return 0;
    }
}
