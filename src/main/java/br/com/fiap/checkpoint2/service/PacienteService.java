package br.com.fiap.checkpoint2.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.DTOs.PacienteDTO;
import br.com.fiap.checkpoint2.model.Paciente;
import br.com.fiap.checkpoint2.repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteDTO createPaciente(PacienteDTO pacienteDTO) {

        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDTO.getNome());
        paciente.setEndereco(pacienteDTO.getEndereco());
        paciente.setBairro(pacienteDTO.getBairro());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setTelefone_completo(pacienteDTO.getTelefoneCompleto());
        paciente.setData_nascimento(pacienteDTO.getDataNascimento());
        paciente.setCreated_at(pacienteDTO.getCreated_at());
        paciente.setUpdated_at(pacienteDTO.getUpdated_at());

        Paciente savedPaciente = pacienteRepository.save(paciente);
        return mapToDTO(savedPaciente);
    }

    public List<PacienteDTO> getAllPacientes() {
        return pacienteRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public PacienteDTO getPacienteById(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente.map(this::mapToDTO).orElse(null);
    }

    public PacienteDTO updatePaciente(Long id, PacienteDTO pacienteDTO) {

        Paciente paciente = pacienteRepository.findById(id).orElse(new Paciente());
        paciente.setId(id);
        paciente.setNome(pacienteDTO.getNome());
        paciente.setEndereco(pacienteDTO.getEndereco());
        paciente.setBairro(pacienteDTO.getBairro());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setTelefone_completo(pacienteDTO.getTelefoneCompleto());
        paciente.setData_nascimento(pacienteDTO.getDataNascimento());
        paciente.setCreated_at(pacienteDTO.getCreated_at());
        paciente.setUpdated_at(pacienteDTO.getUpdated_at());

        Paciente updatedPaciente = pacienteRepository.save(paciente);
        return mapToDTO(updatedPaciente);
    }

    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    private PacienteDTO mapToDTO(Paciente paciente) {
        PacienteDTO dto = new PacienteDTO();
        dto.setId(paciente.getId());
        dto.setNome(paciente.getNome());
        dto.setEndereco(paciente.getEndereco());
        dto.setBairro(paciente.getBairro());
        dto.setEmail(paciente.getEmail());
        dto.setTelefoneCompleto(paciente.getTelefone_completo());
        dto.setDataNascimento(paciente.getData_nascimento());
        dto.setCreated_at(paciente.getCreated_at());
        dto.setUpdated_at(paciente.getUpdated_at());
        return dto;
    }

}
