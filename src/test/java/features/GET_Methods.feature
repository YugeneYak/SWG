# language: ru
@test
@GET_Methods
Функция: Проверка GET методов без параметров

  @success
  Сценарий: GET_Methods
    Дано запуск GET метода "Supplements"
    Тогда в ответе метода найдено значение "PC-00000664"
    Дано запуск GET метода "BaseSupplements"
    Тогда в ответе метода найдено значение "PC-00000664"
    Дано запуск GET метода "SupplementsList"
    Тогда в ответе метода найдено значение "PC-00000664"
    Дано запуск GET метода "CustomerCountry"
    Тогда в ответе метода найдено значение "CallingCode"
    Дано запуск GET метода "PartnerInterface"
    Тогда в ответе метода найдено значение "LanguageID"
    Дано запуск GET метода "LegalCompliance"
    Тогда в ответе метода найдено значение "<html><body>"
    Дано запуск GET метода "LegalOffer"
    Тогда в ответе метода найдено значение "<html><body>"
    Дано запуск GET метода "ConfidentialPolicy"
    Тогда в ответе метода найдено значение "<html><body>"

