package esof.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import esof.projeto.models.*;
import esof.projeto.repositories.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class BootStrap implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ConsultaRepoI consultaRepoI;
    @Autowired
    private FuncionarioRepoI funcionarioRepoI;
    @Autowired
    private MedicoRepoI medicoRepoI;
    @Autowired
    private ClienteRepoI clienteRepoI;
    @Autowired
    private HorarioRepoI horarioRepoI;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        LocalTime local1 = LocalTime.of(8, 00);
        LocalTime local2 = LocalTime.of(22, 00);
        Horario horario1 = new Horario(local1, local2, DayOfWeek.MONDAY);
        Horario horario2 = new Horario(local1, local2, DayOfWeek.TUESDAY);
        Horario horario3 = new Horario(local1, local2, DayOfWeek.FRIDAY);

        Medico medico1 = new Medico();
        medico1.nome = "medico1";
        medico1.morada = "morada1";
        medico1.contacto = "111111111";
        medico1.idMedico = "11";
        medico1.especialidade = "especialidade1";
        medico1.addHorario(horario1);

        Medico medico2 = new Medico();
        medico2.nome = "medico2";
        medico2.morada = "morada2";
        medico2.contacto = "222222222";
        medico2.idMedico = "22";
        medico2.especialidade = "especialidade2";
        medico2.addHorario(horario3);

        Medico medico3 = new Medico();
        medico3.nome = "medico3";
        medico3.morada = "morada3";
        medico3.contacto = "333333333";
        medico3.idMedico = "333";
        medico3.especialidade = "especialidade3";
        medico3.addHorario(horario2);

        Cliente cliente1 = new Cliente();
        cliente1.nome = "cliente4";
        cliente1.morada = "morada4";
        cliente1.contacto = "444444444";
        cliente1.idCliente = "44444";

        Cliente cliente2 = new Cliente();
        cliente2.nome = "cliente5";
        cliente2.morada = "morada5";
        cliente2.contacto = "555555555";
        cliente2.idCliente = "55555";

        Cliente cliente3 = new Cliente();
        cliente3.nome = "cliente6";
        cliente3.morada = "morada6";
        cliente3.contacto = "666666666";
        cliente3.idCliente = "66666";

        Funcionario funcionario1 = new Funcionario();
        funcionario1.nome = "funcionario7";
        funcionario1.morada = "morada7";
        funcionario1.contacto = "777777777";
        funcionario1.idFuncionario = "77";
        funcionario1.cargo = "cargo7";

        Consulta consulta1 = new Consulta();
        consulta1.precoConsulta = 10;
        consulta1.dataHora = LocalDateTime.of(2019, 01, 7, 8, 15, 00);
        consulta1.salaConsulta = "1a";
        consulta1.setCliente(cliente1);
        consulta1.setMedico(medico1);
        consulta1.setNomeMedico("medico1");

        Consulta consulta2 = new Consulta();
        consulta2.precoConsulta = 20;
        consulta2.dataHora = LocalDateTime.of(2019, 01, 8, 10, 30, 00);
        consulta2.salaConsulta = "2b";
        consulta2.setCliente(cliente2);
        consulta2.setMedico(medico2);
        consulta2.setNomeMedico("medico2");

        Consulta consulta3 = new Consulta();
        consulta3.precoConsulta = 30;
        consulta3.dataHora = LocalDateTime.of(2019, 01, 11, 15, 00, 00);
        consulta3.salaConsulta = "3c";
        consulta3.setCliente(cliente3);
        consulta3.setMedico(medico3);
        consulta3.setNomeMedico("medico3");

        Consulta consulta4 = new Consulta();
        consulta4.precoConsulta = 40;
        consulta4.dataHora = LocalDateTime.of(2019, 01, 14, 17, 45, 00);
        consulta4.salaConsulta = "4d";
        consulta4.setCliente(cliente1);
        consulta4.setMedico(medico1);
        consulta4.setNomeMedico("medico1");

        horarioRepoI.save(horario1);
        horarioRepoI.save(horario2);
        horarioRepoI.save(horario3);

        medicoRepoI.save(medico1);
        medicoRepoI.save(medico2);
        medicoRepoI.save(medico3);

        clienteRepoI.save(cliente1);
        clienteRepoI.save(cliente2);
        clienteRepoI.save(cliente3);

        funcionarioRepoI.save(funcionario1);

        consultaRepoI.save(consulta1);
        consultaRepoI.save(consulta2);
        consultaRepoI.save(consulta4);
        consultaRepoI.save(consulta3);
    }
}