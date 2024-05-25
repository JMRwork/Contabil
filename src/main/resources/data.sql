INSERT INTO users (id, email, password, full_name, role, status, created_by, created_at, last_modified_at, last_login_at, last_modified_by, deleted_at) VALUES (default, 'dev@devland.com',        '{bcrypt}$2a$12$x3GGh7du3zhcEfDfu6U1Nem5XCyPVl/1g4ZcA5WXZq41vlhESR9gq', 'The Developer',       'ROLE_ADMIN',      'ACTIVE',          null, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null, null, null);
INSERT INTO users (id, email, password, full_name, role, status, created_by, created_at, last_modified_at, last_login_at, last_modified_by, deleted_at) VALUES (default, 'accountant@devland.com', '{bcrypt}$2a$12$x3GGh7du3zhcEfDfu6U1Nem5XCyPVl/1g4ZcA5WXZq41vlhESR9gq', 'The Accountant',      'ROLE_ACCOUNTANT', 'ACTIVE',          1,    CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null, null, null);
INSERT INTO users (id, email, password, full_name, role, status, created_by, created_at, last_modified_at, last_login_at, last_modified_by, deleted_at) VALUES (default, 'user1@devland.com',      '{bcrypt}$2a$12$x3GGh7du3zhcEfDfu6U1Nem5XCyPVl/1g4ZcA5WXZq41vlhESR9gq', 'User from school A',  'ROLE_USER',       'ACTIVE',          1,    CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null, null, null);
INSERT INTO users (id, email, password, full_name, role, status, created_by, created_at, last_modified_at, last_login_at, last_modified_by, deleted_at) VALUES (default, 'user2@devland.com',      '{bcrypt}$2a$12$x3GGh7du3zhcEfDfu6U1Nem5XCyPVl/1g4ZcA5WXZq41vlhESR9gq', 'User from school B',  'ROLE_USER',       'ACTIVE',          1,    CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null, null, null);
INSERT INTO users (id, email, password, full_name, role, status, created_by, created_at, last_modified_at, last_login_at, last_modified_by, deleted_at) VALUES (default, 'user3@devland.com',      '{bcrypt}$2a$12$x3GGh7du3zhcEfDfu6U1Nem5XCyPVl/1g4ZcA5WXZq41vlhESR9gq', 'Disabled User',       'ROLE_USER',       'DISABLED',        1,    CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null, null, null);
INSERT INTO users (id, email, password, full_name, role, status, created_by, created_at, last_modified_at, last_login_at, last_modified_by, deleted_at) VALUES (default, 'user4@devland.com',      '{bcrypt}$2a$12$x3GGh7du3zhcEfDfu6U1Nem5XCyPVl/1g4ZcA5WXZq41vlhESR9gq', 'Deleted User',        'ROLE_USER',       'DELETED',         1,    CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null, null, CURRENT_TIMESTAMP());
INSERT INTO users (id, email, password, full_name, role, status, created_by, created_at, last_modified_at, last_login_at, last_modified_by, deleted_at) VALUES (default, 'user5@devland.com',      '{bcrypt}$2a$12$x3GGh7du3zhcEfDfu6U1Nem5XCyPVl/1g4ZcA5WXZq41vlhESR9gq', 'Reset Password User', 'ROLE_USER',       'RESET_PASSWORD',  1,    CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null, null, null);
INSERT INTO organizations (id, name, legal_name, cnpj, is_active, created_by, created_at, last_modified_at, last_modified_by, deleted_at) VALUES (default, 'School A', 'School A Ltda', '11111111111111', true, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null, null);
INSERT INTO organizations (id, name, legal_name, cnpj, is_active, created_by, created_at, last_modified_at, last_modified_by, deleted_at) VALUES (default, 'School B', 'School B Ltda', '22222222222222', true, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null, null);
INSERT INTO users_organizations (user_id, organization_id) VALUES (2, 1);
INSERT INTO users_organizations (user_id, organization_id) VALUES (2, 2);
INSERT INTO users_organizations (user_id, organization_id) VALUES (3, 1);
INSERT INTO users_organizations (user_id, organization_id) VALUES (4, 2);
INSERT INTO users_organizations (user_id, organization_id) VALUES (5, 1);
INSERT INTO users_organizations (user_id, organization_id) VALUES (6, 2);
INSERT INTO users_organizations (user_id, organization_id) VALUES (7, 1);
INSERT INTO movimento (id, descricao, tipo, data_lancamento, valor, organization_id, created_by, last_modified_by, created_at, last_modified_at, deleted_at) VALUES (default, 'mensalidade aluno A',             'CREDITO', '2024-04-01', 1245.15, 1, 3, null, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null);
INSERT INTO movimento (id, descricao, tipo, data_lancamento, valor, organization_id, created_by, last_modified_by, created_at, last_modified_at, deleted_at) VALUES (default, 'mensalidade aluno B',             'CREDITO', '2024-04-01', 1245.15, 1, 3, null, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null);
INSERT INTO movimento (id, descricao, tipo, data_lancamento, valor, organization_id, created_by, last_modified_by, created_at, last_modified_at, deleted_at) VALUES (default, 'pagamento professor X',           'DEBITO',  '2024-04-10', 1500.00, 1, 3, null, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null);
INSERT INTO movimento (id, descricao, tipo, data_lancamento, valor, organization_id, created_by, last_modified_by, created_at, last_modified_at, deleted_at) VALUES (default, 'pagamento suprimentos escolares', 'DEBITO',  '2024-04-20', 325.75,  1, 3, null, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null);
INSERT INTO movimento (id, descricao, tipo, data_lancamento, valor, organization_id, created_by, last_modified_by, created_at, last_modified_at, deleted_at) VALUES (default, 'pagamento aluguel imovel',        'DEBITO',  '2024-04-10', 500.00,  1, 3, null, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null);
INSERT INTO escola_dados_cadastrais (organization_id, exercicio, unidade_executora, nome_escola, cnpj, sigla_escola, endereco, cidade, uf, cep, telefone, email, codigo_inep, created_by, last_modified_by, created_at, last_modified_at) VALUES (1, '2024', 'Associação da Escola A', 'Escola A', '11111111111111', 'EA-TO', 'rua primeira nº 200', 'cidade', 'TO', '75250000', '3414-1212', 'escola.a@email.com', '175247', 1, null, CURRENT_TIMESTAMP(), null);
INSERT INTO escola_dados_cadastrais (organization_id, exercicio, unidade_executora, nome_escola, cnpj, sigla_escola, endereco, cidade, uf, cep, telefone, email, codigo_inep, created_by, last_modified_by, created_at, last_modified_at) VALUES (2, '2024', 'Associação da Escola B', 'Escola B', '22222222222222', 'EB-TO', 'rua segunda nº 500',  'cidade', 'TO', '75500000', '3414-3030', 'escola.b@email.com', '241565', 1, null, CURRENT_TIMESTAMP(), null);
INSERT INTO banco (codigo, nome, created_by, last_modified_by, created_at, last_modified_at) VALUES ('001','Banco do Brasil S.A.',             1, null, CURRENT_TIMESTAMP(), null);
INSERT INTO banco (codigo, nome, created_by, last_modified_by, created_at, last_modified_at) VALUES ('003','Banco da Amazonia S.A.',           1, null, CURRENT_TIMESTAMP(), null);
INSERT INTO banco (codigo, nome, created_by, last_modified_by, created_at, last_modified_at) VALUES ('004','Banco do Nordeste do Brasil S.A.', 1, null, CURRENT_TIMESTAMP(), null);
INSERT INTO banco (codigo, nome, created_by, last_modified_by, created_at, last_modified_at) VALUES ('033','Banco Santander (Brasil) S.A.',    1, null, CURRENT_TIMESTAMP(), null);
INSERT INTO banco (codigo, nome, created_by, last_modified_by, created_at, last_modified_at) VALUES ('104','Caixa Econômica Federal',          1, null, CURRENT_TIMESTAMP(), null);
INSERT INTO banco (codigo, nome, created_by, last_modified_by, created_at, last_modified_at) VALUES ('237','Banco Bradesco S.A.',              1, null, CURRENT_TIMESTAMP(), null);
INSERT INTO banco (codigo, nome, created_by, last_modified_by, created_at, last_modified_at) VALUES ('341','Banco Itaú S.A.',                  1, null, CURRENT_TIMESTAMP(), null);
INSERT INTO responsaveis (cpf, nome, funcao, rg, orgao_emissor, periodo_gestao, ata_nomeacao, endereco, cidade, uf, cep, telefone, email, created_by, last_modified_by, created_at, last_modified_at) VALUES ('12345678901', 'responsavel 1', 'diretor', '123456', 'SPC', '03/2024', '10', 'rua a', 'araguatins', 'TO', '75000000', '99966425', 'responsavel01@email.com', 1, null, CURRENT_TIMESTAMP(), null);
INSERT INTO responsaveis (cpf, nome, funcao, rg, orgao_emissor, periodo_gestao, ata_nomeacao, endereco, cidade, uf, cep, telefone, email, created_by, last_modified_by, created_at, last_modified_at) VALUES ('12345678902', 'responsavel 2', 'tesoureiro', '123456', 'SPC', '03/2024', '10', 'rua b', 'araguatins', 'TO', '75000000', '99966425', 'responsavel02@email.com', 1, null, CURRENT_TIMESTAMP(), null);
INSERT INTO responsaveis (cpf, nome, funcao, rg, orgao_emissor, periodo_gestao, ata_nomeacao, endereco, cidade, uf, cep, telefone, email, created_by, last_modified_by, created_at, last_modified_at) VALUES ('12345678903', 'responsavel 3', 'diretor', '123456', 'SPC', '01/2024', '3', 'rua c', 'araguatins', 'TO', '75000000', '99966425', 'responsavel03@email.com', 1, null, CURRENT_TIMESTAMP(), null);
INSERT INTO responsaveis (cpf, nome, funcao, rg, orgao_emissor, periodo_gestao, ata_nomeacao, endereco, cidade, uf, cep, telefone, email, created_by, last_modified_by, created_at, last_modified_at) VALUES ('12345678904', 'responsavel 4', 'tesoureiro', '123456', 'SPC', '01/2024', '3', 'rua d', 'araguatins', 'TO', '75000000', '99966425', 'responsavel04@email.com', 1, null, CURRENT_TIMESTAMP(), null);
INSERT INTO responsaveis_organizations (responsavel_id, organization_id) VALUES ('12345678901', 1);
INSERT INTO responsaveis_organizations (responsavel_id, organization_id) VALUES ('12345678902', 1);
INSERT INTO responsaveis_organizations (responsavel_id, organization_id) VALUES ('12345678903', 2);
INSERT INTO responsaveis_organizations (responsavel_id, organization_id) VALUES ('12345678904', 2);