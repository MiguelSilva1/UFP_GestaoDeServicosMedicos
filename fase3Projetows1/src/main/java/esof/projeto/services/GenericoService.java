package projetoengsof.engsoft.services;


import org.springframework.stereotype.Service;
import projetoengsof.engsoft.filters.FilterObject;
import projetoengsof.engsoft.filters.medicoFiltros.GenericoFiltroService;
import projetoengsof.engsoft.models.*;
import projetoengsof.engsoft.repositories.AdvogadoRepoI;
import projetoengsof.engsoft.repositories.ContabilistaRepoI;
import projetoengsof.engsoft.repositories.MedicoRepoI;
import sun.net.www.content.text.Generic;

import java.util.*;

@Service
public class GenericoService implements  GenericoServiceI{


    private MedicoRepoI medicoRepo;
    private AdvogadoRepoI advogadoRepoI;
    private ContabilistaRepoI contabilistaRepoI;
    private GenericoFiltroService genericoFiltroService;

    public GenericoService(MedicoRepoI medicoRepo, AdvogadoRepoI advogadoRepoI, ContabilistaRepoI contabilistaRepoI,
                           GenericoFiltroService genericoFiltroService) {

        this.medicoRepo = medicoRepo;
        this.advogadoRepoI = advogadoRepoI;
        this.contabilistaRepoI = contabilistaRepoI;
        this.genericoFiltroService = genericoFiltroService;
    }

    @Override
    public Set<Generico> getFilteredGenericos(FilterObject filterObject , String profissao){
        return genericoFiltroService.filterGenerico(getSetGenericosByProfissao(profissao),filterObject);

    }


    @Override
    public Set<Generico> getSetGenericosByProfissao(String profissao){
        Set<Generico> gens = new HashSet<Generico>();
        if(profissao.equalsIgnoreCase("medico")) {
            //Set<Medico> g = new HashSet<>();

            for(Medico medico:this.medicoRepo.findAll()){
                //Generico g = (Generico)medico;
                gens.add(medico);
                //System.out.println(g.size());
            }

            return gens;
        } else if(profissao.equalsIgnoreCase("advogado")){
            //Set<Generico> gens = new HashSet<>();
            for(Advogado advogado:this.advogadoRepoI.findAll()){
                gens.add(advogado);
            }
            return gens;
        } else {
            //Set<Generico> gens = new HashSet<>();
            for(Contabilista contabilista:this.contabilistaRepoI.findAll()){
                gens.add(contabilista);
            }
            return gens;
        }
    }

    @Override
    public Generico getGenById(Long id){
        if(medicoRepo.existsById(id)){
            for(Medico medico : medicoRepo.findAll()){
                if(medico.getId() == id){
                    Generico gn = (Generico)medico;
                    return gn;
                }
            }
        }else if (advogadoRepoI.existsById(id)){
            for(Advogado advogado : advogadoRepoI.findAll()){
                if(advogado.getId() == id){
                    Generico gn = (Generico)advogado;
                    return gn;
                }
            }
        } else if(contabilistaRepoI.existsById(id)){
            for(Contabilista contabilista : contabilistaRepoI.findAll()){
                if(contabilista.getId() == id){
                    Generico gn = (Generico)contabilista;
                    return gn;
                }
            }
        }

        return null;
    }



    @Override
    public Set<Generico> getALL(){

        Set<Generico> gn = new HashSet<>();
        Generico g ;

        for(Medico medico : medicoRepo.findAll()){
            g = (Generico)medico;
            gn.add(g);
        }
        for(Advogado advogado : advogadoRepoI.findAll()){
            g = (Generico)advogado;
            gn.add(g);
        }
        for(Contabilista contabilista : contabilistaRepoI.findAll()){
            g = (Generico)contabilista;
            gn.add(g);
        }

        return gn;

    }


    @Override
    public Generico getGenericoById(Long id , String profissao){
        if(profissao.equalsIgnoreCase("medico")){
            Optional<Medico> med = medicoRepo.findById(id);
            Generico gn = med.get();
            return gn;
        }else if(profissao.equalsIgnoreCase("advogado")){
            Optional<Advogado> adv = advogadoRepoI.findById(id);
            Generico gn = adv.get();
            return gn;
        } else {
            Optional<Contabilista> cont = contabilistaRepoI.findById(id);
            Generico gn = cont.get();
            return gn;
        }
    }










    @Override
    public Set<Generico> getAllGenericos(){
        Set<Generico> genericos=new HashSet<>();
        for(Medico medico:this.medicoRepo.findAll()){
            genericos.add(medico);
        }
        for(Advogado advogado:this.advogadoRepoI.findAll()){
            genericos.add(advogado);
        }
        for(Contabilista contabilista:this.contabilistaRepoI.findAll()){
            genericos.add(contabilista);
        }
        return Collections.unmodifiableSet(genericos);
    }


    @Override
    public void saveGenerico(Generico pessoa){

        if(pessoa.getProfissao().equalsIgnoreCase("medico")){
            Medico med = (Medico)pessoa;
            medicoRepo.save(med);
        }else if(pessoa.getProfissao().equalsIgnoreCase("advogado")){
            Advogado adv = (Advogado)pessoa;
            advogadoRepoI.save(adv);

        } else if(pessoa.getProfissao().equalsIgnoreCase("contabilista")) {
            Contabilista cont = (Contabilista) pessoa;
            contabilistaRepoI.save(cont);
        }

    }






}
