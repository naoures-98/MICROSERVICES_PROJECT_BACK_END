package com.esprit.scoringservice.web.model;

public enum FamilySituation {
    MARIE("Marié(e)"),
    CELIBATAIRE("Célibataire"),
    DIVORCE("Divorcé(e)"),
    VEUF("Veuf(ve)");

    private final String displayName;

    FamilySituation(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
