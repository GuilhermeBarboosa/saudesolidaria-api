package br.edu.iftm.saudesolidaria.api.service;

import br.edu.iftm.saudesolidaria.model.entity.Local ;
import br.edu.iftm.saudesolidaria.model.input.LocalInput;
import br.edu.iftm.saudesolidaria.model.repository.LocalRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LocalService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private final LocalRepository localRepository;

    public Local save(LocalInput localInput) {
        Local local = modelMapper.map(localInput, Local.class);
        return localRepository.save(local);
    }

    public List<Local> listAll() {
        return localRepository.findAll();
    }

    public Local findById(Long id) {
        return localRepository.findById(id).orElseThrow(() -> new RuntimeException("Local  não encontrada"));
    }

    public Local  updateById(Long id, LocalInput localInput) {
        Local local = findById(id);
        local.setRua(localInput.getRua());
        local.setBairro(localInput.getBairro());
        local.setNumero(localInput.getNumero());
        local.setNome_local(localInput.getNome_local());
        return localRepository.save(local);
    }

    public Local deactivateById(Long id) {
        Local local = findById(id);
        local.setActived(false);
        return localRepository.save(local);
    }

    public Local activatedById(Long id) {
        Local local = findById(id);
        local.setActived(true);
        return localRepository.save(local);
    }
}
