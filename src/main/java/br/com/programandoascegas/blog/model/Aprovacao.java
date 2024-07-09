package br.com.programandoascegas.blog.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "aprovacao")
public record Aprovacao(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        Long id,

        @Column(name = "status", nullable = false, length = 20)
        String status,

        @Column(name = "mensagem", length = 100)
        String mensagem,

        @ManyToOne
        @JoinColumn(name = "id_usuario")
        Usuario usuario,

        @ManyToOne
        @JoinColumn(name = "id_post", nullable = false)
        Post post,

        @Column(name = "data_atualizacao", nullable = false)
        LocalDateTime dataAtualizacao
) {
}
