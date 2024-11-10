#!make

MVNW=./mvnw

run-dev:
	@SPRING_PROFILES_ACTIVE=dev $(MVNW) spring-boot:run

run-prod:
	@SPRING_PROFILES_ACTIVE=prod $(MVNW) spring-boot:run

run-test:
	@SPRING_PROFILES_ACTIVE=test $(MVNW) test

.PHONY: run-dev run-prod