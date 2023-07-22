INSERT INTO client (name) VALUES ('Madri Eletrionicos');
INSERT INTO client (name) VALUES ('Humana Gestão de Pessoas');
INSERT INTO client (name) VALUES ('Atacadão Tem de Tudo');

INSERT INTO team (name) VALUES ('RedTeam');
INSERT INTO team (name) VALUES ('BlueTeam');
INSERT INTO team (name) VALUES ('GreenTeam');

INSERT INTO project (name, description, status, initial_date, client_id, team_id) VALUES ('Migração de modulo CRM Madri','Mudança de modulo de JFS para Vuejs', 0, now(), 1, 2);
INSERT INTO project (name, description, status, initial_date, client_id, team_id) VALUES ('Migração de modulo CRM Madri','Mudança de modulo de JEE para SpringBoot', 0, now(), 2, 1);

INSERT INTO activity (name, initial_date, project_id) VALUES ('Tela de Cadastro de clientes', now(), 1);
INSERT INTO activity (name, initial_date, project_id) VALUES ('Tela de Cadastro de Tarefas', now(), 1);
INSERT INTO activity (name, initial_date, project_id) VALUES ('Tela de Cadastro de Team', now(), 1);
INSERT INTO activity (name, initial_date, project_id) VALUES ('Tela de Cadastro de Produtos', now(), 2);
INSERT INTO activity (name, initial_date, project_id) VALUES ('Tela de Cadastro de Itens de produtos', now(), 2);

INSERT INTO task (title, description, status, initial_date, activity_id) VALUES ('Criar CRUD CLIENTE','Criat CRUD para cliente no backend', 1, now(), 1);
INSERT INTO task (title, description, status, initial_date, activity_id) VALUES ('Criar CRUD Produtos','Criat CRUD para produtos no Frontend', 1, now(), 4);
INSERT INTO task (title, description, status, initial_date, activity_id) VALUES ('Criar CRUD CLIENTE','Criat CRUD para cliente no Frontend', 1, now(), 1);