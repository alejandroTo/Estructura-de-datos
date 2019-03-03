package Unidad5;

public class PostOrder extends AbstractPrePostVisitor{
	protected Visitor visitor;
	
	public PostOrder(Visitor visitor) {
		this.visitor = visitor;
	}
	
	public void postVisita(Object ob) {
		visitor.visit(ob);
	}
	
	public boolean hecho() {
		return visitor.hecho();
	}
}
