package Unidad5;

import javax.swing.JOptionPane;

import listasEnlazadas2.LinkedList.Element;

public class ArbolBinarioDeBusqueda extends ArbolBinario implements SearchTree{
	public ArbolBinarioDeBusqueda getABBizquierdo() {
		return (ArbolBinarioDeBusqueda) getIzquierdo();
	}
    
    public ArbolBinarioDeBusqueda getABBderecho() {
    	return (ArbolBinarioDeBusqueda) getDerecho();
    }
    
    public Comparable find(Comparable object){
    	if(isVacio()) {
    		return null;
    	}
    	else {
    		int diff = object.compareTo(info);
    		if(diff == 0) {
    			return (Comparable)info;
    		}
    		else {
    			if(diff < 0) {
    				return getABBizquierdo().find(object);
    			}
    			else {
    				return getABBderecho().find(object);
    			}
    		}
    	}
    }
    public Comparable<Object> findMin() {
    	if(isVacio()) {
    		return null;
    	}
    	else {
    		if(getABBizquierdo().isVacio()) {
    			return (Comparable)info;
    		}
    		else {
    			return getABBizquierdo().findMin();
    		}
    	}
    }
    public Comparable <Object> findMax() {
    	if(isVacio()) {
    		return null;
    	}
    	else {
    		if(getABBderecho().isVacio()) {
    			return (Comparable)info;
    		}
    		else {
    			return getABBderecho().findMax();
    		}
    	}
    }
    public void insertar(Comparable object)
    {
    	
    	if(isVacio()) {
    		try {
    			agregarInfo(object);
    		} catch (InvalidOperationException e) {
    			JOptionPane.showMessageDialog(null, "No inserccion");	
    		}
	}
    	else {
    		int diff = object.compareTo((Comparable)info);
    		if(diff == 0) {
    			System.out.println("Cadena duplicada. "+info);
    		}
    		else {
    			if(diff < 0) {
    				getABBizquierdo().insertar(object);
    			}
    			else {
    				getABBderecho().insertar(object);
    			}
    		}
    	}
    }
    /*public boolean contains(String compara)
    {
    	if(compara.equals(info))
    	{
    		JOptionPane.showMessageDialog(null,"Existe el elemento");
    		return true;
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(null,"No Existe el elemento");
    		return false;
    	}
    }*/
    public void agregarInfo(Object object) throws InvalidOperationException {
    	if(!isVacio()) {
    		throw new InvalidOperationException();
    	}
    	else {
    		info = object;
    		izquierdo = new ArbolBinarioDeBusqueda();
    		derecho = new ArbolBinarioDeBusqueda();
    	}
    }
}
