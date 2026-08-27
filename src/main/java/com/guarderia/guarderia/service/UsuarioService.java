package com.guarderia.guarderia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.guarderia.guarderia.dto.UsuarioDTO;
import com.guarderia.guarderia.entity.Rol;
import com.guarderia.guarderia.entity.Usuario;
import com.guarderia.guarderia.repository.RolRepository;
import com.guarderia.guarderia.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UsuarioService {

     private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;


    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> UsuarioDTO.builder()
                        .id(usuario.getId())
                        .nombre(usuario.getNombre())
                        .apellido(usuario.getApellido())
                        .correo(usuario.getCorreo())
                        .password(usuario.getPassword())
                        .activo(usuario.getActivo())
                        .rolId(usuario.getRol().getId())
                        .build())
                .toList();
    }

    public Optional<UsuarioDTO> findById(Long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> UsuarioDTO.builder()
                        .id(usuario.getId())
                        .nombre(usuario.getNombre())
                        .apellido(usuario.getApellido())
                        .correo(usuario.getCorreo())
                        .password(usuario.getPassword())
                        .activo(usuario.getActivo())
                        .rolId(usuario.getRol().getId())
                        .build());
    }

    public UsuarioDTO save(UsuarioDTO dto) {

        Rol rol = rolRepository.findById(dto.getRolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        Usuario usuario = Usuario.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .correo(dto.getCorreo())
                .password(dto.getPassword())
                .activo(dto.getActivo())
                .rol(rol)
                .build();

        Usuario guardado = usuarioRepository.save(usuario);

        return UsuarioDTO.builder()
                .id(guardado.getId())
                .nombre(guardado.getNombre())
                .apellido(guardado.getApellido())
                .correo(guardado.getCorreo())
                .password(guardado.getPassword())
                .activo(guardado.getActivo())
                .rolId(guardado.getRol().getId())
                .build();
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
