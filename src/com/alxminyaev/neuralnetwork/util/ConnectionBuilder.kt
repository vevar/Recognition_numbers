package com.alxminyaev.neuralnetwork.util

import com.alxminyaev.neuralnetwork.Layer
import com.alxminyaev.neuralnetwork.Neuron

class ConnectionBuilder {

    companion object {
        fun allToAll(layer: Layer, targetLayer: Layer) {
            layer.getListOfNeural().forEach { neuron: Neuron ->
                targetLayer.getListOfNeural().forEach { connectedNeural ->
                    neuron.createConnection(connectedNeural)

                }
            }
        }
    }
}