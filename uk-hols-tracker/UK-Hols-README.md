#  UK Hols Tracker (Android Jetpack Glance)

A modern Android widget and tracker built using Jetpack Glance and Retrofit, fetching real-time holiday data from the GOV.UK API.

##  Tech Stack
- Kotlin, Jetpack Glance, Retrofit, Gson, Coroutines.
## Live Site 
[Live Site] (https://sites.google.com/view/uk-holiday-tracker?usp=sharing)

# 🇬🇧 UK Hols Tracker & Portal

A dual-platform project featuring a native Android Home Screen widget (built with Jetpack Glance & Retrofit) and a location-aware multi-page web portal hosted on Google Sites.

## 📱 Tech Stack
- **Android:** Kotlin, Jetpack Glance, Coroutines, Retrofit, Gson.
- **Web Portal:** HTML5, CSS3, JavaScript, GOV.UK Open API, IP Geolocation Integration.

---

## 🏗️ How It Was Built

### 1. Android Architecture & Jetpack Glance Widgets
- **Declarative Widgets with Jetpack Glance:** Instead of legacy XML remote views and `RemoteViews`, this widget is built using **Jetpack Glance**, enabling standard Jetpack Compose mental models and composables to render native Android home screen widgets with modern theming support (`GlanceTheme`).
- **Asynchronous Data Handling:** Network calls are offloaded using **Kotlin Coroutines** (`withContext(Dispatchers.IO)`) to ensure background synchronization runs smoothly without blocking the main UI thread or causing ANRs.
- **Holiday Calculation Algorithm:** Utilizing Java's modern `java.time` API (`LocalDate` and `DateTimeFormatter`), the repository parses string dates (`yyyy-MM-dd`), filters out past events, and calculates the upcoming holiday dynamically via `.minByOrNull { (_, date) -> date }`.

### 2. Networking & Multi-Region Support
- **Retrofit & Gson:** Built a type-safe API client targeting the official public GOV.UK endpoint (`https://www.gov.uk/bank-holidays.json`).
- **Regional Data Models:** Structured the data layers (`GovUkResponse`, `DivisionData`, `BankHolidayEvent`) with `@SerializedName` annotations to map JSON nodes independently across England & Wales, Scotland, and Northern Ireland.

### 3. Web Portal & Location-Aware Integration
- **Multi-Page Layout Structure:** Designed a multi-page web portal hosted on Google Sites featuring a Home dashboard, dedicated regional breakdowns (**Scotland**, **Northern Ireland**, **England & Wales**), widget setup guides (**Android Glance** & **iOS Scriptable**), and a **Calendar Sync** hub.
- **Smart IP/Geo Auto-Detection:** Embedded JavaScript automatically detects whether a visitor is physically located in Scotland, Northern Ireland, or England/Wales via an IP geolocation service (`ipapi.co`), dynamically adjusting the hero countdown banner and warning users if they are viewing a region that differs from their current physical location.
- **Custom UI Embeds:** Built responsive, dark-mode gradient HTML/CSS/JS components featuring real-time countdown blocks (Days, Hours, Minutes, Seconds) and official short region abbreviations (`ENG & WALES`, `SCOT`, `NI`).

##  Widget Preview
![Widget Screenshot](https://github.com/karthic180/Programming/blob/main/uk-hols-tracker/uk%20track.png)
