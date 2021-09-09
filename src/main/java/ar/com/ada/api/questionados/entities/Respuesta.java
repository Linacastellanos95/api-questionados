package ar.com.ada.api.questionados.entities;

import javax.persistence.*;

@Entity
@Table(name = "respuesta")
public class Respuesta {

    @Id
    @Column(name = "respuesta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer respuestaId;

    private String texto;

    @Column(name = "es_correcta")
    private Boolean esCorrecta;


    public Integer getRespuestaId() {
        return respuestaId;
    }

    public void setRespuestaId(Integer respuestaId) {
        this.respuestaId = respuestaId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public Boolean getEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(Boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }

   
    
}
