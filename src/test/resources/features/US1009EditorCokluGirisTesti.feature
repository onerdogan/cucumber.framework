Feature: US1009 editor sayfasina giris yapildigini test et
  @editor3
  Scenario Outline: TC13 Editor sayfasina farkli kisiler ekleme
    Given kullanici "editorUrl" adresine gider
    Then new butonuna basar
    And editor firstname kutusuna "<firstname>" bilgileri girer
    And editor lastname kutusuna "<lastname>" bilgileri girer
    And editor position kutusuna "<position>" bilgileri girer
    And editor office kutusuna "<office>" bilgileri girer
    And editor extension kutusuna "<extension>" bilgileri girer
    And editor startDate kutusuna "<startDate>" bilgileri girer
    And editor salary kutusuna "<salary>" bilgileri girer
    And Create tusuna basar
    Then "<firstname>" ve "<lastname>" girerek kaydin tamamlandigini test eder
    And sayfayi kapatir




    Examples:
      |firstname|lastname|position|office|extension|startDate|salary|
      |hakan    |tetik   |testlead|paris |124      |2021-12-12|60000|
      |murat    |er      |qa      |kenya |125      |2021-12-22|40000|
      |furkan   |yilmaz  |qa      |adana |130      |2021-01-11|80000|