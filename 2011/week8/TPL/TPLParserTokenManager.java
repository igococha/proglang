/* Generated By:JJTree&JavaCC: Do not edit this line. TPLParserTokenManager.java */

public class TPLParserTokenManager implements TPLParserConstants
{
private static final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0xdffc0L) != 0L)
         {
            jjmatchedKind = 20;
            return 2;
         }
         return -1;
      case 1:
         if ((active0 & 0xdbec0L) != 0L)
         {
            jjmatchedKind = 20;
            jjmatchedPos = 1;
            return 2;
         }
         if ((active0 & 0x4100L) != 0L)
            return 2;
         return -1;
      case 2:
         if ((active0 & 0xa000L) != 0L)
            return 2;
         if ((active0 & 0xd1ec0L) != 0L)
         {
            jjmatchedKind = 20;
            jjmatchedPos = 2;
            return 2;
         }
         return -1;
      case 3:
         if ((active0 & 0x40e40L) != 0L)
            return 2;
         if ((active0 & 0x91080L) != 0L)
         {
            jjmatchedKind = 20;
            jjmatchedPos = 3;
            return 2;
         }
         return -1;
      case 4:
         if ((active0 & 0x10000L) != 0L)
         {
            jjmatchedKind = 20;
            jjmatchedPos = 4;
            return 2;
         }
         if ((active0 & 0x81080L) != 0L)
            return 2;
         return -1;
      case 5:
         if ((active0 & 0x10000L) != 0L)
         {
            jjmatchedKind = 20;
            jjmatchedPos = 5;
            return 2;
         }
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private final int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private final int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static private final int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         return jjMoveStringLiteralDfa1_0(0x40000000L);
      case 40:
         return jjStopAtPos(0, 25);
      case 41:
         return jjStopAtPos(0, 26);
      case 42:
         return jjStopAtPos(0, 37);
      case 43:
         return jjStopAtPos(0, 35);
      case 45:
         return jjStopAtPos(0, 36);
      case 47:
         return jjStopAtPos(0, 38);
      case 59:
         return jjStopAtPos(0, 23);
      case 60:
         jjmatchedKind = 31;
         return jjMoveStringLiteralDfa1_0(0x200000000L);
      case 61:
         jjmatchedKind = 24;
         return jjMoveStringLiteralDfa1_0(0x20000000L);
      case 62:
         jjmatchedKind = 32;
         return jjMoveStringLiteralDfa1_0(0x400000000L);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x2000L);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x10000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x400L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x80000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x8100L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x4000L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x800L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x40L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x40200L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x1080L);
      case 123:
         return jjStopAtPos(0, 27);
      case 125:
         return jjStopAtPos(0, 28);
      default :
         return jjMoveNfa_0(1, 0);
   }
}
static private final int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 61:
         if ((active0 & 0x20000000L) != 0L)
            return jjStopAtPos(1, 29);
         else if ((active0 & 0x40000000L) != 0L)
            return jjStopAtPos(1, 30);
         else if ((active0 & 0x200000000L) != 0L)
            return jjStopAtPos(1, 33);
         else if ((active0 & 0x400000000L) != 0L)
            return jjStopAtPos(1, 34);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x800L);
      case 102:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(1, 8, 2);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x280L);
      case 107:
         return jjMoveStringLiteralDfa2_0(active0, 0x40L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x400L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0xa000L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000L);
      case 114:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(1, 14, 2);
         return jjMoveStringLiteralDfa2_0(active0, 0x41000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private final int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x800L);
      case 100:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(2, 13, 2);
         break;
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x200L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x10c0L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x80000L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x400L);
      case 116:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(2, 15, 2);
         break;
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private final int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 100:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(3, 11, 2);
         break;
      case 101:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(3, 10, 2);
         else if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(3, 18, 2);
         break;
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x10080L);
      case 110:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(3, 9, 2);
         break;
      case 112:
         if ((active0 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(3, 6, 2);
         break;
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x80000L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private final int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(4, 7, 2);
         else if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(4, 12, 2);
         else if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(4, 19, 2);
         return jjMoveStringLiteralDfa5_0(active0, 0x10000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private final int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x10000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private final int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 110:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(6, 16, 2);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
static private final void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private final void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private final void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}
static private final void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}
static private final void jjCheckNAddStates(int start)
{
   jjCheckNAdd(jjnextStates[start]);
   jjCheckNAdd(jjnextStates[start + 1]);
}
static private final int jjMoveNfa_0(int startState, int curPos)
{
   int[] nextStates;
   int startsAt = 0;
   jjnewStateCnt = 3;
   int i = 1;
   jjstateSet[0] = startState;
   int j, kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 1:
               case 0:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAdd(0);
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 1:
               case 2:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjCheckNAdd(2);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 3 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
};
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, "\163\153\151\160", "\167\150\151\154\145", 
"\151\146", "\164\150\145\156", "\145\154\163\145", "\162\145\141\144", 
"\167\162\151\164\145", "\141\156\144", "\157\162", "\151\156\164", "\142\157\157\154\145\141\156", 
null, "\164\162\165\145", "\146\141\154\163\145", null, null, null, "\73", "\75", 
"\50", "\51", "\173", "\175", "\75\75", "\41\75", "\74", "\76", "\74\75", "\76\75", 
"\53", "\55", "\52", "\57", };
public static final String[] lexStateNames = {
   "DEFAULT", 
};
static final long[] jjtoToken = {
   0x7fff9fffc1L, 
};
static final long[] jjtoSkip = {
   0x3eL, 
};
static private ASCII_CharStream input_stream;
static private final int[] jjrounds = new int[3];
static private final int[] jjstateSet = new int[6];
static protected char curChar;
public TPLParserTokenManager(ASCII_CharStream stream)
{
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}
public TPLParserTokenManager(ASCII_CharStream stream, int lexState)
{
   this(stream);
   SwitchTo(lexState);
}
static public void ReInit(ASCII_CharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private final void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 3; i-- > 0;)
      jjrounds[i] = 0x80000000;
}
static public void ReInit(ASCII_CharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}
static public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static private final Token jjFillToken()
{
   Token t = Token.newToken(jjmatchedKind);
   t.kind = jjmatchedKind;
   String im = jjstrLiteralImages[jjmatchedKind];
   t.image = (im == null) ? input_stream.GetImage() : im;
   t.beginLine = input_stream.getBeginLine();
   t.beginColumn = input_stream.getBeginColumn();
   t.endLine = input_stream.getEndLine();
   t.endColumn = input_stream.getEndColumn();
   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

public static final Token getNextToken() 
{
  int kind;
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { 
      while (curChar <= 32 && (0x100003600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

}
