package SendTo;

import Persons.Person;


public class SendPersonPost implements SendMessageToPost {

    private Person person;

    public SendPersonPost(Person person) {
        this.person = person;
    }


    @Override
    public void sendToPost(String string) {
        System.out.println("Отправляем сообщение заказным письмом 'Почта России':\nДобрый день, " + person.getName() + " " + person.getSurname() + "! " + string);
    }

}
