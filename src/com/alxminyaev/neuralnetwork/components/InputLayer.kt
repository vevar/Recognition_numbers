package com.alxminyaev.neuralnetwork.components

import com.alxminyaev.ConsolePrinter

class InputLayer(size: Int) : Layer(size), ConsolePrinter {

    companion object {
        const val TITLE: String = "Input layer"
    }

    init {
        getListOfNeural().forEach { neuron: Neuron ->
            neuron.getDendriteList().add(Neuron.Dendrite())
        }
        getListOfNeural().add(BiasNeuron())
    }

    fun receiveSignals(inputXs: ArrayList<Double>) {
        val listOfInputNeurones = getListOfNeural()
        if (listOfInputNeurones.size >= inputXs.size) {
            for (i in 0 until inputXs.size - 1) {
                listOfInputNeurones[i].getDendriteList()[0].inputSignal = inputXs[i]
            }
        } else {
            TODO()
        }
    }
}
