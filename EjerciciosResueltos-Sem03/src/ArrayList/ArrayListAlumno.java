/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArrayList;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ArrayListAlumno {
    private ArrayList<Alumno> lista;
    
    public ArrayListAlumno(){
        lista = new ArrayList<>();
    }
    public void agregarAlumno(Alumno alumno){
        lista.add(alumno);
    }
    public int busquedaAlumno(String codigo){
        Alumno alumno = new Alumno(codigo);
        return lista.indexOf(alumno);
    }
    public Alumno obtenerAlumnoPorCodigo(String codigo){
        int pos = busquedaAlumno(codigo);
        if(pos!=-1)
            return lista.get(pos);
        return null;
        }
    public void mostrar(DefaultTableModel modelo, String codigo){
        Alumno encontrado = obtenerAlumnoPorCodigo(codigo);
        if(encontrado != null){
          Object fila[] ={ 
            encontrado.getCodigo(),
            encontrado.getNombre(),
            encontrado.getApellido(),
            encontrado.getNota(),
        }; 
          modelo.addRow(fila);
        }
        else
            JOptionPane.showMessageDialog(null, "El codigo no le pertenece a ningun estudiante","ERROR",0);
    }
}
    