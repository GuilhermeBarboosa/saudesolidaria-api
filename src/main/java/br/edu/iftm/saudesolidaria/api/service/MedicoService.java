package br.edu.iftm.saudesolidaria.api.service;

import br.edu.iftm.saudesolidaria.model.entity.Medico;
import br.edu.iftm.saudesolidaria.model.input.MedicoInput;
import br.edu.iftm.saudesolidaria.model.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private final MedicoRepository medicoRepository;
    @Autowired
    private final EspecialidadeService especialidadeService;
    @Autowired
    private final UserService userService;

    public Medico save(MedicoInput medicoInput) {
        Medico medico = modelMapper.map(medicoInput, Medico.class);
        medico.setUser(userService.findById(medicoInput.getId_user()));
        medico.setEspecialidade(especialidadeService.findById(medicoInput.getEspecialidade()));
        System.out.println(medico.toString());
        return medicoRepository.save(medico);
    }

    public List<Medico> listAll() {
        return medicoRepository.findAll();
    }

    public Medico findById(Long id) {
        return medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Medico não encontrada"));
    }

    public Medico updateById(Long id, MedicoInput medicoInput) {
        Medico medico = findById(id);

        medico.setCrm(medicoInput.getCrm());
        medico.setEspecialidade(especialidadeService.findById(medicoInput.getEspecialidade()));
        medico.setUser(userService.findById(medicoInput.getId_user()));

        return medicoRepository.save(medico);

    }

    public Medico deactivateById(Long id) {
        Medico medico = findById(id);
        medico.setActived(false);
        return medicoRepository.save(medico);
    }

}
