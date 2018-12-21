package com.alxminyaev.neuralnetwork

import com.alxminyaev.Data

class Teacher {

    fun train(neuralNet: NeuralNet, dataList: ArrayList<Data>): NeuralNet {
        dataList.forEach { data ->
            val resultPrediction = neuralNet.singlePrediction(data)
            val listDeltaOut = ArrayList<Double>()

            val listDeltas = mutableListOf<MutableList<Double>>()
            for (i in neuralNet.amountLayers..0)
                listDeltas.add(mutableListOf())

            //Output
            val oneDelta = listDeltas[listDeltas.size - 1]
            val listNeural = neuralNet.outputLayer.getListOfNeural()
            for (i in listNeural.indices) {
                val delta = data.getOutputY()[i] - listNeural[i].getResultRunCore()
                oneDelta.add(delta)
            }

            for (i in listDeltas.size - 2..1){

            }


                for (i in data.getOutputY().indices) {
                    val deltaOut = (data.getOutputY()[i] - resultPrediction.getOutputY()[i]) *
                            (1 - resultPrediction.getOutputY()[i]) * resultPrediction.getOutputY()[i]
                    listDeltaOut.add(deltaOut)
                }
        }

        return neuralNet
    }
}