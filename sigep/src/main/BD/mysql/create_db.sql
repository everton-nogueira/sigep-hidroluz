CREATE TABLE endereco (
  idEndereco INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  estado VARCHAR(2) NOT NULL,
  cidade VARCHAR(45) NOT NULL,
  pais VARCHAR(45) NOT NULL,
  endereco VARCHAR(100) NULL,
  pontoReferencia VARCHAR(45) NULL,
  PRIMARY KEY(idEndereco)
);

CREATE TABLE telefone (
  idTelefone INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  numero INTEGER UNSIGNED NOT NULL,
  ddd INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idTelefone)
);

CREATE TABLE mensagem (
  idMensagem INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  mensagem VARCHAR NULL,
  PRIMARY KEY(idMensagem)
);

CREATE TABLE grupoMuscular (
  idGrupoMuscular INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idGrupoMuscular)
);

CREATE TABLE alimento (
  idAlimento INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  quantidade INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idAlimento)
);

CREATE TABLE categoriaSuplemento (
  idCategoriaSuplemento INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nomeCategoria VARCHAR(45) NOT NULL,
  PRIMARY KEY(idCategoriaSuplemento)
);

CREATE TABLE suplemento (
  idSuplemento INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  categoriaSuplemento_idCategoriaSuplemento INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(45) NOT NULL,
  marca VARCHAR(45) NOT NULL,
  valor FLOAT NULL,
  PRIMARY KEY(idSuplemento),
  INDEX suplemento_FKIndex1(categoriaSuplemento_idCategoriaSuplemento)
);

CREATE TABLE academia (
  idAcademia INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  telefone_idTelefone INTEGER UNSIGNED NOT NULL,
  endereco_idEndereco INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(45) NOT NULL,
  valor VARCHAR NOT NULL,
  nivel INTEGER UNSIGNED NOT NULL,
  horarioFuncionamento VARCHAR NULL,
  PRIMARY KEY(idAcademia),
  INDEX academia_FKIndex1(endereco_idEndereco),
  INDEX academia_FKIndex2(telefone_idTelefone)
);

CREATE TABLE pessoa (
  idpessoa INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  telefone_idTelefone INTEGER UNSIGNED NOT NULL,
  academia_idAcademia INTEGER UNSIGNED NOT NULL,
  endereco_idEndereco INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(255) NOT NULL,
  sexo VARCHAR(1) NOT NULL,
  dataNascimento DATE NOT NULL,
  senha VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  PRIMARY KEY(idpessoa),
  INDEX pessoa_FKIndex1(endereco_idEndereco),
  INDEX pessoa_FKIndex2(academia_idAcademia),
  INDEX pessoa_FKIndex3(telefone_idTelefone)
);

CREATE TABLE video (
  idVideo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  link VARCHAR NOT NULL,
  PRIMARY KEY(idVideo),
  INDEX video_FKIndex1(pessoa_idpessoa)
);

CREATE TABLE pagina (
  idPagina INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(45) NULL,
  descricao VARCHAR NULL,
  dataCriacao DATE NULL,
  PRIMARY KEY(idPagina),
  INDEX pagina_FKIndex1(pessoa_idpessoa)
);

CREATE TABLE treino (
  idTreino INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(45) NOT NULL,
  PRIMARY KEY(idTreino),
  INDEX treino_FKIndex1(pessoa_idpessoa)
);

CREATE TABLE amizade (
  idAmizade INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  statusAmizade INTEGER UNSIGNED NULL,
  PRIMARY KEY(idAmizade),
  INDEX amizade_FKIndex1(pessoa_idpessoa)
);

CREATE TABLE foto (
  idFoto INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  localizacao VARCHAR NOT NULL,
  descricao VARCHAR NOT NULL,
  dataFoto DATE NOT NULL,
  PRIMARY KEY(idFoto),
  INDEX foto_FKIndex1(pessoa_idpessoa)
);

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
  INDEX historicoMedida_FKIndex1(pessoa_idpessoa)
);

CREATE TABLE dieta (
  idDieta INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  alimento_idAlimento INTEGER UNSIGNED NOT NULL,
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  qtdRefeicoes INTEGER UNSIGNED NULL,
  PRIMARY KEY(idDieta),
  INDEX dieta_FKIndex1(pessoa_idpessoa),
  INDEX dieta_FKIndex2(alimento_idAlimento)
);

CREATE TABLE suplementoPessoa (
  suplemento_idSuplemento INTEGER UNSIGNED NOT NULL,
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(suplemento_idSuplemento, pessoa_idpessoa),
  INDEX suplemento_has_pessoa_FKIndex1(suplemento_idSuplemento),
  INDEX suplemento_has_pessoa_FKIndex2(pessoa_idpessoa)
);

CREATE TABLE pessoa_has_mensagem (
  pessoa_idpessoa INTEGER UNSIGNED NOT NULL,
  mensagem_idMensagem INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(pessoa_idpessoa, mensagem_idMensagem),
  INDEX pessoa_has_mensagem_FKIndex1(pessoa_idpessoa),
  INDEX pessoa_has_mensagem_FKIndex2(mensagem_idMensagem)
);

CREATE TABLE exercicio (
  idExercicio INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  grupoMuscular_idGrupoMuscular INTEGER UNSIGNED NOT NULL,
  treino_idTreino INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(45) NOT NULL,
  qtdSeries INTEGER UNSIGNED NOT NULL,
  qtdRepeticoes INTEGER UNSIGNED NULL,
  PRIMARY KEY(idExercicio),
  INDEX exercicio_FKIndex1(treino_idTreino),
  INDEX exercicio_FKIndex2(grupoMuscular_idGrupoMuscular)
);


