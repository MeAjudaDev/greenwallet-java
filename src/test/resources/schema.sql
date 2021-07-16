create table users (
    id int AUTO_INCREMENT primary key,
    name varchar(100) not null,
    email varchar(100) not null,
    password varchar(100) not null,
    activation_code varchar(4),
    state char default 'P',
    update_at datetime on update current_timestamp,
    created_at datetime default current_timestamp
);

create table categories (
    id int AUTO_INCREMENT primary key,
    user_id int not null,                           -- Referencia ao usuário que criou a categoria
    name varchar(100) not null,                     -- Nome da Categoria ( Obrigatorio )
    enabled boolean default 1 not null,             -- 1 = True = Enabled / 0 = False = Disabled
    type char not null,                             -- [E] Despesas / [R] Receitas
    update_at datetime on update current_timestamp,
    created_at datetime default current_timestamp,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

create table transactions (
    id int AUTO_INCREMENT primary key,
    user_id int not null,                           -- Referencia ao usuário que criou a transação
    category_id int not null,                       -- Referencia à categoria dessa transação
    description varchar(150) not null,              -- Descrição da transação
    value decimal(15, 2) not null,                  -- Valor da transação
    is_fixed boolean not null,
    due_date date not null,                         -- Data de Vencimento ou Data de Recebimento
    type char not null,                             -- Tipo da transação: [E] Expense (Despesas) / [R] Revenue (Receitas)
    state char default 'A',                         -- [A] Ativo / [D] Desativado (a) / [E] Excluido (a)
    updated_at datetime on update current_timestamp,
    created_at datetime default current_timestamp,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);