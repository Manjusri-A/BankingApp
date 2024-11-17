class CardSystemclass {
    private String cardNumber;
    private String pinNumber;
    private String expiryYear;

    public CardSystemclass(String cardNumber, String pinNumber, String expiryYear) {
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
        this.expiryYear = expiryYear;
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public String getExpiryYear() {
        return expiryYear;
    }
}

