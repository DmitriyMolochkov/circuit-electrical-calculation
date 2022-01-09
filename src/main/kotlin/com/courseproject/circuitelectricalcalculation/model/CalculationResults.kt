package com.courseproject.circuitelectricalcalculation.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import flanagan.complex.ComplexMatrix
import javax.persistence.*

@Entity
@Table(name = "CALCULATION_RESULTS")
class CalculationResults (
    _vBranchesVoltage: ComplexMatrix,
    _vBranchesCurrents: ComplexMatrix,
    _resultFotCTS: CalculationResultForCTS,
    _resultsForTowers: List<CalculationResultForTower>
) {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Long = 0

    @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    @JsonManagedReference
    val branchesVoltage: List<ComplexNumber>

    @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    @JsonManagedReference
    val branchesCurrents: List<ComplexNumber>

    @OneToOne(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    @JsonManagedReference
    val resultFotCTS = _resultFotCTS

    @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    @JsonManagedReference
    val resultsForTowers = _resultsForTowers

    init {
        branchesVoltage = _vBranchesVoltage.getArrayCopy()
            .map{ x -> ComplexNumber(x[0]) }
        branchesCurrents = _vBranchesCurrents.getArrayCopy()
            .map{ x -> ComplexNumber(x[0]) }
    }
}