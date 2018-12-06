package com.alxminyaev.neuralnetwork.components

import com.alxminyaev.ConsolePrinter

class InputLayer(size: Int) : Layer(size), ConsolePrinter {

    companion object {
        const val TITLE: String = "Input layer"
    }

    init {
        getListOfNeural().forEach { neural -> {
        } }
    }
}
