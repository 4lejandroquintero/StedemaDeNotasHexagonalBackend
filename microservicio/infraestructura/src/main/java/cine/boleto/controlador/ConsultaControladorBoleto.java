package cine.boleto.controlador;
import cine.boleto.consulta.ManejadorConsultaBoleto;
import cine.boleto.consulta.ManejadorConsultarBoletoPorFuncion;
import cine.boleto.entidad.Boleto;
import cine.funcion.modelo.entidad.Funcion;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boleto")
@Tag(name = "Controlador consulta de boletos")
public class ConsultaControladorBoleto {

    private final ManejadorConsultaBoleto manejadorConsultaBoleto;
    private final ManejadorConsultarBoletoPorFuncion manejadorConsultarBoletoPorFuncion;

    public ConsultaControladorBoleto(ManejadorConsultaBoleto manejadorConsultaBoleto, ManejadorConsultarBoletoPorFuncion manejadorConsultarBoletoPorFuncion) {
        this.manejadorConsultaBoleto = manejadorConsultaBoleto;
        this.manejadorConsultarBoletoPorFuncion = manejadorConsultarBoletoPorFuncion;
    }

    @GetMapping("/funcion/{idFuncion}")
    @Operation(summary = "Obtener Boletos por Funcion", description = "Metodo utilizado para consultar los boletos de una funcion")
    public List<Boleto> obtenerBoletosDeFuncion(@PathVariable("idFuncion") Long id){
        return manejadorConsultarBoletoPorFuncion.ejecutar(id);
    }

    @GetMapping("/{id}")
    public Boleto obtenerBoleto(@PathVariable("id") Long id){
        return manejadorConsultaBoleto.ejecutar(id);
    }


}
