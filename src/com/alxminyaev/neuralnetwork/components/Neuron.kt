package com.alxminyaev.neuralnetwork.components

import com.alxminyaev.ConsolePrinter
import com.alxminyaev.neuralnetwork.util.ActivationFunction
import java.util.*
import kotlin.collections.ArrayList

open class Neuron : ConsolePrinter {

    companion object {
        const val TITLE: String = "Neuron"
        const val WEIGHT: String = "Weight"

    }

    class Dendrite {
        var inputSignal: Double = 0.0
        var weight: Double = Random().nextDouble()
    }

    private val dendriteList: ArrayList<Dendrite> = ArrayList()
    private val outputDendriteList: ArrayList<Dendrite> = ArrayList()

    private var resultRunCore: Double = 0.0

    fun getDendriteList(): ArrayList<Dendrite> {
        return dendriteList
    }

    open fun runCore() {
        var totalInSignal = 0.0

        for (dendrite in dendriteList) {
            totalInSignal += dendrite.inputSignal * dendrite.weight
        }

        resultRunCore = ActivationFunction.sigmoid(totalInSignal)

        sendSignalToNextNeurons(resultRunCore)
    }

    protected fun sendSignalToNextNeurons(signal: Double) {
        outputDendriteList.forEach { dendrite: Dendrite ->
            dendrite.inputSignal = signal
        }
    }

    fun createConnection(connectedNeural: Neuron) {
        if (connectedNeural !is BiasNeuron) {
            val dendrite = Dendrite()
            outputDendriteList.add(dendrite)
            connectedNeural.dendriteList.add(dendrite)
        }
    }

    fun getResultRunCore(): Double {
        return resultRunCore
    }

    override fun print() {

        print("$WEIGHT: [")
        if (dendriteList.size > 0) {
            for (i in 0 until dendriteList.size - 1) {
                print("${dendriteList[i].weight}, ")
            }
            print(dendriteList[dendriteList.size - 1].weight)
        }
        println("]")
    }
}

