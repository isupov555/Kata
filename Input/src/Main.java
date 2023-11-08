import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ScannerException {
        welcome();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.print("= "+calc(input)+"\nПрограмма завершила работу!");


    }

    public static String calc(String input) throws ScannerException{
        String [] data = input.split(" ");
        String [] arab = {"1","2","3","4","5","6","7","8","9","10"};
        String [] roman = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String [] allRoman = {"I","II","III","IV","V","VI","VII","VIII","IX","X",
                "XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
                "XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX",
                "XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL",
                "XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L",
                "LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX",
                "LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX",
                "LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX",
                "LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC",
                "XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"};
        int checkFirstRoman = 1;
        int checkSecondRoman = -1; // 0
        int checkFirstArab = 4;
        int checkSecondArab = 2; // 3
        if (data.length<3){
            throw new ScannerException("Cтрока не является математической операцией");

        }else if (data.length>3){
            throw new ScannerException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        for (int i=0;i<roman.length;i++){
            String x = data[0];
            if (x.equals(roman[i])){
                checkFirstRoman -= 1;
            }
            else if (x.equals(arab[i])){
                checkFirstArab -= 1;
            }
        }

        for (int i=0;i<roman.length;i++){
            String y = data[2];
            if (y.equals(roman[i])){
                checkSecondRoman += 1;
            }
            else if (y.equals(arab[i])){
                checkSecondArab += 1;
            }
        }
        if (checkFirstRoman == checkSecondRoman) {

            String x = data[0];
            String y = data[2];
            String operator = data[1];
            int xRom = romanNumerals.valueOf(x).getMeaning();
            int yRom = romanNumerals.valueOf(y).getMeaning();
            switch (operator){

                case ("+"):
                    int sum = xRom + yRom;
                    return allRoman[sum-1];

                case ("-"):
                    int minus = xRom - yRom;
                    if (minus<=0){
                        throw new ScannerException("Римские числа не могу быть отрицательным");
                    }
                    return allRoman[minus-1];
                case ("*"):
                    int multiplication = xRom * yRom;
                    return allRoman[multiplication-1];

                case ("/"):
                    int division = xRom / yRom;
                    return allRoman[division-1];

                default:
                    throw new ScannerException("Неверный оператор");
            }
        } else if (checkFirstArab == checkSecondArab){
            String operator = data[1];
            Integer x = Integer.valueOf(data[0]);
            Integer y = Integer.valueOf(data[2]);
            switch (operator){
                case ("+"):
                    return String.valueOf(x + y);

                case ("-"):
                    return String.valueOf(x - y);

                case ("*"):
                    return String.valueOf(x * y);

                case ("/"):
                    return String.valueOf(x / y);

                default:
                    throw new ScannerException("Неверный оператор");
            }
        } else {
            throw new ScannerException("Неверные данные.Вероятно используются одновременно разные системы счисления");
        }
    }
    public static void welcome(){
        System.out.println("Добро пожаловать в калькулятор римский и арабских чисел!");
        System.out.println("Введите выражение: ");
    }
}
