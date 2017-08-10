class IdSymbol {

  IdSymbol (int t, int v) {       /* Integer id symbol constructor. */
    type = t;
    intvalue = v;
  }

  IdSymbol (int t, boolean v) {  /* Boolean id symbol constructor. */
    type = t;
    boolvalue = v;
  }

  public int type;
  public int intvalue;
  public boolean boolvalue;
}
