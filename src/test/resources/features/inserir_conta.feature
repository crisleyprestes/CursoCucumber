# language: pt

@Funcionais
  Funcionalidade: Cadastro de contas
    Como um usuário
    Gostaria de cadastrar contas
    Para que eu possa distribuir meu dinheiro de uma forma mais organizada

  Contexto:
    Dado que desejo adicionar uma conta

  Esquema do Cenário: Deve validar as regras de cadastro de uma conta
    Quando adiciono a conta "<conta>"
    Então recebo a mensagem "<mensagem>"

    Exemplos:
    | conta            | mensagem                           |
    | Conta de Teste   | Conta adicionada com sucesso!      |
    |                  | Informe o nome da conta            |
    | Conta mesmo nome | Já existe uma conta com esse nome! |

  Cenário: Deve inserir uma conta com sucesso
    Quando adiciono uma conta válida
    Então a conta é inserida com sucesso