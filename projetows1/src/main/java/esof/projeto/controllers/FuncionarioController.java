package esof.projeto.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import esof.projeto.models.*;
import esof.projeto.repositories.HorarioRepoI;
import esof.projeto.services.FuncionarioServiceI;
import esof.projeto.services.MedicoServiceI;

import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    FuncionarioServiceI funcionarioService;
    MedicoServiceI medicoServiceI;
    HorarioRepoI horarioRepoI;

    public FuncionarioController(FuncionarioServiceI funcionarioService, MedicoServiceI medicoServiceI,
                                 HorarioRepoI horarioRepoI) {
        this.funcionarioService = funcionarioService;
        this.medicoServiceI = medicoServiceI;
        this.horarioRepoI = horarioRepoI;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable<Funcionario> AllFuncionarios() {
        return funcionarioService.getAllFuncionarios();
    }

    @PostMapping(value = "/adicionar", produces = MediaType.APPLICATION_JSON_VALUE, consumes
            = MediaType.APPLICATION_JSON_VALUE)
    public String adicionarMedico(@RequestBody Medico medico) {
        if (medicoServiceI.existeMedicoById(medico.getIdMedico())) {
            return "medico jรก exite";
        } else {
            medicoServiceI.saveMedico(medico);
            return "medico adicionado com sucesso";
        }
    }

    @PostMapping(value = "/atualizar/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes
            = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medico> atualizarMedico(@RequestBody Medico medico, @PathVariable("id") Long id) {
        Optional<Medico> med = medicoServiceI.getMedicoById(id);
        if (med == null) {
            System.out.println("Medico inexistente");
            return new ResponseEntity<Medico>(HttpStatus.NOT_FOUND);
        }
        med.get().setNome(medico.getNome());
        med.get().setEspecialidade(medico.getEspecialidade());
        med.get().setIdMedico(medico.getIdMedico());
        med.get().setContacto(medico.getContacto());
        med.get().setMorada(medico.getMorada());
        System.out.printf("Medico atualizado");
        return new ResponseEntity<Medico>(med.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/apagar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Medico> apagarMedico(@PathVariable("id") Long id) {
        Optional<Medico> med = medicoServiceI.getMedicoById(id);
        if (med == null) {
            System.out.println("Medico inexistente");
            return new ResponseEntity<Medico>(HttpStatus.NOT_FOUND);
        }
        medicoServiceI.apagarById(id);
        return new ResponseEntity<Medico>(HttpStatus.NO_CONTENT);
    }
}
