package com.guarderia.guarderia.config;

import com.guarderia.guarderia.entity.Grupo;
import com.guarderia.guarderia.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final GrupoRepository grupoRepository;

    @Bean
    CommandLineRunner initGrupos() {
        return args -> {

            if (grupoRepository.count() > 0) {
                return;
            }

            for (int nivel = 1; nivel <= 11; nivel++) {

                int edadPromedio = nivel + 5;
                short edadMinima = (short) (edadPromedio - 1);
                short edadMaxima = (short) (edadPromedio + 2);

                for (int numeroGrupo = 1; numeroGrupo <= 4; numeroGrupo++) {

                    Grupo grupo = Grupo.builder()
                            .nombre(nivel + "-" + numeroGrupo)
                            .edadMinima(edadMinima)
                            .edadMaxima(edadMaxima)
                            .capacidad(34)
                            .profesor(null)
                            .build();

                    grupoRepository.save(grupo);
                }
            }
        };
    }
}