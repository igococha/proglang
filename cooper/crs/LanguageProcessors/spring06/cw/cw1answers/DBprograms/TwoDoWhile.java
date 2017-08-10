

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

class TwoDoWhile {
  public int fred () {
     int i;
      do {
        i = i + 7;
         do {
          i = i+8;
          i = i-1;
           do i = i + 1; while (i < 5);
        } while (i < 5);
     } while ( i < 0 );
     return i;
  }
}

