// Open-closed principle
// Liskov Substitution Principle

import Persons.*;
import SendTo.*;

import java.util.List;

public class Send {

    public Send() {
    }

    public void sendTo(List<Person> list, String string) {
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        if (checkList(list)) {
            for (Person person : list) {
                if (person.getContact() == Contact.TELEGRAM) {
                    SendPersonTelegram sendPersonTG = new SendPersonTelegram(person);
                    sendPersonTG.sendToTelegram(string);
                    i++;
                }
                if (person.getContact() == Contact.POST) {
                    SendPersonPost sendPersonPost = new SendPersonPost(person);
                    sendPersonPost.sendToPost(string);
                    j++;
                }
                if (person.getContact() == Contact.EMAIL) {
                    SendPersonEmail sendPersonEmail = new SendPersonEmail(person);
                    sendPersonEmail.sendToEmail(string);
                    k++;
                } else {
                    l++;
                }
            }
            calculate(i, j, k, l);
        }
    }

    public static void calculate(int i, int j, int k, int l) {
        System.out.format("\nБыло отправлено соискателям: сообщений через TELEGRAM - %d, писем по почте - %d, писем по электронной почте - %d." +
                "\nЧисло сообщений, которые не были отправлены по причине отсутствия контактных данных у адресатов - %d.", i, j, k, l);
    }

    // Liskov Substitution Principle
    public boolean checkList(List<Person> list) {
        boolean b = false;
        if (list.size() != 0) {
            b = true;
        } else {
            System.out.println("У нас нет претендентов!");
        }
        return b;
    }
}
