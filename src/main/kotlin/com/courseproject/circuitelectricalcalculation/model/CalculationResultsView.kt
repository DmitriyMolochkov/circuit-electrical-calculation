package com.courseproject.circuitelectricalcalculation.model

class CalculationResultsView(calculation: Calculation) {
    val calculationId: Long
    val branchesVoltage: List<ComplexNumber>
    val branchesCurrents: List<ComplexNumber>
    val resultFotCTS: CalculationResultForCTS
    val resultsForTowers: List<CalculationResultForTower>

    init {
        calculationId = calculation.id
        branchesVoltage = calculation.calculationResults.branchesVoltage
        branchesCurrents = calculation.calculationResults.branchesCurrents
        resultFotCTS = calculation.calculationResults.resultFotCTS
        resultsForTowers = calculation.calculationResults.resultsForTowers
    }
}