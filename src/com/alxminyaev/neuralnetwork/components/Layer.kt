package com.alxminyaev.neuralnetwork.components

import com.alxminyaev.ConsolePrinter
import java.util.ArrayList

abstract class Layer(var numberOfNeuronsInLayer: Int) : ConsolePrinter {

    private var listOfNeural: ArrayList<Neuron> = ArrayList()

    init {
        for (i in 0 until this.numberOfNeuronsInLayer) {
            listOfNeural.add(Neuron())
        }
    }

    fun getListOfNeural(): ArrayList<Neuron> {
        return listOfNeural
    }

    override fun print() {
        val listOfNeural1 = getListOfNeural()
        for (i in listOfNeural1.indices) {
            println("::: ${Neuron.TITLE}#$i :::")
            listOfNeural1[i].print()
        }
        println()
    }
}
