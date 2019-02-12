package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        SimpleDateFormat sdform = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if (args[0].equals("-c"))
        {
            if (args[2].equals("м"))
            {
                try
                {
                    allPeople.add(Person.createMale(args[1], sdform.parse(args[3])));
                    System.out.println(allPeople.size()-1);
                }
                catch (ParseException e)
                {}
            }
            else if (args[2].equals("ж"))
            {
                try
                {
                    allPeople.add(Person.createFemale(args[1], sdform.parse(args[3])));
                    System.out.println(allPeople.size()-1);
                }
                catch (ParseException e)
                {}
            }
        } else if (args[0].equals("-u"))
        {
            int index = Integer.parseInt(args[1]);
            if (allPeople.size() > index)
            {
                if (args[3].equals("м"))
                {
                    try
                    {
                        allPeople.set(index, Person.createMale(args[2], sdform.parse(args[4])));
                    }
                    catch (ParseException e){}
                } else if (args[3].equals("ж"))
                {
                    try
                    {
                        allPeople.set(index, Person.createFemale(args[2], sdform.parse(args[4])));
                    }
                    catch (ParseException e){}
                }
            }
        } else if (args[0].equals("-d"))
        {
            if (allPeople.size() > Integer.parseInt(args[1]))
            {
                Person nullPerson = allPeople.get(Integer.parseInt(args[1]));
                nullPerson.setBirthDay(null);
                nullPerson.setName(null);
                nullPerson.setSex(null);
            }
        }
        else if (args[0].equals("-i"))
        {
            Person pers = allPeople.get(Integer.parseInt(args[1]));
            String sex = pers.getSex().equals(Sex.MALE) ? "м" : "ж";
            SimpleDateFormat simpDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println(pers.getName() + " " + sex + " " + simpDate.format(pers.getBirthDay()));
        }
    }
}
