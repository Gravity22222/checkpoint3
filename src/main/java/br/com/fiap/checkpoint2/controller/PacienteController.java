package br.com.fiap.checkpoint2.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.checkpoint2.DTOs.ConsultaDTO;
import br.com.fiap.checkpoint2.DTOs.PacienteDTO;
import br.com.fiap.checkpoint2.model.StatusConsulta;
import br.com.fiap.checkpoint2.service.ConsultaService;
import br.com.fiap.checkpoint2.service.PacienteService;


@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private ConsultaService consultaService;
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteDTO> createPaciente(@RequestBody PacienteDTO pacienteDTO) {
        PacienteDTO createdPaciente = pacienteService.createPaciente(pacienteDTO);
        return ResponseEntity.ok(createdPaciente);
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> getAllPacientes() {
        List<PacienteDTO> pacientes = pacienteService.getAllPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> getPacienteById(@PathVariable Long id) {
        PacienteDTO paciente = pacienteService.getPacienteById(id);
        if (paciente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> updatePaciente(@PathVariable Long id, @RequestBody PacienteDTO pacienteDTO) {
        PacienteDTO updatedPaciente = pacienteService.updatePaciente(id, pacienteDTO);
        if (updatedPaciente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPaciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/consultas")
    public ResponseEntity<List<ConsultaDTO>> filtrarConsultasPorPaciente(
            @PathVariable Long id,
            @RequestParam(required = false) StatusConsulta status,
            @RequestParam(required = false, name = "data_de") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataDe,
            @RequestParam(required = false, name = "data_ate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataAte) {
        List<ConsultaDTO> consultas = consultaService.filtrarConsultas(null, id, status, dataDe, dataAte);
        return ResponseEntity.ok(consultas);
    }


}
