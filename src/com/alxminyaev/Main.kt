package com.alxminyaev

import com.alxminyaev.neuralnetwork.NeuralNet
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

import java.util.ArrayList

class Main : Application() {

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("sample.fxml"))
        primaryStage.title = "Hello World"
        primaryStage.scene = Scene(root, 300.0, 275.0)
        primaryStage.show()
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            //        launch(args);
            val sizeHidden = ArrayList<Int>()
            sizeHidden.add(15)


            val neuralNet = NeuralNet(784, sizeHidden, 10)
            println(NeuralNet.TITLE)
            neuralNet.print()

            val listX = ArrayList<Double>()
            for (i in 0..3) {
                listX.add(i * 3.0)
            }

            var dataList: ArrayList<Data> = ArrayList()
            dataList.add(Data(listX))

            dataList = neuralNet.prediction(dataList)

            dataList.forEach { data: Data ->
                data.print()
            }
        }
    }
}
