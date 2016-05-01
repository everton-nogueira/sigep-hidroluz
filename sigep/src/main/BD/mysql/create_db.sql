/*################################################################
  ##		   BANCO DE DADOS DA APLICAÇÃO WEB-FITNESS			##
  ## 															##
  ## 	  Iniciando o processo de criação da base de dados... 	##
  ##															##
  ################################################################*/

CREATE DATABASE webfitness;

USE webfitness;

/*Criando as tabelas*/

CREATE TABLE endereco (
  idEndereco INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  estado VARCHAR(2) NOT NULL,
  cidade VARCHAR(45) NOT NULL,
  pais VARCHAR(45) NOT NULL,
  endereco VARCHAR(100) NULL,
  pontoReferencia VARCHAR(45) NULL,
  PRIMARY KEY(idEndereco)
) ENGINE = innodb;

CREATE TABLE telefone (
  idTelefone INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  numero INTEGER UNSIGNED NOT NULL,
  ddd INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idTelefone)
) ENGINE = innodb;

CREATE TABLE mensagem (
  idMensagem INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  mensagem VARCHAR(500) NULL,
  PRIMARY KEY(idMensagem)
) ENGINE = innodb;

CREATE TABLE grupoMuscular (
  idGrupoMuscular INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idGrupoMuscular)
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
  idCategoriaSuplemento INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(45) NOT NULL,
  marca VARCHAR(45) NOT NULL,
  valor FLOAT NULL,
  PRIMARY KEY(idSuplemento)
) ENGINE = innodb;

CREATE TABLE academia (
  idAcademia INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idTelefone INTEGER UNSIGNED NOT NULL,
  idEndereco INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(45) NOT NULL,
  valor VARCHAR(500) NOT NULL,
  nivel INTEGER UNSIGNED NOT NULL,
  horarioFuncionamento VARCHAR(100) NULL,
  PRIMARY KEY(idAcademia)
) ENGINE = innodb;

CREATE TABLE pessoa (
  idPessoa INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idTelefone INTEGER UNSIGNED NOT NULL,
  idAcademia INTEGER UNSIGNED NOT NULL,
  idEndereco INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(255) NOT NULL,
  sexo VARCHAR(1) NOT NULL,
  dataNascimento DATE NOT NULL,
  senha VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  PRIMARY KEY(idPessoa)
) ENGINE = innodb;

CREATE TABLE video (
  idVideo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idPessoa INTEGER UNSIGNED NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  link VARCHAR(250) NOT NULL,
  PRIMARY KEY(idVideo)
) ENGINE = innodb;

CREATE TABLE pagina (
  idPagina INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idPessoa INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(45) NULL,
  descricao VARCHAR(1000) NULL,
  dataCriacao DATE NULL,
  PRIMARY KEY(idPagina)
) ENGINE = innodb;

CREATE TABLE treino (
  idTreino INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idPessoa INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(45) NOT NULL,
  PRIMARY KEY(idTreino)
) ENGINE = innodb;

CREATE TABLE amizade (
  idAmizade INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idPessoa INTEGER UNSIGNED NOT NULL,
  idAmigo INTEGER UNSIGNED NOT NULL,
  statusAmizade INTEGER UNSIGNED NULL,
  PRIMARY KEY(idAmizade)
) ENGINE = innodb;

CREATE TABLE foto (
  idFoto INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idPessoa INTEGER UNSIGNED NOT NULL,
  localizacao VARCHAR(250) NOT NULL,
  descricao VARCHAR(250) NOT NULL,
  dataFoto DATE NOT NULL,
  PRIMARY KEY(idFoto)
) ENGINE = innodb;

CREATE TABLE historicoMedida (
  idMedida INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idPessoa INTEGER UNSIGNED NOT NULL,
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
  PRIMARY KEY(idMedida)
) ENGINE = innodb;

CREATE TABLE dieta (
  idDieta INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idPessoa INTEGER UNSIGNED NOT NULL,
  qtdRefeicoes INTEGER UNSIGNED NULL,
  PRIMARY KEY(idDieta)
) ENGINE = innodb;

CREATE TABLE suplementoPessoa (
  idSuplemento INTEGER UNSIGNED NOT NULL,
  idPessoa INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idSuplemento, idPessoa)
) ENGINE = innodb;

CREATE TABLE pessoaMensagem (
  idPessoaOrigem INTEGER UNSIGNED NOT NULL,
  idPessoaDestino INTEGER UNSIGNED NOT NULL,
  idMensagem INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idPessoaOrigem, idPessoaDestino, idMensagem)
) ENGINE = innodb;

CREATE TABLE dietaAlimento (
  idDieta INTEGER UNSIGNED NOT NULL,
  idAlimento INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idDieta, idAlimento)
) ENGINE = innodb;

CREATE TABLE exercicio (
  idExercicio INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idGrupoMuscular INTEGER UNSIGNED NOT NULL,
  idTreino INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(45) NOT NULL,
  qtdSeries INTEGER UNSIGNED NOT NULL,
  qtdRepeticoes INTEGER UNSIGNED NULL,
  PRIMARY KEY(idExercicio)
) ENGINE = innodb;

/*Criando as CONSTRAINTS*/
ALTER TABLE suplemento ADD CONSTRAINT suplementoCategoriaFK FOREIGN KEY ( idCategoriaSuplemento ) REFERENCES categoriaSuplemento ( idCategoriaSuplemento ) ;
ALTER TABLE academia ADD CONSTRAINT academiaEnderecoFK FOREIGN KEY ( idEndereco ) REFERENCES endereco ( idEndereco ) ;
ALTER TABLE academia ADD CONSTRAINT academiaTelefoneFK FOREIGN KEY ( idTelefone ) REFERENCES telefone ( idTelefone ) ;
ALTER TABLE pessoa ADD CONSTRAINT pessoaEnderecoFK FOREIGN KEY ( idEndereco ) REFERENCES endereco ( idEndereco ) ;
ALTER TABLE pessoa ADD CONSTRAINT pessoaAcademiaFK FOREIGN KEY ( idAcademia ) REFERENCES academia ( idAcademia ) ;
ALTER TABLE pessoa ADD CONSTRAINT pessoaTelefoneFK FOREIGN KEY ( idTelefone ) REFERENCES telefone ( idTelefone ) ;
ALTER TABLE video ADD CONSTRAINT videoPessoaFK FOREIGN KEY ( idPessoa ) REFERENCES pessoa ( idPessoa ) ;
ALTER TABLE pagina ADD CONSTRAINT paginaPessoaFK FOREIGN KEY ( idPessoa ) REFERENCES pessoa ( idPessoa ) ;
ALTER TABLE treino ADD CONSTRAINT treinoPessoaFK FOREIGN KEY ( idPessoa ) REFERENCES pessoa ( idPessoa ) ;
ALTER TABLE amizade ADD CONSTRAINT amizadePessoaFK FOREIGN KEY ( idPessoa ) REFERENCES pessoa ( idPessoa ) ;
ALTER TABLE amizade ADD CONSTRAINT amizadeAmigoFK FOREIGN KEY ( idAmigo ) REFERENCES pessoa ( idPessoa ) ;
ALTER TABLE foto ADD CONSTRAINT fotoPessoaFK FOREIGN KEY ( idPessoa ) REFERENCES pessoa ( idPessoa ) ;
ALTER TABLE historicoMedida ADD CONSTRAINT historicoMedidaPessoaFK FOREIGN KEY ( idPessoa ) REFERENCES pessoa ( idPessoa ) ;
ALTER TABLE dieta ADD CONSTRAINT dietaPessoaFK FOREIGN KEY ( idPessoa ) REFERENCES pessoa ( idPessoa ) ;
ALTER TABLE suplementoPessoa ADD CONSTRAINT suplementoFK FOREIGN KEY ( idSuplemento ) REFERENCES suplemento ( idSuplemento ) ;
ALTER TABLE suplementoPessoa ADD CONSTRAINT pessoaFK FOREIGN KEY ( idPessoa ) REFERENCES pessoa ( idPessoa ) ;
ALTER TABLE pessoaMensagem ADD CONSTRAINT pessoaDestinoFK FOREIGN KEY ( idPessoaDestino ) REFERENCES pessoa ( idPessoa ) ;
ALTER TABLE pessoaMensagem ADD CONSTRAINT pessoaOrigemFK FOREIGN KEY ( idPessoaOrigem ) REFERENCES pessoa ( idPessoa ) ;
ALTER TABLE pessoaMensagem ADD CONSTRAINT mensagemFK FOREIGN KEY ( idMensagem ) REFERENCES mensagem ( idMensagem ) ;
ALTER TABLE dietaAlimento ADD CONSTRAINT dietaFK FOREIGN KEY ( idDieta ) REFERENCES dieta ( idDieta ) ;
ALTER TABLE dietaAlimento ADD CONSTRAINT alimentoFK FOREIGN KEY ( idAlimento ) REFERENCES alimento ( idAlimento ) ;
ALTER TABLE exercicio ADD CONSTRAINT exercicioTreinoFK FOREIGN KEY ( idTreino ) REFERENCES treino ( idTreino ) ;
ALTER TABLE exercicio ADD CONSTRAINT exercicioMusculoFK FOREIGN KEY ( idGrupoMuscular ) REFERENCES grupoMuscular ( idGrupoMuscular ) ;
