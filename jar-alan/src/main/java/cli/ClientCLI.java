package cli;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.group.rede.RedeInterfaceGroup;
import com.github.britooo.looca.api.group.rede.RedeParametros;
import com.github.britooo.looca.api.util.Conversor;
import connection.ConexaoAzure;
import connection.ConexaoEC2;
import connection.ConexaoMySQL;
import databases.Captura;
import databases.Maquina;
import databases.Status;
import databases.Usuario;
import java.awt.Desktop;
import java.net.URI;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author alan
 */
public class ClientCLI {

    public static void main(String[] args) {
        // Instanciando classes
        ConexaoMySQL conexaoMySql = new ConexaoMySQL();
        ConexaoEC2 conexaoEc2 = new ConexaoEC2();
        ConexaoAzure conexaoAz = new ConexaoAzure();
        JdbcTemplate connMySql = conexaoMySql.getConnection();
        JdbcTemplate connEc = conexaoEc2.getConnection();
        JdbcTemplate connAz = conexaoAz.getConnection();
        Looca looca = new Looca();
        Conversor conversor = new Conversor();

        // Instanciando databases
        Usuario usuario = new Usuario();
        Maquina maquina = new Maquina();
        Status status = new Status();
        Captura captura = new Captura();

        // Criando o gerenciador
        DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
        RedeInterfaceGroup grupoRede = looca.getRede().getGrupoDeInterfaces();
        RedeParametros grupoParametros = looca.getRede().getParametros();

        // Lists
        List<Disco> discos = grupoDeDiscos.getDiscos();
        List<Volume> volumes = grupoDeDiscos.getVolumes();
        List<RedeInterface> interfaces = grupoRede.getInterfaces();
        List<String> parametros = grupoParametros.getServidoresDns();

        // Login
        Scanner scan = new Scanner(System.in);
        Scanner scanEmail = new Scanner(System.in);
        Scanner scanSenha = new Scanner(System.in);
        Integer opcao = 1;
        String email;
        String password;

        System.out.println("LOGIN");
        System.out.println("E-mail:");
        email = scanEmail.nextLine();
        System.out.println("Senha:");
        password = scanSenha.nextLine();

        usuario.setEmail(email);
        usuario.setSenha(password);

        List<Usuario> listaUsuarios = new ArrayList();
        listaUsuarios = connAz.query("SELECT * FROM [dbo].[Usuario] WHERE email = ? AND senha = ?",
                new BeanPropertyRowMapper<>(Usuario.class),
                usuario.getEmail(), usuario.getSenha());

        if (listaUsuarios != null && !listaUsuarios.isEmpty()) {
            System.out.println("Login efetuado com sucesso!");
            System.out.println(" -----------------------------------------\n"
                    + "/                STABILLIS                \\\n"
                    + "|        Que bom te ver de novo!          |\n"
                    + "\\        O que deseja fazer hoje?         /\n"
                    + " -----------------------------------------\n"
                    + "        \\   ^__^\n"
                    + "         \\  (oo)\\_______\n"
                    + "            (__)\\       )\\/\\\n"
                    + "                ||----w |\n"
                    + "                ||     ||");

            while (opcao != 0) {

                System.out.println("\n"
                        + "1-Capturar dados | 2-Monitorar | 0-Sair");
                opcao = scan.nextInt();

                switch (opcao) {
                    case 0:
                        System.out.println(" -----------\n"
                                + "< Até mais! >\n"
                                + " -----------\n"
                                + "        \\   ^__^\n"
                                + "         \\  (oo)\\_______\n"
                                + "            (__)\\       )\\/\\\n"
                                + "                ||----w |\n"
                                + "                ||     ||");
                        System.exit(0); // Sai do programa
                        break;

                    case 1:
                        System.out.println(" ----------------------------------------\n"
                                + "< Se quiser encerrar a captura, digite 0 >\n"
                                + " ----------------------------------------\n"
                                + "        \\   ^__^\n"
                                + "         \\  (oo)\\_______\n"
                                + "            (__)\\       )\\/\\\n"
                                + "                ||----w |\n"
                                + "                ||     ||");
                        //BUSCANDO FK_EMPRESA DO USUARIO
                        for (Usuario listaUsuario : listaUsuarios) {
                            usuario.setFkEmpresa(listaUsuario.getFkEmpresa());
                        }

                        //PEGANDO HOSTNAME
                        for (RedeInterface dado : interfaces) {
                            maquina.setNomeMaquina(grupoParametros.getHostName());
                        }

                        //BUSCANDO MAQUINA A PARTIR DA FK_EMPRESA DO USUARIO
                        List<Maquina> listaMaquinas = new ArrayList<>();
                        listaMaquinas = connEc.query("SELECT * FROM Maquina "
                                + "WHERE nomeMaquina = ?",
                                new BeanPropertyRowMapper<>(Maquina.class), maquina.getNomeMaquina());
                        System.out.println("Máquina atual: " + listaMaquinas);
                        listaMaquinas = connAz.query("SELECT * FROM Maquina "
                                + "WHERE nomeMaquina = ?",
                                new BeanPropertyRowMapper<>(Maquina.class), maquina.getNomeMaquina());
                        System.out.println("Máquina atual: " + listaMaquinas);

                        for (Maquina listaMaquina : listaMaquinas) {
                            maquina.setNomeMaquina(listaMaquina.getNomeMaquina());
                            maquina.setCapacidadeMaxDisco(listaMaquina.getCapacidadeMaxDisco());
                        }

                        listaMaquinas = connEc.query("SELECT idMaquina "
                                + "FROM Maquina m LEFT JOIN Captura c "
                                + "ON c.FK_Maquina = m.idMaquina"
                                + " WHERE m.nomeMaquina = ?",
                                new BeanPropertyRowMapper<>(Maquina.class),
                                maquina.getNomeMaquina());
                        listaMaquinas = connAz.query("SELECT idMaquina "
                                + "FROM Maquina m LEFT JOIN Captura c "
                                + "on c.FK_Maquina = m.idMaquina"
                                + "WHERE m.nomeMaquina = ?",
                                new BeanPropertyRowMapper<>(Maquina.class),
                                maquina.getNomeMaquina());

                        for (Maquina listaMaquina : listaMaquinas) {
                            maquina.setIdMaquina(listaMaquina.getIdMaquina());
                            captura.setFkMaquina(listaMaquina.getIdMaquina());
                        }

                        // TIMER
                        new Timer().scheduleAtFixedRate(new TimerTask() {
                            @Override
                            public void run() {
                                // Configuração da hora
                                Timestamp dataHora = Timestamp.from(Instant.now());
                                captura.setDataHora(dataHora);
                                System.out.println("Dados da sua máquina:");

                                // Uso da CPU
                                String usoCpu = String.format("%.2f", looca.getProcessador().getUso());
                                usoCpu = usoCpu.replace(",", ".");
                                double usoCpuFormatado = Double.parseDouble(usoCpu);
                                System.out.println("Uso CPU: " + usoCpuFormatado);

                                // Uso da memória
                                String memoriaUso = conversor.formatarBytes(looca.getMemoria().getEmUso());
                                String[] arrayMemoriaUso = memoriaUso.split("GiB");
                                System.out.println("Uso memória: " + arrayMemoriaUso[0]);
                                Double memTotal = Double.valueOf(arrayMemoriaUso[0].replace(",", "."));

                                //ALTERANDO VALORES
                                captura.setUsoCPU(usoCpuFormatado);
                                captura.setUsoRAM(memTotal);
                                captura.setDataHora(dataHora);
                                captura.setTempoAtividade(conversor.formatarSegundosDecorridos(looca.getSistema().getTempoDeAtividade()));

                                //System.out.println("Memoria uso: " + looca.getMemoria().getEmUso());
                                // Volume do disco
                                for (int i = 0; i < volumes.size(); i++) {
                                    String discoTotal = conversor.formatarBytes(volumes.get(0).getTotal());
                                    String[] arrayDiscoTotal = discoTotal.split("GiB");
                                    System.out.println("Total disco: " + arrayDiscoTotal[0]);
                                    Double totalDisco = Double.valueOf(arrayDiscoTotal[0].replace(",", "."));

                                    String discoDisponivel = conversor.formatarBytes(volumes.get(0).getDisponivel());
                                    String[] arrayDiscoDisponivel = discoDisponivel.split("GiB");
                                    System.out.println("Disponivel disco: " + arrayDiscoDisponivel[0]);
                                    Double disponivelDisco = Double.valueOf(arrayDiscoDisponivel[0].replace(",", "."));
                                    Double disco = (totalDisco - disponivelDisco);

                                    captura.setUsoDisco(disco);
                                }

                                for (RedeInterface dado : interfaces) {
                                    long pacRecebidos = dado.getPacotesRecebidos();
                                    int pacRecInt = (int) pacRecebidos;

                                    captura.setPacotesRecebidos(pacRecInt);

                                    long pacEnviados = dado.getPacotesEnviados();
                                    int pacEnvInt = (int) pacEnviados;

                                    captura.setPacotesEnviados(pacEnvInt);
                                }

                                connEc.update("INSERT INTO Captura (usoRAM, usoCPU, usoDisco,"
                                        + "pacotesRecebidos, pacotesEnviados, tempoAtividade,"
                                        + "dataHora, FK_Maquina) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                                        captura.getUsoRAM(),
                                        captura.getUsoCPU(),
                                        captura.getUsoDisco(),
                                        captura.getPacotesRecebidos(),
                                        captura.getPacotesEnviados(),
                                        captura.getTempoAtividade(),
                                        captura.getDataHora(),
                                        captura.getFkMaquina()
                                );
                                connAz.update("INSERT INTO Captura (usoRAM, usoCPU, usoDisco,"
                                        + "pacotesRecebidos, pacotesEnviados, tempoAtividade,"
                                        + "dataHora, FK_Maquina) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                                        captura.getUsoRAM(),
                                        captura.getUsoCPU(),
                                        captura.getUsoDisco(),
                                        captura.getPacotesRecebidos(),
                                        captura.getPacotesEnviados(),
                                        captura.getTempoAtividade(),
                                        captura.getDataHora(),
                                        captura.getFkMaquina()
                                );
                            }
                        },
                                0, 15000); // roda a cada 15segundos

                        break;

                    case 2:
                        System.out.println(" -----------------------------------------\n"
                                + "< Irei te direcionar para o nosso website >\n"
                                + " -----------------------------------------\n"
                                + "        \\   ^__^\n"
                                + "         \\  (oo)\\_______\n"
                                + "            (__)\\       )\\/\\\n"
                                + "                ||----w |\n"
                                + "                ||     ||");

                        String url = "https://stabillis.azurewebsites.net";

                        try {
                            Desktop desktop = Desktop.getDesktop();
                            desktop.browse(new URI(url));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        break;

                    default:
                        System.out.println("Opção inválida.");
                }
            }

        } else {
            System.out.println("E-mail e/ou senha incorretos.");
        }

    }
}
