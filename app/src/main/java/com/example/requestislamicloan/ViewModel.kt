package com.example.requestislamicloan

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoanViewModel: ViewModel() {
    var amount: Double? by mutableStateOf(0.0)
        private set
    var months: Int? by mutableStateOf(0)
        private set
    var installments: Double? by mutableStateOf(0.0)
        private set
    var salaryInstallments: Double? by mutableStateOf(0.0)
        private set
    var salary: Double? by mutableStateOf(0.0)
        private set
    var period: Double? by mutableStateOf(0.0)

    fun newAmount(amount: Double?){
        this.amount = amount
    }

    fun newMonths(months: Int?){
        this.months = months
    }

    fun newSalary(salary: Double?){
        this.salary = salary
    }

    fun calculateInstallments(amount: Double? = this.amount, months: Int? = this.months){
        val result = amount?.div(months!!)
        this.installments = result
    }

    fun calculateSalaryInstallments(salary: Double? = this.salary){
        val result = salary?.times(0.4)
        salaryInstallments = result
        val period = amount?.div(salaryInstallments!!)
        this.period = period
    }
}