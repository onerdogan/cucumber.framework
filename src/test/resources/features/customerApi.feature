@CustomerApi

Feature: Api Data Okuma
  #https://www.gmibank.com/api/tp-customers end pointten datalari 12 li olarak alir
  #https://www.gmibank.com/api/tp-customers?=size=2000 butun datalari alir.

  Background: Api Datalari Ayarlama
    * Kullanici Api end pointe gidecek "https://www.gmibank.com/api/tp-customers?=size=2000" datalari alacak

  Scenario: Apiden Data Alma ve Onaylama
    * Kullanici musteri datalarini alir
    * Kullanici aldigi datalari kaydeder
    * Kullanici Customer datalarini onaylar