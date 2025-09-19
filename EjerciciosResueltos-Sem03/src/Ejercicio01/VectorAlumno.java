/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio01;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VectorAlumno {
    private Alumno lista[];
    private int totalElementos; 

    public VectorAlumno() {
        lista = new Alumno[50];
        totalElementos = 0;
    }

    public void agregar(Alumno alumno) {
        if (totalElementos < lista.length) {
            lista[totalElementos] = alumno;
            totalElementos++;
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio en el vector", "ERROR", 0);
        }
    }

    private int buscar(String codigo) {
        for (int i = 0; i < totalElementos; i++) {
            if (lista[i].getCodigo().equals(codigo)) {
                if (i != 0) {
                    Alumno encontrado = lista[i];

                    for (int j = i; j > 0; j--) {
                        lista[j] = lista[j - 1];
                    }
                    lista[0] = encontrado;
                    return 0;
                }
                return i;
            }
        }
        return -1; 
    }


    public Alumno obtenerAlumno(String codigo) {
        int posicion = buscar(codigo);
        if (posicion != -1) {
            return lista[posicion];
        }
        return null;
    }

    public void mostrar(DefaultTableModel modelo, String codigo) {
        Alumno encontrado = obtenerAlumno(codigo);
        if (encontrado != null) {
            Object fila[] = {
                encontrado.getCodigo(),
                encontrado.getNombre(),
                encontrado.getApellido()
            };
            modelo.addRow(fila);
        } else {
            JOptionPane.showMessageDialog(null, "El código no le pertenece a ningún estudiante", "ERROR", 0);
        }
    }

}
