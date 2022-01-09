package com.courseproject.circuitelectricalcalculation.repositiry

import com.courseproject.circuitelectricalcalculation.model.Calculation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CalculationRepository  : JpaRepository<Calculation, Long>