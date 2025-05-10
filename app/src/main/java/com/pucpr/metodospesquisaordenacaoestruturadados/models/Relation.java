package com.pucpr.metodospesquisaordenacaoestruturadados.models;

public class Relation {

    private String origin;
    private String relatedTo;
    private int weight;

    public Relation() {
    }

    public Relation(String origin, String relatedTo, int weight) {
        this.origin = origin;
        this.relatedTo = relatedTo;
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public Relation setOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public String getRelatedTo() {
        return relatedTo;
    }

    public Relation setRelatedTo(String relatedTo) {
        this.relatedTo = relatedTo;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public Relation setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "<Relation origin: %s, relatedTo: %s, wight: %d>",
                this.origin,
                this.relatedTo,
                this.weight);
    }

}
