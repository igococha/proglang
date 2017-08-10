
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
