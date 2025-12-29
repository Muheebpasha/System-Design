import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Transaction {
	private int custId;
	private double transactionAmount;
	private LocalDate transactionTime;

	public Transaction(int custId, double transactionAmount, LocalDate transactionTime) {
		this.custId = custId;
		this.transactionAmount = transactionAmount;
		this.transactionTime = transactionTime;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public LocalDate getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalDate transactionTime) {
		this.transactionTime = transactionTime;
	}

	@Override
	public String toString() {
		return "Transaction [custId=" + custId + ", transactionAmount=" + transactionAmount + ", transactionTime="
				+ transactionTime + "]";
	}
}

class TopSpenders {
	List<Transaction> transactions = List.of(
		new Transaction(1, 250.0, LocalDate.now().minusDays(5)),
            new Transaction(2, 500.0, LocalDate.now().minusDays(10)),
            new Transaction(1, 300.0, LocalDate.now().minusDays(20)),
            new Transaction(3, 800.0, LocalDate.now().minusDays(2)),
            new Transaction(4, 200.0, LocalDate.now().minusDays(35)),
            new Transaction(2, 200.0, LocalDate.now().minusDays(3)),
            new Transaction(5, 100.0, LocalDate.now().minusDays(1)),
            new Transaction(1, 200.0, LocalDate.now().minusDays(1))
	);
	 // 🔹 1️⃣ Group by Customer and Sum Total
    public Map<Integer, Double> groupByCustomer() {
        return transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCustId,
                        Collectors.summingDouble(Transaction::getTransactionAmount)
                ));
    }

    // 🔹 2️⃣ Sort by highest spending
    public List<Map.Entry<Integer, Double>> sortBySpending(Map<Integer, Double> grouped) {
        return grouped.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                .toList();
    }

    // 🔹 3️⃣ Limit top 3
    public void getTop3Spenders() {
        Map<Integer, Double> grouped = groupByCustomer();
        List<Map.Entry<Integer, Double>> sorted = sortBySpending(grouped);
        List<Map.Entry<Integer, Double>> topSpenders = sorted.stream().limit(3).toList();

        System.out.println("Top 3 Spenders:");
        topSpenders.forEach(System.out::println);
    }
    /*
	 public void getTop3Spenders() {
        List<Map.Entry<Integer, Double>> topSpenders = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCustId,
                        Collectors.summingDouble(Transaction::getTransactionAmount)
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                .limit(3)
                .toList();

        System.out.println("Top 3 Spenders:");
        topSpenders.forEach(System.out::println);
    }
    */
    public static void main(String[] args) {
        new TopSpenders().getTop3Spenders();
    }
	
}
