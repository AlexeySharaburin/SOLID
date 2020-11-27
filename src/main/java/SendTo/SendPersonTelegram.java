package SendTo;

import Persons.Person;

public class SendPersonTelegram implements SendMessageToSocialMedia {

    private Person person;

    public SendPersonTelegram(Person person) {
        this.person = person;
    }

    @Override
    public void sendToTelegram(String string) {
        System.out.println("Отправляем сообщение в TELEGRAM:\nДобрый день, " + person.getName() + " " + person.getSurname() + "! " + string);
    }

}

