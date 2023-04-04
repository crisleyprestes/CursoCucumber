# CursoCucumber

## Descrição

Este projeto se refere à automação de uma aplicação de teste do curso **_Aprenda BDD com Cucumber em Java_** da _Udemy_.

## Setup do Projeto

Para este projeto são necessários as seguintes aplicações/ferramentas:

- [Java 8 (Update 361)](https://www.oracle.com/br/java/technologies/javase/javase8u211-later-archive-downloads.html)
- [Cucumber JUnit (versão 4.8.0)](https://mvnrepository.com/artifact/io.cucumber/cucumber-junit/4.8.0)
- [Selenium WebDriver (versão 3.11.0)](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
- [Apache commons-io (versão 2.11.0)](https://mvnrepository.com/artifact/commons-io/commons-io)
- [WebDriver Manager (versão 5.3.2)](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager)
- [Git (versão 2.39.1)](https://git-scm.com/downloads)
- [Maven (versão 3.9.1)](https://maven.apache.org/download.cgi)
- [Google Chrome (versão 111.0.5563.111)](https://www.google.com/intl/pt-BR/chrome/)

## Configurando o Setup do Projeto

Este projeto foi configurado e executado no *_Windows_*, logo os passos abaixo foram executados para este sistema operacional.

### Java

- Primeiramente configure as variáveis de ambiente no *_path_* do seu computador, criando as seguintes variáveis:
    - JAVA_HOME (Utilize o path onde o Java foi instalado)
    - %JAVA_HOME%\bin

- Após a configuração, execute no CMD:
<pre>java -version</pre>

- Deverá ser exibida a seguinte saída:
<pre>java version "1.8.0_361"
Java(TM) SE Runtime Environment (build 1.8.0_361-b09)
Java HotSpot(TM) 64-Bit Server VM (build 25.361-b09, mixed mode)</pre>

### Maven

- Configure as variáveis de ambiente no *_path_* do computador, criando as seguintes variáveis:
    - MAVEN_HOME (Utilize o path onde o Maven foi instalado)
    - %MAVEN_HOME%\bin

- Após a configuração, execute no CMD:
<pre>mvn -version</pre>

- Deverá ser exibida a seguinte saída:
<pre>Maven home: C:\maven
Java version: 1.8.0_361, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk1.8.0_361\jre
Default locale: pt_BR, platform encoding: Cp1252
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"</pre>

### Git

- Execute o instalador do *_git_* e após finalizar a instalação, execute no CMD:
<pre>git -v</pre>

- Deverá ser exibida a seguinte saída:
<pre>git version 2.39.1.windows.1</pre>

### Demais Dependências

- As demais dependências são carregadas diretamente no arquivo *_pom.xml_*, e são gerenciadas e baixadas pelo *_Maven_* quando o projeto for importado para a sua IDE de preferência.

## Clonando e Importando o Projeto

- No CMD, execute o comando *_git clone_*:
<pre>https://github.com/crisleyprestes/CursoCucumber.git</pre>

- Aguarde o clone ser finalizado. Em seguida, o projeto pode ser importado para sua IDE de preferência.


## Implementação do Código

- Há um pacote (_br.com.linhares.crisley.config_), com as classes de configuração utilizadas neste projeto.
- Os testes propriamente ditos estão dentro do pacote _**br.com.linhares.crisley.runners**_. São duas classes de testes implementadas:
  - _RunnerFunctionalTest_
  - _RunnerUnitTest_
  
- Os _steps_ utilizados nos testes estão no pacote _**br.com.linhares.crisley.steps**_.
- Os arquivos _.feature_, estão no diretório _**resources/features**_.

## Executando os Testes

- Os testes podem ser executados como um _teste JUnit_ a partir das classes de teste.
- Caso prefira, navegue até o diretório raiz do repositório via CMD e execute o comando:
<pre>mvn tests</pre>
