package exe.gba.projetojpadb.controller;

import exe.gba.projetojpadb.dto.UsuarioCriacaoDto;
import exe.gba.projetojpadb.dto.UsuarioListagemDto;
import exe.gba.projetojpadb.entity.Usuario;
import exe.gba.projetojpadb.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<UsuarioListagemDto> criar(@RequestBody @Valid
                                                        UsuarioCriacaoDto novoUsuario) {
        Usuario usuario = UsuarioMapper.toEntity(novoUsuario);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        UsuarioListagemDto dto = UsuarioMapper.toDto(usuarioSalvo);


        return ResponseEntity.status(201).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioListagemDto> porId(@PathVariable int id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        UsuarioListagemDto dto = UsuarioMapper.toDto(usuarioOpt.get());

        return ResponseEntity.status(200).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioListagemDto>> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        if (usuarios.isEmpty()) return ResponseEntity.status(204).build();


        return ResponseEntity.status(200).body(UsuarioMapper.toDto(usuarios));
    }


}
