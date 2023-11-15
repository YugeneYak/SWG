# language: ru
@testy
@checkApi

Функция: Проверка API обмена сайт-конфигуратор

  @success
  Сценарий: Проверка API Combo 2
    Дано Json
      |https://swgshop.ru/catalog/svetilniki/combo_2/?GET_JSON=Y&API_KEY=2vr72y9esgolu7zg|
      |combo|

#  @success
#  Сценарий: Проверка API
#    Дано Json
#      |https://swgshop.ru/api/586/2vr72y9esgolu7zg/swgget_prods/?start=1|
#      |all|
