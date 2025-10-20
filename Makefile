# ==========================
# 🏐 Makefile SJL Project
# ==========================

DOCKER_POSTGRESQL_COMPOSE = ./docker/postgres.yml

# --- DATABASE COMMANDS ---

db-up:
	docker compose -f $(DOCKER_POSTGRESQL_COMPOSE) up -d

db-down:
	docker compose -f $(DOCKER_POSTGRESQL_COMPOSE) down

db-reset:
	docker compose -f $(DOCKER_POSTGRESQL_COMPOSE) down -v

# --- BACKEND COMMANDS ---

backend-dev:
	cd backend && ./mvnw quarkus:dev

backend-build:
	cd backend && ./mvnw clean package

# --- UTILITAIRES ---
logs:
	docker compose -f $(DOCKER_COMPOSE) logs -f

status:
	docker compose -f $(DOCKER_COMPOSE) ps