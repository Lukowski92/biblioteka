package pl.projekt.biblioteka.infrastructure.Type;

import lombok.Getter;
import lombok.Setter;

public enum Cathegory {

    CRYMINAL("Kryminał"),
    ROMANS("Romans"),
    SCIENCE("Naukowa");


    @Getter
    @Setter
    String label;

    Cathegory(String label) {

        this.label = label;
    }


}
