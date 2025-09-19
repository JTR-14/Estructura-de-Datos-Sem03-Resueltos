/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio02;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class VectorNumeros {
    private int[] lista;
    private int totalElementos;

    public VectorNumeros() {
        lista = new int[50];
        totalElementos = 0;
    }

    public void agregar(int valor) {
        if (totalElementos < lista.length) {
            lista[totalElementos] = valor;
            totalElementos++;
            JOptionPane.showMessageDialog(null, "Número ingresado correctamente", "MENSAJE", 1);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo ingresar número. Vector lleno", "ERROR", 0);
        }
    }

    public void ordenar() {
        for (int i = 0; i < totalElementos - 1; i++) {
            for (int j = 0; j < totalElementos - 1 - i; j++) {
                if (lista[j] > lista[j + 1]) {
                    int aux = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = aux;
                }
            }
        }
    }

    public int buscarLinealOrdenada(int valor) {
        ordenar();
        for (int i = 0; i < totalElementos; i++) {
            if (lista[i] == valor) {
                return i;
            } else if (lista[i] > valor) {
                return -1;
            }
        }
        return -1;
    }

    public int mostrarEncontrado(int valor) {
        int posicion = buscarLinealOrdenada(valor);
        if (posicion != -1) {
            return lista[posicion];
        }
        return -1;
    }

    public void mostrar(DefaultListModel modelo) {
        modelo.removeAllElements();
        for (int i = 0; i < totalElementos; i++) {
            modelo.addElement(lista[i]);
        }
   }
}
