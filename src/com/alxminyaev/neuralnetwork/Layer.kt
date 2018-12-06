package com.alxminyaev.neuralnetwork

import java.util.ArrayList

abstract class Layer(var numberOfNeuronsInLayer: Int) {

    private var listOfNeural: ArrayList<Neuron> = ArrayList()

    init {
        for (i in 0 until this.numberOfNeuronsInLayer) {
            listOfNeural.add(Neuron())
        }
    }

    fun getListOfNeural(): ArrayList<Neuron> {
        return listOfNeural
    }

    abstract fun initLayer()

    abstract fun printLayer()
}