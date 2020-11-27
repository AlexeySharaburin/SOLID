// Single-responsibility principle

import Persons.Person;

import java.util.List;

public class CalcProfis {

    public CalcProfis() {
    }

    public static void calculate(List<Person> list) {
        int result = 0;
        String profession = null;
        for (Person person : list
             ) {
            result++;
            profession = person.getProfession().toString();
        }
        System.out.format("\nКоличество кандидатов на соискание должности %s - %d чел.\n", profession, result);
    }
}
