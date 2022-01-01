
Feature: GMIBank Guvenli Sifre
  Background:


    Given kullanici gmibank sayfasina gider
    Then gmibank giris butonuna tiklar
    Then gmibank register butonuna tiklar
    And gmibank password kutusuna tiklar

    Scenario Outline: Password Red Test
      Given "<password>" girer
      Then gmibank Password strenght red gorunur

      Examples:
      |password|
      |1111    |
      |AAAA    |

  Scenario Outline: Password orange Test
    Given "<passwordOrange>" girer
    Then gmibank Password strenght orange gorunur

    Examples:
      |passwordOrange|
      |AA11    |
      |AA22    |

  Scenario Outline: Password yellow Test
    Given "<passwordYellow>" girer
    Then gmibank Password strenght yellow gorunur

    Examples:
      |passwordYellow|
      |AA11aa    |
      |AA22aa    |

  Scenario Outline: Password lightgreen Test
    Given "<passwordLightgreen>" girer
    Then gmibank Password strenght lightgreen gorunur

    Examples:
      |passwordLightgreen|
      |1Aa+    |
      |A2a+    |

  Scenario Outline: Password green Test
    Given "<passwordGreen>" girer
    Then gmibank Password strenght green gorunur

    Examples:
      |passwordGreen|
      |1Aa+A!a    |
      |A2a+B!b    |


