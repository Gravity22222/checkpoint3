package br.com.fiap.checkpoint2.DTOs;

import java.time.LocalDateTime;

public class ProfissionalDTO {

    private Long id;
    private String nome;
    private String especialidade;
    private double valorHora;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Long totalConsultas;
    private Long consultasAgendadas;
    private Long consultasRealizadas;
    private Long consultasCanceladas;
    private Double valorTotalConsultas;

    public ProfissionalDTO(Long id, String nome, String especialidade, double valorHora, LocalDateTime created_at,
            LocalDateTime updated_at, Long totalConsultas, Long consultasAgendadas, Long consultasRealizadas,
            Long consultasCanceladas, Double valorTotalConsultas) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.valorHora = valorHora;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.totalConsultas = totalConsultas;
        this.consultasAgendadas = consultasAgendadas;
        this.consultasRealizadas = consultasRealizadas;
        this.consultasCanceladas = consultasCanceladas;
        this.valorTotalConsultas = valorTotalConsultas;
    }

    public ProfissionalDTO() {
    }

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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
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
}
