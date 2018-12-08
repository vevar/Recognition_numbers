package com.alxminyaev.neuralnetwork.components

class BiasNeuron : Neuron() {

    override fun runCore() {
        sendSignalToNextNeurons(1.0)
    }
}