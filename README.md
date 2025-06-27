# Reserva Hotel RMI

Sistema simples de reserva de quartos usando Java RMI (Remote Method Invocation).

## Sobre o projeto

Este projeto implementa um sistema cliente/servidor em Java que permite:

- Listar quartos disponíveis por tipo
- Reservar quartos informando o tipo e o nome do hóspede
- Listar hóspedes cadastrados

Não é possível selecionar datas. As reservas são feitas para um período fixo e imediato.

## Tipos de quartos

| Tipo | Descrição         | Quantidade | Valor da diária |
|------|-------------------|------------|-----------------|
| 0    | Individual         | 10         | R$ 100,00       |
| 1    | Duplo (standard)   | 20         | R$ 150,00       |
| 2    | Duplo (premium)    | 5          | R$ 200,00       |
| 3    | Triplo             | 3          | R$ 250,00       |
| 4    | Quádruplo          | 2          | R$ 300,00       |

---

## Estrutura de Arquivos

`ClienteHotel.java`

`ServidorHotel.java`

`GerenciadorQuartos.java`

## Funcionalidades disponíveis no cliente

1 - Listar quartos disponíveis

2 - Reservar quarto

3 - Ver hóspedes cadastrados

0 - Sair do sistema
