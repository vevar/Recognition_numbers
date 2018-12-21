package com.alxminyaev.neuralnetwork

import com.alxminyaev.ConsolePrinter
import com.alxminyaev.Data
import com.alxminyaev.neuralnetwork.components.HiddenLayer
import com.alxminyaev.neuralnetwork.components.InputLayer
import com.alxminyaev.neuralnetwork.components.Neuron
import com.alxminyaev.neuralnetwork.components.OutputLayer
import com.alxminyaev.neuralnetwork.util.ConnectionBuilder


class NeuralNet(sizeIn: Int, sizesHidden: ArrayList<Int>, sizeOut: Int) : ConsolePrinter {

    companion object {
        const val TITLE: String = "Neural Net"
    }

    val inputLayer: InputLayer = InputLayer(sizeIn)

    val hiddenLayerList: ArrayList<HiddenLayer> = ArrayList()

    val outputLayer: OutputLayer = OutputLayer(sizeOut)

    val amountLayers = (if (sizeIn != 0) 1 else 0) + (if (sizeOut != 0) 1 else 0) + sizesHidden.size

    init {
        if (sizesHidden.size != 0) {
            sizesHidden.forEach { size -> hiddenLayerList.add(HiddenLayer(size)) }
            ConnectionBuilder.allToAll(inputLayer, hiddenLayerList[0])

            for (index in 0 until hiddenLayerList.size - 1) {
                ConnectionBuilder.allToAll(hiddenLayerList[index], hiddenLayerList[index + 1])
            }

            ConnectionBuilder.allToAll(hiddenLayerList[hiddenLayerList.size - 1], outputLayer)

        } else {
            ConnectionBuilder.allToAll(inputLayer, outputLayer)
        }
    }

    override fun print() {
        println("::: ${InputLayer.TITLE} :::")
        inputLayer.print()

        for (index in hiddenLayerList.indices) {
            println(">>> ${HiddenLayer.TITLE} #$index <<<")
            hiddenLayerList[index].print()
        }

        println("::: ${OutputLayer.TITLE} :::")
        outputLayer.print()

        println()
    }

    fun prediction(dataList: ArrayList<Data>): ArrayList<Data> {
        val dataResult: ArrayList<Data> = ArrayList(dataList)
        dataResult.forEach { data: Data ->
            val inputXs = data.getInputX()
            inputLayer.receiveSignals(inputXs)
            inputLayer.getListOfNeural().forEach { neuron: Neuron ->
                neuron.runCore()
            }

            hiddenLayerList.forEach { hiddenLayer: HiddenLayer ->
                hiddenLayer.getListOfNeural().forEach { neuron: Neuron ->
                    neuron.runCore()
                }
            }
            val resultList: ArrayList<Double> = ArrayList()
            outputLayer.getListOfNeural().forEach { neuron: Neuron ->
                neuron.runCore()
                resultList.add(neuron.getResultRunCore())
            }
            data.setOutputY(resultList)
        }

        return dataResult
    }

    fun singlePrediction(data: Data): Data {
        val dataResult = Data(data.getInputX(), data.getOutputY())

        val inputXs = dataResult.getInputX()
        inputLayer.receiveSignals(inputXs)
        inputLayer.getListOfNeural().forEach { neuron: Neuron ->
            neuron.runCore()
        }

        hiddenLayerList.forEach { hiddenLayer: HiddenLayer ->
            hiddenLayer.getListOfNeural().forEach { neuron: Neuron ->
                neuron.runCore()
            }
        }
        val resultList: ArrayList<Double> = ArrayList()
        outputLayer.getListOfNeural().forEach { neuron: Neuron ->
            neuron.runCore()
            resultList.add(neuron.getResultRunCore())
        }
        dataResult.setOutputY(resultList)

        return dataResult
    }
}
