Feature: US2001 GMIBank Positive Login

  Scenario: TC01 Positif Login Testi
    When kullanici gmibank sayfasina gider
    Then sayfaya giris yapar
    And sayfaya giris yapyigini dogrular
    When gmibank signout butonuna tiklar
    And gmibank sayfasindan cikis yaptigini dogrular