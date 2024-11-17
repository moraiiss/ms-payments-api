#!make

MVNW=./mvnw

build-all:
	@$(MVNW) clean package
	docker-compose up --build -d

build-api:
	docker-compose build ms.payments.api
	docker-compose up -d

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