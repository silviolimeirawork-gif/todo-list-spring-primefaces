package com.exemplo.todo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "todo")
public class Todo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String descricao;
    private Date dataAlvo;
    private boolean concluido;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "descricao", nullable = false, length = 255)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "data_alvo")
    public Date getDataAlvo() {
        return dataAlvo;
    }

    public void setDataAlvo(Date dataAlvo) {
        this.dataAlvo = dataAlvo;
    }

    @Column(name = "concluido")
    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
}
