package br.edu.iftm.saudesolidaria.api.service;

import br.edu.iftm.saudesolidaria.model.entity.Especialidade;
import br.edu.iftm.saudesolidaria.model.entity.Local;
import br.edu.iftm.saudesolidaria.model.input.EspecialidadeInput;
import br.edu.iftm.saudesolidaria.model.repository.EspecialidadeRepository;
import br.edu.iftm.saudesolidaria.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EspecialidadeService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private final EspecialidadeRepository especialidadeRepository;

    public Especialidade save(EspecialidadeInput especialidadeInput) {
        Especialidade especialidade = modelMapper.map(especialidadeInput, Especialidade.class);
        return especialidadeRepository.save(especialidade);
    }

    public List<Especialidade> listAll() {
        return especialidadeRepository.findAll();
    }

    public Especialidade findById(Long id) {
        return especialidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Especialidade não encontrada"));
    }

    public Especialidade updateById(Long id, EspecialidadeInput especialidadeInput) {
        Especialidade especialidade = findById(id);
        especialidade.setEspecialidade(especialidadeInput.getEspecialidade());
        return especialidadeRepository.save(especialidade);
    }

    public Especialidade deactivateById(Long id) {
        Especialidade especialidade = findById(id);
        especialidade.setActived(false);
        return especialidadeRepository.save(especialidade);
    }

    public Especialidade activatedById(Long id) {
        Especialidade espec = findById(id);
        espec.setActived(true);
        return especialidadeRepository.save(espec);
    }

}
