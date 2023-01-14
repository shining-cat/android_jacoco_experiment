package com.jacocoexp

class GuineaPigClass {

    fun function1(param:Int):String{
        return when(param){
            0-> "is zero"
            2-> "is two"
            5 -> "is five"
            10 -> "is ten"
            else -> "is something else"
        }
    }

    fun function2(param:String):String{
        return when{
            param.isBlank() -> "blank string"
            else -> "is not blank"
        }
    }

    fun function3(param:Int):Boolean{
        return when(param){
            0-> true
            2-> false
            5 -> true
            10 -> false
            else -> true
        }
    }

}