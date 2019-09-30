package esof.projeto.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import esof.projeto.models.Cliente;
import esof.projeto.services.ClienteServiceI;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    ClienteServiceI clienteService;

    public ClienteController(ClienteServiceI clienteService) {
        this.clienteService = clienteService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable<Cliente> AllClientees() {
        return clienteService.getAllClientees();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Cliente getByIdCliente(@PathVariable("id") String id) {
        Optional<Cliente> cliente = clienteService.getClienteByIdCliente(id);
        return cliente.orElse(null);
    }

    @RequestMapping(value = "/getid/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Optional<Cliente> getById(@PathVariable("id") Long id) {
        return clienteService.getById(id);
    }
}
