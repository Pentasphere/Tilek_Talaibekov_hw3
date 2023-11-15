import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        System.out.println("Ваш текущий счет: " + bankAccount.getAmount());
        bankAccount.deposit(15000);
        System.out.println("Вы пополнили счет на " + bankAccount.getAmount());
        while (true) {
            try {
                bankAccount.withDraw(6000);
                System.out.println("Успешно. Снялось 6000. Оставшаяся сумма: " +
                        bankAccount.getAmount());
            } catch (LimitException e) {
                System.out.println("Попытка вывести больше оставшейся суммы. Оставшаяся сумма: " +
                        e.getRemainingAmount());
                try {
                    bankAccount.withDraw((int)e.getRemainingAmount());
                    System.out.println("Остаток снят со счета." +
                            "\nСумма на счете: " + bankAccount
                            .getAmount());
                } catch (LimitException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            }

        }
    }
}