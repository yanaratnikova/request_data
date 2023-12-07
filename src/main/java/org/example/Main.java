package org.example;

import java.util.Scanner;

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
        String LastName = data[0];
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
    }
}