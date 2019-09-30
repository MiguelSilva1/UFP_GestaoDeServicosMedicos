package esof.projeto.services;

import org.springframework.stereotype.Service;
import esof.projeto.filters.FilterObject;
import esof.projeto.filters.medicoFilters.MedicoFilterService;
import esof.projeto.models.Medico;
import esof.projeto.repositories.MedicoRepoI;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MedicoService implements MedicoServiceI {
    private MedicoRepoI medicoRepo;
    private MedicoFilterService medicoFilterService;

    public MedicoService(MedicoRepoI medicoRepo, MedicoFilterService medicoFilterService) {
        this.medicoRepo = medicoRepo;
        this.medicoFilterService = medicoFilterService;
    }

    @Override
    public Optional<Medico> getMedicoById(Long id) {
        Optional<Medico> med = medicoRepo.findById(id);
        return med;
    }

    @Override
    public Set<Medico> getAllMedicos() {
        Set<Medico> medicos = new HashSet<>();
        for (Medico medico : this.medicoRepo.findAll()) {
            medicos.add(medico);
        }
        return Collections.unmodifiableSet(medicos);
    }

    @Override
    public boolean existeMedicoById(String id) {
        for (Medico medico : this.medicoRepo.findAll()) {
            if (medico.getIdMedico().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Medico getMedicoByName(String name) {
        for (Medico medico : getAllMedicos()) {
            if (medico.getNome().equalsIgnoreCase(name)) {
                return medico;
            }
        }
        return null;
    }

    @Override
    public Set<Medico> getFilteredMedicos(FilterObject filterObject) {
        return medicoFilterService.filterMedico(getAllMedicos(), filterObject);
    }

    @Override
    public void saveMedico(Medico medico) {
        medicoRepo.save(medico);
    }

    @Override
    public void apagarById(Long id) {
        medicoRepo.deleteById(id);
    }
}
