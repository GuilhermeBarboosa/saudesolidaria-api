package br.edu.iftm.saudesolidaria.api.controller;

import br.edu.iftm.saudesolidaria.api.service.MedicoService;
import br.edu.iftm.saudesolidaria.api.service.UserService;
import br.edu.iftm.saudesolidaria.model.entity.Medico;
import br.edu.iftm.saudesolidaria.model.entity.User;
import br.edu.iftm.saudesolidaria.model.input.MedicoInput;
import br.edu.iftm.saudesolidaria.model.input.UserInput;
import br.edu.iftm.saudesolidaria.model.output.MedicoOutput;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final MedicoService medicoService;

    @Autowired
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody MedicoInput medicoInput) {
        UserInput user = new UserInput(medicoInput.getNome(), medicoInput.getCpf(), medicoInput.getEmail(), medicoInput.getSenha(), medicoInput.getRole());
        User userCreated = userService.save(user);
        medicoInput.setId_user(userCreated.getId());
        Medico createdMedico = medicoService.save(medicoInput);
        MedicoOutput medicoOutput = new MedicoOutput(createdMedico);
        return ResponseEntity.ok(medicoOutput);
    }

    @GetMapping
    public ResponseEntity<List<MedicoOutput>> listAll() {
        List<Medico> medicos = medicoService.listAll();
        List<MedicoOutput> responseDTOS = medicos.stream()
                .map(MedicoOutput::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoOutput> getById(@PathVariable Long id) {
        Medico medico = medicoService.findById(id);
        MedicoOutput medicoOutput = new MedicoOutput(medico);
        return ResponseEntity.ok(medicoOutput);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody @Valid MedicoInput medicoInput) {
        Medico updatedMedico = medicoService.updateById(id, medicoInput);
        MedicoOutput medicoOutput = new MedicoOutput(updatedMedico);
        return ResponseEntity.ok(medicoOutput);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MedicoOutput> deactivateById(@PathVariable Long id) {
        Medico deactivatedMedico = medicoService.deactivateById(id);
        MedicoOutput medicoOutput = new MedicoOutput(deactivatedMedico);
        return ResponseEntity.ok(medicoOutput);
    }
}
