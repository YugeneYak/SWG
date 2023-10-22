package validator;

import builder.FieldsBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class FieldsValidator {

    private String methodNameStartGet = "get";
    private String methodNameStartIs = "is";
    private String dotSplitter = ".";
    private String underscoreSplitter = "__";
    private Class annotation = JsonProperty.class;

    /**
     * Метод для сравнения переданных значений полей
     * со значениями этих полей объекта
     * @param builder - Поля для сравения
     * @param target - Объект в котором произоводится поиск и сравнение
     * @return true если равны, false если не равны
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public boolean isEqual(FieldsBuilder builder, Object target) throws InvocationTargetException, IllegalAccessException {
        if (builder == null || target == null) {
            return false;
        }
        if (target instanceof Class) {
            return false;
        }
        Map<String, String> fields = builder.getParams();
        for (String s: fields.keySet()) {
            String value = getValue(target.getClass(), target, s);
            if(value == null) {
                return false;
            }
            if (!value.equals(fields.get(s))) {
                System.out.println("Wrong value '" + fields.get(s) + "'. " + s + " is '" + value + "'");
                return false;
            }
        }
        return true;
    }

    /**
     * Метод для получения значения переменной объекта
     * по переданному значению аннотации
     * @param clazz
     * @param instance
     * @param annotationValue
     * @return возвращает найденное значение или null
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private String getValue(Class clazz, Object instance, String annotationValue) throws InvocationTargetException, IllegalAccessException {
        if (annotationValue == null) {
            return null;
        }
        Method[] methods = getAnnotatedDeclaredGetters(clazz);
        for (Method method: methods) {
            JsonProperty property = (JsonProperty) method.getAnnotation(annotation);
            if (annotationValue.contains(dotSplitter)) {
                String[] separated = annotationValue.split("\\.");
                if (separated[0].contains(underscoreSplitter)) {
                    String[] separatedWithNumber = separated[0].split(underscoreSplitter);
                    if (property.value().equals(separatedWithNumber[0])) {
                        int number = 0;
                        try{
                            number = Integer.parseInt(separatedWithNumber[1]);
                        } catch (NumberFormatException e) {
                            throw new RuntimeException("Incorrect field value " + annotationValue + ". Index must be integer");
                        }
                        number--;
                        if (number < 0) {
                            throw new RuntimeException("Incorrect field value " + annotationValue + ". Index must be greater than zero");
                        }
                        Object inst = method.invoke(instance);
                        List<Object> list = (List<Object>) inst;
                        if (number < list.size()) {
                            Object element = list.get(number);
                            return getValue(element.getClass(), element, getStringFromArray(separated));
                        }
                    }
                } else {
                    if (property.value().equals(separated[0])) {
                        Object inst = method.invoke(instance);
                        return getValue(inst.getClass(), inst, getStringFromArray(separated));
                    }
                }
            } else {
                if (property.value().equals(annotationValue)) {
                    return method.invoke(instance).toString();
                }
            }
        }
        return null;
    }

    /**
     * Метод для создания строки из массива
     * @param array
     * @return Возвращает строку
     */
    private String getStringFromArray(String[] array){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if(i != array.length - 1) {
                stringBuilder.append(dotSplitter);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Метод для получения методов get класса с заданной аннотацией
     * @param clazz
     * @return Возвращает массив аннотированных методов get класса
     */
    private Method[] getAnnotatedDeclaredGetters(Class clazz) {
        Method[] methods = getDeclaredMethods(clazz);
        List<Method> annotatedMethods = new LinkedList<>();
        for (Method method: methods) {
            if (method.isAnnotationPresent(annotation)
                    && method.getName().startsWith(methodNameStartGet)
                    || method.getName().startsWith(methodNameStartIs)) {
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods.toArray(new Method[annotatedMethods.size()]);
    }

    /**
     * Метод для получения всех методов класса
     * @param clazz
     * @return возвращает массив всех методов класса
     */
    private static Method[] getDeclaredMethods(Class clazz){
        List<Method> methods = new LinkedList<>();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Collections.addAll(methods, declaredMethods);
        return methods.toArray(new Method[methods.size()]);
    }
}