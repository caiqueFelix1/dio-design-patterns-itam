# ITAM Design Patterns - Gestão de Ativos com Padrão State

API desenvolvida em **Java 17** e **Spring Boot** para o desafio de Padrões de Projeto da DIO, aplicando conceitos reais de **ITAM (Information Technology Asset Management)** para o controle do ciclo de vida de ativos de tecnologia.

---

## 💡 Sobre o Projeto
Em vez de utilizar exemplos genéricos, este projeto modela um cenário comum em ambientes corporativos de ITAM: o controle das transições de estado durante o ciclo de vida de ativos de TI.

O sistema implementa o **Padrão de Projeto Comportamental State**, eliminando estruturas complexas de `if/else` ou `switch/case` e garantindo que cada ativo transite apenas para estados permitidos de acordo com regras de negócio claras.

---

## 🛠️ Tecnologias Utilizadas
- **Java 17**
- **Spring Boot** (Spring Web, Spring MVC)
- **Gradle** (Gerenciamento de dependências)

---

## 🔄 Ciclo de Vida do Ativo (State Pattern)
O fluxo do ativo gerencia as seguintes transições:

1. `EM_SOLICITACAO`: Estado inicial ao cadastrar um novo ativo. Pode avançar para `EM_USO` ou ser descomissionado.
2. `EM_USO`: Ativo entregue ao colaborador. Pode ser enviado para `EM_MANUTENCAO` ou `DESCOMISSIONADO`.
3. `EM_MANUTENCAO`: Ativo em suporte técnico. Pode retornar para `EM_USO` ou ser `DESCOMISSIONADO` caso seja irrecuperável.
4. `DESCOMISSIONADO`: Estado final/baixado. Bloqueia novas transições e impede que o ativo retorne ao ciclo operacional.

---

## 🚀 Como obter o Projeto

1. Clone o repositório:

   ```bash
   git clone https://github.com/caiqueFelix1/dio-design-patterns-itam.git
   ```
   
