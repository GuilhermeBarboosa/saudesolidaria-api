package br.edu.iftm.saudesolidaria.api.controller;

import br.edu.iftm.saudesolidaria.api.service.JwtService;
import br.edu.iftm.saudesolidaria.api.service.UserService;
import br.edu.iftm.saudesolidaria.exception.SenhaInvalidaException;
import br.edu.iftm.saudesolidaria.model.entity.User;
import br.edu.iftm.saudesolidaria.model.input.LoginInput;
import br.edu.iftm.saudesolidaria.model.output.Token;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public Token login(@RequestBody LoginInput loginInput) {
        try {
            User usuario = User.builder()
                    .email(loginInput.getEmail())
                    .senha(loginInput.getSenha()).build();

            User user = userService.autenticar(usuario);
            String token = jwtService.gerarToken(user);
            return new Token(usuario.getEmail(), token);

        } catch (SenhaInvalidaException | UsernameNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

    @PostMapping("/verifyToken")
    public boolean verifyToken(@RequestBody String token) {
        try {
            return jwtService.tokenValido(token);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

    @PostMapping("/obterClaims")
    public Claims obterClaims(@RequestBody String token) {
        try {
            return jwtService.obterClaims(token);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
