USE `cursojava` ;


insert into pessoa (nome, endereco) values ('Luis', 'Rua A');
insert into pessoa (nome, endereco) values ('Pedro', 'Rua B');
insert into pessoa (nome, endereco) values ('Ana', 'Rua C');
insert into pessoa (nome, endereco) values ('Vanessa', 'Avenida E');
insert into pessoa (nome, endereco) values ('Ricardo', 'Rua A');

insert into funcionario (id, matricula, data_contratacao, data_demissao, salario)
 values (1, '1', '2016-01-01', null, 2000.00);

insert into funcionario (id, matricula, data_contratacao, data_demissao, salario)
 values (3, '2', '2016-01-01', null, 2000.00);

insert into aluno (id, matricula) values (2, '1');
insert into aluno (id, matricula) values (4, '2');
insert into aluno (id, matricula) values (5, '3');
