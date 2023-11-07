# language: ru
@testy
@checkCatalogMenu

Функция: Проверка полноты меню каталога

  @success
  Сценарий: Проверка полноты меню каталога
    Дано Открыта страница сайта ""
    И Приняты куки
    Тогда Открываем меню каталога
  И Находим пункты меню
    | Светодиодная лента |
    | Источники питания |
    | Алюминиевые профили |
    | Светильники |
    | Трековые системы |
    | Управление освещением |
    | Уличное освещение |
    | Декоративное освещение |

  @success
  Сценарий: Проверка полноты меню секции
#    Дано Открыта страница сайта ""
#    И Приняты куки
    Дано Открываем меню каталога
    Тогда Выбираем раздел "Светодиодная лента"
    И Находим фильтры
      | Для витрин и рекламных конструкций |
      | Дежурная подсветка |
      | Для бань и саун |
      | Для рабочей зоны с высокой цветопередачей |
      | Для влажных помещений |
      | Для закарнизной подсветки |
      | Для потолка |
      | Для мебели и кухни |

