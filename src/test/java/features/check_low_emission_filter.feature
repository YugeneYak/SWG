# language: ru
@testy
@checkLowEmissionColor
Функция: Проверка работы фильтра по цветовой температуре

  @success
  Сценарий: Проверка работы фильтра по цветовой температуре для светильников
    Дано Открыта страница сайта "/catalog/svetilniki/potolochnye/vstraivaemye-svetilniki/tochechnye_svetilniki_inlondon/lc1528fbk-5-nw/"
    И Приняты куки
    Тогда Находим фильтр "//input[@name='color-temp1']"

