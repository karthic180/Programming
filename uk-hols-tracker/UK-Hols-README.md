#  UK Hols Tracker (Android Jetpack Glance)

A modern Android widget and tracker built using Jetpack Glance and Retrofit, fetching real-time holiday data from the GOV.UK API.

##  Tech Stack
- Kotlin, Jetpack Glance, Retrofit, Gson, Coroutines.
## Live Site 
[Live Site] (https://sites.google.com/view/uk-holiday-tracker?usp=sharing)

Architecture & How It Was Built
1. Android Native App & Jetpack Glance Widgets

    Declarative UI with Jetpack Glance: Instead of legacy XML remote views, the native Android home screen widget is built using Jetpack Glance, letting Jetpack Compose composables render directly onto the Android launcher with dynamic theming (GlanceTheme).

    Asynchronous Coroutines & Retrofit: Network calls to the official GOV.UK API ([https://www.gov.uk/bank-holidays.json](https://www.gov.uk/bank-holidays.json)) are offloaded to IO threads (Dispatchers.IO) to prevent ANRs and ensure fluid widget syncing.

    Dynamic Holiday Calculation Algorithm: Using Java's java.time API (LocalDate), the repository parses string dates (yyyy-MM-dd), filters out past events, and calculates the exact upcoming holiday using .minByOrNull { (_, date) -> date }.

2. Google Sites Web Portal & Interactive Embeds

    Multi-Page Layout Structure: Designed a multi-page portal ([https://sites.google.com/view/uk-holiday-tracker](https://sites.google.com/view/uk-holiday-tracker)) featuring a Home dashboard, dedicated regional breakdowns (Scotland, Northern Ireland, England & Wales), widget setup guides (Android Glance & iOS Scriptable), and a Calendar Sync hub.

    Smart IP/Geo Auto-Detection: Embedded JavaScript automatically detects whether a visitor is physically located in Scotland, Northern Ireland, or England/Wales via an IP geolocation service (ipapi.co), dynamically adjusting the hero countdown banner and warning users if they are viewing a region that differs from their current location.

    Live Countdown & Responsive UI: Built custom, dark-mode gradient HTML/CSS/JS components featuring real-time countdown blocks (Days, Hours, Minutes, Seconds) and official short region abbreviations (ENG & WALES, SCOT, NI).

##  Widget Preview
![Widget Screenshot](https://github.com/karthic180/Programming/blob/main/uk-hols-tracker/uk%20track.png)
