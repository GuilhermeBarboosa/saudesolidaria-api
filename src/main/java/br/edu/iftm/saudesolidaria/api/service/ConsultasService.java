package br.edu.iftm.saudesolidaria.api.service;

import br.edu.iftm.saudesolidaria.model.entity.Consultas;
import br.edu.iftm.saudesolidaria.model.entity.Especialidade;
import br.edu.iftm.saudesolidaria.model.input.ConsultasInput;
import br.edu.iftm.saudesolidaria.model.repository.ConsultasRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultasService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private final ConsultasRepository consultasRepository;
    @Autowired
    private final MedicoService medicoService;
    @Autowired
    private final LocalService localService;

    public Consultas save(ConsultasInput consultasInput) {
        Consultas consultas = modelMapper.map(consultasInput, Consultas.class);
        return consultasRepository.save(consultas);
    }

    public List<Consultas> listAll() {
        return consultasRepository.findAll();
    }

    public Consultas findById(Long id) {
        return consultasRepository.findById(id).orElseThrow(() -> new RuntimeException("Consultas não encontrada"));
    }

    public Consultas updateById(Long id, ConsultasInput consultasInput) {
        Consultas consultas = findById(id);
        consultas.setData(consultasInput.getData());
        consultas.setLocal(localService.findById(consultasInput.getLocal()));
        consultas.setMedico(medicoService.findById(consultasInput.getMedico()));
        return consultasRepository.save(consultas);
    }

    public Consultas deactivateById(Long id) {
        Consultas consultas = findById(id);
        consultas.setActived(false);
        return consultasRepository.save(consultas);
    }

    public Consultas activatedById(Long id) {
        Consultas consulta = findById(id);
        consulta.setActived(true);
        return consultasRepository.save(consulta);
    }
}
