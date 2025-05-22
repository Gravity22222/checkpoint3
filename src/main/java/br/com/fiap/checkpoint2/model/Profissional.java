package br.com.fiap.checkpoint2.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profissional {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String nome;
    private String especialidade;
    private double valor_hora;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Long totalConsultas;
    private Long consultasAgendadas;
    private Long consultasRealizadas;
    private Long consultasCanceladas;
    private Double valorTotalConsultas;

    

    public Long getTotalConsultas() {
        return totalConsultas;
    }

    public void setTotalConsultas(Long totalConsultas) {
        this.totalConsultas = totalConsultas;
    }

    public Long getConsultasAgendadas() {
        return consultasAgendadas;
    }

    public void setConsultasAgendadas(Long consultasAgendadas) {
        this.consultasAgendadas = consultasAgendadas;
    }

    public Long getConsultasRealizadas() {
        return consultasRealizadas;
    }

    public void setConsultasRealizadas(Long consultasRealizadas) {
        this.consultasRealizadas = consultasRealizadas;
    }

    public Long getConsultasCanceladas() {
        return consultasCanceladas;
    }

    public void setConsultasCanceladas(Long consultasCanceladas) {
        this.consultasCanceladas = consultasCanceladas;
    }

    public Double getValorTotalConsultas() {
        return valorTotalConsultas;
    }

    public void setValorTotalConsultas(Double valorTotalConsultas) {
        this.valorTotalConsultas = valorTotalConsultas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public double getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(double valor_hora) {
        this.valor_hora = valor_hora;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

}
