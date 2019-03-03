package Unidad2.as;

public interface InterfaceStack{
	boolean isEmpety();
	boolean isFull();
	Object getTop();
	void push (Object ob);
	Object pop();
}