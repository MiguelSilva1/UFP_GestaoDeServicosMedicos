package projetoengsof.engsoft.services;

import projetoengsof.engsoft.models.Utilizador;

import java.util.Optional;
import java.util.Set;

public interface ClienteServiceI {

    Set<Utilizador> getAllUtilizadores();
    Optional<Utilizador> getUtilizadorByNumeroUtente(String numeroUtente);
    Optional<Utilizador> getById(Long id);
}
