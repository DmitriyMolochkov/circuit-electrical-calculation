package com.courseproject.circuitelectricalcalculation.model

import org.springframework.util.SerializationUtils

class CalculationView(calculation: Calculation) {
    val id : Long
    val networkTopology: List<DoubleArray>
    val branchResistances: List<ComplexNumber>
    val branchEVMs: List<ComplexNumber>
    val branchCurrentSources: List<ComplexNumber>
    val towersNumbers: List<String>
    val calculationPoints: List<String>
    val calculationResults: CalculationResults

    init {
        id = calculation.id
        networkTopology = SerializationUtils.deserialize(calculation.networkTopology) as List<DoubleArray>
        branchResistances = calculation.branchResistances
        branchEVMs = calculation.branchEVMs
        branchCurrentSources = calculation.branchCurrentSources
        towersNumbers = calculation.towersNumbers
        calculationPoints = calculation.calculationPoints
        calculationResults = calculation.calculationResults
    }
}