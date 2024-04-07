# Contabil

## TODO

- [x] login
- [x] users table
- [x] organizations table
- [x] movimento table
- [x] users x organizations
- [x] organizations x movimento
- [ ] users x organizations x movimento authorization
- [x] users page
- [x] organizations page
- [x] movimento page
- [ ] user add
- [ ] user edit
- [ ] organization add
- [ ] organization edit
- [ ] movimento add
- [ ] movimento edit
- [ ] audit table
- [x] add spring boot devtools
- [ ] add pagination to queries and repositories
- [ ] add header to pages
- [ ] add footer to pages
- [ ] add menu to pages
- [ ] add css framework - bootstrap or material
- [ ] add table handler to pages

> [!TIP]
> [Access this docs for readme.md markdown syntax](https://docs.github.com/pt/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)
> [Code blocks with syntax highlighting](https://docs.github.com/en/get-started/writing-on-github/working-with-advanced-formatting/creating-and-highlighting-code-blocks)
> [Tables on readme.md syntax](https://docs.github.com/en/get-started/writing-on-github/working-with-advanced-formatting/organizing-information-with-tables)
> [Docs for diagrams on readme.md, Mermaid syntax](https://docs.github.com/en/get-started/writing-on-github/working-with-advanced-formatting/creating-diagrams)
> [Mermaid syntax](https://mermaid.js.org/syntax/entityRelationshipDiagram.html)

## Reference

### Thymeleaf

- [Thymeleaf + Spring](https://www.thymeleaf.org/doc/tutorials/3.1/thymeleafspring.html)
- [Using thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)

### Spring

- [Spring Framework](https://spring.io/)
- [Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/jpa.html)
- [Spring Security](https://docs.spring.io/spring-security/reference/index.html)

### SQL

* https://www.w3schools.com/sql/sql_join_inner.asp

> Select all users from School A

```sql
select * from users 
inner join users_organizations 
  on users.id = users_organizations.user_id 
inner join organizations 
  on users_organizations.organization_id = organizations.id
where organizations.id = 1;
```

### SQL Diagram

```mermaid
---
title: Contabil
---
erDiagram
    users ||--o{ users_organizations : has
    users_organizations }o--|| organizations : has
    organizations ||--o{ movimento : has
    users {
      int id
      string email
      string password
      string full_name
      string role
      enum status
      int created_by
      timestamp created_at
      timestamp last_modified_at
      timestamp last_login_at
      int last_modified_by
      timestamp deleted_at
    }
    users_organizations {
      int user_id
      int organization_id
    }
    organizations {
      int id
      string name
      string legal_name
      string cnpj
      boolean is_active
      int created_by
      timestamp created_at
      timestamp last_modified_at
      int last_modified_by
      timestamp deleted_at
    }
    movimento {
      int id
      string descricao
      enum tipo
      date data_lancamento
      numeric(38,2) valor
      int organization_id
      id created_by
      int last_modified_by
      timestamp created_at
      timestamp last_modified_at
      timestamp deleted_at
    }
```