package com.example.bankholidaywidget.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object BankHolidayRepository {
    private val api: GovUkApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.gov.uk/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GovUkApiService::class.java)
    }

    suspend fun getNextBankHoliday(region: String = "england-and-wales"): BankHolidayEvent? {
        return runCatching {
            val response = api.getBankHolidays()
            val events = when (region) {
                "scotland" -> response.scotland.events
                "northern-ireland" -> response.northernIreland.events
                else -> response.englandAndWales.events
            }
            val today = LocalDate.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            events
                .map { Pair(it, LocalDate.parse(it.date, formatter)) }
                .filter { (_, date) -> !date.isBefore(today) }
                .minByOrNull { (_, date) -> date }
                ?.first
        }.getOrNull()
    }
}
