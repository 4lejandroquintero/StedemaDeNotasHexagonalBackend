package sistemaNotas.categoria;

import sistemaNotas.categoria.entidad.Categoria;
import sistemaNotas.examen.ExamenTestDataBuilder;
import sistemaNotas.examen.modelo.entidad.Examen;

public class CategoriaTestDataBuilder {
    private Long categoriaId;
    private String titulo;
    private String descripcion;
    private Examen examen;

    public CategoriaTestDataBuilder conCategoriaPorDefecto() {
        this.categoriaId = 1L;
        this.titulo = "Ciencias Naturales";
        this.descripcion = "Aprende sobre las ciencias";
        this.examen = new ExamenTestDataBuilder().crearExamenPorDefecto().reconstruir();
        return this;
    }

    public CategoriaTestDataBuilder conCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
        return this;
    }

    public CategoriaTestDataBuilder conTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public CategoriaTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public CategoriaTestDataBuilder conExamen(Examen examen) {
        this.examen = examen;
        return this;
    }
    public Categoria reconstruir(){
        return Categoria.reconstruir(categoriaId,titulo,descripcion, examen);
    }
    public Categoria crear() {
    return Categoria.crear(titulo,descripcion,examen);
    }
}
