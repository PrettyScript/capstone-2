package com.capstone2;

public class Player {
    private String name;
    private final Chip chip;

    public Player(Chip chip) {
        this.chip = chip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chip getChip() {
        return chip;
    }
}
