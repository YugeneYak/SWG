# language: ru
@test
@GET_Methods_Params
Функция: Проверка GET методов c параметрами

  @success
  Сценарий: GET_Methods_Params
    Дано запуск GET метода "CreateOrder" с параметрами "{\"SupplementCourseID\": 675,\"PaymentOptionID\": 3,\"OrderPaid\": false,\"DeliveryAddress\": null,\"DeliverySum\": 256,\"DeliveryComment\": \"Не торопитесь, я подожду\",\"DeliveryOptions\": {  \"DeliveryID\": 368,  \"Code\": \"SRK10\",  \"DeliveryOption\": \"PVZ\"}}"
    Тогда в ответе метода найдено значение "OrderNumberPlatform"


#  @success
#  Сценарий: GET_Methods_Params
#    Дано запуск GET метода "OrdersList" с параметрами ""
