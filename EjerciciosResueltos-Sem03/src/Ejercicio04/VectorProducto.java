/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio04;


import javax.swing.table.DefaultTableModel;


public class VectorProducto {
    private Producto vector[];
    private int totalElementos;

    public VectorProducto() {
        vector = new Producto[50];
        totalElementos = 0;
    }
      public void agregar(Producto producto){
      if(totalElementos<vector.length){
          vector[totalElementos] = producto;
          totalElementos++;
      }     
    }
    public void mostrar(DefaultTableModel modelo){
       Object datos[][] = new Object[totalElementos][5];
       String titulos[] = {"Codigo","Descripcion","Precio","Stock","Categoria"};
       for(int i=0 ; i<totalElementos ; i++){
           datos[i][0] = vector[i].getCodigo();
           datos[i][1] = vector[i].getDescripcion();
           datos[i][2] = vector[i].getPrecio();
           datos[i][3] = vector[i].getStock();
           datos[i][4] = vector[i].getCategoria();
       }
       modelo.setDataVector(datos, titulos);
    }
    public Producto busquedaSecuencial(String valor) {
    return busquedaSecuencialRecursiva(vector,valor, totalElementos - 1);
}
    
    private Producto busquedaSecuencialRecursiva(Producto vector[] , String valor, int indice) {
        if (indice < 0) 
            return null;

        if (vector[indice].getCodigo().equals(valor)) 
            return vector[indice];
  
        return busquedaSecuencialRecursiva(vector, valor, indice - 1);
    }
     public boolean mostrarEncontrado(DefaultTableModel modelo, String codigoBuscado) {
        modelo.setRowCount(0);
        Producto productoEncontrado = busquedaSecuencial(codigoBuscado);
        Object datos[][] = new Object[1][5];
        String titulos[] = {"Codigo","Descripcion","Precio","Stock","Categoria"};
        if(productoEncontrado != null){
            datos[0][0] = productoEncontrado.getCodigo();
            datos[0][1] = productoEncontrado.getDescripcion();
            datos[0][2] = productoEncontrado.getPrecio();
            datos[0][3] = productoEncontrado.getStock();
            datos[0][4] = productoEncontrado.getCategoria();
            modelo.setDataVector(datos, titulos);
            return true;
        }
        return false;
    } 
}
