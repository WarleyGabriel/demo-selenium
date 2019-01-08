## DEMO Selenium

Este foi o meu primeiro projeto de testes com o framework Selenium, é um codigo selenium puro, sem uso de frameworks renomados. Neste cenário foram implementados todos os metodos de ação. <br/>
Essa não é uma boa prática, mas para quem quer aprender um pouco como o selenium funciona, é um bom exemplo. <br/>

**DEMO Selenium** é um projeto de testes de integração, nesse projeto ocorre o cadastro de um contato no site [phptravels](https://phptravels.org) <br/>
O projeto [DEMO WebDriverIO](https://github.com/WarleyGabriel/demo-webdriverio) tem os mesmos cenários de teste, porém nesse projeto o framework WebDriverIO é utilizado. Após analisar os dois projetos, fica claro como um framework como o WebDriverIO pode nós ajudar a criar testes.

### Pré requisitos

- maven >= 3.2.x
- Alterar driver de acordo sistema operacional utilizado, no repositório esta driver Chrome/MACOS

#### Como executar

Para instalar as dependências do projeto, execute;
```
mvn install
```

Para executar os testes via terminal, execute;
```
mvn -Dtest=login,cadastrarContato test
```
