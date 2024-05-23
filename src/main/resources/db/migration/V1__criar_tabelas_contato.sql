CREATE SEQUENCE CONTATOS_SEQ
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

 CREATE TABLE TBL_CONTATOS (
   CONTATO_ID INTEGER DEFAULT CONTATOS_SEQ.NEXTVAL NOT NULL,
   NOME VARCHAR2(100) NOT NULL,
   EMAIL VARCHAR2(100) UNIQUE NOT NULL,
   SENHA VARCHAR2(20) NOT NULL,
   DATA_NASCIMENTO DATE NOT NULL
 );