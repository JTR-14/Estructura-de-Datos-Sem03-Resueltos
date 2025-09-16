
package ArrayList;


public class Alumno {
    private String codigo;
    private String nombre;
    private String apellido;
    private double nota;

    public Alumno(String codigo) {
        this.codigo = codigo;
    }

    public Alumno(String codigo, String nombre, String apellido, double nota) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota = nota;
    }

    public Alumno() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    @Override
    public boolean equals(Object obj) {
    if (obj == null) return false;
    Alumno alumno = (Alumno) obj;
    return codigo.equals(alumno.codigo);
}
}
