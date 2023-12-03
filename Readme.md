## Instalação:

Para rodar buildar e rodar a aplicação, é necessário ter instalado na máquina: Docker e java (versão 17+) <p>

O processo de instalação deve ser feito da seguinte forma:  <p>

- Clonamos o repositorio
```shell
git clone https://github.com/rebecamariamg/dianome.git
```
Obs: Se estiver usando o windows, verificar se o GIT foi instalado sem a conversão de formato de LF para CRLF, pois pode dar problema na hora de fazer o docker-compose. Se tiver com problemas, basta converter o arquivo docker-entrypoint.sh para usar LF ao invés de CRLF usando o notepad++.
<br>

- Buildar o artefato java
```shell
.\mvnw clean package
```
<br>

- Rodar a aplicação Docker contendo Spring + MySQL com:
```shell
docker-compose up --build
```
<br>

Em seguida, basta acessar aplicação em:

http://localhost:8080/swagger
