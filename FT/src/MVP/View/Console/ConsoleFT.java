package MVP.View.Console;

import FamilyTreePackage.Gender;
import FamilyTreePackage.Human;
import MVP.Presenter.Present;
import MVP.View.MenuClass;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

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
            operation();
        }
    }
    public void operation() throws ParseException {

        menuClass.execute(err());

    }
    public Integer err(){
        int x = 0;
        label:
        while (true) {
            String s = null;
            s = scanner.next();
            Pattern c = Pattern.compile(".*[A-Za-zА-Яа-я<>,./|}{()!&?~].*");
            boolean b = s.matches(c.pattern());
            if (b == true) {
                System.out.println("Должны быть только числа, попробуйте еще раз");
                continue label;
            }
            x = Integer.parseInt(s);
            if (x <= 0 || x > menuClass.getCList().size()){
                System.out.println("Таких вариантов нет, попробуйте еще раз");
                continue label;
            }
            break;
        }
            return x;
    }
    public void finish(){
        scanner.close();
        bool = false;
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
        LocalDate localDate1 = LocalDate.of(y1,m2,d3);
        System.out.println("укажите пол");
        Gender gender = pol();
        present.addNewHuman(name,localDate,localDate1,gender);
    }
    public Gender pol(){
        String pol = scanner.next();
        if (pol.equals("м")){
            return Gender.MAN;
        } else if (pol.equals("ж"))
            return Gender.WOMAN;
        return null;
    }
    public void removeHuman(){
        System.out.println("Введите имя человека которого хотите удалить");
        String name = scanner.next();
        present.removeHuman(name);
    }
    public void printTree(){
        present.printTree();
    }
    public void save(){
        present.save();
    }
    public void load(){

        for (Human h : present.load()) {
            System.out.println(h.getName() + " " + h.getBirthDate() + " " +
                    h.getDeathDate()
                    + " " + h.getGender());
        }
    }
    public void sortName(){
        present.sortName();
    }
    public void sortBirthdate(){
        present.sortBirthday();
    }
    public void clearTree() {
        present.clearTree();
    }
}
