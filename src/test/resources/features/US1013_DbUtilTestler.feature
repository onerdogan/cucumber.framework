Feature: US1013 Kullanici DB Util ile Concort Hotel database'ini test eder
  @Dbutil
  Scenario: TC19 DB Util ile Concort Hotel Database Read Test
    Given kullanici DBUtil ile CHQA database'ine baglanir
    Then kullanici DBUtil ile "tHOTELROOM" tablosundaki "Price" verilerini alir
    And kullanici DBUtil ile "Price" sutunundaki 5. fiyatin 470 oldugunu test eder



  @dbupdate
  Scenario: Kullanici tHOTEL tablosundan istedigi Emaili update eder
    Given kullanici DBUtil ile CHQA database'ine baglanir
    Then  DBU IDHotel degeri 1017 olan kaydin Email degerini "elveda@gmail.com" yapar