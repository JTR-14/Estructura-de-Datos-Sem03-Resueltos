/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio01;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ArrayListAlumno {
    ArrayList<Alumno> lista;

    public ArrayListAlumno() {
        lista = new ArrayList<>();
    }
    public void agregar(Alumno alumno){
        lista.add(alumno);
    }
    
     public int buscar(String codigo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCodigo().equals(codigo)) {
                if (i != 0) {
                    Alumno encontrado = lista.get(i);
                    lista.remove(i);
                    lista.add(0, encontrado); 
                }
                return i; 
            }
        }
        return -1;
    }
     public Alumno obtenerAlumno(String codigo){
        int posicion;
        posicion = buscar(codigo);
        if(posicion !=-1)
            return lista.get(posicion);
        return null;
     }
     public void mostrar(DefaultTableModel modelo, String codigo){
        Alumno encontrado = obtenerAlumno(codigo);
        if(encontrado != null){
          Object fila[] ={ 
            encontrado.getCodigo(),
            encontrado.getNombre(),
            encontrado.getApellido(),
        }; 
          modelo.addRow(fila);
        }
        else
            JOptionPane.showMessageDialog(null, "El codigo no le pertenece a ningun estudiante","ERROR",0);
    }
}
