/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio03;

import javax.swing.table.DefaultTableModel;

public class VectorClientes {
    private Cliente vector[];
    private int totalElementos;
    
    public VectorClientes(){
        totalElementos = 0;
        vector = new Cliente[50];
    }
    
    public void agregar(Cliente cliente){
        if(totalElementos < vector.length){
            vector[totalElementos] = cliente;
            totalElementos++;
        }
    }
    
    public void mostrar(DefaultTableModel modelo){
        Object datos[][] = new Object[totalElementos][3];
        String titulos[] = {"Codigo","Nombre","Saldo"};
        for(int i = 0 ; i < totalElementos ; i++){
            datos[i][0] = vector[i].getCodigo();
            datos[i][1] = vector[i].getNombre();
            datos[i][2] = vector[i].getSaldo();
        }
        modelo.setDataVector(datos, titulos);
    }
    
    public void ordenarPorNombre() {
        if (totalElementos > 1) {
            quicksort(0, totalElementos - 1);
        }
    }
    
    private void quicksort(int bajo, int alto) {
        if (bajo < alto) {
            int indiceParticion = particion(bajo, alto);
            quicksort(bajo, indiceParticion - 1);
            quicksort(indiceParticion + 1, alto);
        }
    }

    private int particion(int bajo, int alto) {
        String pivote = vector[alto].getNombre();
        int i = (bajo - 1);
        
        for (int j = bajo; j < alto; j++) {
            if (vector[j].getNombre().compareTo(pivote) <= 0) {
                i++;
                Cliente temp = vector[i];
                vector[i] = vector[j];
                vector[j] = temp;
            }
        }
        Cliente temp = vector[i + 1];
        vector[i + 1] = vector[alto];
        vector[alto] = temp;

        return i + 1;
    }

    public int busquedaBinaria(String nombreBuscado) {
        return busquedaBinariaRecursiva(nombreBuscado, 0, totalElementos - 1);
    }
    
    private int busquedaBinariaRecursiva(String nombreBuscado, int izq, int der) {
        if (izq > der) {
            return -1;
        }

        int central = (der + izq) / 2;
        int comparacion = vector[central].getNombre().compareTo(nombreBuscado);

        if (comparacion == 0) {
            return central;
        }
        if (comparacion < 0) {
            return busquedaBinariaRecursiva(nombreBuscado, central + 1, der);
        }
        return busquedaBinariaRecursiva(nombreBuscado, izq, central - 1);
    }

    public Cliente obtenerCliente(String nombreBuscado){
        
        int indice = busquedaBinaria(nombreBuscado);
        
        if (indice != -1) {
            return vector[indice];
        }
        return null;
    }

    public boolean mostrarEncontrado(DefaultTableModel modelo, String nombreBuscado){
        Object datos[][] = new Object[1][3];
        String titulos[] = {"Codigo","Nombre","Saldo"};
        
        Cliente cliente = obtenerCliente(nombreBuscado);
        
        if (cliente != null) {
            datos[0][0] = cliente.getCodigo();
            datos[0][1] = cliente.getNombre();
            datos[0][2] = cliente.getSaldo();
            modelo.setDataVector(datos, titulos);
            return true;
        }
        return false;
    }
}
