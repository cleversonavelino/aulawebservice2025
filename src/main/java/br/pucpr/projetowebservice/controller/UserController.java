package br.pucpr.projetowebservice.controller;

import br.pucpr.projetowebservice.dto.UserDTO;
import br.pucpr.projetowebservice.exception.BusinessException;
import br.pucpr.projetowebservice.model.User;
import br.pucpr.projetowebservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "Usuário", description = "APIs de gerenciamento de usuários")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    private List<UserDTO> usuarios = new ArrayList<>();

    @PostMapping
    @Operation(summary = "Salva um usuário", description = "Salva um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário Salvo com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Os dados do usuário estão incorretos."),
    })
    public ResponseEntity<UserDTO> save(@Valid @RequestBody UserDTO usuarioDTO) {
        User user = new ModelMapper().map(usuarioDTO, User.class);
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
    }

    @GetMapping
    @Operation(summary = "Obter a lista de usuários", description = "Retorna a lista de usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recuperado com sucesso"),
    })
    public List<UserDTO> findAll() {
        return usuarios;
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable("id") Integer id, @RequestBody UserDTO usuarioDTO)
            throws BusinessException {
        if (id == null || usuarioDTO.getId() == null) {
            throw new BusinessException("ID_REQUIRED","O ID é necessário");
        }

        usuarioDTO.setId(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
    }

}
