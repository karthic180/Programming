package com.example.bankholidaywidget.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import com.example.bankholidaywidget.data.BankHolidayEvent
import com.example.bankholidaywidget.data.BankHolidayRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NextHolidayWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        val nextHoliday = withContext(Dispatchers.IO) {
            BankHolidayRepository.getNextBankHoliday("england-and-wales")
        }
        provideContent {
            GlanceTheme {
                WidgetContent(nextHoliday)
            }
        }
    }

    @Composable
    private fun WidgetContent(holiday: BankHolidayEvent?) {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .padding(16.dp)
                .background(GlanceTheme.colors.background),
            verticalAlignment = Alignment.CenterVertically,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Next UK Bank Holiday",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = GlanceTheme.colors.onSurfaceVariant
                )
            )
            Spacer(modifier = GlanceModifier.height(8.dp))
            if (holiday != null) {
                Text(
                    text = holiday.title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = GlanceTheme.colors.onSurface
                    )
                )
                Spacer(modifier = GlanceModifier.height(4.dp))
                Text(
                    text = holiday.date,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = GlanceTheme.colors.primary
                    )
                )
            } else {
                Text(
                    text = "Unable to load data",
                    style = TextStyle(fontSize = 14.sp, color = GlanceTheme.colors.error)
                )
            }
        }
    }
}
