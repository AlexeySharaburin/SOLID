// Magic !
// Don't Repeat Yourself !
// // SOLID
// Single Pesponsibility Principle !
// Open-Closed Principle !
// Liskov Substitution Principle !
// Interface Segregation Principle !
// Dependency Inversion Principle !

import Persons.*;
import SendTo.*;
//import SendTo.SendReport;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static Collection<Person> persons = new ArrayList<>();
    static List<String> names = Arrays.asList("Jackie", "Conny", "Harry", "Georgy", "Sammy", "Johny");
    static List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

    static final int MAX_PERSONS = 300; // Magic
    static final int MIN_AGE = 21;
    static final int MAX_AGE = 30;


    public static void main(String[] args) {

        addPersons();

        List<Person> youngBestProgrammers = findYoungBestProgrammers();
        workWitnPretenders(youngBestProgrammers, "Список лучших молодых программистов: ",
                "Мы заинтересованы в ваших услугах для разработки программного обеспечения!\nАдрес эл.почты для связи: free-tech.ru");

        List<Person> bestTeachers = findBestTeachers();
        workWitnPretenders(bestTeachers, "Список учителей с самым высоким рейтингом (ААААА): ",
                "Мы заинтересованы в ваших услугах для работы в нашем университете!\nАдрес эл.почты для связи: univer.hh.io");

        List<Person> russianNurses = findRussianNurses();
        workWitnPretenders(russianNurses, "Список медсестёр со знанием русского языка: ",
                "Мы заинтересованы в ваших услугах для работы с русскоязычными клиентами!\nАдрес эл.почты для связи: heim.tirol.at");

        // Dependency Inversion Principle
        SendMessageToEmail sendReport = new SendReport();
        sendReport.sendToEmail("'Нетология'");
    }

    public static void addPersons() {
        for (int i = 0; i < MAX_PERSONS; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    (new Random().nextInt((MAX_AGE - MIN_AGE) + 1) + MIN_AGE),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Rating.values()[new Random().nextInt(Rating.values().length)],
                    Language.values()[new Random().nextInt(Language.values().length)],
                    Residence.values()[new Random().nextInt(Residence.values().length)],
                    Profession.values()[new Random().nextInt(Profession.values().length)],
                    Contact.values()[new Random().nextInt(Contact.values().length)])
            );
        }
    }

    public static void workWitnPretenders(List<Person> list, String string, String letter) { // Don't Repeat Yourself
        printPersons(list, string);
        CalcProfis.calculate(list);
        BeforeAfterSend send = new BeforeAfterSend();
        send.checkList(list);
        send.sendTo(list, letter);
    }

    public static void printPersons(List<Person> list, String string) {  // Don't Repeat Yourself
        System.out.println("\n" + string);
        if (list.size() == 0) {
            System.out.println("К сожалению, работники, удовлетворяющие Вашим требованиям, в базе данных отсутствуют!");
        } else {
            for (Person person : list) {
                System.out.println(person.toString());
            }
        }
    }

    public static List<Person> findYoungBestProgrammers() {
        Stream<Person> stream = persons.stream();
        List<Person> youngBestProgrammers = stream
                .filter(person -> ((person.getAge() > MIN_AGE) && (person.getAge() < MAX_AGE)))
                .filter(person -> ((person.getProfession() == Profession.PROGRAMMER)))
                .filter(person -> ((person.getRating() == Rating.AAAAA)))
                .collect(Collectors.toList());
        return youngBestProgrammers;
    }

    public static List<Person> findBestTeachers() {
        Stream<Person> stream = persons.stream();
        List<Person> bestTeachers = stream
                .filter(person -> ((person.getRating() == Rating.AAAAA) && (person.getProfession() == Profession.TEACHER)))
                .collect(Collectors.toList());
        return bestTeachers;
    }

    public static List<Person> findRussianNurses() {
        Stream<Person> stream = persons.stream();
        List<Person> nurses = stream
                .filter(person -> (person.getProfession() == Profession.NURSE))
                .filter(person -> (person.getSex() == Sex.WOMAN))
                .filter(person -> (person.getLanguage() == Language.РУССКИЙ))
                .collect(Collectors.toList());
        return nurses;
    }

}
