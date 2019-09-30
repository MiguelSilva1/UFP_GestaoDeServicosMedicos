package esof.projeto.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import esof.projeto.models.Consulta;
import esof.projeto.models.Medico;
import esof.projeto.models.Cliente;
import esof.projeto.services.ConsultaServiceI;
import esof.projeto.services.MedicoServiceI;
import esof.projeto.services.ClienteServiceI;

import java.util.Optional;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    private ConsultaServiceI consultaService;
    private MedicoServiceI medicoService;
    private ClienteServiceI clienteService;

    public ConsultaController(ConsultaServiceI consultaService, MedicoServiceI medicoService,
                              ClienteServiceI clienteService) {

        this.medicoService = medicoService;
        this.consultaService = consultaService;
        this.clienteService = clienteService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable<Consulta> AllConsultas() {
        return consultaService.getAllConsultas();
    }

    @PostMapping(value = "/marcar/{idcliente}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String marcarConsulta(@RequestBody Consulta consulta, @PathVariable("idcliente") Long idcliente) {
        Medico medico = medicoService.getMedicoByName(consulta.getNomeMedico());
        Optional<Cliente> cliente = clienteService.getById(idcliente);
        if (consultaService.MarcarConsulta(consulta, medico)) {
            medico.addConsulta(consulta);
            consulta.setMedico(medico);
            consulta.setCliente(cliente.get());
            cliente.get().addConsulta(consulta);
            consultaService.saveConsulta(consulta);
            return "Adicionada com sucesso";
        }
        return "Nao adicionada";
    }

    @RequestMapping(value = "/apagar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Consulta> apagarConsulta(@PathVariable("id") Long id) {
        Optional<Consulta> cons = consultaService.getConsultaById(id);
        if (cons == null) {
            System.out.println("Consulta inexistente");
            return new ResponseEntity<Consulta>(HttpStatus.NOT_FOUND);
        }
        consultaService.apagarConsulta(id);
        return new ResponseEntity<Consulta>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/atualizar/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Consulta> atualizarConsulta(@RequestBody Consulta consulta, @PathVariable("id") Long id) {
        Optional<Consulta> cons = consultaService.getConsultaById(id);
        if (cons == null) {
            System.out.println("Consulta inexistente");
            return new ResponseEntity<Consulta>(HttpStatus.NOT_FOUND);
        }
        Medico med = medicoService.getMedicoByName(consulta.getNomeMedico());
        cons.get().setPrecoConsulta(consulta.getPrecoConsulta());
        cons.get().setDataHora(consulta.getDataHora());
        cons.get().setSalaConsulta(consulta.getSalaConsulta());
        cons.get().setNomeMedico(consulta.getNomeMedico());
        cons.get().setMedico(med);
        System.out.printf("Consulta atualizada");
        return new ResponseEntity<Consulta>(cons.get(), HttpStatus.OK);
    }
}
