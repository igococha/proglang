
class SwitchEx {
   public static void main(String [] a) {
          switch (n) {   // assume N is an integer variable
             case 1:
                System.out.println(1);
                break;
             case 2:
             case 4:
             case 8:
                System.out.println(2);
                System.out.println(22);
                break;
             case 3:
             case 6:
             case 9:
                System.out.println(3);
                System.out.println(33);
                switch (i+9) { 
                  case (8+6) : i=i+1; 
                       System.out.println(i+2);
                       break;
                  case 11 : 
                       System.out.println(4);
                       break;
                  default : break;
                }
                break;
             case 5:
                System.out.println(5);
                break;
             default:
                System.out.println(7);
                System.out.println(9);
          }
    }
}
