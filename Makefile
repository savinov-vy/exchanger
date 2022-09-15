.PHONY: up-db
up-db:
	docker-compose -f dev/docker-compose.yml up -d

.PHONY: down-db
down-db:
	docker-compose -f dev/docker-compose.yml down