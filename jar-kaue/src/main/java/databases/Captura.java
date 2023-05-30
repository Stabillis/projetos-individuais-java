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
    private String bytesRecebidos;
    private String bytesEnviados;
    private String tempoAtividade;
    private Timestamp dataHora;
    private Integer fkMaquina;

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

    public String getBytesRecebidos() {
        return bytesRecebidos;
    }

    public void setBytesRecebidos(String bytesRecebidos) {
        this.bytesRecebidos = bytesRecebidos;
    }

    public String getBytesEnviados() {
        return bytesEnviados;
    }

    public void setBytesEnviados(String bytesEnviados) {
        this.bytesEnviados = bytesEnviados;
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

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    @Override
    public String toString() {
        return "Captura{" + "idCaptura=" + idCaptura 
                + ", usoRAM=" + usoRAM 
                + ", usoCPU=" + usoCPU 
                + ", usoDisco=" + usoDisco 
                + ", bytesRecebidos=" + bytesRecebidos 
                + ", bytesEnviados=" + bytesEnviados 
                + ", tempoAtividade=" + tempoAtividade 
                + ", dataHora=" + dataHora 
                + ", fkMaquina=" + fkMaquina + '}';
    }



}
