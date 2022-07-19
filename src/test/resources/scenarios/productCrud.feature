Feature: Testing product controller

  Scenario Outline: Adding a products to db
    When add product with "<title>", <price> and <categoryId> to db
    Then I receive product with not null id, "<title>", <price> and <categoryId>

    Examples:
      | title | price | categoryId |
      | add1  | 3.99  | 1          |
      | add2  | 16.49 | 3          |

  Scenario Outline: Getting a product from db
    Given there are no objects in db with <id>
    Given a product with "<title>", <price> and <categoryId> in db and have <id>
    When I try to get product with <id>
    Then I receive product with not null id, "<title>", <price> and <categoryId>

    Examples:
      | id | title | price | categoryId |
      | 3  | get1  | 3.99  | 1          |
      | 4  | get2  | 16.49 | 3          |

  Scenario Outline: Testing delete operation
    Given a product with "<title>", <price> and <categoryId> in db and have <id>
    When delete product from db by <id>
    Then there are no objects in db with <id>

    Examples:
      | id | title   | price | categoryId |
      | 5  | delete1 | 3.99  | 1          |
      | 6  | delete2 | 16.49 | 3          |

  Scenario Outline: Updating product in db
    Given a product with "<title>", <price> and <categoryId> in db and have <id>
    When update product with <id>, using "<title>", <newPrice> and <categoryId>
    Then there are a product in db with <id>, "<title>", <newPrice> and <categoryId>
    Examples:
      | id | title | price | categoryId | newPrice |
      | 7  | put1  | 3.99  | 1          | 9.99     |
      | 8  | put2  | 16.49 | 3          | 12.35    |