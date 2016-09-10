DROP DATABASE webfitness;

CREATE DATABASE webfitness;

USE webfitness;

CREATE TABLE endereco (
  idEndereco INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  estado VARCHAR(2) NOT NULL,
  cidade VARCHAR(45) NOT NULL,
  pais VARCHAR(45) NOT NULL,
  endereco VARCHAR(100) NULL,
  pontoReferencia VARCHAR(45) NULL,
  PRIMARY KEY(idEndereco)
) ENGINE = innodb;

CREATE TABLE comunidade (
  idPagina INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NULL,
  descricao VARCHAR(255) NULL,
  dataCriacao DATE NULL,
  PRIMARY KEY(idPagina)
) ENGINE = innodb;

CREATE TABLE grupoMuscular (
  idGrupoMuscular INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idGrupoMuscular)
) ENGINE = innodb;

CREATE TABLE telefone (
  idTelefone INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  numero INTEGER UNSIGNED NOT NULL,
  ddd INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idTelefone)
) ENGINE = innodb;

CREATE TABLE mensagem (
  idMensagem INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  mensagem VARCHAR(255) NULL,
  dataMensagem DATE NULL,
  PRIMARY KEY(idMensagem)
) ENGINE = innodb;

CREATE TABLE alimento (
  idAlimento INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  quantidade INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idAlimento)
) ENGINE = innodb;

CREATE TABLE categoriaSuplemento (
  idCategoriaSuplemento INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nomeCategoria VARCHAR(45) NOT NULL,
  PRIMARY KEY(idCategoriaSuplemento)
) ENGINE = innodb;

CREATE TABLE suplemento (
  idSuplemento INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  categoriaSuplemento_idCategoriaSuplemento INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(45) NOT NULL,
  marca VARCHAR(45) NOT NULL,
  valor FLOAT NULL,
  PRIMARY KEY(idSuplemento),
  INDEX suplemento_FKIndex1(categoriaSuplemento_idCategoriaSuplemento),
  FOREIGN KEY(categoriaSuplemento_idCategoriaSuplemento)
    REFERENCES categoriaSuplemento(idCategoriaSuplemento)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE academia (
  idAcademia INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  endereco_idEndereco INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(45) NOT NULL,
  valor VARCHAR(255) NOT NULL,
  nivel INTEGER UNSIGNED NOT NULL,
  horarioFuncionamento VARCHAR(100) NULL,
  PRIMARY KEY(idAcademia),
  INDEX academia_FKIndex1(endereco_idEndereco),
  FOREIGN KEY(endereco_idEndereco)
    REFERENCES endereco(idEndereco)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE exercicio (
  idExercicio INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  grupoMuscular_idGrupoMuscular INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(45) NOT NULL,
  qtdSeries INTEGER UNSIGNED NOT NULL,
  qtdRepeticoes INTEGER UNSIGNED NULL,
  nivelDificuldade INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idExercicio),
  INDEX exercicio_FKIndex2(grupoMuscular_idGrupoMuscular),
  FOREIGN KEY(grupoMuscular_idGrupoMuscular)
    REFERENCES grupoMuscular(idGrupoMuscular)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE pessoa (
  idpessoa INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  academia_idAcademia INTEGER UNSIGNED NOT NULL,
  endereco_idEndereco INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(255) NOT NULL,
  sexo CHAR(1) NOT NULL,
  dataNascimento DATE NOT NULL,
  senha VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  relacionamento INTEGER UNSIGNED NULL,
  descricao VARCHAR(255) NULL,
  PRIMARY KEY(idpessoa),
  INDEX pessoa_FKIndex1(endereco_idEndereco),
  INDEX pessoa_FKIndex2(academia_idAcademia),
  FOREIGN KEY(endereco_idEndereco)
    REFERENCES endereco(idEndereco)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(academia_idAcademia)
    REFERENCES academia(idAcademia)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE academia_has_telefone (
  academia_idAcademia INTEGER UNSIGNED NOT NULL,
  telefone_idTelefone INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(academia_idAcademia, telefone_idTelefone),
  INDEX academia_has_telefone_FKIndex1(academia_idAcademia),
  INDEX academia_has_telefone_FKIndex2(telefone_idTelefone),
  FOREIGN KEY(academia_idAcademia)
    REFERENCES academia(idAcademia)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(telefone_idTelefone)
    REFERENCES telefone(idTelefone)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE pessoa_has_mensagem (
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  mensagem_idMensagem INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(pessoa_idpessoa, mensagem_idMensagem),
  INDEX pessoa_has_mensagem_FKIndex1(pessoa_idpessoa),
  INDEX pessoa_has_mensagem_FKIndex2(mensagem_idMensagem),
  FOREIGN KEY(pessoa_idpessoa)
    REFERENCES pessoa(idpessoa)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(mensagem_idMensagem)
    REFERENCES mensagem(idMensagem)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE pessoa_has_telefone (
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  telefone_idTelefone INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(pessoa_idpessoa, telefone_idTelefone),
  INDEX pessoa_has_telefone_FKIndex1(pessoa_idpessoa),
  INDEX pessoa_has_telefone_FKIndex2(telefone_idTelefone),
  FOREIGN KEY(pessoa_idpessoa)
    REFERENCES pessoa(idpessoa)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(telefone_idTelefone)
    REFERENCES telefone(idTelefone)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE video (
  idVideo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  link VARCHAR(255) NOT NULL,
  dataInicio DATE NULL,
  PRIMARY KEY(idVideo),
  INDEX video_FKIndex1(pessoa_idpessoa),
  FOREIGN KEY(pessoa_idpessoa)
    REFERENCES pessoa(idpessoa)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE treino (
  idTreino INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(45) NOT NULL,
  dataInicio DATE NULL,
  dataFim DATE NULL,
  PRIMARY KEY(idTreino),
  INDEX treino_FKIndex1(pessoa_idpessoa),
  FOREIGN KEY(pessoa_idpessoa)
    REFERENCES pessoa(idpessoa)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE postagem (
  idPostagem INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  texto VARCHAR(250) NULL,
  PRIMARY KEY(idPostagem, pessoa_idpessoa),
  INDEX postagem_FKIndex1(pessoa_idpessoa),
  FOREIGN KEY(pessoa_idpessoa)
    REFERENCES pessoa(idpessoa)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE amizade (
  idAmizade INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  statusAmizade INTEGER UNSIGNED NULL,
  PRIMARY KEY(idAmizade),
  INDEX amizade_FKIndex1(pessoa_idpessoa),
  FOREIGN KEY(pessoa_idpessoa)
    REFERENCES pessoa(idpessoa)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE dieta (
  idDieta INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  dataInicio DATE NULL,
  dataFim DATE NULL,
  objetivo VARCHAR(50) NULL,
  PRIMARY KEY(idDieta),
  INDEX dieta_FKIndex1(pessoa_idpessoa),
  FOREIGN KEY(pessoa_idpessoa)
    REFERENCES pessoa(idpessoa)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE historicoMedida (
  idMedida INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  dataMedicao DATE NULL,
  bracoEsquerdo FLOAT NULL,
  bracoDireito FLOAT NULL,
  anteBracoEsquerdo FLOAT NULL,
  anteBracoDireito FLOAT NULL,
  ombro FLOAT NULL,
  torax FLOAT NULL,
  abdomem FLOAT NULL,
  gluteos FLOAT NULL,
  coxaEsquerda FLOAT NULL,
  coxaDireita FLOAT NULL,
  panturrilhaEsquerda FLOAT NULL,
  panturrilhaDireita FLOAT NULL,
  PRIMARY KEY(idMedida),
  INDEX historicoMedida_FKIndex1(pessoa_idpessoa),
  FOREIGN KEY(pessoa_idpessoa)
    REFERENCES pessoa(idpessoa)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE foto (
  idFoto INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  localizacao VARCHAR(255) NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  dataFoto DATE NOT NULL,
  PRIMARY KEY(idFoto),
  INDEX foto_FKIndex1(pessoa_idpessoa),
  FOREIGN KEY(pessoa_idpessoa)
    REFERENCES pessoa(idpessoa)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE video_has_postagem (
  video_idVideo INTEGER UNSIGNED NOT NULL,
  postagem_idPostagem INTEGER UNSIGNED NOT NULL,
  postagem_pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(video_idVideo, postagem_idPostagem, postagem_pessoa_idpessoa),
  INDEX video_has_postagem_FKIndex1(video_idVideo),
  INDEX video_has_postagem_FKIndex2(postagem_idPostagem, postagem_pessoa_idpessoa),
  FOREIGN KEY(video_idVideo)
    REFERENCES video(idVideo)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(postagem_idPostagem, postagem_pessoa_idpessoa)
    REFERENCES postagem(idPostagem, pessoa_idpessoa)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE treino_has_exercicio (
  treino_idTreino INTEGER UNSIGNED NOT NULL,
  exercicio_idExercicio INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(treino_idTreino, exercicio_idExercicio),
  INDEX treino_has_exercicio_FKIndex1(treino_idTreino),
  INDEX treino_has_exercicio_FKIndex2(exercicio_idExercicio),
  FOREIGN KEY(treino_idTreino)
    REFERENCES treino(idTreino)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(exercicio_idExercicio)
    REFERENCES exercicio(idExercicio)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE pessoa_has_comunidade (
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  comunidade_idPagina INTEGER UNSIGNED NOT NULL,
  perfil INTEGER UNSIGNED NULL,
  PRIMARY KEY(pessoa_idpessoa, comunidade_idPagina),
  INDEX pessoa_has_comunidade_FKIndex1(pessoa_idpessoa),
  INDEX pessoa_has_comunidade_FKIndex2(comunidade_idPagina),
  FOREIGN KEY(pessoa_idpessoa)
    REFERENCES pessoa(idpessoa)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(comunidade_idPagina)
    REFERENCES comunidade(idPagina)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE postagem_has_foto (
  postagem_idPostagem INTEGER UNSIGNED NOT NULL,
  foto_idFoto INTEGER UNSIGNED NOT NULL,
  postagem_pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(postagem_idPostagem, foto_idFoto, postagem_pessoa_idpessoa),
  INDEX postagem_has_foto_FKIndex1(postagem_idPostagem, postagem_pessoa_idpessoa),
  INDEX postagem_has_foto_FKIndex2(foto_idFoto),
  FOREIGN KEY(postagem_idPostagem, postagem_pessoa_idpessoa)
    REFERENCES postagem(idPostagem, pessoa_idpessoa)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(foto_idFoto)
    REFERENCES foto(idFoto)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE refeicao (
  idRefeicao INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  dieta_idDieta INTEGER UNSIGNED NOT NULL,
  horario DATE NOT NULL,
  descricao VARCHAR(50) NOT NULL,
  PRIMARY KEY(idRefeicao),
  INDEX refeicao_FKIndex1(dieta_idDieta),
  FOREIGN KEY(dieta_idDieta)
    REFERENCES dieta(idDieta)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE refeicao_has_suplemento (
  refeicao_idRefeicao INTEGER UNSIGNED NOT NULL,
  suplemento_idSuplemento INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(refeicao_idRefeicao, suplemento_idSuplemento),
  INDEX refeicao_has_suplemento_FKIndex1(refeicao_idRefeicao),
  INDEX refeicao_has_suplemento_FKIndex2(suplemento_idSuplemento),
  FOREIGN KEY(refeicao_idRefeicao)
    REFERENCES refeicao(idRefeicao)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(suplemento_idSuplemento)
    REFERENCES suplemento(idSuplemento)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE refeicao_has_alimento (
  refeicao_idRefeicao INTEGER UNSIGNED NOT NULL,
  alimento_idAlimento INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(refeicao_idRefeicao, alimento_idAlimento),
  INDEX refeicao_has_alimento_FKIndex1(refeicao_idRefeicao),
  INDEX refeicao_has_alimento_FKIndex2(alimento_idAlimento),
  FOREIGN KEY(refeicao_idRefeicao)
    REFERENCES refeicao(idRefeicao)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(alimento_idAlimento)
    REFERENCES alimento(idAlimento)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;

CREATE TABLE funcao (
  idfuncao INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NULL,
  PRIMARY KEY(idfuncao)
) ENGINE = innodb;

CREATE TABLE pessoa_has_funcao (
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  funcao_idfuncao INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(pessoa_idpessoa, funcao_idfuncao),
  INDEX pessoa_has_funcao_FKIndex1(pessoa_idpessoa),
  INDEX pessoa_has_funcao_FKIndex2(funcao_idfuncao),
  FOREIGN KEY(pessoa_idpessoa)
    REFERENCES pessoa(idpessoa)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(funcao_idfuncao)
    REFERENCES funcao(idfuncao)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
) ENGINE = innodb;


INSERT INTO endereco (idEndereco, estado, cidade, pais, endereco, pontoReferencia)
			VALUES (null, 'DF', 'Brasília', 'Brasil', 'QNH 07 Casa 04', 'Escola Classe 12');
INSERT INTO endereco (idEndereco, estado, cidade, pais, endereco, pontoReferencia)
			VALUES (null, 'DF', 'Brasília', 'Brasil', 'CNB 12', 'Sesc Taguatinga Norte/Top Mall');
INSERT INTO telefone (idTelefone, ddd, numero)
			VALUES (null, 61, 84029970);
INSERT INTO telefone (idTelefone, ddd, numero)
			VALUES (null, 61, 33542226);
INSERT INTO academia (idAcademia, endereco_idEndereco, nome, valor, nivel, horarioFuncionamento)
			VALUES (null, 2, 'SPAÇO FITNESS', '100,00', 0, 'seg a sex das 6 as 23');
INSERT INTO academia_has_telefone (academia_idAcademia, telefone_idTelefone)
			VALUES (1, 2);
INSERT INTO pessoa (idPessoa, academia_idAcademia, endereco_idEndereco, nome, sexo, relacionamento, descricao, dataNascimento, senha, email)
			VALUES (null, 1, 1, 'Administrador', 'M', 0, 'Teste de descrição do administrador!', '1992-03-15', 'AZICOnu9cyUFFvBp3xi1AA==', 'admin@gmail.com'); /*senha = admin123*/
INSERT INTO pessoa_has_telefone (pessoa_idPessoa, telefone_idTelefone)
			VALUES (1, 1);
INSERT INTO funcao (idFuncao, nome)
			VALUES (null, 'ADMIN');
INSERT INTO funcao (idFuncao, nome)
			VALUES (null, 'USUARIO');
INSERT INTO pessoa_has_funcao (pessoa_idPessoa, funcao_idFuncao)
			VALUES (1,1);
INSERT INTO pessoa_has_funcao (pessoa_idPessoa, funcao_idFuncao)
			VALUES (1,2);