package br.com.programandoascegas.blog.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comentario")
public record Comentario(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_comentario")
        Long id,

        @Column(name = "texto", nullable = false, columnDefinition = "TEXT")
        String texto,

        @ManyToOne
        @JoinColumn(name = "id_usuario")
        Usuario usuario,

        @ManyToOne
        @JoinColumn(name = "id_post", nullable = false)
        Post post,

        @Column(name = "data_criacao", nullable = false)
        LocalDateTime dataCriacao,

        @Column(name = "data_atualizacao", nullable = false)
        LocalDateTime dataAtualizacao
) {
}
