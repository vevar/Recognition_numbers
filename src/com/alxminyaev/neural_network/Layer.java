package com.alxminyaev.neural_network;

import java.util.ArrayList;

abstract class Layer {
    private int numberOfNeuronsInLayer;
    private ArrayList<Neuron> listOfNeural;

    public int getNumberOfNeuronsInLayer() {
        return numberOfNeuronsInLayer;
    }

    public void setNumberOfNeuronsInLayer(int numberOfNeuronsInLayer) {
        this.numberOfNeuronsInLayer = numberOfNeuronsInLayer;
    }

    public ArrayList<Neuron> getListOfNeural() {
        return listOfNeural;
    }

    public void setListOfNeural(ArrayList<Neuron> listOfNeural) {
        this.listOfNeural = listOfNeural;
    }

    abstract void initLayer();

    abstract void printLayer();
}
