package com.example.requestislamicloan

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun App(modifier: Modifier = Modifier, viewModel: LoanViewModel = viewModel()){
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = "${viewModel.amount}",
            label = { Text(text = "Amount")},
            onValueChange = {
                var amount: Double? = it.toDouble()
                viewModel.newAmount(amount)},
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number))
        OutlinedTextField(
            value = "${viewModel.months}",
            label = { Text(text = "Months")},
            onValueChange = {
                var months: Int? = it.toInt()
                viewModel.newMonths(months)},
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number))
        Text(text = "Monthly Installment: ${viewModel.installments}")
        Button(onClick = { viewModel.calculateInstallments() }) {
            Text(text = "Calculate")
        }
        OutlinedTextField(
            value = "${viewModel.salary}",
            label = { Text(text = "Salary")},
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            onValueChange = {
            var salary: Double? = it.toDouble()
            viewModel.newSalary(salary)
        })
        Text(text = "Monthly Installments: ${viewModel.salaryInstallments}\nLoan Period: ${viewModel.period}")
        Button(onClick = { viewModel.calculateSalaryInstallments() }) {
            Text(text = "Calculate")
        }
    }
}