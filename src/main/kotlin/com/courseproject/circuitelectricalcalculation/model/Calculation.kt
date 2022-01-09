package com.courseproject.circuitelectricalcalculation.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import org.springframework.util.SerializationUtils
import javax.persistence.*

@Entity
@Table(name = "CALCULATION")
class Calculation (calculationCreateModel: CalculationCreateModel, calculationResults: CalculationResults) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Long = 0

    @Column(length = 65536)
    val networkTopology: ByteArray

    @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    @JsonManagedReference
    val branchResistances: List<ComplexNumber>

    @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    @JsonManagedReference
    val branchEVMs: List<ComplexNumber>

    @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    @JsonManagedReference
    val branchCurrentSources: List<ComplexNumber>

    @ElementCollection
    val towersNumbers: List<String>

    @ElementCollection
    val calculationPoints: List<String>

    @OneToOne(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    @JsonManagedReference
    val calculationResults = calculationResults

 init {
  networkTopology = SerializationUtils.serialize(calculationCreateModel.networkTopology)!!
  branchResistances = calculationCreateModel.branchResistances
  branchEVMs = calculationCreateModel.branchEVMs
  branchCurrentSources = calculationCreateModel.branchCurrentSources
  towersNumbers = calculationCreateModel.towersNumbers
  calculationPoints = calculationCreateModel.calculationPoints
 }
}