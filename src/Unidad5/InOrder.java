package Unidad5;

public class InOrder extends AbstractPrePostVisitor{
	protected Visitor visitor;
	
	public InOrder(Visitor visitor) {
		this.visitor = visitor;
	}
	
	public void inVisita(Object ob) {
		visitor.visit(ob);
	}
	
	public boolean hecho() {
		return visitor.hecho();
	}
}
