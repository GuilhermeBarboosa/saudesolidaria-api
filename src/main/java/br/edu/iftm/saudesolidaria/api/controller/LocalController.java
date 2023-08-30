package br.edu.iftm.saudesolidaria.api.controller;

import br.edu.iftm.saudesolidaria.api.service.LocalService;
import br.edu.iftm.saudesolidaria.model.entity.Local;
import br.edu.iftm.saudesolidaria.model.input.LocalInput;
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
@RequestMapping("/local")
public class LocalController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final LocalService localService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody LocalInput localInput) {
        Local createdLocal = localService.save(localInput);
        LocalOutput localOutput = new LocalOutput(createdLocal);
        return ResponseEntity.ok(localOutput);
    }

    @GetMapping
    public ResponseEntity<List<LocalOutput>> listAll() {
        List<Local> locais = localService.listAll();
        List<LocalOutput> responseDTOS = locais.stream()
                .map(LocalOutput::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalOutput> getById(@PathVariable Long id) {
        Local local = localService.findById(id);
        LocalOutput localOutput = new LocalOutput(local);
        return ResponseEntity.ok(localOutput);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody @Valid LocalInput localInput) {
        Local updatedLocal = localService.updateById(id, localInput);
        LocalOutput localOutput = new LocalOutput(updatedLocal);
        return ResponseEntity.ok(localOutput);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<LocalOutput> deactivateById(@PathVariable Long id) {
        Local deactivatedLocal = localService.deactivateById(id);
        LocalOutput localOutput = new LocalOutput(deactivatedLocal);
        return ResponseEntity.ok(localOutput);
    }

    @PutMapping("/ativar/{id}")
    public ResponseEntity<?> activedById(@PathVariable Long id) {
        Local updatedLocal = localService.activatedById(id);
        LocalOutput localOutput = new LocalOutput(updatedLocal);
        return ResponseEntity.ok(localOutput);
    }

}
