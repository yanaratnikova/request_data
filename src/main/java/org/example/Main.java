package org.example;

import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные (Фамилия Имя Отчество дата_рождения номер_телефона пол): ");
        String input = scanner.nextLine();
        String[] data = input.split(" ");
        if (data.length != 6){
            System.out.println("Ошибка: введено неверное количество параметров");
            return;
        }
        String lastName = data[0];
        String firstName = data[1];
        String patronymic = data[2];
        String birthDate = data[3];
        String phoneNumber = data[4];
        String gender = data[5];
        if (!isCorrectBirthDate(birthDate)){
            System.out.println("Ошибка: неверный формат даты рождения. Ожидается дата в формате дд.мм.гг");
            return;
        }
        if (!isCorrectPhoneNumber(phoneNumber)){
            System.out.println("Ошибка: неверный формат номера телефона. Ожидается номер в формате +7ХХХХХХХХХХ");
            return;
        }
        if (!isCorrectGender(gender)){
            System.out.println("Ошибка: неверное значение пола. Ожидается m или f");
            return;
        }
        try {


            FileWriter fileWriter = new FileWriter(lastName + ".txt", true);
            fileWriter.write(input+"; ");
            fileWriter.write("\n");
            fileWriter.close();
            System.out.println("Данные успешно записаны в файл "+ lastName + ".txt");
        }  catch (IOException e) {
            System.out.println("Ошибка записи в файл: ");
            e.getStackTrace();
            throw new RuntimeException(e);
        }
    }
    private static boolean isCorrectBirthDate(String birthDate){
        return birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
    }
    private static boolean isCorrectPhoneNumber(String phoneNumber){

        return Pattern.matches("\\+7\\d{10}", phoneNumber);
    }
    private static boolean isCorrectGender(String gender){
        return gender.equals("m") || gender.equals("f");
    }

}