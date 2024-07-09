package br.com.programandoascegas.blog.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public record Usuario(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_usuario")
        Long id,

        @Column(name = "nome", nullable = false, length = 50)
        String nome,

        @Column(name = "email", nullable = false, length = 50)
        String email,

        @Column(name = "senha", nullable = false, length = 200)
        String senha,

        @Column(name = "perfil", nullable = false, length = 20)
        String perfil,

        @Column(name = "codigo_verificacao", length = 6)
        String codigoVerificacao,

        @Column(name = "expiracao_codigo")
        LocalDateTime expiracaoCodigo,

        @Column(name = "data_criacao", nullable = false)
        LocalDateTime dataCriacao,

        @Column(name = "data_atualizacao", nullable = false)
        LocalDateTime dataAtualizacao
) {
}
