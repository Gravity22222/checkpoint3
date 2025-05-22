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
import br.com.fiap.checkpoint2.model.StatusConsulta;
import br.com.fiap.checkpoint2.service.ConsultaService;


@RestController
@RequestMapping("consultas")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaDTO> createConsulta(@RequestBody ConsultaDTO consultaDTO) {
        ConsultaDTO createdConsulta = consultaService.createConsulta(consultaDTO);
        return ResponseEntity.ok(createdConsulta);
    }

    @GetMapping("/todas")
    public ResponseEntity<List<ConsultaDTO>> getAllConsultas() {
        List<ConsultaDTO> consultas = consultaService.getAllConsultas();
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> getConsultaById(@PathVariable Long id) {
        ConsultaDTO consulta = consultaService.getConsultaById(id);
        if (consulta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(consulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDTO> updateConsulta(@PathVariable Long id, @RequestBody ConsultaDTO consultaDTO) {
        ConsultaDTO updatedConsulta = consultaService.updateConsulta(id, consultaDTO);
        if (updatedConsulta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedConsulta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable Long id) {
        consultaService.deleteConsulta(id);
        return ResponseEntity.noContent().build();
    }

     @GetMapping("/filtro")
    public ResponseEntity<List<ConsultaDTO>> filtrarConsultas(
            @RequestParam(required = false) StatusConsulta status,
            @RequestParam(required = false, name = "data_de") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataDe,
            @RequestParam(required = false, name = "data_ate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataAte) {
        List<ConsultaDTO> consultas = consultaService.filtrarConsultas(null, null, status, dataDe, dataAte);
        return ResponseEntity.ok(consultas);
    }

}
