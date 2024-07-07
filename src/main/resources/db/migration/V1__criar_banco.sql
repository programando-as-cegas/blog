CREATE TABLE usuario(
    id_usuario BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(200) NOT NULL,
    perfil VARCHAR(20) NOT NULL,
    codigo_verificacao VARCHAR(6),
    expiracao_codigo DATETIME,
    data_criacao DATETIME NOT NULL,
    data_atualizacao DATETIME NOT NULL
);

CREATE TABLE categoria(
    id_categoria BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE post(
    id_post BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    texto TEXT NOT NULL,
    disponivel TINYINT(1) DEFAULT 0,
    id_categoria BIGINT NOT NULL,
    id_usuario BIGINT,
    data_criacao DATETIME NOT NULL,
    data_atualizacao DATETIME NOT NULL,
    FOREIGN KEY(id_categoria) REFERENCES categoria(id_categoria),
    FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario) ON DELETE SET NULL
);

CREATE TABLE comentario(
    id_comentario BIGINT AUTO_INCREMENT PRIMARY KEY,
    texto TEXT NOT NULL,
    id_usuario BIGINT,
    id_post BIGINT NOT NULL,
    data_criacao DATETIME NOT NULL,
    data_atualizacao DATETIME NOT NULL,
    FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario) ON DELETE SET NULL,
    FOREIGN KEY(id_post) REFERENCES post(id_post) ON DELETE CASCADE
);

CREATE TABLE aprovacao(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(20) NOT NULL,
    mensagem VARCHAR(100),
    id_usuario BIGINT,
    id_post BIGINT NOT NULL,
    data_atualizacao DATETIME NOT NULL,
    FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario) ON DELETE SET NULL,
    FOREIGN KEY(id_post) REFERENCES post(id_post) ON DELETE CASCADE
);