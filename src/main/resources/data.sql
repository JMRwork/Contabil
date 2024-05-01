INSERT INTO users (id, email, password, full_name, role, status, created_by, created_at, last_modified_at, last_login_at, last_modified_by, deleted_at) VALUES (default, 'dev@devland.com',        '{bcrypt}$2a$12$x3GGh7du3zhcEfDfu6U1Nem5XCyPVl/1g4ZcA5WXZq41vlhESR9gq', 'The Developer',       'ROLE_ADMIN',      'ACTIVE',          null, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null, null, null);
INSERT INTO users (id, email, password, full_name, role, status, created_by, created_at, last_modified_at, last_login_at, last_modified_by, deleted_at) VALUES (default, 'accountant@devland.com', '{bcrypt}$2a$12$x3GGh7du3zhcEfDfu6U1Nem5XCyPVl/1g4ZcA5WXZq41vlhESR9gq', 'The Accountant',      'ROLE_ACCOUNTANT', 'ACTIVE',          1,    CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null, null, null);
INSERT INTO users (id, email, password, full_name, role, status, created_by, created_at, last_modified_at, last_login_at, last_modified_by, deleted_at) VALUES (default, 'user1@devland.com',      '{bcrypt}$2a$12$x3GGh7du3zhcEfDfu6U1Nem5XCyPVl/1g4ZcA5WXZq41vlhESR9gq', 'User from school A',  'ROLE_USER',       'ACTIVE',          1,    CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null, null, null);
INSERT INTO users (id, email, password, full_name, role, status, created_by, created_at, last_modified_at, last_login_at, last_modified_by, deleted_at) VALUES (default, 'user2@devland.com',      '{bcrypt}$2a$12$x3GGh7du3zhcEfDfu6U1Nem5XCyPVl/1g4ZcA5WXZq41vlhESR9gq', 'User from school B',  'ROLE_USER',       'ACTIVE',          1,    CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null, null, null);
INSERT INTO users (id, email, password, full_name, role, status, created_by, created_at, last_modified_at, last_login_at, last_modified_by, deleted_at) VALUES (default, 'user3@devland.com',      '{bcrypt}$2a$12$x3GGh7du3zhcEfDfu6U1Nem5XCyPVl/1g4ZcA5WXZq41vlhESR9gq', 'Disabled User',       'ROLE_USER',       'DISABLED',        1,    CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null, null, null);
INSERT INTO users (id, email, password, full_name, role, status, created_by, created_at, last_modified_at, last_login_at, last_modified_by, deleted_at) VALUES (default, 'user4@devland.com',      '{bcrypt}$2a$12$x3GGh7du3zhcEfDfu6U1Nem5XCyPVl/1g4ZcA5WXZq41vlhESR9gq', 'Deleted User',        'ROLE_USER',       'DELETED',         1,    CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), null, null, null);
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
INSERT INTO escola_dados_cadastrais (organization_id, unidade_executora, nome_escola, cnpj, sigla_escola, endereco, cidade, uf, cep, telefone, email, codigo_inep, created_by, last_modified_by, created_at, last_modified_at) VALUES (1, 'Associação da Escola A', 'Escola A', '11111111111111', 'EA-TO', 'rua primeira nº 200', 'cidade', 'TO', '75250000', '3414-1212', 'escola.a@email.com', '175247', 1, null, CURRENT_TIMESTAMP(), null);
INSERT INTO escola_dados_cadastrais (organization_id, unidade_executora, nome_escola, cnpj, sigla_escola, endereco, cidade, uf, cep, telefone, email, codigo_inep, created_by, last_modified_by, created_at, last_modified_at) VALUES (2, 'Associação da Escola B', 'Escola B', '22222222222222', 'EB-TO', 'rua segunda nº 500', 'cidade', 'TO', '75500000', '3414-3030', 'escola.b@email.com', '241565', 1, null, CURRENT_TIMESTAMP(), null);