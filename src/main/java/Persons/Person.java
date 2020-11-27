package Persons;

public class Person {
    private String name;
    private String surname;
    private Integer age;
    private Sex sex;
    private Rating rating;
    public Language language;
    public Residence residence;
    public Profession profession;
    public Contact contact;

    public Person(String name,
                  String surname,
                  Integer age,
                  Sex sex,
                  Rating rating,
                  Language language,
                  Residence residence,
                  Profession profession,
                  Contact contact
    ) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.rating = rating;
        this.language = language;
        this.residence = residence;
        this.profession = profession;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Rating getRating() {
        return rating;
    }

    public Language getLanguage() {
        return language;
    }

    public Residence getResidence() {
        return residence;
    }

    public Profession getProfession() {
        return profession;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Ваш претендент =>" +
                " профессия: " + profession +
                ", имя и фамилия: " + name + " " + surname +
                ", возраст, лет: " + age +
                ", пол: " + sex +
                ", рейтинг в базе: " + rating +
                ", язык: " + language +
                ", проживает в : " + residence +
                ", тип контакта: " + contact;
    }

    public boolean work() {
        System.out.println("Я хочу работать!");
        return true;
    }
}
