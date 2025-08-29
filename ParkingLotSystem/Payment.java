import java.time.LocalDateTime;

// Payment class
class Payment {
    private Long id;
    private ParkingTicket ticket;
    private Double amount;
    private PaymentType paymentType;
    private LocalDateTime timestamp;

    public Payment(Long id, ParkingTicket ticket, Double amount, PaymentType paymentType) {
        this.id = id;
        this.ticket = ticket;
        this.amount = amount;
        this.paymentType = paymentType;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public ParkingTicket getTicket() {
        return ticket;
    }

    public Double getAmount() {
        return amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    // Additional methods if needed
}
