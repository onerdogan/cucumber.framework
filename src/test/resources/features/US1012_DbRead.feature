Feature: US1012 Kullanici Concort Hotel database'ini test eder
  @Db
  Scenario: TC18 Concort Hotel Database Read Test
    Given kullanici CHQA database'ine baglanir
    Then kullanici "tHOTELROOM" tablosundaki "Price" verilerini alir
    And kullanici "Price" sutunundaki verileri okur ve istedigi islemi yapar