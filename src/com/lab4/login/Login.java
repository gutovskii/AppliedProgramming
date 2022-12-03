package com.lab4.login;

import java.util.Scanner;

public class Login {
    private final String login = "ADMIN";
    private final String password = "ADMIN";

    public Login() { }

    public void startLogging() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введіть ваш логін:");
            String login = scanner.nextLine();
            System.out.println("Введіть пароль:");
            String password = scanner.nextLine();

            if(this.login.equals(login) && this.password.equals(password)) {
                System.out.println("Вітаю ви успішно ввійшли!");
                break;
            } else System.out.println("Ви ввели хибний логін або пароль, будь ласка спробуйте ще раз!\n");
        }
    }
}
