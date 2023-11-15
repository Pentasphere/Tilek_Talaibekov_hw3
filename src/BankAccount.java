public class BankAccount{
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void deposit(double sum){
        setAmount(getAmount() + sum);
    }
    public void withDraw(int sum) throws LimitException{
        if (sum > getAmount()){
            throw new LimitException("Ошибка. " +
                    "Сумма снятия не может быть больше остатка на счете." +
                    " У Вас на счету: " + getAmount() +
                    " Вы задали: " + sum, amount);
        }else {
            setAmount(getAmount() - sum);
        }
    }
}
