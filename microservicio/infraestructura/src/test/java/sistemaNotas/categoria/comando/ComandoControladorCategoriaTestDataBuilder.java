package sistemaNotas.categoria.comando;

public class ComandoControladorCategoriaTestDataBuilder {
    private Long idBoleto;
    private String titulo;
    private String descripcion;
    private Long idFuncion;
    public ComandoControladorCategoriaTestDataBuilder crearPorDefecto() {
        this.idBoleto = 1L;
        this.titulo = "Ciencias Naturales";
        this.descripcion = "En esta categoria se verán temas de ciencias naturales";
        this.idFuncion = 2L;
        return this;
    }

    public ComandoSolicitudCrearCategoria construir() {
        return new ComandoSolicitudCrearCategoria(idBoleto,titulo,descripcion,idFuncion);
    }
}
