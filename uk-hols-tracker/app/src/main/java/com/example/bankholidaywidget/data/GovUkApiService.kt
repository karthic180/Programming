package com.example.bankholidaywidget.data

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET

data class GovUkResponse(
    @SerializedName("england-and-wales") val englandAndWales: DivisionData,
    val scotland: DivisionData,
    @SerializedName("northern-ireland") val northernIreland: DivisionData
)

data class DivisionData(
    val division: String,
    val events: List<BankHolidayEvent>
)

data class BankHolidayEvent(
    val title: String,
    val date: String,
    val notes: String?,
    val bunting: Boolean
)

interface GovUkApiService {
    @GET("bank-holidays.json")
    suspend fun getBankHolidays(): GovUkResponse
}
