# language: ru
@test
@BaseSupplements
Функция: Проверка BaseSupplements

  @success
  Сценарий: BaseSupplements
    Дано запуск GET метода "Supplements"
    Тогда в ответе метода найдено значение "PC-00000664"

