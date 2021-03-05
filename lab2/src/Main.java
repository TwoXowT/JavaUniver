//17ви1 Хамзин Х. Хусаинов И.
//ВАРИАНТ 8
//Проверить, надежно ли составлен пароль. Пароль считается надежным,
//если он состоит из 8 или более символов. Где символом может быть
//английская буква, цифра и знак подчеркивания. Пароль должен
//содержать хотя бы одну заглавную букву, одну маленькую букву и
//одну цифру.
// пример правильных выражений: C00l_Pass, SupperPas1.
// пример неправильных выражений: Cool_pass, C00l.

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // Класс для нахождения совпадений по шаблону
        Matcher matcher;
        // входная строка пользователя
        String inputString;
        // Для проверки и вывода сообщений об отсутствии символов
        boolean haveNumbers,haveLowerLetter,haveUpperLetter,haveescape,matches,haveCountSymbol;
        // Регулярное выражение на весь пароль
        Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?!.*[!@#$%^&*()+=-])\\_*(?=\\S+$).{8,}");
        // нахождение хотябы 1 цифры, нижнего и верхнего регистра
        Pattern numbers = Pattern.compile("(?=.*[0-9]).{1,}");
        Pattern lowerLetters = Pattern.compile("(?=.*[a-z]).{1,}");
        Pattern UpperLetters = Pattern.compile("(?=.*[A-Z]).{1,}");
        Pattern escape = Pattern.compile("(?!.*[!@#$%^&*()+=-])\\_*(?=\\S+$).{0,}");

        do{
            System.out.println("Введите пароль:");
            inputString = input.nextLine();


            if(inputString.length() < 8){
                System.out.println("В пароле должно быть не менее 8 символов");
            }

            //Проверка есть ли цифры в строке
            matcher = numbers.matcher(inputString);
            haveNumbers = matcher.matches();
            if(!haveNumbers){
                System.out.println("В пароле должна быть хотябы одна цифра");
            }

            //Проверка есть ли буквы нижнего регистра в строке
            matcher = lowerLetters.matcher(inputString);
            haveLowerLetter = matcher.matches();
            if(!haveLowerLetter){
                System.out.println("В пароле должна быть хотябы одна буква строчная буква");
            }

            //Проверка есть ли верхнего регистра в строке
            matcher = UpperLetters.matcher(inputString);
            haveUpperLetter = matcher.matches();
            if(!haveUpperLetter){
                System.out.println("В пароле должна быть хотябы одна буква прописная буква");
            }

            //Проверка есть ли пробелы и лишние символы
            matcher = escape.matcher(inputString);
            haveescape = matcher.matches();
            if(!haveescape){
                System.out.println("В пароле запрещено использовать пробелы и спецсимволы(кроме _ ).");
            }
            //Проверка на удовлетворения доп. требованиям(можно писать _, нельзя чтобы были пробелы)
            matcher = pattern.matcher(inputString);
            matches = matcher.matches();
            if(matches) {
                System.out.println("Пароль успешно записан");
                break;
            }
            System.out.println("Попробуйте еще раз");


        }while(!matches);



    }
}

//(?=.*[0-9]) цифра должна появляться по крайней мере один раз
//(?=.*[a-z]) строчная буква должна появляться как минимум раз
//(?=.*[a-z]) письмо с верхним регистром должно происходить по крайней мере один раз
//(?=.*[@#$%^&+=]) специальный символ должен появляться по крайней мере один раз
//(?=\\S+$) пробелы не разрешены во всей строке
//.{8,} не менее 8 символов

//        Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])\\_*(?=\\S+$).{8,}");
//        Scanner input = new Scanner(System.in);
//        Matcher matcher;
//        boolean matches;
//        String inputString;
//        do{
//            System.out.println("Введите пароль:");
//            inputString = input.nextLine();
//            matcher = pattern.matcher(inputString);
//            matches = matcher.matches();
//            if(matches){
//                System.out.println("Пароль успешно записан");
//                break;
//            }
//            System.out.println("Пароль не подходит. Попробуйте еще раз");
//        }while(!matches);
//