package MVP.View.Console;

import FamilyTreePackage.Gender;
import FamilyTreePackage.Human;
import MVP.Presenter.Present;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ConsoleFT implements IConsole{
    private Present present;
    private Scanner scanner;

    public ConsoleFT() {
        present = new Present(this);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void start() throws ParseException {
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
                addHuman();
                continue label;
            } else if (x == 2) {
                removeHuman();
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

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
    public void addHuman() throws ParseException {
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
        LocalDate localDate1 = LocalDate.of(y,m,d);
        System.out.println("укажите пол");
        String pol = scanner.nextLine();
        Gender g = null;
        if (pol.equals("M")){
            g = Gender.MAN;
        } else if (pol.equals("Ж")) {
            g = Gender.WOMAN;
        }
        present.AddNewHuman(name,localDate,localDate1,g);
    }
    void removeHuman(){
        String name = scanner.nextLine();
        present.RemoveHuman(name);
    }
}
