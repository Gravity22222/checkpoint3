package br.com.fiap.checkpoint2.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.DTOs.ProfissionalDTO;
import br.com.fiap.checkpoint2.model.Profissional;
import br.com.fiap.checkpoint2.repository.ProfissionalRepository;

@Service

public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public ProfissionalDTO createProfissional(ProfissionalDTO profissionalDTO) {
        Profissional profissional = new Profissional();
        profissional.setNome(profissionalDTO.getNome());
        profissional.setEspecialidade(profissionalDTO.getEspecialidade());
        profissional.setValor_hora(profissionalDTO.getValorHora());
        profissional.setCreated_at(profissionalDTO.getCreated_at());
        profissional.setUpdated_at(profissionalDTO.getUpdated_at());
        profissional.setTotalConsultas(profissionalDTO.getTotalConsultas());
        profissional.setConsultasAgendadas(profissionalDTO.getConsultasAgendadas());
        profissional.setConsultasRealizadas(profissionalDTO.getConsultasRealizadas());

        Profissional savedProfissional = profissionalRepository.save(profissional);

        return new ProfissionalDTO(
                savedProfissional.getId(),
                savedProfissional.getNome(),
                savedProfissional.getEspecialidade(),
                savedProfissional.getValor_hora(),
                savedProfissional.getUpdated_at(),
                savedProfissional.getCreated_at(),
                savedProfissional.getTotalConsultas(),
                savedProfissional.getConsultasAgendadas(),
                savedProfissional.getConsultasRealizadas(),
                savedProfissional.getConsultasCanceladas(),
                savedProfissional.getValorTotalConsultas());
    }

    public List<ProfissionalDTO> getAllProfissionais() {
        return profissionalRepository.findAll()
                .stream()
                .map(profissional -> new ProfissionalDTO(
                        profissional.getId(),
                        profissional.getNome(),
                        profissional.getEspecialidade(),
                        profissional.getValor_hora(),
                        profissional.getUpdated_at(),
                        profissional.getCreated_at(),
                        profissional.getTotalConsultas(),
                        profissional.getConsultasAgendadas(),
                        profissional.getConsultasRealizadas(),
                        profissional.getConsultasCanceladas(),
                        profissional.getValorTotalConsultas()))
                .collect(Collectors.toList());
    }

    public ProfissionalDTO getProfissionalById(Long id) {
        Optional<Profissional> profissional = profissionalRepository.findById(id);
        return profissional.map(p -> new ProfissionalDTO(
                p.getId(),
                p.getNome(),
                p.getEspecialidade(),
                p.getValor_hora(),
                p.getCreated_at(),
                p.getUpdated_at(),
                p.getTotalConsultas(),
                p.getConsultasAgendadas(),
                p.getConsultasRealizadas(),
                p.getConsultasCanceladas(),
                p.getValorTotalConsultas())).orElse(null);
    }

    public ProfissionalDTO updateProfissional(Long id, ProfissionalDTO profissionalDTO) {
        Optional<Profissional> optionalProfissional = profissionalRepository.findById(id);

        if (optionalProfissional.isEmpty()) {
            return null; 
        }

        Profissional profissional = optionalProfissional.get();
        profissional.setNome(profissionalDTO.getNome());
        profissional.setEspecialidade(profissionalDTO.getEspecialidade());
        profissional.setValor_hora(profissionalDTO.getValorHora());

        Profissional updatedProfissional = profissionalRepository.save(profissional);

        return new ProfissionalDTO(
                updatedProfissional.getId(),
                updatedProfissional.getNome(),
                updatedProfissional.getEspecialidade(),
                updatedProfissional.getValor_hora(),
                updatedProfissional.getCreated_at(),
                updatedProfissional.getUpdated_at(),
                updatedProfissional.getTotalConsultas(),
                updatedProfissional.getConsultasAgendadas(),
                updatedProfissional.getConsultasRealizadas(),
                updatedProfissional.getConsultasCanceladas(),
                updatedProfissional.getValorTotalConsultas());
    }

    public void deleteProfissional(Long id) {
        profissionalRepository.deleteById(id);
    }
}
