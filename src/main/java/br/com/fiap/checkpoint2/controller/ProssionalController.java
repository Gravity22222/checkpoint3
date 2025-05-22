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
import br.com.fiap.checkpoint2.DTOs.ProfissionalDTO;
import br.com.fiap.checkpoint2.model.StatusConsulta;
import br.com.fiap.checkpoint2.service.ConsultaService;
import br.com.fiap.checkpoint2.service.ProfissionalService;

@RestController
@RequestMapping("profissionais")
public class ProssionalController {
     @Autowired
    private ConsultaService consultaService;

    @Autowired
    private ProfissionalService profissionalService;

    @PostMapping
    public ResponseEntity<ProfissionalDTO> createProfissional(@RequestBody ProfissionalDTO profissionalDTO) {
        ProfissionalDTO createdProfissional = profissionalService.createProfissional(profissionalDTO);
        return ResponseEntity.ok(createdProfissional);
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalDTO>> getAllProfissionais() {
        List<ProfissionalDTO> profissionais = profissionalService.getAllProfissionais();
        return ResponseEntity.ok(profissionais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalDTO> getProfissionalById(@PathVariable Long id) {
        ProfissionalDTO profissional = profissionalService.getProfissionalById(id);
        if (profissional == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profissional);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalDTO> updateProfissional(@PathVariable Long id,
            @RequestBody ProfissionalDTO profissionalDTO) {
        ProfissionalDTO updatedProfissional = profissionalService.updateProfissional(id, profissionalDTO);
        if (updatedProfissional == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProfissional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfissional(@PathVariable Long id) {
        profissionalService.deleteProfissional(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/consultas")
    public ResponseEntity<List<ConsultaDTO>> filtrarConsultasPorProfissional(
            @PathVariable Long id,
            @RequestParam(required = false) StatusConsulta status,
            @RequestParam(required = false, name = "data_de") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataDe,
            @RequestParam(required = false, name = "data_ate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataAte) {
        List<ConsultaDTO> consultas = consultaService.filtrarConsultas(id, null, status, dataDe, dataAte);
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/{id}/stats")
    public ResponseEntity<ProfissionalDTO> statsProfissional(@PathVariable Long id) {
        ProfissionalDTO stats = consultaService.getProfissionalStats(id);
        if (stats == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(stats);
    }
}
