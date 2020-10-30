
/* OPERACIONES BÁSICAS DE LAS LISTAS ENLAZADAS
 * 1) Creacion
 * 2) Verificar no vacia
 * 3) Agregar elemento
 * 		2a) Al inicio
 * 		2b) Al final
 * 		2c) En un lugar específico
 * 4) Eliminar elemento
 * 		3a) Al inicio
 * 		3b) Al final
 * 		3c) Un dato específico
 * 5) Recorrer lista (mostrar elemento)
 * 
 * 6) Buscar elemento
 * 7) Vaciar lista
 * 8) Mostrar cantidad elementos */

class Nodo{
	private int info;
	private Nodo nSiguiente;
	
	public Nodo(){}
	public Nodo(int info) {
		this.info = info;
	}
	
	public int getInfo() {return info;}
	public void setInfo(int info) {
		this.info = info;}
	public Nodo getnSiguiente() {return nSiguiente;}
	public void setnSiguiente(Nodo nSiguiente) {
		this.nSiguiente = nSiguiente;}
	
}//class Nodo


class ListaEnlazada{
	Nodo nodoInicio;
	Nodo nodoFin;
	
	// 1) Creación
	public ListaEnlazada() {
		nodoInicio = nodoFin = null;
	}
	
	// 2) Verificar Lista vacia
	public boolean vacia() {
		return nodoInicio == null;
	}
	
	// 3a) Agregar elemento al inicio
	public void agregarElementoAlInicio(int info){
		
		Nodo nuevoNodo = new Nodo(info);
		
		if(vacia()) {
			//lista vacia
			nodoInicio=nodoFin=nuevoNodo;
		}else {
			//ya tiene nodos
			nuevoNodo.setnSiguiente(nodoInicio);
			nodoInicio = nuevoNodo;
		}
	}
	
	// 3b) Agregar elemento al final
	public void agregarElementoAlFinal(int info) {
		
		Nodo nuevoNodo = new Nodo (info);
		
		if(vacia()) {
			//lista vacia
			nodoInicio=nodoFin=nuevoNodo;
		}else {
			nodoFin.setnSiguiente(nuevoNodo);
			nodoFin = nuevoNodo;
			
		}
		
	}
	
	//4a) eliminar elemento al inicio
	public void eliminarElementoAlInicio() {
		if (vacia()) {
			System.out.println("La lista está vacía");
		}else if (nodoInicio == nodoFin){
			nodoInicio = nodoFin = null;
		}else {
			Nodo nodoActual=nodoInicio;
			nodoInicio=nodoActual.getnSiguiente();
		}
	}
	
	//4b) eliminar elemanto al final
	public void eliminarElementoAlFinal() {
		if (vacia()) {
			System.out.println("La lista está vacía");
		}else if (nodoInicio == nodoFin){
			nodoInicio = nodoFin = null;
		}else {
			Nodo nodoAnterior, nodoSiguiente;
			nodoAnterior = nodoInicio;
			nodoSiguiente = nodoInicio.getnSiguiente();
			if (nodoSiguiente==null) {
				nodoInicio=nodoFin=null;
			}else {
				while(nodoSiguiente.getnSiguiente()!=null) {
					nodoAnterior = nodoAnterior.getnSiguiente();
					nodoSiguiente = nodoSiguiente.getnSiguiente();
				}
				nodoAnterior.setnSiguiente(null);
			}
		}
		
	}
		
		
	//4c) eliminar un dato específico
	public int eliminarDatoEspecifico(int info) {
		if (vacia()) {
			//lista vacia
			return -1;
		}else if(nodoInicio == nodoFin && nodoInicio.getInfo() == info){
			// hay un solo nodo
			System.out.println("Encontrado en el primer nodo");
			int n = nodoInicio.getInfo();
			nodoInicio = nodoFin = null;
			return n;
		}else {
			// hay más de un nodo y la informacion puede estar en alguno de ellos
			Nodo nodoAnterior, nodoSiguiente;
			nodoAnterior = nodoInicio;
			nodoSiguiente = nodoInicio.getnSiguiente();
			
			while (nodoSiguiente != null && nodoSiguiente.getInfo() != info) {
				nodoAnterior = nodoAnterior.getnSiguiente();
				nodoSiguiente = nodoSiguiente.getnSiguiente();
			}
			
			if (nodoSiguiente != null && nodoSiguiente.getInfo() == info) {
				int n = nodoInicio.getInfo();
				nodoAnterior.setnSiguiente(nodoSiguiente.getnSiguiente());
				nodoSiguiente = nodoSiguiente.getnSiguiente();
				return n;
			}else {
				return -2;
			}	
		}
		
	}
	
	
	// 5) Recorrer lista (mostrar elemento)
	public void mostrarElementos() {
		Nodo nodoActual = nodoInicio;
		
		while (nodoActual != null) {
			System.out.print("["+nodoActual.getInfo()+"]-->");
			nodoActual = nodoActual.getnSiguiente();
		}
	}
	
	
}//class ListaEnlazada

public class ListasEnlazadas {

	public static void main(String[] args) {
		
		ListaEnlazada le1 = new ListaEnlazada();
		
		System.out.println(le1.eliminarDatoEspecifico(3)==-1?"Lista Vacia":"Se eliminó correctamente");
		
		le1.agregarElementoAlInicio(7);
		le1.agregarElementoAlInicio(3);
		le1.agregarElementoAlInicio(10);
		
		le1.mostrarElementos();
		
		
		int num = le1.eliminarDatoEspecifico(7);
		System.out.println(num==-1?"Lista Vacia":"Se eliminó correctamente");
		
		if (num == -1)
			System.out.println("Lista vacia");
		else if(num == -2) 
			System.out.println("No se encontró el dato");
		else
			System.out.println("Se eliminó el " +num+ " correctamente");
			
		System.out.println();
		le1.agregarElementoAlFinal(4);
		
		le1.mostrarElementos();
		System.out.println();
		le1.eliminarElementoAlInicio();
		le1.mostrarElementos();
		System.out.println();
		le1.eliminarElementoAlFinal();
		le1.mostrarElementos();
	}

}
