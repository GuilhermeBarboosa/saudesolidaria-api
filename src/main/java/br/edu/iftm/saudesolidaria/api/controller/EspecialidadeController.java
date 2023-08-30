package br.edu.iftm.saudesolidaria.api.controller;

import br.edu.iftm.saudesolidaria.api.service.EspecialidadeService;
import br.edu.iftm.saudesolidaria.model.entity.Especialidade;
import br.edu.iftm.saudesolidaria.model.entity.Local;
import br.edu.iftm.saudesolidaria.model.input.EspecialidadeInput;
import br.edu.iftm.saudesolidaria.model.output.EspecialidadeOutput;
import br.edu.iftm.saudesolidaria.model.output.LocalOutput;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/especialidade")
public class EspecialidadeController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final EspecialidadeService especialidadeService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody EspecialidadeInput especialidadeInput) {
        Especialidade createdEspecialidade = especialidadeService.save(especialidadeInput);
        EspecialidadeOutput especialidadeOutput = new EspecialidadeOutput(createdEspecialidade);
        return ResponseEntity.ok(especialidadeOutput);
    }

    @GetMapping
    public ResponseEntity<List<EspecialidadeOutput>> listAll() {
        List<Especialidade> especialidades = especialidadeService.listAll();
        List<EspecialidadeOutput> responseDTOS = especialidades.stream()
                .map(EspecialidadeOutput::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeOutput> getById(@PathVariable Long id) {
        Especialidade especialidade = especialidadeService.findById(id);
        EspecialidadeOutput especialidadeOutput = new EspecialidadeOutput(especialidade);
        return ResponseEntity.ok(especialidadeOutput);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody @Valid EspecialidadeInput especialidadeInput) {
        Especialidade updatedEspecialidade = especialidadeService.updateById(id, especialidadeInput);
        EspecialidadeOutput especialidadeOutput = new EspecialidadeOutput(updatedEspecialidade);
        return ResponseEntity.ok(especialidadeOutput);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EspecialidadeOutput> deactivateById(@PathVariable Long id) {
        Especialidade deactivatedEspecialidade = especialidadeService.deactivateById(id);
        EspecialidadeOutput especialidadeOutput = new EspecialidadeOutput(deactivatedEspecialidade);
        return ResponseEntity.ok(especialidadeOutput);
    }

    @PutMapping("/ativar/{id}")
    public ResponseEntity<?> activedById(@PathVariable Long id) {
        Especialidade updatedEspecialidade = especialidadeService.activatedById(id);
        EspecialidadeOutput especOutput = new EspecialidadeOutput(updatedEspecialidade);
        return ResponseEntity.ok(especOutput);
    }
}
