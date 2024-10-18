
package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;



import cronapp.framework.core.persistence.*;

/**
* Classe que representa a tabela PERIODO
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"PERIODO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Periodo")
@CronappTable(role=CronappTableRole.CLASS)
public class Periodo implements Serializable {
    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @CronappColumn(attributeType="STRING", label="Id", defaultValue = "UUID.randomUUID().toString().toUpperCase()")
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Periodo")
    @Column(name = "periodo", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String periodo;


    /**
    * @generated
    */
    @CronappColumn(attributeType="BOOLEAN", label="Ativo")
    @Column(name = "ativo", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean ativo;


    /**
    * @generated
    */
    @Temporal(TemporalType.DATE)
    @CronappColumn(attributeType="DATE", label="Datainicial")
    @Column(name = "datainicial", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date datainicial;


    /**
    * @generated
    */
    @Temporal(TemporalType.DATE)
    @CronappColumn(attributeType="DATE", label="Datafinal")
    @Column(name = "datafinal", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date datafinal;


    /**
    * Construtor
    * @generated
    */
    public Periodo(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    public java.lang.String getId() {
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public Periodo setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém periodo
    * return periodo
    * @generated
    */
    public java.lang.String getPeriodo() {
        return this.periodo;
    }

    /**
    * Define periodo
    * @param periodo periodo
    * @generated
    */
    public Periodo setPeriodo(java.lang.String periodo) {
        this.periodo = periodo;
        return this;
    }
    /**
    * Obtém ativo
    * return ativo
    * @generated
    */
    public java.lang.Boolean getAtivo() {
        return this.ativo;
    }

    /**
    * Define ativo
    * @param ativo ativo
    * @generated
    */
    public Periodo setAtivo(java.lang.Boolean ativo) {
        this.ativo = ativo;
        return this;
    }
    /**
    * Obtém datainicial
    * return datainicial
    * @generated
    */
    public java.util.Date getDatainicial() {
        return this.datainicial;
    }

    /**
    * Define datainicial
    * @param datainicial datainicial
    * @generated
    */
    public Periodo setDatainicial(java.util.Date datainicial) {
        this.datainicial = datainicial;
        return this;
    }
    /**
    * Obtém datafinal
    * return datafinal
    * @generated
    */
    public java.util.Date getDatafinal() {
        return this.datafinal;
    }

    /**
    * Define datafinal
    * @param datafinal datafinal
    * @generated
    */
    public Periodo setDatafinal(java.util.Date datafinal) {
        this.datafinal = datafinal;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Periodo object = (Periodo)obj;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;
        return true;
    }

    /**
    * @generated
    */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}