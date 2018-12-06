package com.alxminyaev.neuralnetwork.components

import com.alxminyaev.ConsolePrinter

class HiddenLayer(size: Int) : Layer(size), ConsolePrinter {

    companion object {
        const val TITLE: String = "Hidden layer"
    }

}
