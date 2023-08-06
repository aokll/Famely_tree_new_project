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
    boolean flag = true;

    public ConsoleFT() {
        present = new Present(this);
        this.scanner = new Scanner(System.in);
        menuClass = new MenuClass(this);
    }

    @Override
    public void start() throws ParseException {
        System.out.println("Привет");

        while (flag){
            System.out.println(menuClass.menu());
            operation();
        }
    }
    public void operation() throws ParseException {

        menuClass.execute(tryingOutACommand());

    }
    public Integer tryingOutACommand(){
        int commandTestValue = 0;
        label:
        while (true) {
            String checkValueForOtherCharacters = null;
            checkValueForOtherCharacters = scanner.next();
            Pattern c = Pattern.compile(".*[A-Za-zА-Яа-я<>,./|}{()!&?~Ёё`].*");
            boolean b = checkValueForOtherCharacters.matches(c.pattern());
            if (b) {
                System.out.println("Должны быть только числа, попробуйте еще раз");
                continue label;
            }
            commandTestValue = Integer.parseInt(checkValueForOtherCharacters);
            if (commandTestValue <= 0 || commandTestValue > menuClass.getListOfCommands().size()){
                System.out.println("Таких вариантов нет, попробуйте еще раз");
                continue label;
            }
            break;
        }
            return commandTestValue;
    }
    public void finish(){
        scanner.close();
        flag = false;
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
        int yearOfBirth = scanner.nextInt();
        System.out.println("месяц");
        int birthMonth = scanner.nextInt();
        System.out.println("день");
        int dayOfBirth = scanner.nextInt();
        LocalDate localDate = LocalDate.of(yearOfBirth, birthMonth, dayOfBirth);
        System.out.println("укажите дату смерти");
        System.out.println("год");
        int yearOfDeath = scanner.nextInt();
        System.out.println("месяц");
        int deathMonth = scanner.nextInt();
        System.out.println("день");
        int dayOfDeath = scanner.nextInt();
        LocalDate localDate1 = LocalDate.of(yearOfDeath, deathMonth, dayOfDeath);
        System.out.println("укажите пол");
        Gender gender = gender();
        present.addNewHuman(name,localDate,localDate1,gender);
    }
    public Gender gender(){
        String gender = scanner.next();
        if (gender.equals("м")){
            return Gender.MAN;
        } else if (gender.equals("ж"))
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
