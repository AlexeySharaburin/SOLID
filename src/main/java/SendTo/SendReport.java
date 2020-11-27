package SendTo;

// Dependency Inversion Principle
public class SendReport implements SendMessageToEmail {

    public SendReport() {
    }

    @Override
    public void sendToEmail(String company) {
        System.out.println("Уважаемый представитель компании " + company + "! " +
                "\nРабота по вашему запросу проведена.\nВаши предложения разосланы соискателям");
    }
}
