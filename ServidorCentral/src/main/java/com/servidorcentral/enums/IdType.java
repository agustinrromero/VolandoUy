package com.servidorcentral.enums;

public enum IdType {

    CI("CI"),
    DNI("DNI"),
    PASSPORT("Pasaporte");

    private final String idType;

    IdType(String idType) {
        this.idType = idType;
    }

    public String getIdType() {
        return idType;
    }

    public static String[] getValues() {
        String[] values = new String[IdType.values().length];
        for (int i = 0; i < IdType.values().length; i++) {
            values[i] = IdType.values()[i].idType;
        }
        return values;
    }

    public static IdType fromString(String text) {
        for (IdType b : IdType.values()) {
            if (b.idType.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

}

