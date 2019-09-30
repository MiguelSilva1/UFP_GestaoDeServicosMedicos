package projetoengsof.engsoft;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import projetoengsof.engsoft.models.*;
import projetoengsof.engsoft.repositories.*;
import projetoengsof.engsoft.services.GenericoServiceI;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.time.LocalTime.MIDNIGHT;
import static java.time.LocalTime.NOON;


@Component
public class BootStrap implements ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    private ConsultaRepoI consultaRepoI;

    @Autowired
    private FuncionarioRepoI funcionarioRepoI;

    @Autowired
    private UtilizadorRepoI utilizadorRepoI;

    @Autowired
    private HorarioRepoI horarioRepoI;

    @Autowired
    private GenericoServiceI genericoServiceI;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        LocalTime local1 = LocalTime.of(10,00);
        LocalTime local2 = LocalTime.of(22,00);
        Horario horario1 = new Horario(local1,local2, DayOfWeek.MONDAY);
        Horario horario2 = new Horario(local1,local2, DayOfWeek.TUESDAY);
        Horario horario3 = new Horario(local1,local2, DayOfWeek.FRIDAY);
        Horario horario4 = new Horario(local1,local2, DayOfWeek.FRIDAY);

        Generico medico1 = new Medico();
        medico1.nome = "Tiago";
        medico1.contacto = "911006431";
        medico1.endereco = "Porto";
        medico1.idade = 20;
        medico1.numeroProfissao = "33755";
        medico1.especialidade = "ortopedia";
        medico1.addHorario(horario1);
        medico1.setProfissao("medico");
        //medico1.addHorario(horario2);

        Generico medico2 = new Medico();
        medico2.nome = "Joao";
        medico2.contacto = "900006431";
        medico2.endereco = "Porto";
        medico2.idade = 21;
        medico2.numeroProfissao = "33756";
        medico2.especialidade = "oftalmologia";
        //medico2.addHorario(horario1);
        medico2.addHorario(horario3);
        medico2.setProfissao("medico");

        Generico medico3 = new Medico();
        medico3.nome = "Pedro";
        medico3.contacto = "921006431";
        medico3.endereco = "Porto";
        medico3.idade = 22;
        medico3.numeroProfissao = "33757";
        medico3.especialidade = "cardiologia";
        medico3.addHorario(horario2);
        medico3.setProfissao("medico");


        Generico advogado1 = new Advogado();
        advogado1.nome = "Pedro";
        advogado1.contacto = "921006431";
        advogado1.endereco = "Porto";
        advogado1.idade = 22;
        advogado1.numeroProfissao = "33757";
        advogado1.especialidade = "criminologia";
        advogado1.addHorario(horario4);
        advogado1.setProfissao("advogado");


        Generico advogado2 = new Advogado();
        advogado2.nome = "blabla";
        advogado2.contacto = "921006431";
        advogado2.endereco = "Porto";
        advogado2.idade = 22;
        advogado2.numeroProfissao = "33757";
        advogado2.especialidade = "partilhas";
        advogado2.setProfissao("advogado");


        Generico contabilista1 = new Contabilista();
        contabilista1.nome = "blabla";
        contabilista1.contacto = "921006431";
        contabilista1.endereco = "Porto";
        contabilista1.idade = 22;
        contabilista1.numeroProfissao = "33757";
        contabilista1.especialidade = "IRS";
        contabilista1.setProfissao("contabilista");





        Utilizador utilizador1 = new Utilizador();
        utilizador1.numeroUtente = "123";
        utilizador1.nome = "Paulo";
        utilizador1.idade = 23;
        utilizador1.endereco = "Santa Maria da Feira";
        utilizador1.contacto = "91000000";


        Utilizador utilizador2 = new Utilizador();
        utilizador2.numeroUtente = "456";
        utilizador2.nome = "Paulo1";
        utilizador2.idade = 25;
        utilizador2.endereco = "Lisboa";
        utilizador2.contacto = "91099900";

        Utilizador utilizador3 = new Utilizador();
        utilizador3.numeroUtente = "789";
        utilizador3.nome = "Paulo2";
        utilizador3.idade = 24;
        utilizador3.endereco = "Porto";
        utilizador3.contacto = "91099900";

        Funcionario funcionario1 = new Funcionario();
        funcionario1.iban = "12345";
        funcionario1.nif="54321";
        funcionario1.numeroFuncionario = "1";
        funcionario1.contacto = "91111";
        funcionario1.nome= "Rita";
        funcionario1.idade = 27;


        Consulta consulta1 = new Consulta();
        consulta1.custo = 20;
        LocalDateTime dat1 = LocalDateTime.of(2019 , 01 , 07,12,12,12);
        consulta1.dataHora = dat1;
        consulta1.gabinete="kk";
        consulta1.setUtilizador(utilizador1);
        consulta1.setGenerico(medico1);
        consulta1.setPessoa_nome("Tiago");
        //medico1.getConsultas().add(consulta1);


        Consulta consulta4 = new Consulta();
        consulta4.custo = 20;
        LocalDateTime dat5 = LocalDateTime.of(2019 , 01 , 8,15,12,12);
        consulta4.dataHora = dat5;
        consulta4.gabinete="kk";
        consulta4.setUtilizador(utilizador1);
        consulta4.setGenerico(medico1);
        //medico1.getConsultas().add(consulta4);
        consulta4.setPessoa_nome("Tiago");


        Consulta consulta2 = new Consulta();
        consulta2.custo = 25;
        consulta2.dataHora  = LocalDateTime.of(2019 , 01 ,11,2,12 , 12);
        consulta2.gabinete="ki";
        consulta2.setUtilizador(utilizador2);
        consulta2.setGenerico(medico2);
        //medico2.getConsultas().add(consulta2);
        consulta2.setPessoa_nome("Joao");

        Consulta consulta3 = new Consulta();
        consulta3.custo = 45;
        consulta3.dataHora  = LocalDateTime.of(2019 , 01 ,07,19,12 , 12);
        consulta3.gabinete="4f";
        consulta3.setUtilizador(utilizador3);
        consulta3.setGenerico(medico3);
        consulta3.setPessoa_nome("Pedro");

        /*medico3.addConsulta(consulta3);
        medico1.addConsulta(consulta4);
        medico2.addConsulta(consulta2);
        medico1.addConsulta(consulta1);*/



        funcionarioRepoI.save(funcionario1);

        horarioRepoI.save(horario1);
        horarioRepoI.save(horario2);
        horarioRepoI.save(horario3);
        horarioRepoI.save(horario4);

        /*medicoRepoI.save(medico1);
        medicoRepoI.save(medico2);
        medicoRepoI.save(medico3);*/

        genericoServiceI.saveGenerico(medico1);
        genericoServiceI.saveGenerico(medico2);
        genericoServiceI.saveGenerico(medico3);
        genericoServiceI.saveGenerico(advogado1);
        genericoServiceI.saveGenerico(advogado2);
        genericoServiceI.saveGenerico(contabilista1);

        utilizadorRepoI.save(utilizador1);
        utilizadorRepoI.save(utilizador2);
        utilizadorRepoI.save(utilizador3);

        consultaRepoI.save(consulta1);
        consultaRepoI.save(consulta2);
        consultaRepoI.save(consulta4);
        consultaRepoI.save(consulta3);



    }
}