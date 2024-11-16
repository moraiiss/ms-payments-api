#!make

MVNW=./mvnw

build:
	@$(MVNW) clean package -DskipTests
	docker-compose up --build -d

up:
	docker-compose up -d

down:
	docker-compose down

test:
	@SPRING_PROFILES_ACTIVE=test $(MVNW) test