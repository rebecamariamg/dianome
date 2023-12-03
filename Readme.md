## Instalação:

Para rodar buildar e rodar a aplicação, é necessário ter instalado na máquina: Docker e java (versão 17+) <p>

O process de instalação deve ser feito da seguinte forma:  <p>

```shell
# Buildar o artefato java
.\mvnw clean package
```
<br>

```shell
# Rodar a aplicação Docker contendo Spring + MySQL com: 
docker-compose up --build
```
<br>

Em seguida, basta acessar aplicação em:

http://localhost:8080/swagger