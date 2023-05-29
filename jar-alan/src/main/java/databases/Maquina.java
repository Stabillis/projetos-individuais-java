package databases;

/**
 *
 * @author alan
 */
public class Maquina {

    private Integer idMaquina;
    private String nomeMaquina;
    private Integer fkStatus;
    private Double capacidadeMaxRAM;
    private Double capacidadeMaxDisco;
    private Double capacidadeMaxCPU;
    private String arquitetura;
    private String sistemaOperacional;
    private Integer fkEmpresa;

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }

    public Integer getFkStatus() {
        return fkStatus;
    }

    public void setFkStatus(Integer fkStatus) {
        this.fkStatus = fkStatus;
    }

    public Double getCapacidadeMaxRAM() {
        return capacidadeMaxRAM;
    }

    public void setCapacidadeMaxRAM(Double capacidadeMaxRAM) {
        this.capacidadeMaxRAM = capacidadeMaxRAM;
    }

    public Double getCapacidadeMaxDisco() {
        return capacidadeMaxDisco;
    }

    public void setCapacidadeMaxDisco(Double capacidadeMaxDisco) {
        this.capacidadeMaxDisco = capacidadeMaxDisco;
    }

    public Double getCapacidadeMaxCPU() {
        return capacidadeMaxCPU;
    }

    public void setCapacidadeMaxCPU(Double capacidadeMaxCPU) {
        this.capacidadeMaxCPU = capacidadeMaxCPU;
    }

    public String getArquitetura() {
        return arquitetura;
    }

    public void setArquitetura(String arquitetura) {
        this.arquitetura = arquitetura;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    @Override
    public String toString() {
        return "Maquina{" + "idMaquina=" + idMaquina + ", "
                + "nomeMaquina=" + nomeMaquina + ", fkStatus="
                + fkStatus + ", capacidadeMaxRAM=" + capacidadeMaxRAM + ","
                + " capacidadeMaxDisco=" + capacidadeMaxDisco + ", "
                + "capacidadeMaxCPU=" + capacidadeMaxCPU + ","
                + " arquitetura=" + arquitetura + ", sistemaOperacional="
                + sistemaOperacional + ", fkEmpresa=" + fkEmpresa + '}';
    }

}
