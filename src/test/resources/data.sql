INSERT INTO users (name, email, password, activation_code, state) VALUES ('John Doe', 'johndoe@provider.com', 'very strong password', '1234', 'A');
INSERT INTO users (name, email, password, activation_code, state) VALUES ('Geno Doe', 'geno@provider.com', 'too much strong password', '4321', 'A');
INSERT INTO categories (user_id, name, enabled, type) VALUES (1, 'Educação', 1, 'E');
INSERT INTO categories (user_id, name, enabled, type) VALUES (1, 'Salário', 1, 'R');