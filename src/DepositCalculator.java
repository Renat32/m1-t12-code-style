import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double Amount, double YearRate, int depositPeriod) {
        double pay = Amount * Math.pow((1 + YearRate / 12), 12 * depositPeriod);
        return helpsToCalculatePercent(pay, 2);
    }

    double calculateSimplePercent(double Amount, double YearRate, int depositPeriod) {
        return helpsToCalculatePercent(Amount + Amount * YearRate * depositPeriod, 2);
    }

    double helpsToCalculatePercent(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void launchProgram() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double out = 0;
        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }
    public static void main(String[] args) {
        new DepositCalculator().launchProgram();
    }
}
