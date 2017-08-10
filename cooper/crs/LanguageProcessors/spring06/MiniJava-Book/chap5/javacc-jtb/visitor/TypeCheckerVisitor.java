package visitor;
import syntaxtree.*;

public class TypeCheckerVisitor extends GJNoArguDepthFirst<String> {
	private static final String INT = "0";
	private static final String BOOLEAN = "1";
	private static final String INTARRAY = "2";

	private static final String TYPEERROR = "Type error";
	private static final boolean VERBOSE = false;

	private SymbolTable st;
	private Class currentClass;
	private Method currentMethod;

	private Method messageSendMethod;
	private int currentParameter;

	public TypeCheckerVisitor(SymbolTable st) {
		this.st = st;
		currentClass = null;
		currentMethod = null;
		messageSendMethod = null;
		currentParameter = 0;
	}

	private boolean isPrimitiveType(String id) {
		if(id.equals(INT) || id.equals(BOOLEAN) || id.equals(INTARRAY)) {
			return true;
		}
		else {
			return false;
		}
	}

	private boolean isValidType(String id) {
		if(isPrimitiveType(id)) {
			return true;
		}
		else {
			if(st.getClass(id) != null) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	private boolean compareTypes(String basetype, String supertype) {
		if(isPrimitiveType(basetype) || isPrimitiveType(supertype)) {
			return basetype.equals(supertype);
		}
		else {
			Class c = st.getClass(supertype);
			while(c != null) {
				if(basetype.equals(c.id())) {
					return true;
				}
				else {
					if(c.parent() == null) {
						c = null;
					}
					else {
						c = st.getClass(c.parent());
					}
				}
			}
			return false;
		}
	}

	private String getVarType(String id) {
		if(currentMethod != null) {
			if(currentMethod.getVar(id) != null) {
				return currentMethod.getVar(id).type();
			}
		}

		if(currentClass != null) {
			Class c = currentClass;
			while(c != null) {
				if(c.getVar(id) != null) {
					return c.getVar(id).type();
				}
				else {
					if(c.parent() == null) {
						c = null;
					}
					else {
						c = st.getClass(c.parent());
					}
				}
			}
		}

		System.out.println(TYPEERROR);
		if(VERBOSE) {
			System.out.println("Variable " + id + " not defined in current scope");
		}
		System.exit(0);

		return null;
	}

	private String getMethodType(String id, String classScope) {
		if(st.getClass(classScope) == null) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Class " + classScope + " not defined");
			}
			System.exit(0);
		}

		Class c = st.getClass(classScope);
		while(c != null) {
			if(c.getMethod(id) != null) {
				return c.getMethod(id).type();
			}
			else {
				if(c.parent() == null) {
					c = null;
				}
				else {
					c = st.getClass(c.parent());
				}
			}
		}

		System.out.println(TYPEERROR);
		if(VERBOSE) {
			System.out.println("Method " + id + " not defined in class " + classScope);
		}
		System.exit(0);
		return null;
	}

	private String getClassType(String id) {
		if(st.getClass(id) == null) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Class " + id + " not defined");
			}
			System.exit(0);
		}

		return st.getClass(id).type();
	}

	/**
	* f0 -> "class"
	* f1 -> Identifier()
	* f2 -> "{"
	* f3 -> "public"
	* f4 -> "static"
	* f5 -> "void"
	* f6 -> "main"
	* f7 -> "("
	* f8 -> "String"
	* f9 -> "["
	* f10 -> "]"
	* f11 -> Identifier()
	* f12 -> ")"
	* f13 -> "{"
	* f14 -> PrintStatement()
	* f15 -> "}"
	* f16 -> "}"
	*/
	public String visit(MainClass n) {
		String _ret=null;

		currentClass = st.getClass(n.f1.f0.toString());

		n.f0.accept(this);
		n.f1.accept(this);
		n.f2.accept(this);
		n.f3.accept(this);
		n.f4.accept(this);
		n.f5.accept(this);
		n.f6.accept(this);
		n.f7.accept(this);
		n.f8.accept(this);
		n.f9.accept(this);
		n.f10.accept(this);
		n.f11.accept(this);
		n.f12.accept(this);
		n.f13.accept(this);
		n.f14.accept(this);
		n.f15.accept(this);
		n.f16.accept(this);

		currentClass = null;

		return _ret;
	}

	/**
	* f0 -> ClassDeclaration()
	*       | ClassExtendsDeclaration()
	*/
	public String visit(TypeDeclaration n) {
		String _ret=null;
		n.f0.accept(this);
		return _ret;
	}

	/**
	* f0 -> "class"
	* f1 -> Identifier()
	* f2 -> "{"
	* f3 -> ( VarDeclaration() )*
	* f4 -> ( MethodDeclaration() )*
	* f5 -> "}"
	*/
	public String visit(ClassDeclaration n) {
		String _ret=null;

		currentClass = st.getClass(n.f1.f0.toString());

		n.f0.accept(this);
		n.f1.accept(this);
		n.f2.accept(this);
		n.f3.accept(this);
		n.f4.accept(this);
		n.f5.accept(this);

		currentClass = null;

		return _ret;
	}

	/**
	* f0 -> "class"
	* f1 -> Identifier()
	* f2 -> "extends"
	* f3 -> Identifier()
	* f4 -> "{"
	* f5 -> ( VarDeclaration() )*
	* f6 -> ( MethodDeclaration() )*
	* f7 -> "}"
	*/
	public String visit(ClassExtendsDeclaration n) {
		String _ret=null;

		currentClass = st.getClass(n.f1.f0.toString());

		n.f0.accept(this);
		n.f1.accept(this);
		n.f2.accept(this);

		String type = n.f3.accept(this);

		if(st.getClass(type) == null) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Base class " + type + " not defined");
			}
			System.exit(0);
		}
		n.f4.accept(this);
		n.f5.accept(this);
		n.f6.accept(this);
		n.f7.accept(this);

		currentClass = null;

		return _ret;
	}

	/**
	* f0 -> "public"
	* f1 -> Type()
	* f2 -> Identifier()
	* f3 -> "("
	* f4 -> ( FormalParameterList() )?
	* f5 -> ")"
	* f6 -> "{"
	* f7 -> ( VarDeclaration() )*
	* f8 -> ( Statement() )*
	* f9 -> "return"
	* f10 -> Expression()
	* f11 -> ";"
	* f12 -> "}"
	*/
	public String visit(MethodDeclaration n) {
		String _ret=null;

		currentMethod = currentClass.getMethod(n.f2.f0.toString());

		n.f0.accept(this);
		n.f1.accept(this);
		n.f2.accept(this);
		n.f3.accept(this);
		n.f4.accept(this);
		n.f5.accept(this);
		n.f6.accept(this);
		n.f7.accept(this);
		n.f8.accept(this);
		n.f9.accept(this);

		String returnType = n.f10.accept(this);
		if(!isValidType(returnType)) {
			returnType = getVarType(returnType);
		}

		if(!compareTypes(currentMethod.type(), returnType)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Method " + currentMethod.id() + " must be of return type " + currentMethod.type());
			}
			System.exit(0);
		}
		n.f11.accept(this);
		n.f12.accept(this);

		currentMethod = null;

		return _ret;
	}

	/**
	* f0 -> Identifier()
	* f1 -> "="
	* f2 -> Expression()
	* f3 -> ";"
	*/
	public String visit(AssignmentStatement n) {
		String _ret=null;

		String type1 = n.f0.accept(this);
		n.f1.accept(this);
		String type2 = n.f2.accept(this);
		n.f3.accept(this);


		type1 = getVarType(type1);

		if(!isValidType(type2)) {
			type2 = getVarType(type2);
		}

		if(!compareTypes(type1, type2)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Assignment values must be of same type");
			}
			System.exit(0);
		}

		return _ret;
	}

	/**
	* f0 -> Identifier()
	* f1 -> "["
	* f2 -> Expression()
	* f3 -> "]"
	* f4 -> "="
	* f5 -> Expression()
	* f6 -> ";"
	*/
	public String visit(ArrayAssignmentStatement n) {
		String _ret=null;

		String type1 = n.f0.accept(this);
		n.f1.accept(this);
		String type2 = n.f2.accept(this);
		n.f3.accept(this);
		n.f4.accept(this);
		String type3 = n.f5.accept(this);
		n.f6.accept(this);

		type1 = getVarType(type1);

		if(!isPrimitiveType(type2)) {
			type2 = getVarType(type2);
		}

		if(!isPrimitiveType(type3)) {
			type3 = getVarType(type3);
		}

		if(!type1.equals(INTARRAY)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Array Assignment Statement must have left side of type intarray");
			}
			System.exit(0);
		}

		if(!type2.equals(INT)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Array index must be of type int");
			}
			System.exit(0);
		}

		if(!type3.equals(INT)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Array Assignment Statement must have right side of type int");
			}
			System.exit(0);
		}
		return _ret;
	}

	/**
	* f0 -> "if"
	* f1 -> "("
	* f2 -> Expression()
	* f3 -> ")"
	* f4 -> Statement()
	* f5 -> "else"
	* f6 -> Statement()
	*/
	public String visit(IfStatement n) {
		String _ret=null;
		n.f0.accept(this);
		n.f1.accept(this);

		String type = n.f2.accept(this);

		if(!isPrimitiveType(type)) {
			type = getVarType(type);
		}

		if(!type.equals(BOOLEAN)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("If statement must have expression of type boolean");
			}
			System.exit(0);
		}

		n.f3.accept(this);
		n.f4.accept(this);
		n.f5.accept(this);
		n.f6.accept(this);
		return _ret;
	}

	/**
	* f0 -> "while"
	* f1 -> "("
	* f2 -> Expression()
	* f3 -> ")"
	* f4 -> Statement()
	*/
	public String visit(WhileStatement n) {
		String _ret=null;
		n.f0.accept(this);
		n.f1.accept(this);

		String type = n.f2.accept(this);

		if(!isPrimitiveType(type)) {
			type = getVarType(type);
		}

		if(!type.equals(BOOLEAN)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("While expression must have expression of type boolean");
			}
			System.exit(0);
		}

		n.f3.accept(this);
		n.f4.accept(this);
		return _ret;
	}

	/**
	* f0 -> "System.out.println"
	* f1 -> "("
	* f2 -> Expression()
	* f3 -> ")"
	* f4 -> ";"
	*/
	public String visit(PrintStatement n) {
		String _ret=null;
		n.f0.accept(this);
		n.f1.accept(this);

		String type = n.f2.accept(this);
		if(!isPrimitiveType(type)) {
			type = getVarType(type);
		}

		if(!type.equals(INT)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Print Statement must print type int");
			}
			System.exit(0);
		}

		n.f3.accept(this);
		n.f4.accept(this);
		return _ret;
	}

	/**
	* f0 -> AndExpression()
	*       | CompareExpression()
	*       | PlusExpression()
	*       | MinusExpression()
	*       | TimesExpression()
	*       | ArrayLookup()
	*       | ArrayLength()
	*       | MessageSend()
	*       | PrimaryExpression()
	*/
	public String visit(Expression n) {
		return n.f0.accept(this);
	}

	/**
	* f0 -> PrimaryExpression()
	* f1 -> "&"
	* f2 -> PrimaryExpression()
	*/
	public String visit(AndExpression n) {
		String type1 = n.f0.accept(this);

		n.f1.accept(this);

		String type2 = n.f2.accept(this);

		if(!isPrimitiveType(type1)) {
			type1 = getVarType(type1);
		}

		if(!isPrimitiveType(type2)) {
			type2 = getVarType(type2);
		}

		if(!type1.equals(BOOLEAN)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Left side of AND expression must be of type boolean");
			}
			System.exit(0);
		}
		if(!type2.equals(BOOLEAN)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Right side of AND expression must be of type boolean");
			}
			System.exit(0);
		}
		return BOOLEAN;
	}

	/**
	* f0 -> PrimaryExpression()
	* f1 -> "<"
	* f2 -> PrimaryExpression()
	*/
	public String visit(CompareExpression n) {
		String type1 = n.f0.accept(this);

		n.f1.accept(this);

		String type2 = n.f2.accept(this);

		if(!isPrimitiveType(type1)) {
			type1 = getVarType(type1);
		}

		if(!isPrimitiveType(type2)) {
			type2 = getVarType(type2);
		}

		if(!type1.equals(INT)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Left side of LESS expression msut be of type integer");
			}
			System.exit(0);
		}

		if(!type2.equals(INT)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Right side of LESS expression must be of type integer");
			}
			System.exit(0);
		}
		return BOOLEAN;
	}

	/**
	* f0 -> PrimaryExpression()
	* f1 -> "+"
	* f2 -> PrimaryExpression()
	*/
	public String visit(PlusExpression n) {
		String type1 = n.f0.accept(this);

		n.f1.accept(this);

		String type2 = n.f2.accept(this);

		if(!isPrimitiveType(type1)) {
			type1 = getVarType(type1);
		}

		if(!isPrimitiveType(type2)) {
			type2 = getVarType(type2);
		}

		if(!type1.equals(INT)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Left side of PLUS expression must be of type integer");
			}
			System.exit(0);
		}

		if(!type2.equals(INT)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Right side of PLUS expression must be of type integer");
			}
			System.exit(0);
		}
		return INT;
	}

	/**
	* f0 -> PrimaryExpression()
	* f1 -> "-"
	* f2 -> PrimaryExpression()
	*/
	public String visit(MinusExpression n) {
		String type1 = n.f0.accept(this);

		n.f1.accept(this);

		String type2 = n.f2.accept(this);

		if(!isPrimitiveType(type1)) {
			type1 = getVarType(type1);
		}

		if(!isPrimitiveType(type2)) {
			type2 = getVarType(type2);
		}

		if(!type1.equals(INT)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Left side of SUBTRACT expression must be of type integer");
			}
			System.exit(0);
		}

		if(!type2.equals(INT)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Right side of SUBTRACT expression must be of type integer");
			}
			System.exit(0);
		}
		return INT;
	}

	/**
	* f0 -> PrimaryExpression()
	* f1 -> "*"
	* f2 -> PrimaryExpression()
	*/
	public String visit(TimesExpression n) {
		String type1 = n.f0.accept(this);

		n.f1.accept(this);

		String type2 = n.f2.accept(this);

		if(!isPrimitiveType(type1)) {
			type1 = getVarType(type1);
		}

		if(!isPrimitiveType(type2)) {
			type2 = getVarType(type2);
		}

		if(!type1.equals(INT)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Left side of MULTIPLY expression must be of type integer");
			}
			System.exit(0);
		}

		if(!type2.equals(INT)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Right side of MULTIPLY expression must be of type integer");
			}
			System.exit(0);
		}
		return INT;
	}

	/**
	* f0 -> PrimaryExpression()
	* f1 -> "["
	* f2 -> PrimaryExpression()
	* f3 -> "]"
	*/
	public String visit(ArrayLookup n) {
		String type1 = n.f0.accept(this);

		n.f1.accept(this);

		String type2 = n.f2.accept(this);

		if(!isPrimitiveType(type1)) {
			type1 = getVarType(type1);
		}

		if(!isPrimitiveType(type2)) {
			type2 = getVarType(type2);
		}

		if(!type1.equals(INTARRAY)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Array lookup variable not of type array");
			}
			System.exit(0);
		}
		if(!type2.equals(INT)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Array index not of type integer");
			}
			System.exit(0);
		}
		n.f3.accept(this);
		return INT;
	}

	/**
	* f0 -> PrimaryExpression()
	* f1 -> "."
	* f2 -> "length"
	*/
	public String visit(ArrayLength n) {
		String type = n.f0.accept(this);

		if(!isPrimitiveType(type)) {
			type = getVarType(type);
		}

		if(!type.equals(INTARRAY)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Variable not of type array");
			}
			System.exit(0);
		}

		n.f1.accept(this);
		n.f2.accept(this);
		return INT;
	}

	/**
	* f0 -> PrimaryExpression()
	* f1 -> "."
	* f2 -> Identifier()
	* f3 -> "("
	* f4 -> ( ExpressionList() )?
	* f5 -> ")"
	*/
	public String visit(MessageSend n) {
		String expressionClass;
		String id = n.f2.f0.toString();
		String type;

		expressionClass = n.f0.accept(this);

		if(isPrimitiveType(expressionClass)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("MessageSend class must not be a primitive type");
			}
		}

		if(!isValidType(expressionClass)) {
			expressionClass = getVarType(expressionClass);
		}

		type = getMethodType(id, expressionClass);

		messageSendMethod = st.getClass(expressionClass).getMethod(id);

		n.f1.accept(this);
		n.f2.accept(this);
		n.f3.accept(this);
		n.f4.accept(this);
		n.f5.accept(this);
		return type;
	}

	/**
	* f0 -> Expression()
	* f1 -> ( ExpressionRest() )*
	*/
	public String visit(ExpressionList n) {
		String _ret=null;
		currentParameter = 0;

		int oldCurrentParameter = currentParameter;
		Method oldMessageSendMethod = messageSendMethod;

		String type = n.f0.accept(this);

		currentParameter = oldCurrentParameter;
		messageSendMethod = oldMessageSendMethod;

		if(type == null) {
			return _ret;
		}

		if(!isValidType(type)) {
			type = getVarType(type);
		}

		if(currentParameter >= messageSendMethod.numParameters()) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Wrong number of parameters for method " + messageSendMethod.id());
			}
			System.exit(0);
		}

		if(!compareTypes(messageSendMethod.getParameter(currentParameter).type(), type)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Parameters for method call to" + messageSendMethod.id() +" do not match types");
			}
			System.exit(0);
		}

		n.f1.accept(this);
		return _ret;
	}

	/**
	* f0 -> ","
	* f1 -> Expression()
	*/
	public String visit(ExpressionRest n) {
		String _ret=null;
		currentParameter++;

		int oldCurrentParameter = currentParameter;
		Method oldMessageSendMethod = messageSendMethod;

		n.f0.accept(this);
		String type = n.f1.accept(this);

		currentParameter = oldCurrentParameter;
		messageSendMethod = oldMessageSendMethod;

		if(type == null) {
			return _ret;
		}

		if(!isValidType(type)) {
			type = getVarType(type);
		}

		if(currentParameter >= messageSendMethod.numParameters()) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Wrong number of parameters for method " + messageSendMethod.id());
			}
			System.exit(0);
		}

		if(!compareTypes(messageSendMethod.getParameter(currentParameter).type(), type)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Parameters for method call to" + messageSendMethod.id() +" do not match types");
			}
			System.exit(0);
		}
		
		return _ret;
	}

	/**
	* f0 -> IntegerLiteral()
	*       | TrueLiteral()
	*       | FalseLiteral()
	*       | Identifier()
	*       | ThisExpression()
	*       | ArrayAllocationExpression()
	*       | AllocationExpression()
	*       | NotExpression()
	*       | BracketExpression()
	*/
	public String visit(PrimaryExpression n) {
		String type = n.f0.accept(this);
		return type;
	}

	/**
	* f0 -> <INTEGER_LITERAL>
	*/
	public String visit(IntegerLiteral n) {
		n.f0.accept(this);
		return INT;
	}

	/**
	* f0 -> "true"
	*/
	public String visit(TrueLiteral n) {
		n.f0.accept(this);
		return BOOLEAN;
	}

	/**
	* f0 -> "false"
	*/
	public String visit(FalseLiteral n) {
		n.f0.accept(this);
		return BOOLEAN;
	}

	/**
	* f0 -> <IDENTIFIER>
	*/
	public String visit(Identifier n) {
		n.f0.accept(this);
		return n.f0.toString();
	}

	/**
	* f0 -> "this"
	*/
	public String visit(ThisExpression n) {
		n.f0.accept(this);
		return currentClass.id();
	}

	/**
	* f0 -> "new"
	* f1 -> "int"
	* f2 -> "["
	* f3 -> Expression()
	* f4 -> "]"
	*/
	public String visit(ArrayAllocationExpression n) {
		n.f0.accept(this);
		n.f1.accept(this);
		n.f2.accept(this);

		String type = n.f3.accept(this);
		if(!isPrimitiveType(type)) {
			type = getVarType(type);
		}

		if(!type.equals(INT)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Array size must be of type integer");
			}
			System.exit(0);
		}
		n.f4.accept(this);
		return INTARRAY;
	}

	/**
	* f0 -> "new"
	* f1 -> Identifier()
	* f2 -> "("
	* f3 -> ")"
	*/
	public String visit(AllocationExpression n) {
		String type = getClassType(n.f1.f0.toString());

		n.f0.accept(this);
		n.f1.accept(this);
		n.f2.accept(this);
		n.f3.accept(this);
		return type;
	}

	/**
	* f0 -> "!"
	* f1 -> Expression()
	*/
	public String visit(NotExpression n) {
		n.f0.accept(this);
		String type = n.f1.accept(this);

		if(!isPrimitiveType(type)) {
			type = getVarType(type);
		}

		if(!type.equals(BOOLEAN)) {
			System.out.println(TYPEERROR);
			if(VERBOSE) {
				System.out.println("Boolean required for not");
			}
			System.exit(0);
		}

		return BOOLEAN;
   	}

	/**
	* f0 -> "("
	* f1 -> Expression()
	* f2 -> ")"
	*/
	public String visit(BracketExpression n) {
		n.f0.accept(this);
		String type = n.f1.accept(this);
		n.f2.accept(this);
		return type;
	}
}

