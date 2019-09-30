package esof.projeto.services;

import org.springframework.stereotype.Service;
import esof.projeto.models.Consulta;
import esof.projeto.models.Medico;
import esof.projeto.repositories.ConsultaRepoI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ConsultaService implements ConsultaServiceI {
    private ConsultaRepoI consultaRepo;

    public ConsultaService(ConsultaRepoI consultaRepo) {
        this.consultaRepo = consultaRepo;
    }

    @Override
    public Set<Consulta> getAllConsultas() {
        Set<Consulta> consultas = new HashSet<>();
        for (Consulta consulta : this.consultaRepo.findAll()) {
            consultas.add(consulta);
        }
        return Collections.unmodifiableSet(consultas);
    }

    @Override
    public LocalDateTime StringToLocalDateTime(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.parse(data, formatter);
        System.out.println(dateTime);
        return dateTime;
    }

    @Override
    public Set<Consulta> getConsultaData(LocalDateTime data) {
        Set<Consulta> consultas = new HashSet<>();
        for (Consulta consulta : this.consultaRepo.findAll()) {
            if (consulta.getDataHora().isEqual(data)) {
                consultas.add(consulta);
            }
        }
        return consultas;
    }

    @Override
    public boolean MarcarConsulta(Consulta novaConsulta, Medico medico) {
        if (medico.verificarSeExisteHorario(novaConsulta.getDataHora())) {
            if (medico.verificaSeMedicoTemConsultas(novaConsulta.getDataHora())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Consulta> getConsultaById(Long id) {
        Optional<Consulta> cons = consultaRepo.findById(id);
        return cons;
    }

    @Override
    public void saveConsulta(Consulta novaConsulta) {
        consultaRepo.save(novaConsulta);
    }

    @Override
    public void apagarConsulta(Long id) {
        consultaRepo.deleteById(id);
    }
}
