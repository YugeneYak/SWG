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
    Дано Открыта страница сайта ""
    И Приняты куки
    Дано Открываем меню каталога
    Тогда Выбираем раздел "Светодиодная лента"
    И Находим фильтры
      |ПО МЕСТУ ПРИМЕНЕНИЯ|
      |Для витрин и рекламных конструкций|
      |Дежурная подсветка|
      |Для бань и саун|
      |Для рабочей зоны с высокой цветопередачей|
      |Для влажных помещений|
      |Для закарнизной подсветки|
      |Для потолка|
      |Для мебели и кухни|
      |ПО ТИПУ|
      |Термоустойчивая|
      |Ультратонкая|
      |Влагозащищенная|
      |Неоновая|
      |Лента 360|
      |Однорядная лента|
      |Многорядная лента|
      |Светодиодные линейки|
      |Светодиодные модули|
      |ПО НАПРЯЖЕНИЮ|
      |12 В|
      |24 В|
      |48 В|
      |220 В|
      |ПО ЦВЕТУ СВЕЧЕНИЯ|
      |Холодный белый (5100 - 13 000 К)|
      |Нейтральный белый (3700 - 5000 К)|
      |mix лента (2700 - 6000 К)|
      |Цветные ленты|

  @success
  Сценарий: Проверка полноты меню секции
    Дано Открыта страница сайта ""
    И Приняты куки
    Дано Открываем меню каталога
    Тогда Выбираем раздел "Трековые системы"
    И Находим фильтры
      |Системы|
      |Магнитная система SY-Link|
      |Трековая система TR-Slim|
      |Трековая система SY-Mini|
      |Трековая система SY|
      |Трехфазная трековая система|
      |Однофазная трековая система|

  @success
  Сценарий: Проверка полноты меню секции
    Дано Открыта страница сайта ""
    И Приняты куки
    Дано Открываем меню каталога
    Тогда Выбираем раздел "Источники питания"
    И Находим фильтры
      |ПО ТИПУ|
      |Влагозащищенные|
      |Диммируемые|
      |ПО РАЗМЕРУ|
      |Стандартные|
      |Компактные|
      |Ультратонкие|
      |ПО НАПРЯЖЕНИЮ|
      |12 В|
      |24 В|
      |48 В|
      |ДРАЙВЕРЫ|
      |TRIAC|
      |DALI|

  @success
  Сценарий: Проверка полноты меню секции
    Дано Открыта страница сайта ""
    И Приняты куки
    Дано Открываем меню каталога
    Тогда Выбираем раздел "Алюминиевые профили"
    И Находим фильтры
      |ПО ТИПУ МОНТАЖА|
      |Встраиваемый|
      |Накладной|
      |Подвесной|
      |ПО ЦВЕТУ|
      |Черный|
      |Серебро|
      |Белый|
      |Золотой|
      |Черный муар|
      |ПОДВЕС ДЛЯ ПРОФИЛЯ|
      |2 м|
      |ПО МЕСТУ ПРИМЕНЕНИЯ|
      |Для мебели|
      |Для гипсового потолка|
      |Для натяжного потолка|
      |Закарнизная подсветка|
      |Для пола|
      |Для теневой подсветки|
      |Для линейных светильников|
      |ПО ВИДУ|
      |Влагостойкий|
      |Безрамный|
      |Для ультратонких лент|
      |Круглый|
      |Угловой|

  @success
  Сценарий: Проверка полноты меню секции
    Дано Открыта страница сайта ""
    И Приняты куки
    Дано Открываем меню каталога
    Тогда Выбираем раздел "Светильники"
    И Находим фильтры
      |ПО ТИПУ МОНТАЖА|
      |Встраиваемые|
      |Накладные|
      |Подвесные|
      |ПО МЕСТУ ПРИМЕНЕНИЯ|
      |Для натяжного потолка|
      |Для гипсового потолка (с рамкой)|
      |Для гипсового потолка (под шпаклевку)|
      |Потолочные|
      |Настенные|
      |Напольные|
      |Офисные|
      |Под лампу - убрать и отдать маркетплейсам|
      |Для влажных помещений|
      |ПО ТИПУ|
      |Поворотные|
      |Линейные|
      |Профильные|
      |Из массива дерева|

  @success
  Сценарий: Проверка полноты меню секции
    Дано Открыта страница сайта ""
    И Приняты куки
    Дано Открываем меню каталога
    Тогда Выбираем раздел "Управление освещением"
    И Находим фильтры
      |Беспроводная система Easybus|
      |Беспроводная система Easybus|
      |Беспроводная система EasyDim|
      |Беспроводная система EasyDim|
      |Датчики|
      |Датчики взмаха руки|
      |Датчики движения|
      |Сенсорные|
      |Для лестницы|
      |Датчик открытия двери|
      |Контроллеры и диммеры|
      |Усилители|
      |С радиопультом|
      |С ИК пультом|
      |Для светодиодной ленты (диммирование)|
      |Для лент RGB и RGB+W|
      |Для лент MIX|
      |Для лент SPI|
      |Без пульта|
      |Цифровое управление|
      |DALI|
      |DMX|

  @success
  Сценарий: Проверка полноты меню секции
    Дано Открыта страница сайта ""
    И Приняты куки
    Дано Открываем меню каталога
    Тогда Выбираем раздел "Уличное освещение"
    И Находим фильтры
      |Светильники для фасада|
      |Потолочные|
      |Настенные накладные|
      |Настенные встраиваемые|
      |Прожекторы|
      |Светильники для ландшафта|
      |Прожекторы|
      |Столбики|
      |Встраиваемые в грунт|
      |ПО МЕСТУ ПРИМЕНЕНИЯ|
      |Фасад дома|
      |Зона парковки|
      |Террасы, веранды, беседки|
      |Ступени и лестницы|
      |Дорожки и тропинки|
      |Зеленые насаждения|

  @success
  Сценарий: Проверка полноты меню секции
    Дано Открыта страница сайта ""
    И Приняты куки
    Дано Открываем меню каталога
    Тогда Выбираем раздел "Декоративное освещение"
    И Находим фильтры
      |ПО МЕСТУ ПРИМЕНЕНИЯ|
      |Потолочные|
      |Настенные|
      |Напольные|
      |Настольные|
      |Накладной|
      |По цвету|
      |Черный|
      |Белый|
      |Бронза|
      |Золото|
      |Серебро|
      |Кофейный|
      |Хром|
      |Серый|
      |Медь|
      |Желтый|
      |Дуб|
      |Голубой|

