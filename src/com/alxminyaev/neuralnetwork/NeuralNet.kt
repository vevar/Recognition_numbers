package com.alxminyaev.neuralnetwork

import com.alxminyaev.ConsolePrinter
import com.alxminyaev.neuralnetwork.components.HiddenLayer
import com.alxminyaev.neuralnetwork.components.InputLayer
import com.alxminyaev.neuralnetwork.components.OutputLayer
import com.alxminyaev.neuralnetwork.util.ConnectionBuilder


class NeuralNet(sizeIn: Int, sizesHidden: ArrayList<Int>, sizeOut: Int) : ConsolePrinter {

    companion object {
        private val INPUT_LAYER: String = "::: Input layer :::"
        private val OUTPUT_LAYER: String = "::: Output layer :::"

    }

    private val inputLayer: InputLayer = InputLayer(sizeIn)

    private val hiddenLayerList: ArrayList<HiddenLayer> = ArrayList()

    private val outputLayer: OutputLayer = OutputLayer(sizeOut)

    init {
        if (sizesHidden.size == 0) {
            sizesHidden.forEach { size -> hiddenLayerList.add(HiddenLayer(size)) }
            ConnectionBuilder.allToAll(inputLayer, hiddenLayerList[0])

            for (index in 0 until hiddenLayerList.size) {
                ConnectionBuilder.allToAll(hiddenLayerList[index], hiddenLayerList[index + 1])
            }

            ConnectionBuilder.allToAll(hiddenLayerList[hiddenLayerList.size - 1], outputLayer)

        } else {
            ConnectionBuilder.allToAll(inputLayer, outputLayer)
        }
    }

    override fun print() {
        println(INPUT_LAYER)
        inputLayer.print()

        for (index in hiddenLayerList.indices) {
            println("::: Hidden layer #$index :::")
            hiddenLayerList[index].print()
        }

        println(OUTPUT_LAYER)
        outputLayer.print()
    }
}
