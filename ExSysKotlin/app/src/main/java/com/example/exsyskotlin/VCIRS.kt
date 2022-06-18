package com.example.exsyskotlin

import android.util.Log
import java.math.RoundingMode
import java.text.DecimalFormat

class VCIRS {
    private val cfQ1 = 0.7
    private val cfQ2 = 0.7
    private val cfQ3 = 0.7
    private val cfQ4 = 0.7
    private val cfQ5 = 0.8
    private val cfQ6 = 0.3
    private val cfQ7 = 0.1
    private val cfQ8 = 0.8
    private val cfQ9 = 0.5
    private val cfQ10P = 0.9
    private val cfQ10= 0.3
    private val cfQ11= 0.3

    private val cfQISPA = arrayOf(cfQ1, cfQ2, cfQ3, cfQ4, cfQ5, cfQ6, cfQ7, cfQ8, cfQ9, cfQ10, cfQ11)
    private val cfQPneumonia = arrayOf(cfQ1, cfQ2, cfQ3, cfQ4, cfQ5, cfQ6, cfQ7, cfQ8, cfQ9, cfQ10P, cfQ10, cfQ11)

    private val credit = 1
    private val numOfNode = 1


    fun getVariableOrder(getDoubleQ: Array<Double>):DoubleArray{
    val variableOrder = DoubleArray(getDoubleQ.size)
        for (i in variableOrder.indices){
            variableOrder[i] = i.toDouble()+1
        }
        return variableOrder
    }
 
    fun getTotalVariable(getDoubleQ: Array<Double>):Double{
        return getDoubleQ.size.toDouble()
    }


    fun calculateCFValueHE(getDoubleQ: Array<Double>, state: Int):DoubleArray{
        val cfValueHE = DoubleArray(getDoubleQ.size)
        if (state == 0) {
            for(i in cfValueHE.indices) {
                                cfValueHE[i] = cfQISPA[i] * getDoubleQ[i]
                                Log.d("tes4", cfValueHE[i].toString())
                            }
                        }
        else if (state==1){
            for(i in cfValueHE.indices) {
                cfValueHE[i] = cfQPneumonia[i] * getDoubleQ[i]
                Log.d("tes4", cfValueHE[i].toString())
            }
        }
        return cfValueHE
    }

    fun calculateVUR(getDoubleQ: Array<Double>, variableOrder: DoubleArray, totalVariable:Double):DoubleArray{
        val valueVUR = DoubleArray(getDoubleQ.size)
        for(i in valueVUR.indices) {
            valueVUR[i] = credit*(numOfNode*(variableOrder[i]/totalVariable))
            Log.d("tes5",valueVUR[i].toString())
        }
        return valueVUR
    }

    fun calculateNUR(getDoubleQ: DoubleArray, totalVariable: Double):Double{
        var valueNUR = 0.0
        for (i in getDoubleQ.indices){
            valueNUR += getDoubleQ[i]
        }
        valueNUR /= totalVariable
        Log.d("tes6",valueNUR.toString())
        return valueNUR
    }

    fun calculateRUR(valueNUR : Double):Double{
        return valueNUR/ numOfNode
    }

    fun calculateCFRValue(getDoubleQ: DoubleArray, valueRUR: Double):DoubleArray{
        val cfrValue = DoubleArray(getDoubleQ.size)
        Log.d("tes",cfrValue.indices.toString())
        for(i in cfrValue.indices) {
            cfrValue[i] = getDoubleQ[i]*valueRUR
            Log.d("tes7",getDoubleQ[i].toString())
            Log.d("tes7",cfrValue[i].toString())
            Log.d("tes7",i.toString())
        }
        return cfrValue
    }

    fun calculateCFRTotal(getDoubleQ: DoubleArray):Double{
        var cfrTotal = 0.0
        val cfrTotalPercent: Double
        val cfrTotalFinal = DecimalFormat("#.##")
        val cfrBefore = DoubleArray(getDoubleQ.size)
        //calculate CFR1R2
        cfrBefore[0] = getDoubleQ[0] + (getDoubleQ[1] * (1 - getDoubleQ[0]))
        //calculate CFR..R.. until RLast
        for (i in getDoubleQ.indices) {
            if(i!=getDoubleQ.lastIndex){
                cfrTotal = cfrBefore[i] + (getDoubleQ[i+1] * (1 - cfrBefore[i]))
                cfrBefore[i+1]=cfrTotal
            }
            Log.d("tes8",cfrTotal.toString())
            Log.d("tes",i.toString())
            Log.d("tes9",cfrBefore.toString())
        }
        cfrTotalPercent= cfrTotal*100.0
        cfrTotalFinal.roundingMode = RoundingMode.CEILING
        return cfrTotalFinal.format(cfrTotalPercent).toDouble()
    }
}