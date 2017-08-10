class TestExtends{
    public static void main(String[] a){
        System.out.println(new DoSomething().Do()); 
    }
}

class DoSomething {
    EC b; 

    public int b() {return 0; }
    public int Do() {
        int i; boolean bval;

        b = new EC();
        i = b.setParField(1);
        i = b.setOwnField(true);
        bval = b.setAnotherParField();
	System.out.println(b.pfv());
        System.out.println(b.apfv());
        return 0;
    }
}

class OneClass {
    int pf;
    int apf;

    public int setParField(int i) { pf = i; return 1; }
    public int setParField(int j) { return 1; }
    public int foo(EC i) {return 3;}
    public int pfv() { return pf; }
    public int apfv() { return apf; }
}

class EC extends OneClass {
    boolean myf;

    public int foo(OneClass i) {return 4;}

    public int setOwnField(boolean b) { myf = b; return 2; }

    public boolean setAnotherParField() { 
	if (myf) { apf = 5; }
        else { apf = 15; }
        return true;
    }

    public boolean myfv() { return myf; }

}

