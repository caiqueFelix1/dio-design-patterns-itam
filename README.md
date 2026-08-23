# ITAM Design Patterns - Gestão de Ativos com Padrão State

API desenvolvida em **Java 17** e **Spring Boot** para o desafio de Padrões de Projeto da DIO, aplicando conceitos reais de **ITAM (Information Technology Asset Management)** para o controle do ciclo de vida de ativos de tecnologia.

---

## 💡 Sobre o Projeto
Em vez de utilizar exemplos genéricos, este projeto resolve um problema corporativo real: o controle rigoroso de transições de estado de ativos de TI (como notebooks, servidores e licenças).

O sistema implementa o **Padrão de Projeto Comportamental State**, eliminando estruturas complexas de `if/else` ou `switch/case`, garantindo que cada ativo transacione apenas para estados permitidos de acordo com regras de negócio claras.

---

## 🛠️ Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 4** (Spring Web, Spring MVC)
- **Gradle** (Gerenciamento de dependências)
- **JUnit 5 & MockMvc** (Testes unitários e de integração)

---

## 🔄 Ciclo de Vida do Ativo (State Pattern)
O fluxo do ativo gerencia as seguintes transições:
1. `EM_SOLICITACAO`: Estado inicial ao cadastrar um novo ativo. Pode avançar para `EM_USO` ou ser descomissionado.
2. `EM_USO`: Ativo entregue ao colaborador. Pode ser enviado para `EM_MANUTENCAO` ou `DESCOMISSIONADO`.
3. `EM_MANUTENCAO`: Ativo em suporte técnico. Pode retornar para `EM_USO` ou ser `DESCOMISSIONADO` caso seja irrecuperável.
4. `DESCOMISSIONADO`: Estado final/baixado. Barre novas transições e protege o ativo de retornar ao ciclo operacional.

---

## 🚀 Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone [https://github.com/caiqueFelix1/dio-design-patterns-itam.git](https://github.com/caiqueFelix1/dio-design-patterns-itam.git)