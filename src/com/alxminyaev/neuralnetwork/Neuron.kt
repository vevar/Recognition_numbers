package com.alxminyaev.neuralnetwork

import java.util.*
import kotlin.collections.ArrayList

class Neuron {

    private class Dendrite {
        var inputSignal: Double = 0.0
        var weight: Double = Random().nextDouble()
    }

    private val dendriteList: ArrayList<Dendrite> = ArrayList()

    private val listOutputNeurons: ArrayList<Neuron> = ArrayList()

    fun runCore() {
        var totalInSignal = 0.0

        for (dendrite in dendriteList) {
            totalInSignal += dendrite.inputSignal * dendrite.weight
        }

        val signal = ActivationFunction.sigmoid(totalInSignal)

        sendSignal(signal)
    }

    private fun sendSignal(signal: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun createConnection(connectedNeural: Neuron) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
