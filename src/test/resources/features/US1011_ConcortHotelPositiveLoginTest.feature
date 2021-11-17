@CH1
Feature: US1011 kullanici dogru bilgilerle sayfaya girebilmeli

  Scenario: TC17 positive login testi
    When kullanici "CHQAUrl" sayfasina gider
    Then CH Login linkine tiklar
    And CH username kutusuna "manager" yazar
    And CH password kutusuna "Manager1!" yazar
    And CH Login butonuna basar
    Then CH basarili giris yapildigini test eder
    And sayfayi kapatir