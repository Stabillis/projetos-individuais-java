package databases;

/**
 *
 * @author alan
 */
public class Status {

    private Integer idStatus;
    private String tipoStatus;

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getTipoStatus() {
        return tipoStatus;
    }

    public void setTipoStatus(String tipoStatus) {
        this.tipoStatus = tipoStatus;
    }

    @Override
    public String toString() {
        return "Status{" + "idStatus=" + idStatus + ", tipoStatus=" + tipoStatus + '}';
    }

}
