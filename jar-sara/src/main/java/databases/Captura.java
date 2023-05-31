package databases;

import java.sql.Timestamp;

/**
 *
 * @author alan
 */
public class Captura {

    private Integer idCaptura;
    private Double usoRAM;
    private Double usoCPU;
    private Double usoDisco;
    private Integer pacotesRecebidos;
    private Integer pacotesEnviados;
    private String tempoAtividade;
    private Timestamp dataHora;
    private Integer fkMaquina;

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    public Integer getIdCaptura() {
        return idCaptura;
    }

    public void setIdCaptura(Integer idCaptura) {
        this.idCaptura = idCaptura;
    }

    public Double getUsoRAM() {
        return usoRAM;
    }

    public void setUsoRAM(Double usoRAM) {
        this.usoRAM = usoRAM;
    }

    public Double getUsoCPU() {
        return usoCPU;
    }

    public void setUsoCPU(Double usoCPU) {
        this.usoCPU = usoCPU;
    }

    public Double getUsoDisco() {
        return usoDisco;
    }

    public void setUsoDisco(Double usoDisco) {
        this.usoDisco = usoDisco;
    }

    public Integer getPacotesRecebidos() {
        return pacotesRecebidos;
    }

    public void setPacotesRecebidos(Integer pacotesRecebidos) {
        this.pacotesRecebidos = pacotesRecebidos;
    }

    public Integer getPacotesEnviados() {
        return pacotesEnviados;
    }

    public void setPacotesEnviados(Integer pacotesEnviados) {
        this.pacotesEnviados = pacotesEnviados;
    }

    public String getTempoAtividade() {
        return tempoAtividade;
    }

    public void setTempoAtividade(String tempoAtividade) {
        this.tempoAtividade = tempoAtividade;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Captura{" + "idCaptura=" + idCaptura + ", "
                + "usoRAM=" + usoRAM + ", usoCPU=" + usoCPU + ","
                + " usoDisco=" + usoDisco + ", pacotesRecebidos="
                + pacotesRecebidos + ", pacotesEnviados=" + pacotesEnviados
                + ", tempoAtividade=" + tempoAtividade + ", dataHora="
                + dataHora + ", fkMaquina=" + fkMaquina + '}';
    }

}
