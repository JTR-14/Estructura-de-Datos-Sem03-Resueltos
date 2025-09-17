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
      if(totalElementos<vector.length){
          vector[totalElementos] = cliente;
          totalElementos++;
      }     
    }
    public void mostrar(DefaultTableModel modelo){
       Object datos[][] = new Object[totalElementos][3];
       String titulos[] = {"Codigo","Nombre","Saldo"};
       for(int i=0 ; i<totalElementos ; i++){
           datos[i][0] = vector[i].getCodigo();
           datos[i][1] = vector[i].getNombre();
           datos[i][2] = vector[i].getSaldo();
       }
       modelo.setDataVector(datos, titulos);
    }
}
