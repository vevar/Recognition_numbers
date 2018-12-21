package com.alxminyaev

class Data(private val inputDataX: ArrayList<Double>, private var outputDataY: ArrayList<Double>) : ConsolePrinter {

    companion object {
        const val TITLE: String = "Data"
        private const val INPUT_DATA_X = "X"
        private const val OUT_DATA_Y = "Y"
    }

    constructor(inputDataX: ArrayList<Double>) : this(inputDataX, ArrayList<Double>())

    fun getInputX(): ArrayList<Double> {
        return inputDataX
    }

    fun setOutputY(resultList: ArrayList<Double>) {
        outputDataY = resultList
    }

    override fun print() {
        println(TITLE)

        print("$INPUT_DATA_X: [")
        if (inputDataX.size > 1) {
            for (i in 0 until inputDataX.size - 1) {
                print("${inputDataX[i]}, ")
            }
            print(inputDataX[inputDataX.size - 1])
        }
        println("]")

        print("$OUT_DATA_Y: [")
        if (outputDataY.size > 0) {
            for (i in 0 until outputDataY.size - 1) {
                print("${outputDataY[i]}, ")
            }
            print(outputDataY[outputDataY.size - 1])
        }
        println("]")
        println()
    }

    fun getOutputY(): ArrayList<Double> {
        return outputDataY
    }
}