package pl.projekt.biblioteka.infrastructure.type;

import lombok.Getter;
import lombok.Setter;

public enum Cathegory {

    CRYMINAL("Kryminały"),
    ROMANS("Romanse"),
    SCIENCE("Naukowe");

    @Getter
    @Setter
    String label;

    Cathegory(String label) {

        this.label = label;
    }
}
