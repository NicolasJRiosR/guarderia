package com.guarderia.guarderia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.guarderia.guarderia.dto.UsuarioRequestDTO;
import com.guarderia.guarderia.dto.UsuarioResponseDTO;
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
    private final PasswordEncoder passwordEncoder;

    public List<UsuarioResponseDTO> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> UsuarioResponseDTO.builder()
                        .id(usuario.getId())
                        .nombre(usuario.getNombre())
                        .apellido(usuario.getApellido())
                        .correo(usuario.getCorreo())
                        .activo(usuario.getActivo())
                        .rolId(usuario.getRol().getId())
                        .build())
                .toList();
    }

    public Optional<UsuarioResponseDTO> findById(Long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> UsuarioResponseDTO.builder()
                        .id(usuario.getId())
                        .nombre(usuario.getNombre())
                        .apellido(usuario.getApellido())
                        .correo(usuario.getCorreo())
                        .activo(usuario.getActivo())
                        .rolId(usuario.getRol().getId())
                        .build());
    }

    public UsuarioResponseDTO save(UsuarioRequestDTO dto) {

        Rol rol = rolRepository.findById(dto.getRolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        Usuario usuario = Usuario.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .correo(dto.getCorreo())
                .password(passwordEncoder.encode(dto.getPassword()))
                .activo(dto.getActivo())
                .rol(rol)
                .build();

        Usuario guardado = usuarioRepository.save(usuario);

        return UsuarioResponseDTO.builder()
                .id(guardado.getId())
                .nombre(guardado.getNombre())
                .apellido(guardado.getApellido())
                .correo(guardado.getCorreo())
                .activo(guardado.getActivo())
                .rolId(guardado.getRol().getId())
                .build();
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}