# Employee Leave System

## Overview

A secure Spring Boot REST API for employee profiles, leave requests, manager decisions, balances, and reporting.

## Features

- Revocable bearer login/logout and admin/manager/employee roles
- Admin-created employee profiles with reporting-manager scope
- Annual, sick, and unpaid leave; date validation and overlap prevention
- Manager/admin approval and rejection, employee cancellation, locked balance deduction
- Filtering, pagination, dashboards, Flyway, PostgreSQL, H2 tests, Docker, CI, Dependabot

## Technology Stack

Java 25, Spring Boot 4.1.1, Web MVC, Security, Data JPA, Bean Validation, Flyway, PostgreSQL 17, H2, Maven Wrapper.

## Requirements

Java 25 plus PostgreSQL 15+ or Docker. Maven is optional.

## Installation

Run `Copy-Item .env.example .env` and `.\mvnw.cmd clean package`.

## Environment Variables

Set `DATABASE_URL`, `DATABASE_USERNAME`, and `DATABASE_PASSWORD`. Optional: `TOKEN_TTL_MINUTES`, `ALLOWED_ORIGINS`, `SPRING_PROFILES_ACTIVE`.

## Database Setup

Flyway applies the schema automatically at startup. Docker users can run `docker compose up --build`.

## Running the Application

Set `$env:SPRING_PROFILES_ACTIVE='dev'`, then run `.\mvnw.cmd spring-boot:run`. Health: `/actuator/health`.

## Running Tests

Run `.\mvnw.cmd verify`.

## Default Development Accounts

With `dev`: admin `admin@example.com` / `AdminPassword123!`; manager `manager@example.com` / `ManagerPassword123!`; employee `employee@example.com` / `EmployeePassword123!`. Development only.

## API Endpoints

`POST /api/auth/login|logout`; `GET/POST /api/employees`; `GET/POST /api/leave-requests`; `PATCH /api/leave-requests/{id}/approve|reject|cancel`; `GET /api/dashboard`.

## Folder Structure

The project uses explicit `controller`, `service`, `repository`, `entity`, `dto`, `security`, `config`, `exception`, and Flyway migration layers.

## Security Notes

BCrypt cost 12, hashed revocable opaque tokens, rate-limited timing-equalized login, service-layer RBAC, manager scope and ownership checks, DTO validation, bounded pages, JPA parameters, row locks/versioning, CORS allow-listing, and safe errors.

## Known Limitations

Days are calendar days, not working days. Holiday calendars, half-days, accrual jobs, attachments, notifications, delegated approvals, MFA, and password recovery are outside scope. Rate limiting is per process.
