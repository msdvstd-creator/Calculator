static String input;

public static String calc(String input) throws ScannerException {
    String[] parts = input.split(" ");
    for (String part : parts) {
        try {
            Integer.parseInt(part);
        } catch (NumberFormatException e) {
            if (("+".equals(part)) || ("-".equals(part)) || ("*".equals(part)) || ("/".equals(part))) {
                continue;
            }
            throw new ScannerException("Введите целое число");
        }
    }
    if (parts.length == 1) {
        throw new ScannerException("throws Exception //т.к. строка не является математической операцией");
    }
    if (parts.length == 4) {
        throw new ScannerException("throws Exception");
    }
    if (parts.length == 5) {
        throw new ScannerException("throws Exception: //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
    }
    int number = Integer.parseInt(parts[0]);
    int number2 = Integer.parseInt(parts[2]);
    if (number < 1 || number > 10 || number2 < 1 || number2 > 10) {
        throw new ScannerException("Числа должны быть от 1 до 10 включительно");
    }
    char operator = parts[1].charAt(0);
    int result;
    switch (operator) {
        case '+':
            result = number + number2;
            break;
        case '-':
            result = number - number2;
            break;
        case '*':
            result = number * number2;
            break;
        case '/':
            if (number % number2 == 0) {
                result = number / number2;
                break;
            }
            if (number % number2 != 0){
                result = number % number2;
            break;
    }
        default:
            throw new ScannerException("Неверная операция");
    }
    return String.valueOf(result);
}


public static void main(String[] args) {
    System.out.println("Введите выражение, например: 2 + 3");
    Scanner scanner = new Scanner(System.in);
    input = scanner.nextLine();
    try {
        System.out.println("результат - " + calc(input));

    } catch (ScannerException e) {
        System.out.println(e.getMessage());

    }
}
