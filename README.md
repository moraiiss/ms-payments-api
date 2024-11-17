# Payments API
API Rest para simulação de pagamento simplificado entre vendedores e consumidores.

# Stack
- Kotlin 
- Spring 
- MySQL

## Executando a primeira vez

    make build

## Rodando o projeto

    make up

A aplicação estará disponível em `http://localhost:8081` 

[Swagger Docs](http://localhost:8081/swagger-ui/index.html)

## Executando os testes

    make test

## Rodando o Detekt Check
    
    make format

# REST API

A API Rest para a aplicação de exemplo é descrita abaixo.

## Criando nova transferência

### Request

`POST /transactions/`

    curl -i -H 'Accept: application/json' -d 'payee=213&payer=321&amount=100.0' http://localhost:8081/transactions/

### Response

    HTTP/1.1 201 Created
    Date: Thu, 15 Nov 2024 12:36:30 GMT
    Status: 201 Created
    Connection: close
    Content-Type: application/json
    Location: /transactions/1
    Content-Length: 2

    {
        "id": 1,
        "payee": 213,
        "payer": 321,
        "amount": 100.0,
        "status": "APPROVED"
    }

