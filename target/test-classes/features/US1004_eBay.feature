
Feature: US1004 ebay sayfasinda kelime arama
  @Failed
  Scenario: TC08 kullanici ebayda istedigi kelimeyi aratip test eder
    #BU TEST CALISMAZ
    Given kullanici "ebayUrl" sayfasina gider
    Then "nutella" icin arama yapar
    And sonucun "nutella" icerdigini test eder
    Then sayfayi kapatir

    #tum step definitionlar tanimli gibi gorunse de tesst calismaz,
  #ebay icin de locationlarin yapilmasi gerekli, stepler ayni ifade var oldugu icin adimlar varmis gibi gorunuz
