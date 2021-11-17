
Feature: US1008 editor coklu parametreli bir step ile kisi ekler
  @editor2
  Scenario Outline: TC12 Editor sayfasina farkli kisiler ekleme
    Given kullanici "editorUrl" adresine gider
    Then new butonuna basar
    And editor ilgili kutulara "<firstname>" "<lastname>" "<position>" "<office>" "<extension>" "<startDate>""<salary>" bilgileri girer
    And Create tusuna basar




    Examples:
      |firstname|lastname|position|office|extension|startDate|salary|
      |hakan    |tetik   |testlead|paris |124      |2021-12-12|60000|
      |murat    |er      |qa      |kenya |125      |2021-12-22|40000|
      |furkan   |yilmaz  |qa      |adana |130      |2021-01-11|80000|