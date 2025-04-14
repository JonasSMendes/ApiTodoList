# sistema de ToDoList  

Desenvolvendo uma API de ToDoList para gerenciar requisições simples com categorias temáticas específicas.

## Mermaid

```mermaid
erDiagram
    CATEGORY ||--o{ TASK : has

    CATEGORY {
        int id PK
        string name
        string description
    }

    TASK {
        long id PK
        string title
        string description
        boolean completed
        int category_id FK
    }
