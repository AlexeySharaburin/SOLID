package SendTo;

import Persons.Person;

public class SendPersonEmail implements SendMessageToEmail {

    private Person person;

    public SendPersonEmail(Person person) {
        this.person = person;
    }

    @Override
    public void sendToEmail(String string) {
        System.out.println("Отправляем сообщение по эл.почте:\nДобрый день, " + person.getName() + " " + person.getSurname() + "! " + string);
    }

}
