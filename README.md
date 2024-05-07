# Java-Api-Coin-Gecko

Este é um pequeno aplicativo em Java que permite encontrar informações sobre criptomoedas usando a [API CoinGecko](https://www.coingecko.com/api/documentations/v3). Você pode pesquisar por criptomoedas pelo nome e obter o ID correspondente, bem como buscar o preço atual em dólares de uma criptomoeda específica.

## Pré-requisitos

Certifique-se de ter o seguinte instalado em seu ambiente de desenvolvimento:

- Java JDK
- Um editor de código de sua preferência
- Conexão com a Internet para fazer solicitações à API CoinGecko

## Como usar

1. Clone este repositório para o seu ambiente local:

   ```
   git clone https://github.com/rmellofilho/Java-Api-Coin-Gecko.git
   ```

2. Navegue até o diretório onde o projeto foi clonado:

   ```
   cd crypto-info-finder
   ```

3. Compile o código-fonte:

   ```
   javac App.java
   ```

4. Execute o aplicativo:

   ```
   java App
   ```

5. Siga as instruções apresentadas no console para realizar as operações desejadas.

## Funcionalidades

- Pesquisa de criptomoeda por nome e exibição do ID correspondente.
- Consulta do preço atual em dólares de uma criptomoeda específica.

## Estrutura do projeto

- `App.java`: O código-fonte principal que contém a lógica para interagir com a API CoinGecko.
- `Coin.java`: Uma classe de modelo simples para representar uma criptomoeda com campos de ID e nome.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests com melhorias, correções de bugs ou novas funcionalidades.

## Licença

Este projeto é distribuído sob a licença [MIT](https://opensource.org/licenses/MIT). Veja o arquivo `LICENSE` para mais detalhes.
