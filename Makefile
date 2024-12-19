#!make

MVNW=./mvnw

build:
	@$(MVNW) clean package -DskipTests
	docker-compose up --build -d

rebuild-api:
	docker-compose build ms.payments.api
	docker-compose up -d

migrate:
	@$(MVNW) flyway:migrate

db-clean:
	@$(MVNW) flyway:clean

debug:
	@$(MVNW) clean package -DskipTests
	docker-compose up --build

test:
	@SPRING_PROFILES_ACTIVE=test $(MVNW) test

format:
	mvn detekt:check

up:
	docker-compose up -d

down:
	docker-compose down
