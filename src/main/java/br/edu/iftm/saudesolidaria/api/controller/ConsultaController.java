package br.edu.iftm.saudesolidaria.api.controller;

import br.edu.iftm.saudesolidaria.api.service.ConsultasService;
import br.edu.iftm.saudesolidaria.model.entity.Consultas;
import br.edu.iftm.saudesolidaria.model.input.ConsultasInput;
import br.edu.iftm.saudesolidaria.model.output.ConsultasOutput;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final ConsultasService consultaService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ConsultasInput consultaInput) throws ParseException {
        Consultas createdConsulta = consultaService.save(consultaInput);
        ConsultasOutput consultaOutput = new ConsultasOutput(createdConsulta);
        return ResponseEntity.ok(consultaOutput);
    }

    @GetMapping
    public ResponseEntity<List<ConsultasOutput>> listAll() {
        List<Consultas> consultas = consultaService.listAll();
        List<ConsultasOutput> responseDTOS = consultas.stream()
                .map(ConsultasOutput::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultasOutput> getById(@PathVariable Long id) {
        Consultas consulta = consultaService.findById(id);
        ConsultasOutput consultaOutput = new ConsultasOutput(consulta);
        return ResponseEntity.ok(consultaOutput);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody @Valid ConsultasInput consultaInput) {
        Consultas updatedConsulta = consultaService.updateById(id, consultaInput);
        ConsultasOutput consultaOutput = new ConsultasOutput(updatedConsulta);
        return ResponseEntity.ok(consultaOutput);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ConsultasOutput> deactivateById(@PathVariable Long id) {
        Consultas deactivatedConsulta = consultaService.deactivateById(id);
        ConsultasOutput consultaOutput = new ConsultasOutput(deactivatedConsulta);
        return ResponseEntity.ok(consultaOutput);
    }

    @PutMapping("/ativar/{id}")
    public ResponseEntity<?> activedById(@PathVariable Long id) {
        Consultas updatedConsulta = consultaService.activatedById(id);
        ConsultasOutput especOutput = new ConsultasOutput(updatedConsulta);
        return ResponseEntity.ok(especOutput);
    }
}
