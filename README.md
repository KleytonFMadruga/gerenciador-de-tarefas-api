# Gerenciador-de-tarefas-api

## Visão Geral
O gerenciador-de-tarefas-api é uma interface de programação de aplicações (API) desenvolvida para facilitar a criação, organização, e gerenciamento de tarefas a fim de facilicar o dia a dia de seu usuário.

## Funcionalidades Principais

- Cadastro simples, edição e exclusão de um usuário:

O usuário precisará apenas de inserir seu nome, a fim de simplesmente ser possível a customização do aplicativo cliente com o nome do usuário.



- Criação, atualização, exibição e exclusão de tarefas:

O usuário poderá adicionar suas tarefas para organizar melhor seu dia.
Para melhor organização além de inserir a descrição da tarefa ele poderá também optar em inserir um prazo de conclusão da mesma.


## Endpoins e body's suportados

- Usuários:


    - POST: '/usuarios'

```json
{
 "nome": "José"
}
```
------------------------------------------------------------------------------------------------------------------------------------------------------------
    - PUT: '/usuarios/{id_usuario}'

```json
{
 "nome": "José"
}
```
------------------------------------------------------------------------------------------------------------------------------------------------------------
    - DELETE: '/usuarios/{id_usuario}'

------------------------------------------------------------------------------------------------------------------------------------------------------------
- Nenhum dado do body de Usuarios é opcional

------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------

- Tarefas:


    - POST: '/usuarios/{id_usuario}/tarefas'

```json
{
    "descricao": "Limpar a casa",
    "prazo": "03/05/2025 10:30:00"
}
```

- O campo prazo é opcional.
- O status é cadastrado como PENDENTE por default.

------------------------------------------------------------------------------------------------------------------------------------------------------------
    - PUT: '/usuarios/{id_usuario}/tarefas/{id_tarefa}'

```json
{
    "descricao": "Limpar a casa",
    "status": "CONCLUIDA",
    "prazo": "03/05/2025 10:30:00"
}
```
- Todos os campos são adicionais.
- Status suportados: PENDENTE, EM_ANDAMENTO, CONCLUIDA

------------------------------------------------------------------------------------------------------------------------------------------------------------
    - DELETE: '/usuarios/{id_usuario}/tarefas/{id_tarefa}'

------------------------------------------------------------------------------------------------------------------------------------------------------------


