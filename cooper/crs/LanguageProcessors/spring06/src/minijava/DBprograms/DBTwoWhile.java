

class Factorial{
    public static void main(String[] a){
	System.out.println(new Fac().ComputeFac(10));
    }
}

class Fac {

    public int ComputeFac(int num){
	int num_aux ;
	if (num < 1)
	    num_aux = 1 ;
	else 
	    num_aux = num * (this.ComputeFac(num-1)) ;
	return num_aux ;
    }

}

class TwoWhile {
  public int fred () {
     int i;
     while ( i < 0 ) {
        i = i + 7;
        while (i < 5) {
          i = i+8;
          i = i-1;
        }
     }
     return i;
  }
}

