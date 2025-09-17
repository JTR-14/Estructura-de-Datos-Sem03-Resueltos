/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio02;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class ArrayListNumeros {
    ArrayList<Integer>  lista;

    public ArrayListNumeros() {
       lista  = new ArrayList<>();
    }
     public void agregar(int valor) {
        if(lista.add(valor))
            JOptionPane.showMessageDialog(null, "Numero ingresado Correctamente","MENSAJE",1);
        else
             JOptionPane.showMessageDialog(null, "No se pudo ingresar Numero","ERROR",0);
    }

    public void ordenar() {
        Collections.sort(lista);
    }
    public int buscarLinealOrdenada(int valor){
        ordenar();
        for(int i=0 ; i<lista.size(); i++ ){
            if(lista.get(i)==valor)
                return i;
            else if(lista.get(i)>valor)
                return -1;
        }
        return -1;
    }
    public int mostrarEncontrado(int valor){
        int posicion =  buscarLinealOrdenada(valor);
        if(posicion !=-1)
            return lista.get(posicion);
        return -1;
    }
    public void mostrar(DefaultListModel modelo){
        modelo.removeAllElements();
        for(int i=0 ; i<lista.size(); i++ ){
            modelo.addElement(lista.get(i));
        }
    }
}
