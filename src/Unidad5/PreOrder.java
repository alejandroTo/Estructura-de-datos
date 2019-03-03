package Unidad5;

public class PreOrder extends AbstractPrePostVisitor{
	protected Visitor visitor;
	
	public PreOrder(Visitor visitor) {
		this.visitor = visitor;
	}
	
	public void preVisita(Object ob) {
		visitor.visit(ob);
	}
	
	public boolean hecho() {
		return visitor.hecho();
	}
}
