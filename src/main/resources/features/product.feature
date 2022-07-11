Feature: Testing product controller

  Scenario: Adding and getting a products

    Given a several products
      | title | price | categoryId |
      | p1    | 3.99  | 1          |
      | p2    | 16.49 | 3          |

    When I try to add those to db

    Then I receive in response objects with not null id


#    When I try to get product with id "1"
#
#    Then I receive in product with name "p1", price "3.99" and category id "1"
#
#    When I try to get product with id "2"
#
#    Then I receive in product with name "p2", price "16.49" and category id "3"



