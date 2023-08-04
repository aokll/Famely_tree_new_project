package MVP.View.Console;

import FamilyTreePackage.Gender;
import MVP.Presenter.Present;
import MVP.View.MenuClass;

import java.awt.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleFT implements IConsole{
    private Present present;
    private Scanner scanner;
    private MenuClass menuClass;
    boolean bool = true;

    public ConsoleFT() {
        present = new Present(this);
        this.scanner = new Scanner(System.in);
        menuClass = new MenuClass(this);
    }

    @Override
    public void start() throws ParseException {
        System.out.println("привет");

        while (bool){
            System.out.println(menuClass.menu());
            Operation();
        }
    }
    public void start1() throws ParseException {
        System.out.println("привет");
        label:
        while (true){
            System.out.println("0 - посмотреть дерево, " +
                    "1 - добавить в дерево, " +
                    "2 - удалить из дерева, " +
                    "3 - сохранить, " +
                    "4 - сортировать по имени, " +
                    "5 - сортировать по дате рождения." +
                    "6 - выход");
            System.out.println("введите номер команды");
            int x = scanner.nextInt();
            if (x == 0){
                present.PrintTree();
                continue label;
            } else if (x == 1) {
                AddHuman();
                continue label;
            } else if (x == 2) {
                RemoveHuman();
                continue label;
            } else if (x == 3) {
                present.Save();
                continue label;
            } else if (x == 4) {
                present.SortName();
                continue label;
            } else if (x == 5) {
                present.SortBirthday();
                continue label;
            } else if (x == 6) {
                break;
            }
            break;
        }
    }

    public void Operation() throws ParseException {
            String ch = scanner.nextLine();
            int x = Integer.parseInt(ch);
            menuClass.execute(x);
    }
    public void finish(){
        scanner.close();
        bool = false;
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
    public void AddHuman() throws ParseException {
        System.out.println("укажите имя");
        String name = scanner.next();
        System.out.println("укажите дату рождения");
        System.out.println("год");
        int y = scanner.nextInt();
        System.out.println("месяц");
        int m = scanner.nextInt();
        System.out.println("день");
        int d = scanner.nextInt();
        LocalDate localDate = LocalDate.of(y,m,d);
        System.out.println("укажите дату смерти");
        System.out.println("год");
        int y1 = scanner.nextInt();
        System.out.println("месяц");
        int m2 = scanner.nextInt();
        System.out.println("день");
        int d3 = scanner.nextInt();
        LocalDate localDate1 = LocalDate.of(y1,m2,d3);
        System.out.println("укажите пол");
        Gender gender = Pol();
        present.AddNewHuman(name,localDate,localDate1,gender);
    }
    public Gender Pol(){
        String pol = scanner.next();
        if (pol.equals("м")){
            return Gender.MAN;
        } else if (pol.equals("ж"))
            return Gender.WOMAN;
        return null;
    }
    public void RemoveHuman(){
        String name = scanner.next();
        present.RemoveHuman(name);
    }
    public void PrintTree(){
        present.PrintTree();
    }
    public void Save(){
        present.Save();
    }
    public void SortName(){
        present.SortName();
    }
    public void SortBirthdate(){
        present.SortBirthday();
    }
}
