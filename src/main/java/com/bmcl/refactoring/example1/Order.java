package com.bmcl.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> lines;
    public Order() {
        lines = new ArrayList<>();
    }
    public void add(Product product, int quantity) {
        lines.add(new OrderLine(product, quantity));
    }
    public boolean isElegibleForFreeDelivery() {
        return getTotal()>100;
    }
    private double getTotal() {
        double total = 0;
        for (OrderLine line : lines)
            total += line.getProduct().getPrice() * line.getQuantity();
        return total;
    }
    public String printOrder() {
        StringBuffer printBuffer = new StringBuffer();
        for (OrderLine line : lines)
            printBuffer.append(line.getProduct().getName() + "(x" + line.getQuantity() + "): " + (line.getProduct().getPrice() * line.getQuantity()) + "\n");
        printBuffer.append("Total: " + getTotal());
        return printBuffer.toString();
    }
}