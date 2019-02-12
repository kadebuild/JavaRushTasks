package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public volatile static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        SimpleDateFormat sdform = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if (args[0].equals("-c"))
        {
            int numOfPerson = (args.length-1)/3;
            for (int i = 0; i < numOfPerson; i++)
            {
                if (args[2+3*i].equals("м"))
                {
                    try
                    {
                        allPeople.add(Person.createMale(args[1+3*i], sdform.parse(args[3+3*i])));
                        System.out.println(allPeople.size() - 1);
                    }
                    catch (ParseException e)
                    {
                    }
                } else if (args[2+3*i].equals("ж"))
                {
                    try
                    {
                        allPeople.add(Person.createFemale(args[1+3*i], sdform.parse(args[3+3*i])));
                        System.out.println(allPeople.size() - 1);
                    }
                    catch (ParseException e)
                    {
                    }
                }
            }
        } else if (args[0].equals("-u"))
        {
            int numOfPerson = (args.length-1)/4;
            for (int i = 0; i < numOfPerson; i++)
            {
                int index = Integer.parseInt(args[1+4*i]);
                if (allPeople.size() > index)
                {
                    if (args[3+4*i].equals("м"))
                    {
                        try
                        {
                            allPeople.set(index, Person.createMale(args[2+4*i], sdform.parse(args[4+4*i])));
                        }
                        catch (ParseException e)
                        {
                        }
                    } else if (args[3+4*i].equals("ж"))
                    {
                        try
                        {
                            allPeople.set(index, Person.createFemale(args[2+4*i], sdform.parse(args[4+4*i])));
                        }
                        catch (ParseException e)
                        {
                        }
                    }
                }
            }
        } else if (args[0].equals("-d"))
        {
            int numOfPerson = args.length-1;
            for (int i = 0; i < numOfPerson; i++)
            {
                if (allPeople.size() > Integer.parseInt(args[1+i]))
                {
                    Person nullPerson = allPeople.get(Integer.parseInt(args[1+i]));
                    nullPerson.setBirthDay(null);
                    nullPerson.setName(null);
                    nullPerson.setSex(null);
                }
            }
        }
        else if (args[0].equals("-i"))
        {
            int numOfPerson = args.length-1;
            for (int i = 0; i < numOfPerson; i++)
            {
                Person pers = allPeople.get(Integer.parseInt(args[1+i]));
                String sex = pers.getSex().equals(Sex.MALE) ? "м" : "ж";
                SimpleDateFormat simpDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                System.out.println(pers.getName() + " " + sex + " " + simpDate.format(pers.getBirthDay()));
            }
        }
    }
}
