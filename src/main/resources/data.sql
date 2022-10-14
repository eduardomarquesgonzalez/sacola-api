INSERT INTO restaurante(id, cep, complemento, nome)
VALUES (1L, '0000001', 'complemento endereço restaurante 1', 'Restaurante 1'),
       (2L, '0000002', 'complemento endereço restaurante 2', 'Restaurante 2');

INSERT INTO cliente (id, cep, complemento, nome)
VALUES (1L, '78058573', 'quadra 10', 'Joana Barboza Gonzalez'),
       (2L, '78058573', 'quadra 32', 'Eduardo Marques Gonzalez');

INSERT INTO produto (id, disponivel, nome, valor_unitario, restaurante_id)
VALUES (1L, true, 'Produto1', 5.0, 1L),
       (2L, true, 'Produto2', 6.0, 1L),
       (3L, true, 'Produto3', 7.0, 2L);

INSERT INTO sacola (id, forma_pagamento, fechada, valor_total, cliente_id)
VALUES (1L, 1, false, 1.0, 1L);
