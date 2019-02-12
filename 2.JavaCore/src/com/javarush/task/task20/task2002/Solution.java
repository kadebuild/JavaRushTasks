package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("d:/1.txt", null);
            OutputStream outputStream = new FileOutputStream("d:/1.txt");
            InputStream inputStream = new FileInputStream("d:/1.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users.add(new User());
            javaRush.users.get(0).setFirstName("Abraham");
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush.equals(loadedObject))
            {
                System.out.println("TRUE");
            }
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            for (int i = 0; i < users.size(); i++) {
                printWriter.println(users.get(i).getFirstName());
                printWriter.println(users.get(i).getLastName());
                if (users.get(i).getBirthDate() != null) {
                    printWriter.println(users.get(i).getBirthDate().getTime());
                } else {
                    printWriter.println("null");
                }
                printWriter.println(users.get(i).getCountry());
                printWriter.println(users.get(i).isMale());
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                users.add(new User());
                String buf = reader.readLine();
                if (!buf.equals("null")) {
                    users.get(users.size() - 1).setFirstName(buf);
                }
                buf = reader.readLine();
                if (!buf.equals("null")) {
                    users.get(users.size() - 1).setLastName(buf);
                }
                buf = reader.readLine();
                if (!buf.equals("null")) {
                    users.get(users.size() - 1).setBirthDate(new Date(Long.parseLong(buf)));
                }
                buf = reader.readLine();
                if (!buf.equals("null")) {
                    users.get(users.size() - 1).setCountry(User.Country.valueOf(buf));
                }
                users.get(users.size()-1).setMale(reader.readLine().equals("true"));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
