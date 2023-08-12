package MVP.View.Console;

import FamilyTreePackage.Connect;
import FamilyTreePackage.Gender;
import FamilyTreePackage.Human;
import FamilyTreePackage.MakingConnections;
import MVP.Presenter.Present;
import MVP.View.MenuClass;

import java.io.IOException;
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
        present = new Present();
        this.scanner = new Scanner(System.in);
        menuClass = new MenuClass(this);
    }

    @Override
    public void start() throws ParseException, IOException {
        System.out.println("Привет");

        while (flag){
            System.out.println(menuClass.menu());
            operation();
        }
    }
    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
    public void finish(){
        scanner.close();
        flag = false;
    }
    public void printBD(){
        System.out.println("----------база данных людей---------");
        present.printBD();
        System.out.println("------------------------------------");

    }
    public void printTree(){
        System.out.println("--------установленные связи---------");
        present.printTree();
        System.out.println("------------------------------------");

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
        System.out.println("Укажите личный идентификатор");
        int id = scanner.nextInt();
        present.addNewHuman(name,localDate,localDate1,gender,id);
    }
    public void connectGenetic(){
        boolean flag1 = true;
        boolean flag2 = true;
        int id1 = 0;
        int id2 = 0;
        System.out.println("Ведите id 1го человека");
        label:
        while (flag1){
        id1 = scanner.nextInt();

            if(!verification(id1)){
                System.out.println(" Такого id не существует, ведите id 1го человека еще раз");
                continue label;
            }
            flag1 = false;
        }
        System.out.println("Ведите id 2го человека");
        label:
        while (flag2){
            id2 = scanner.nextInt();

            if(!verification(id2)){
                System.out.println(" Такого id не существует, ведите id 2го человека еще раз");
                continue label;
            }
            flag2 = false;
        }
        System.out.println("Кем является 1ый человек 2му");
        System.out.println("Введите следующие обозначения:" +
                " м - муж." +
                " ж - жена." +
                " с - сын." +
                " д - дочь." +
                " б - бабушка." +
                " дд - дедушка." +
                " вк - внук." +
                " вка - внучка." +
                " прад - прадедушка." +
                " праб - прабабушка.");
        Connect c = connect();
        present.addConnection(id1,id2,c);

    }
    public Boolean verification(int id){
        return present.verification(id);
    }
    public void removeHuman(){
        System.out.println("Введите имя человека которого хотите удалить");
        String name = scanner.next();
        present.removeHuman(name);
    }
    public void save(){
        present.save();
    }
    public void load(){
        System.out.println("----данные загруженные из файла базы данных-----");
        for (Human h : present.load()) {
            System.out.println(h.getName() + " " + h.getBirthDate() + " " +
                    h.getDeathDate()
                    + " " + h.getGender()+ " " + h.getID());
        }
        System.out.println("-------------------------------------------------");
    }
    public void saveFT() throws IOException {
        present.saveFT();
    }
    public void loadFT(){
        System.out.println("----данные загруженные из файла связей-----");
        for (MakingConnections h : present.loadFT()) {
            System.out.println(h.getId1() + " " + h.getConnections() + " -> " + h.getId2());
        }
        System.out.println("--------------------------------------------");
    }
    public void sortName(){
        System.out.println("------------------------------------");
        for (Human h : present.sortName()) {
            System.out.println(h.getName() + " " + h.getBirthDate() + " " + h.getDeathDate() + " " +
                    h.getGender() + " " + h.getID());
        }
        System.out.println("------------------------------------");
    }
    public void sortBirthdate(){
        System.out.println("------------------------------------");
        for (Human h : present.sortBirthday()) {
            System.out.println(h.getBirthDate() + " " + h.getName() + " " + h.getDeathDate() + " " +
                    h.getGender() + " " + h.getID());
        }
        System.out.println("------------------------------------");
    }
    public void sortID(){
        System.out.println("------------------------------------");
        for (Human h : present.sortID()) {
            System.out.println(h.getID() + " " + h.getBirthDate() + " " + h.getName() + " " + h.getDeathDate() + " " +
                    h.getGender());
        }
        System.out.println("------------------------------------");
    }
    public void clearTree() {
        present.clearTree();
    }
    public void clearBD() {
        present.clearBD();
    }
    public void operation() throws ParseException, IOException {

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
    public Gender gender(){
        String gender = scanner.next();
        if (gender.equals("м")){
            return Gender.MAN;
        } else if (gender.equals("ж"))
            return Gender.WOMAN;
        return null;
    }
    public Connect connect(){
        String connect = scanner.next();
        if (connect.equals("м")) {
            return Connect.HUSBAND;
        } else if (connect.equals("ж")) {
            return Connect.WIFE;
        } else if (connect.equals("c")) {
            return Connect.SON;
        } else if (connect.equals("д")) {
            return Connect.DAUGHTER;
        } else if (connect.equals("б")) {
            return Connect.GRANDMOTHER;
        } else if (connect.equals("дд")) {
            return Connect.GRANDFATHER;
        } else if (connect.equals("вк")) {
            return Connect.GRANDSON;
        } else if (connect.equals("вка")) {
            return Connect.GRANDDAUGHTER;
        } else if (connect.equals("прад")) {
            return Connect.GREAT_GRANDFATHER;
        } else if (connect.equals("праб")) {
            return Connect.GREAT_GRANDMOTHER;
        }
        return null;
    }
}
