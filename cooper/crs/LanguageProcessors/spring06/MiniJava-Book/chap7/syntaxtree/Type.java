//// Generated by JTB GJ1.1.2//package syntaxtree;/** * Grammar production: * f0 -> ArrayType() *       | BooleanType() *       | IntegerType() *       | Identifier() */public class Type implements Node {   public NodeChoice f0;   public Type(NodeChoice n0) {      f0 = n0;   }   public void accept(visitor.Visitor v) {      v.visit(this);   }   public <R,A> R accept(visitor.GJVisitor<R,A> v, A argu) {      return v.visit(this,argu);   }   public <R> R accept(visitor.GJNoArguVisitor<R> v) {      return v.visit(this);   }   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {      v.visit(this,argu);   }}