package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

public class HtmlView implements View {

    Controller controller;
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replaceAll("\\.", "/") + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            String str = getUpdatedFileContent(vacancies);
            updateFile(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException {
        String result = null;
        try {
            Document document = getDocument();
            Element element = document.getElementsByClass("template").first();
            Element copy = element.clone();
            copy.removeClass("template").removeAttr("style");
            document.getElementsByAttributeValue("class", "vacancy").remove();
            for (Vacancy vacancy : vacancies) {
                Element c = copy.clone();
                c.getElementsByAttributeValue("class", "city").get(0).text(vacancy.getCity());
                c.getElementsByAttributeValue("class", "companyName").get(0).text(vacancy.getCompanyName());
                c.getElementsByAttributeValue("class", "salary").get(0).text(vacancy.getSalary());
                Element link = c.getElementsByTag("a").get(0);
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());
                element.before(c.outerHtml());
            }
            result = document.html();
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
        return result;
    }

    private void updateFile(String str) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(str);
        writer.close();
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
