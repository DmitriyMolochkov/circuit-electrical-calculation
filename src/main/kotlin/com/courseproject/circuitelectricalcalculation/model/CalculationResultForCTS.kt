package com.courseproject.circuitelectricalcalculation.model

import com.fasterxml.jackson.annotation.JsonIgnore
import flanagan.complex.Complex
import javax.persistence.*

@Entity
@Table(name = "CALCULATION_RESULT_FOR_CTS")
class CalculationResultForCTS(
    _currentPhaseA: Complex,
    _currentPhaseB: Complex,
    _currentPhaseC: Complex
) {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Long = 0

    @OneToOne(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    val currentPhaseA = ComplexNumber(_currentPhaseA)
    @OneToOne(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    val currentPhaseB = ComplexNumber(_currentPhaseB)
    @OneToOne(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    val currentPhaseC = ComplexNumber(_currentPhaseC)
}