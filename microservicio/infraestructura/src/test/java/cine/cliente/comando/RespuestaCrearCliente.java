package cine.cliente.comando;

public class RespuestaCrearCliente {
    private Long valor;

    public RespuestaCrearCliente() {
    }

    public RespuestaCrearCliente(Long valor) {
        this.valor = valor;
    }

    public Long getValor() {
        return valor;
    }
}