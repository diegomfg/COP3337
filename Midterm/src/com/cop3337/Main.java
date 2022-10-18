package com.cop3337;

public class Main {
    public static void main(String[] args) {
        Customer diego = new Customer(213652L, "Diego", "Matheus");
        Dealer d = new Dealer(diego);
        Dealer d1 = new Dealer(new Vehicle("Mazda", "2006", "56dfjkk-x"),diego);

        d.getCustomer();
        d1.getCustomer();
    }
}
