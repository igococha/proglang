import java.lang.String;

class Table {
    TableNode first;
    class TableNode {
	String id; 
	int value;
	TableNode next;
	TableNode(String i, int v, TableNode n) { id=i;  value=v; next=n; }
    }
    Table() { first=null; }
    void update(String i, int v) { first = new TableNode(i,v,first); }
    int lookup(String id) throws TableLookupException {
	TableNode current=first;
	while (current!=null && !id.equals(current.id))
	    current=current.next;
	if (current==null)
	    throw new TableLookupException("Variable "+id+" undefined");
	else
	    return current.value;
    }
}

class TableLookupException extends Exception {
    public String message;
    TableLookupException(String m) { message=m; }
}