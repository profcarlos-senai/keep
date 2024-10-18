package com.keep.keep2.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="atividade")
public class M_Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        M_Atividade that = (M_Atividade) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getNome() != null ? !getNome().equals(that.getNome()) : that.getNome() != null) return false;
        if (getData() != null ? !getData().equals(that.getData()) : that.getData() != null) return false;
        return getConcluida() != null ? getConcluida().equals(that.getConcluida()) : that.getConcluida() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getData() != null ? getData().hashCode() : 0);
        result = 31 * result + (getConcluida() != null ? getConcluida().hashCode() : 0);
        return result;
    }

    private Boolean concluida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }
}
