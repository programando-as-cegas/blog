package br.com.programandoascegas.blog.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public record Categoria(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_categoria")
        Long id,

        @Column(name = "nome", nullable = false, length = 50)
        String nome
) {
}
