package com.courseproject.circuitelectricalcalculation.model

import com.fasterxml.jackson.annotation.JsonIgnore
import flanagan.complex.Complex
import javax.persistence.*

@Entity
@Table(name = "CALCULATION_RESULT_FOR_TOWER")
class CalculationResultForTower(
    _towerNumber: String,
    _voltagePhaseA: Complex,
    _voltagePhaseB: Complex,
    _voltagePhaseC: Complex
) {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Long = 0

    val towerNumber = _towerNumber
    @OneToOne(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    val voltagePhaseA = ComplexNumber(_voltagePhaseA)
    @OneToOne(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    val voltagePhaseB = ComplexNumber(_voltagePhaseB)
    @OneToOne(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    val voltagePhaseC = ComplexNumber(_voltagePhaseC)
}