import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

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
			nodoInicio = nodoInicio.getnSiguiente();
			nodoFin=nodoInicio;
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
		
		ListaEnlazada le = new ListaEnlazada();
		
		Scanner ent = new Scanner(System.in);
		
		boolean salir = false;
		
		
		do {
			
			System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar elemento");
            System.out.println("3. Mostrar elementos");
            System.out.println("4. Salir ");
           
            try {
            	System.out.println("Escribe una de las opciones\n");
                int opcion = ent.nextInt();
 
                switch (opcion) {
                    case 1:
                    	
                    	boolean salir1 = false;
                		
                		do {
                			
                			System.out.println("1. Insertar elemento al inicio");
                            System.out.println("2. Insertar elemento al final");
                            System.out.println("3. Salir");
                           
                            try {
                            	System.out.println("Escribe una de las opciones\n");
                                int opcion1 = ent.nextInt();
                 
                                switch (opcion1) {
                                    case 1:
                                    	System.out.println("Escribe el dato a ingresar: ");
                                    	int info = ent.nextInt();
                                        le.agregarElementoAlInicio(info);
                                        break;
                                    case 2:
                                    	System.out.println("Escribe el dato a ingresar: ");
                                    	int info1 = ent.nextInt();
                                        le.agregarElementoAlFinal(info1);
                                        break;
                                    case 3:
                                        salir1 = true;
                                        break;
                                    default:
                                        System.out.println("Debes ingresar números entre 1 y 3");
                                }
                				
                			} catch (InputMismatchException e) {
                				System.out.println("Debes ingresar un número");
                                ent.next();
                				
                			}
                            
                            
                			
                		}while (!salir1);//while
                        
                        break;
                    case 2:
                        
                    	boolean salir2 = false;
                		
                		do {
                			
                			System.out.println("1. Eliminar elemento al inicio");
                            System.out.println("2. Eliminar elemento al final");
                            System.out.println("3. Eliminar dato específico");
                            System.out.println("4. Salir");
                           
                            try {
                            	System.out.println("Escribe una de las opciones\n");
                                int opcion1 = ent.nextInt();
                 
                                switch (opcion1) {
                                    case 1:
                                        le.eliminarElementoAlInicio();
                                        break;
                                    case 2:
                                        le.eliminarElementoAlFinal();
                                        break;
                                    case 3:
                                    	System.out.println("Ingresa el dato a eliminar: ");
                                    	int info2 = ent.nextInt();
                                    	
                                    	int num = le.eliminarDatoEspecifico(info2);
                                    	System.out.println(num == -1? "Lista vacía":"Se eliminó correctamente");
                                    	
                                    	if (num == -1)
                                    		System.out.println("Lista vacía");
                                    	else if (num == -2)
                                    		System.out.println("No se encontró el dato");
                                    	else
                                    		System.out.println("Se eliminó el " + num + " correctamente");
                                    	
                                    	break;
                                    case 4:
                                        salir2 = true;
                                        break;
                                    default:
                                        System.out.println("Debes ingresar números entre 1 y 4");
                                }
                				
                			} catch (InputMismatchException e) {
                				System.out.println("Debes ingresar un número");
                                ent.next();
                				
                			}
                            
                            
                			
                		}while (!salir2);//while
                    	
                        break;
                    case 3:
                    	le.mostrarElementos();
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Debes ingresar números entre 1 y 4");
                }
				
			} catch (InputMismatchException e) {
				System.out.println("Debes ingresar un número");
                ent.next();
				
			}
            
            
			
		}while (!salir);//while
		
		
		
	}

}
