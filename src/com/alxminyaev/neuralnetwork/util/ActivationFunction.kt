package com.alxminyaev.neuralnetwork.util


import kotlin.math.exp

class ActivationFunction {

    companion object {
        fun sigmoid(impulse: Double): Double {
            return 1 / (1 + exp(impulse))
        }
    }


}
