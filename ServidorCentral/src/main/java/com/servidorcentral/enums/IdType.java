package com.servidorcentral.enums;

public enum IdType {

    CI("CI"),
    DNI("DNI"),
    PASSPORT("Pasaporte");

    private final String name;

    IdType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String[] getValues() {
        String[] values = new String[IdType.values().length];
        for (int i = 0; i < IdType.values().length; i++) {
            values[i] = IdType.values()[i].name;
        }
        return values;
    }

    public static IdType fromString(String text) {
        for (IdType b : IdType.values()) {
            if (b.name.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

}

