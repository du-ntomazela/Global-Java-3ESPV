package br.com.skillup.api.config;

import br.com.skillup.api.model.Usuario;
import br.com.skillup.api.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsuario(UsuarioRepository usuarioRepository) {
        return args -> {

            // Verifica se já existe algum usuário
            if (usuarioRepository.count() == 0) {

                Usuario admin = new Usuario();
                admin.setNome("Administrador");
                admin.setEmail("admin@skillup.com");

                // senha admin123 criptografada
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                admin.setSenha(encoder.encode("admin123"));

                usuarioRepository.save(admin);

                System.out.println("🔥 Usuário admin criado no banco com sucesso!");
                System.out.println("👉 Email: admin@skillup.com");
                System.out.println("👉 Senha: admin123");
            } else {
                System.out.println("ℹ️ Usuário já existente – nenhum admin criado.");
            }
        };
    }
}