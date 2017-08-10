/* Generated By:JavaCC: Do not edit this line. LexInt.java */
/* Lab 3 - Solution */
/* Java declarations to be inserted by JavaCC  */

/* Class declaration for LexInt used instead of default */
public class LexInt implements LexIntConstants {
  public static void main(String args[]) throws ParseException {
    System.out.println ("Type in tokens separated by white space (including newlines)");
    System.out.println ("Type EOF to finish...(Ctrl-D on Unix, Ctrl-Z on PC)");
    LexInt parser = new LexInt(System.in);
    parser.TokenList(); /* TokenList declared below */
  }

  public static int parseLiteral(String hex, int base)  {
       int valchar=0, val=0, l;
       char ch;
       StringBuffer buf = new StringBuffer(hex);
       l = buf.length();
       for(int i=0; i < l; i++) {
        ch=buf.charAt(i);
        if (ch >= '0' && ch <= '9')
           valchar = ch-'0';
        else if (ch >= 'a' && ch <= 'f')
             valchar = 10 + (ch-'a');
        else if (ch >= 'A' && ch <= 'F')
             valchar = 10 + (ch-'A');
        else {
             System.out.println("Bad Char "+ch); // better trow an exception
             return -1;
        }
        if (valchar >= base) {
             System.out.println("Bad Char "+ch+" greater or equal than base "+base);
             return -1;
        }
        val = val*base + valchar;
       }
      return val;
  }

/*
 * A simple grammar to match tokens and print them.
 */
  static final public void TokenList() throws ParseException {
 Token t; int val;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER_LITERAL:
      case BINARY_LITERAL:
      case REAL:
      case IDENTIFIER:
      case COMMENT:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
       val = 0;
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER_LITERAL:
        t = jj_consume_token(INTEGER_LITERAL);
                              val = LexInt.parseLiteral(t.image,10);
        break;
      case IDENTIFIER:
        t = jj_consume_token(IDENTIFIER);
        break;
      case REAL:
        t = jj_consume_token(REAL);
        break;
      case BINARY_LITERAL:
        t = jj_consume_token(BINARY_LITERAL);
                              val = LexInt.parseLiteral(t.image.substring(1),2);
        break;
      case COMMENT:
        t = jj_consume_token(COMMENT);
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
             System.out.print("token found: "+ tokenImage[t.kind]);
             System.out.print(" (`"+t.image+"')");
             System.out.println(" value = "+val);
    }
    jj_consume_token(0);
  }

  static private boolean jj_initialized_once = false;
  static public LexIntTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  static public Token token, jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[2];
  static private int[] jj_la1_0;
  static {
      jj_la1_0();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x7c0,0x7c0,};
   }

  public LexInt(java.io.InputStream stream) {
     this(stream, null);
  }
  public LexInt(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new LexIntTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  public LexInt(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new LexIntTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  public LexInt(LexIntTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  public void ReInit(LexIntTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  static final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.Vector jj_expentries = new java.util.Vector();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  static public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[14];
    for (int i = 0; i < 14; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 2; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 14; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  static final public void enable_tracing() {
  }

  static final public void disable_tracing() {
  }

}
