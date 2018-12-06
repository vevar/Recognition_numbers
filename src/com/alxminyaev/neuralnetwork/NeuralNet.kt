package com.alxminyaev.neuralnetwork

import com.alxminyaev.neuralnetwork.util.ConnectionBuilder


class NeuralNet(sizeIn: Int, sizesHidden: ArrayList<Int>, sizeOut: Int) {

    private val inputLayer: InputLayer = InputLayer(sizeIn)

    private val hiddenLayerArrayList: ArrayList<HiddenLayer> = ArrayList()

    private val outputLayer: OutputLayer = OutputLayer(sizeOut)

    init {
        sizesHidden.forEach { size -> hiddenLayerArrayList.add(HiddenLayer(size)) }

        ConnectionBuilder.allToAll(inputLayer, hiddenLayerArrayList[0])

    }
}
