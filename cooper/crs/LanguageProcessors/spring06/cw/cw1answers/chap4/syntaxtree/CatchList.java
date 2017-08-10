package syntaxtree;

import java.util.Vector;

public class CatchList {	/* Added by DB */
   private Vector list;

   public CatchList() {
      list = new Vector();
   }

   public void addElement(Catch n) {
      list.addElement(n);
   }

   public Catch elementAt(int i)  { 
      return (Catch)list.elementAt(i); 
   }

   public int size() { 
      return list.size(); 
   }
}
