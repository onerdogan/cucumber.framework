
@Paralel2
Feature: US1006 CONCORT HOTELS SAYFASINDA FARKLI KULLANICI ADLARI ILE NEGATIVE TEST
@CH
  Scenario Outline: TC10 farkli kullanici isimleriyle negative test

    Given kullanici "CHQAUrl" sayfasina gider
    Then CH Login linkine tiklar
    And CH username kutusuna "<wrongUserName>" yazar
    And CH password kutusuna "<wrongPassword>" yazar
    And CH Login butonuna basar
    Then giris yapilamadigini test eder
    And sayfayi kapatir



    Examples:
  |wrongUserName|wrongPassword|
|Manager5     | Manager5!   |
|Manager6     | Manager6!   |
|Manager7     | Manager7!   |
|Manager8     | Manager8!   |
|Manager9     | Manager9!   |