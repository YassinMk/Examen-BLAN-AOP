package com.example.demo;

import java.util.Date;

// Transaction class
class Transaction {
    private String id;
    private Date date;
    private double montant;
    private TransactionType type;

    private Transaction(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.montant = builder.montant;
        this.type = builder.type;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public TransactionType getType() {
        return type;
    }

    public enum TransactionType {
        VENTE, ACHAT
    }

    public static class Builder {
        private String id;
        private Date date;
        private double montant;
        private TransactionType type;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder setMontant(double montant) {
            this.montant = montant;
            return this;
        }

        public Builder setType(TransactionType type) {
            this.type = type;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", montant=" + montant +
                ", type=" + type +
                '}';
    }
}
