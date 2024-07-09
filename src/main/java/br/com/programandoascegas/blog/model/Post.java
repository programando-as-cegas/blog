package br.com.programandoascegas.blog.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
public record Post(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_post")
        Long id,

        @Column(name = "titulo", nullable = false, length = 100)
        String titulo,

        @Column(name = "texto", nullable = false, columnDefinition = "TEXT")
        String texto,

        @Column(name = "disponivel")
        boolean disponivel,

        @ManyToOne
        @JoinColumn(name = "id_categoria", nullable = false)
        Categoria categoria,

        @ManyToOne
        @JoinColumn(name = "id_usuario")
        Usuario usuario,

        @Column(name = "data_criacao", nullable = false)
        LocalDateTime dataCriacao,

        @Column(name = "data_atualizacao", nullable = false)
        LocalDateTime dataAtualizacao
) {
}
