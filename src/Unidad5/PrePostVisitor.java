package Unidad5;

public interface PrePostVisitor {
	void preVisita(Object ob);
	void inVisita(Object ob);
	void postVisita(Object ob);
	boolean hecho();
}
