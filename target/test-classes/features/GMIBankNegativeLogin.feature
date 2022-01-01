Feature: Negative Login
  Scenario Outline: GMIBank Negative Login Test

    Given kullanici gmibank sayfasina gider
    Then gmibank signin butonuna tiklar
    And gmibank username kutusuna "<yanlisUserName>" yazar
    And gmibank password kutusuna "<yanlisPassword>" yazar
    And gmibank sign in butonuna basar
    Then gmibank giris yapilamadigini test eder
    And sayfayi kapatir

    Examples:
    |yanlisUserName|yanlisPassword|
    |employee1     |Manager1!     |
    |employee2     |Manager2!     |
    |employee3     |Manager3!     |