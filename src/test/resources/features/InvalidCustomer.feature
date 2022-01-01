Feature: My Operations

  Scenario: Invalid Customer

    Given kullanici gmibank sayfasina gider
    Then gmibank signin butonuna tiklar
    Then kullanici gecerli username ve password girer
    And gmibank sign in butonuna basar
    Then kullanici My Operations a tiklar
    Then kullanaici Manage Customers i secer
    And kullanici Create anew Customer a tiklar
    And kullanici "ssn" girer
    And kullanaici search button a tiklar
    Then kullanici fail message i gorur