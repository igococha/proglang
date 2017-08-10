class prog {

// example prog from Appel book
static Stm prog = 
new CompoundStm(new AssignStm("a",new OpExp(new NumExp(5), OpExp.Plus, 
					    new NumExp(3))),
 new CompoundStm(new AssignStm("b",
     new EseqExp(new PrintStm(new PairExpList(new IdExp("a"),
                       new LastExpList(new OpExp(new IdExp("a"), OpExp.Minus,
				  	         new NumExp(1))))),
             new OpExp(new NumExp(10), OpExp.Times, new IdExp("a")))),
  new PrintStm(new LastExpList(new IdExp("b")))));

// example 2
static Stm prog2 = new PrintStm(new LastExpList(new NumExp(52)));

// example 3
static Stm prog3 = 
      new CompoundStm(
              new PrintStm(new PairExpList(new NumExp(52), 
                         new LastExpList( new NumExp(53) ) )),
              new PrintStm(new PairExpList(new NumExp(54), 
                         new LastExpList( new NumExp(55) ) ))
                    );

// example 4
static Stm prog4 =
         new CompoundStm(
            new AssignStm("b",new NumExp(3)),
            new CompoundStm(
              new PrintStm(new PairExpList(new NumExp(52), 
                         new LastExpList( new NumExp(53) ) )),
              new PrintStm(new PairExpList(new NumExp(54), 
                         new LastExpList( new IdExp("b") ) ))
            )
         );

// example 5

static Stm prog5 = null; /* do a prog with an assig nested in a print */

}
