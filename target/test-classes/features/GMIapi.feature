@api
  Feature: gmibank Api Test
    Scenario: Read all Customer
      Given user goes to api end point "https://www.gmibank.com/api/tp-customers"
      And read all customers and set response