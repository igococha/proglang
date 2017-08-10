/* Generated By:JJTree&JavaCC: Do not edit this line. TPLParser.java */
public class TPLParser/*@bgen(jjtree)*/implements TPLParserTreeConstants, TPLParserConstants {/*@bgen(jjtree)*/
  protected static JJTTPLParserState jjtree = new JJTTPLParserState();

/*
 * TPL grammar follows.
 */
  static final public void CompilationUnit() throws ParseException {
 /*@bgen(jjtree) CompilationUnit */
  ASTCompilationUnit jjtn000 = new ASTCompilationUnit(JJTCOMPILATIONUNIT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case KEYINT:
        case KEYBOOL:
          ;
          break;
        default:
          jj_la1[0] = jj_gen;
          break label_1;
        }
        VarDeclaration();
        jj_consume_token(24);
      }
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case KEYSKIP:
        case KEYWHILE:
        case KEYFOR:
        case KEYIF:
        case KEYREAD:
        case KEYWRITE:
        case IDENTIFIER:
          ;
          break;
        default:
          jj_la1[1] = jj_gen;
          break label_2;
        }
        Statement();
      }
      jj_consume_token(0);
    } catch (Throwable jjte000) {
     if (jjtc000) {
       jjtree.clearNodeScope(jjtn000);
       jjtc000 = false;
     } else {
       jjtree.popNode();
     }
     if (jjte000 instanceof RuntimeException) {
       {if (true) throw (RuntimeException)jjte000;}
     }
     if (jjte000 instanceof ParseException) {
       {if (true) throw (ParseException)jjte000;}
     }
     {if (true) throw (Error)jjte000;}
    } finally {
     if (jjtc000) {
       jjtree.closeNodeScope(jjtn000, true);
     }
    }
  }

  static final public void VarDeclaration() throws ParseException {
 /*@bgen(jjtree) VarDeclaration */
  ASTVarDeclaration jjtn000 = new ASTVarDeclaration(JJTVARDECLARATION);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token t;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case KEYBOOL:
        jj_consume_token(KEYBOOL);
                jjtn000.type = TPLTypes.boolType;
        break;
      case KEYINT:
        jj_consume_token(KEYINT);
               jjtn000.type = TPLTypes.intType;
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      t = jj_consume_token(IDENTIFIER);
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    jjtn000.name = t.image;
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

/*
 * Statement syntax follows.
 */
  static final public void Statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case KEYSKIP:
      SkipStatement();
      break;
    case IDENTIFIER:
      AssignStatement();
      break;
    case KEYIF:
      IfStatement();
      break;
    case KEYWHILE:
      WhileStatement();
      break;
    case KEYFOR:
      ForStatement();
      break;
    case KEYREAD:
      ReadStatement();
      break;
    case KEYWRITE:
      WriteStatement();
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void SkipStatement() throws ParseException {
 /*@bgen(jjtree) SkipStatement */
  ASTSkipStatement jjtn000 = new ASTSkipStatement(JJTSKIPSTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(KEYSKIP);
      jj_consume_token(24);
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void AssignStatement() throws ParseException {
 /*@bgen(jjtree) AssignStatement */
  ASTAssignStatement jjtn000 = new ASTAssignStatement(JJTASSIGNSTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      Id();
      jj_consume_token(25);
      Expression();
      jj_consume_token(24);
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void IfStatement() throws ParseException {
 /*@bgen(jjtree) IfStatement */
  ASTIfStatement jjtn000 = new ASTIfStatement(JJTIFSTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(KEYIF);
      jj_consume_token(26);
      Expression();
      jj_consume_token(27);
      StatementBlock();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case KEYELSE:
        jj_consume_token(KEYELSE);
        StatementBlock();
        break;
      default:
        jj_la1[4] = jj_gen;
        ;
      }
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void WhileStatement() throws ParseException {
 /*@bgen(jjtree) WhileStatement */
  ASTWhileStatement jjtn000 = new ASTWhileStatement(JJTWHILESTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(KEYWHILE);
      jj_consume_token(26);
      Expression();
      jj_consume_token(27);
      StatementBlock();
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void UpdateStatement() throws ParseException {
 /*@bgen(jjtree) UpdateStatement */
  ASTUpdateStatement jjtn000 = new ASTUpdateStatement(JJTUPDATESTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      Id();
      jj_consume_token(25);
      Expression();
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void ForStatement() throws ParseException {
 /*@bgen(jjtree) ForStatement */
  ASTForStatement jjtn000 = new ASTForStatement(JJTFORSTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(KEYFOR);
      jj_consume_token(26);
      AssignStatement();
      Expression();
      jj_consume_token(24);
      UpdateStatement();
      jj_consume_token(27);
      StatementBlock();
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void StatementBlock() throws ParseException {
 /*@bgen(jjtree) StatementBlock */
  ASTStatementBlock jjtn000 = new ASTStatementBlock(JJTSTATEMENTBLOCK);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(28);
      label_3:
      while (true) {
        Statement();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case KEYSKIP:
        case KEYWHILE:
        case KEYFOR:
        case KEYIF:
        case KEYREAD:
        case KEYWRITE:
        case IDENTIFIER:
          ;
          break;
        default:
          jj_la1[5] = jj_gen;
          break label_3;
        }
      }
      jj_consume_token(29);
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void ReadStatement() throws ParseException {
 /*@bgen(jjtree) ReadStatement */
  ASTReadStatement jjtn000 = new ASTReadStatement(JJTREADSTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token t;
    try {
      jj_consume_token(KEYREAD);
      t = jj_consume_token(IDENTIFIER);
      jj_consume_token(24);
     jjtree.closeNodeScope(jjtn000, true);
     jjtc000 = false;
     jjtn000.name = t.image;
    } finally {
     if (jjtc000) {
       jjtree.closeNodeScope(jjtn000, true);
     }
    }
  }

  static final public void WriteStatement() throws ParseException {
 /*@bgen(jjtree) WriteStatement */
  ASTWriteStatement jjtn000 = new ASTWriteStatement(JJTWRITESTATEMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token t;
    try {
      jj_consume_token(KEYWRITE);
      t = jj_consume_token(IDENTIFIER);
      jj_consume_token(24);
     jjtree.closeNodeScope(jjtn000, true);
     jjtc000 = false;
     jjtn000.name = t.image;
    } finally {
     if (jjtc000) {
       jjtree.closeNodeScope(jjtn000, true);
     }
    }
  }

/*
 * Expression syntax follows.
 */
  static final public void Expression() throws ParseException {
    OrExpression();
  }

  static final public void OrExpression() throws ParseException {
    AndExpression();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case KEYOR:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_4;
      }
      jj_consume_token(KEYOR);
           ASTOr jjtn001 = new ASTOr(JJTOR);
           boolean jjtc001 = true;
           jjtree.openNodeScope(jjtn001);
      try {
        AndExpression();
      } catch (Throwable jjte001) {
           if (jjtc001) {
             jjtree.clearNodeScope(jjtn001);
             jjtc001 = false;
           } else {
             jjtree.popNode();
           }
           if (jjte001 instanceof RuntimeException) {
             {if (true) throw (RuntimeException)jjte001;}
           }
           if (jjte001 instanceof ParseException) {
             {if (true) throw (ParseException)jjte001;}
           }
           {if (true) throw (Error)jjte001;}
      } finally {
           if (jjtc001) {
             jjtree.closeNodeScope(jjtn001,  2);
           }
      }
    }
  }

  static final public void AndExpression() throws ParseException {
    EqualityExpression();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case KEYAND:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_5;
      }
      jj_consume_token(KEYAND);
            ASTAnd jjtn001 = new ASTAnd(JJTAND);
            boolean jjtc001 = true;
            jjtree.openNodeScope(jjtn001);
      try {
        EqualityExpression();
      } catch (Throwable jjte001) {
            if (jjtc001) {
              jjtree.clearNodeScope(jjtn001);
              jjtc001 = false;
            } else {
              jjtree.popNode();
            }
            if (jjte001 instanceof RuntimeException) {
              {if (true) throw (RuntimeException)jjte001;}
            }
            if (jjte001 instanceof ParseException) {
              {if (true) throw (ParseException)jjte001;}
            }
            {if (true) throw (Error)jjte001;}
      } finally {
            if (jjtc001) {
              jjtree.closeNodeScope(jjtn001,  2);
            }
      }
    }
  }

  static final public void EqualityExpression() throws ParseException {
    RelationalExpression();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 30:
      case 31:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_6;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 30:
        jj_consume_token(30);
            ASTEQ jjtn001 = new ASTEQ(JJTEQ);
            boolean jjtc001 = true;
            jjtree.openNodeScope(jjtn001);
        try {
          RelationalExpression();
        } catch (Throwable jjte001) {
            if (jjtc001) {
              jjtree.clearNodeScope(jjtn001);
              jjtc001 = false;
            } else {
              jjtree.popNode();
            }
            if (jjte001 instanceof RuntimeException) {
              {if (true) throw (RuntimeException)jjte001;}
            }
            if (jjte001 instanceof ParseException) {
              {if (true) throw (ParseException)jjte001;}
            }
            {if (true) throw (Error)jjte001;}
        } finally {
            if (jjtc001) {
              jjtree.closeNodeScope(jjtn001,  2);
            }
        }
        break;
      case 31:
        jj_consume_token(31);
            ASTNE jjtn002 = new ASTNE(JJTNE);
            boolean jjtc002 = true;
            jjtree.openNodeScope(jjtn002);
        try {
          RelationalExpression();
        } catch (Throwable jjte002) {
            if (jjtc002) {
              jjtree.clearNodeScope(jjtn002);
              jjtc002 = false;
            } else {
              jjtree.popNode();
            }
            if (jjte002 instanceof RuntimeException) {
              {if (true) throw (RuntimeException)jjte002;}
            }
            if (jjte002 instanceof ParseException) {
              {if (true) throw (ParseException)jjte002;}
            }
            {if (true) throw (Error)jjte002;}
        } finally {
            if (jjtc002) {
              jjtree.closeNodeScope(jjtn002,  2);
            }
        }
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void RelationalExpression() throws ParseException {
    AdditiveExpression();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
    case 33:
    case 34:
    case 35:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 32:
        jj_consume_token(32);
          ASTLT jjtn001 = new ASTLT(JJTLT);
          boolean jjtc001 = true;
          jjtree.openNodeScope(jjtn001);
        try {
          AdditiveExpression();
        } catch (Throwable jjte001) {
          if (jjtc001) {
            jjtree.clearNodeScope(jjtn001);
            jjtc001 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte001 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte001;}
          }
          if (jjte001 instanceof ParseException) {
            {if (true) throw (ParseException)jjte001;}
          }
          {if (true) throw (Error)jjte001;}
        } finally {
          if (jjtc001) {
            jjtree.closeNodeScope(jjtn001,  2);
          }
        }
        break;
      case 33:
        jj_consume_token(33);
          ASTGT jjtn002 = new ASTGT(JJTGT);
          boolean jjtc002 = true;
          jjtree.openNodeScope(jjtn002);
        try {
          AdditiveExpression();
        } catch (Throwable jjte002) {
          if (jjtc002) {
            jjtree.clearNodeScope(jjtn002);
            jjtc002 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte002 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte002;}
          }
          if (jjte002 instanceof ParseException) {
            {if (true) throw (ParseException)jjte002;}
          }
          {if (true) throw (Error)jjte002;}
        } finally {
          if (jjtc002) {
            jjtree.closeNodeScope(jjtn002,  2);
          }
        }
        break;
      case 34:
        jj_consume_token(34);
           ASTLE jjtn003 = new ASTLE(JJTLE);
           boolean jjtc003 = true;
           jjtree.openNodeScope(jjtn003);
        try {
          AdditiveExpression();
        } catch (Throwable jjte003) {
           if (jjtc003) {
             jjtree.clearNodeScope(jjtn003);
             jjtc003 = false;
           } else {
             jjtree.popNode();
           }
           if (jjte003 instanceof RuntimeException) {
             {if (true) throw (RuntimeException)jjte003;}
           }
           if (jjte003 instanceof ParseException) {
             {if (true) throw (ParseException)jjte003;}
           }
           {if (true) throw (Error)jjte003;}
        } finally {
           if (jjtc003) {
             jjtree.closeNodeScope(jjtn003,  2);
           }
        }
        break;
      case 35:
        jj_consume_token(35);
           ASTGE jjtn004 = new ASTGE(JJTGE);
           boolean jjtc004 = true;
           jjtree.openNodeScope(jjtn004);
        try {
          AdditiveExpression();
        } catch (Throwable jjte004) {
           if (jjtc004) {
             jjtree.clearNodeScope(jjtn004);
             jjtc004 = false;
           } else {
             jjtree.popNode();
           }
           if (jjte004 instanceof RuntimeException) {
             {if (true) throw (RuntimeException)jjte004;}
           }
           if (jjte004 instanceof ParseException) {
             {if (true) throw (ParseException)jjte004;}
           }
           {if (true) throw (Error)jjte004;}
        } finally {
           if (jjtc004) {
             jjtree.closeNodeScope(jjtn004,  2);
           }
        }
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
  }

  static final public void AdditiveExpression() throws ParseException {
    MultiplicativeExpression();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 36:
      case 37:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_7;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 36:
        jj_consume_token(36);
          ASTAdd jjtn001 = new ASTAdd(JJTADD);
          boolean jjtc001 = true;
          jjtree.openNodeScope(jjtn001);
        try {
          MultiplicativeExpression();
        } catch (Throwable jjte001) {
          if (jjtc001) {
            jjtree.clearNodeScope(jjtn001);
            jjtc001 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte001 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte001;}
          }
          if (jjte001 instanceof ParseException) {
            {if (true) throw (ParseException)jjte001;}
          }
          {if (true) throw (Error)jjte001;}
        } finally {
          if (jjtc001) {
            jjtree.closeNodeScope(jjtn001,  2);
          }
        }
        break;
      case 37:
        jj_consume_token(37);
          ASTSubtract jjtn002 = new ASTSubtract(JJTSUBTRACT);
          boolean jjtc002 = true;
          jjtree.openNodeScope(jjtn002);
        try {
          MultiplicativeExpression();
        } catch (Throwable jjte002) {
          if (jjtc002) {
            jjtree.clearNodeScope(jjtn002);
            jjtc002 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte002 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte002;}
          }
          if (jjte002 instanceof ParseException) {
            {if (true) throw (ParseException)jjte002;}
          }
          {if (true) throw (Error)jjte002;}
        } finally {
          if (jjtc002) {
            jjtree.closeNodeScope(jjtn002,  2);
          }
        }
        break;
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void MultiplicativeExpression() throws ParseException {
    PrimaryExpression();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 38:
      case 39:
      case 40:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_8;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 38:
        jj_consume_token(38);
          ASTMul jjtn001 = new ASTMul(JJTMUL);
          boolean jjtc001 = true;
          jjtree.openNodeScope(jjtn001);
        try {
          PrimaryExpression();
        } catch (Throwable jjte001) {
          if (jjtc001) {
            jjtree.clearNodeScope(jjtn001);
            jjtc001 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte001 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte001;}
          }
          if (jjte001 instanceof ParseException) {
            {if (true) throw (ParseException)jjte001;}
          }
          {if (true) throw (Error)jjte001;}
        } finally {
          if (jjtc001) {
            jjtree.closeNodeScope(jjtn001,  2);
          }
        }
        break;
      case 39:
        jj_consume_token(39);
          ASTDiv jjtn002 = new ASTDiv(JJTDIV);
          boolean jjtc002 = true;
          jjtree.openNodeScope(jjtn002);
        try {
          PrimaryExpression();
        } catch (Throwable jjte002) {
          if (jjtc002) {
            jjtree.clearNodeScope(jjtn002);
            jjtc002 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte002 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte002;}
          }
          if (jjte002 instanceof ParseException) {
            {if (true) throw (ParseException)jjte002;}
          }
          {if (true) throw (Error)jjte002;}
        } finally {
          if (jjtc002) {
            jjtree.closeNodeScope(jjtn002,  2);
          }
        }
        break;
      case 40:
        jj_consume_token(40);
          ASTPow jjtn003 = new ASTPow(JJTPOW);
          boolean jjtc003 = true;
          jjtree.openNodeScope(jjtn003);
        try {
          PrimaryExpression();
        } catch (Throwable jjte003) {
          if (jjtc003) {
            jjtree.clearNodeScope(jjtn003);
            jjtc003 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte003 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte003;}
          }
          if (jjte003 instanceof ParseException) {
            {if (true) throw (ParseException)jjte003;}
          }
          {if (true) throw (Error)jjte003;}
        } finally {
          if (jjtc003) {
            jjtree.closeNodeScope(jjtn003,  2);
          }
        }
        break;
      default:
        jj_la1[15] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void PrimaryExpression() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
    case KEYTRUE:
    case KEYFALSE:
      Literal();
      break;
    case IDENTIFIER:
      Id();
      break;
    case 26:
      jj_consume_token(26);
      Expression();
      jj_consume_token(27);
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Id() throws ParseException {
 /*@bgen(jjtree) Id */
   ASTId jjtn000 = new ASTId(JJTID);
   boolean jjtc000 = true;
   jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(IDENTIFIER);
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
          jjtn000.name = t.image;
    } finally {
     if (jjtc000) {
       jjtree.closeNodeScope(jjtn000, true);
     }
    }
  }

  static final public void Literal() throws ParseException {
   Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
   ASTIntConst jjtn001 = new ASTIntConst(JJTINTCONST);
   boolean jjtc001 = true;
   jjtree.openNodeScope(jjtn001);
      try {
        t = jj_consume_token(INTEGER_LITERAL);
                        jjtree.closeNodeScope(jjtn001, true);
                        jjtc001 = false;
                        jjtn001.val = Integer.parseInt(t.image);
      } finally {
   if (jjtc001) {
     jjtree.closeNodeScope(jjtn001, true);
   }
      }
      break;
    case KEYTRUE:
    case KEYFALSE:
      BooleanLiteral();
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void BooleanLiteral() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case KEYTRUE:
    ASTTrue jjtn001 = new ASTTrue(JJTTRUE);
    boolean jjtc001 = true;
    jjtree.openNodeScope(jjtn001);
      try {
        jj_consume_token(KEYTRUE);
      } finally {
    if (jjtc001) {
      jjtree.closeNodeScope(jjtn001, true);
    }
      }
      break;
    case KEYFALSE:
    ASTFalse jjtn002 = new ASTFalse(JJTFALSE);
    boolean jjtc002 = true;
    jjtree.openNodeScope(jjtn002);
      try {
        jj_consume_token(KEYFALSE);
      } finally {
    if (jjtc002) {
      jjtree.closeNodeScope(jjtn002, true);
    }
      }
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public TPLParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[19];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x30000,0x2033c0,0x30000,0x2033c0,0x800,0x2033c0,0x8000,0x4000,0xc0000000,0xc0000000,0x0,0x0,0x0,0x0,0x0,0x0,0x43c0000,0x1c0000,0x180000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0xf,0xf,0x30,0x30,0x1c0,0x1c0,0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public TPLParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public TPLParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new TPLParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public TPLParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new TPLParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public TPLParser(TPLParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(TPLParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
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


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[41];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 19; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 41; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
