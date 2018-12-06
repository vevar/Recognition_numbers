package com.alxminyaev.neuralnetwork.components

import com.alxminyaev.ConsolePrinter
import com.alxminyaev.neuralnetwork.util.ActivationFunction
import java.util.*
import kotlin.collections.ArrayList

class Neuron : ConsolePrinter {

    companion object {
        const val TITLE: String = "Neuron"
        const val WEIGHT: String = "Weight"

    }

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
        listOutputNeurons.add(connectedNeural)
        connectedNeural.dendriteList.add(Dendrite())
    }

    override fun print() {

        print("$WEIGHT: [")

        if (dendriteList.size == 0) {
            println("]")
        } else {
            if (dendriteList.size > 1) {
                for (index in 0 until dendriteList.size - 1) {
                    print("${dendriteList[index].weight}, ")
                }
            }
            println("${dendriteList[dendriteList.size - 1].weight}]")
        }
        println()
    }

}

