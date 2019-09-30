package projetoengsof.engsoft.services;


import org.springframework.stereotype.Service;
import projetoengsof.engsoft.models.Funcionario;
import projetoengsof.engsoft.models.Medico;
import projetoengsof.engsoft.repositories.FuncionarioRepoI;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class FuncionarioService implements FuncionarioServiceI {

    private FuncionarioRepoI funcionarioRepo;

    public FuncionarioService(FuncionarioRepoI funcionarioRepo){
        this.funcionarioRepo = funcionarioRepo;
    }

    @Override
    public Set<Funcionario> getAllFuncionarios(){
        Set<Funcionario> funcionarios=new HashSet<>();
        for(Funcionario funcionario:this.funcionarioRepo.findAll()){
            funcionarios.add(funcionario);
        }
        return Collections.unmodifiableSet(funcionarios);
    }


    public void editarMedico (Medico medico){

    }



}
