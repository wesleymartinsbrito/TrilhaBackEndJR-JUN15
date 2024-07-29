package com.wesleymartins.codigocerto.controllers;

import com.wesleymartins.codigocerto.entities.User;
import com.wesleymartins.codigocerto.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/users", produces = {"application/json"})
@Tag(name = "codigo-certo")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "Insere usuários", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario inserido com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao inserir usuário"),
    })
    @PostMapping
    public ResponseEntity<User> insert(User user){
        return ResponseEntity.ok().body(userService.insert(user));
    }
}
