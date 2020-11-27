// Open-Closed Principle
// Liskov Substitution Principle

import Persons.Person;

import java.util.List;

public class BeforeAfterSend extends Send {
    public BeforeAfterSend() {
    }

    @Override
    public void sendTo(List<Person> list, String string) {
        beforeSend(list);
        super.sendTo(list, string);
        afterSend(list);
    }

    public void beforeSend(List<Person> list) {
        if (checkList(list)) {
            System.out.println("Отправляем ваши предложения соискателям:");
        } else {
            System.out.println("Увы, никого не нашли!");
        }
    }

    public void afterSend(List<Person> list) {
        if (checkList(list)) {
            System.out.println("\nОтправка сообщений закончена");
        }
        System.out.println("__________________________________________________________________________________________");

    }

// Liskov Substitution Principle

    @Override
    public boolean checkList(List<Person> list) {
        if (list.size() == 0) {
            throw new IllegalStateException(
                    String.format("Список пуст!")
            );
        }
        return true;
    }
}
