public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1500.0);

        while (true) {
            try {
                System.out.println("Account balance: " + account.getAmount() + " sum.");
                double withdrawalAmount = 750;
                System.out.println("Try to withdraw " + withdrawalAmount + " sum.");
                account.withdraw(withdrawalAmount);
                System.out.println("Amount successfully withdrawn.");
                System.out.println("New account balance: " + account.getAmount() + " sum.\n");
            } catch (LimitException e) {
                System.out.println("Error: " + e.getMessage());
                double remainingAmount = e.getRemainingAmount();
                System.out.println("Remaining after withdraw: " + remainingAmount + " sum.");
                try {
                    account.withdraw(remainingAmount);
                    System.out.println("Remaining amount has been withdrawn.");
                } catch (LimitException e2) {
                    System.out.println("Error while withdrawing remaining amount: " + e2.getMessage());
                }
                break;
            }
        }
    }
}
