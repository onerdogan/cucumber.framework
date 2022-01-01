Feature: user Settings sayfasi1

  Scenario: Kullanici ayarlaridaki bilglerle dil seceneklerini dogrulama
    Given kullanici gmibank sayfasina gider
    Then gmibank signin butonuna tiklar
    Then kullanici gecerli username ve password girer
    Then gmibank sign in butonuna basar
    Then kullanici usedrIcona tiklar
    Then kullanici settings sayfasinda olmalidir
    And kullanici language dropdown da secenekleri gorur
    Then kullanici English ve Turkish den baska dil seceneginin olmadigini dogrular