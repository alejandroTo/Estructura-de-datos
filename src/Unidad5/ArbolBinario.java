package Unidad5;

public class ArbolBinario {
	protected Object info;
	protected ArbolBinario izquierdo;
	protected ArbolBinario derecho;
	
	public ArbolBinario(Object info, ArbolBinario izquierdo, ArbolBinario derecho) {
		this.info = info;
		this.izquierdo = izquierdo;
		this.derecho = derecho;
	}
	
	public ArbolBinario() {
		this(null, null, null);
	}
	
	public ArbolBinario(Object info) {
		this(info, new ArbolBinario(), new ArbolBinario());
	}
	
	public void limpiar() {
		this.info = null;
		this.izquierdo = null;
		this.derecho = null;
	}
	
	public boolean isVacio() {
		return info == null && izquierdo == null && derecho == null;
	}
	
	public void recorridoEnProfundidad(PrePostVisitor visitor) {
		if(!isVacio()) {
			visitor.preVisita(info);
			izquierdo.recorridoEnProfundidad(visitor);
			visitor.inVisita(info);
			derecho.recorridoEnProfundidad(visitor);
			visitor.postVisita(info);
		}
	}
	
	public ArbolBinario getIzquierdo(){
        return izquierdo;
    }
    
    public ArbolBinario getDerecho(){
        return derecho;
    }
}
