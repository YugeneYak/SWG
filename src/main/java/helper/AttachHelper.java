package helper;

import io.qameta.allure.Attachment;

public final class AttachHelper {

    private AttachHelper(){
    }

    /**
     * Метод для прикрепления json к отчету
     * @param text текст для отчета
     * @return строка с текстом
     */
    @Attachment(value = "Response", type = "application/json")
    public static String attachResponse(String text) {
        return text;
    }
}