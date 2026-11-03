# UK Bank Holiday Tracker

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=flat-square)](LICENSE)
[![Android](https://img.shields.io/badge/Android-3DDC84?style=flat-square&logo=android&logoColor=white)](https://developer.android.com)
[![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=css3&logoColor=white)](https://developer.mozilla.org/en-US/docs/Web/CSS)
[![HTML](https://img.shields.io/badge/HTML5-E34F26?style=flat-square&logo=html5&logoColor=white)](https://developer.mozilla.org/en-US/docs/Web/HTML)
[![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=javascript&logoColor=black)](https://developer.mozilla.org/en-US/docs/Web/JavaScript)
[![GOV.UK API](https://img.shields.io/badge/API-GOV.UK%20Open%20Data-005EA5?style=flat-square)](https://www.gov.uk/bank-holidays.json)
[![AI Tools: Google Gemini & ChatGPT](https://img.shields.io/badge/AI%20Tools-Google%20Gemini%20%26%20ChatGPT-8E75B2?style=flat-square&logo=openai&logoColor=white)](https://gemini.google.com/)

A modern, location-aware web application and multi-platform companion designed to track UK bank holidays in real time across England & Wales, Scotland, and Northern Ireland.

---
##  Development & AI Disclosure
This project was developed and structured collaboratively with AI tools, combining modern frontend UI patterns, automated API integrations, and mobile widget architectures.
##  The Original Idea
 "I want to create a calendar widget to countdown the next bank holiday using the GOV.UK website and auto-change with the next one."
## How I Built It

I designed and built this project from the ground up to be lightweight, instant-loading, and completely serverless by leveraging modern web standards and public data feeds.

###  Architecture & Tech Stack
* **Frontend Core:** Pure **HTML5, CSS3, and Vanilla JavaScript**, structured into modular components embedded directly into a polished multi-page **Google Sites** portal (`https://sites.google.com/view/uk-holiday-tracker`).
* **Live Data Feed:** Automatically queries the official **GOV.UK Open Data API** (`bank-holidays.json`) on load. Past events are filtered out locally, and upcoming dates are parsed dynamically.
* **Smart Geolocation:** Integrated client-side IP lookup via **ipapi.co** with robust timeout guards and automatic fallbacks to instantly detect the user's region (**ENG WALES**, **SCOT**, or **NI**).

###  Key Features Developed
* **Live Countdown Banners:** Dark-mode gradient countdown timers that calculate real-time days, hours, minutes, and seconds until the next regional public holiday.
* **Multi-Region Navigation:** Clean, short regional abbreviation tabs (`ENG WALES`, `SCOT`, `NI`) with smooth active states.
* **Expandable Holiday Lists:** Scrollable container cards featuring a custom expandable view toggle (`▼ Expand Full List`) to keep the UI clean on both desktop and mobile viewports.
* **Calendar Syncing (`.ics` Generator):** A built-in utility that programmatically generates standard `.ics` calendar files on the fly, allowing visitors to download and sync schedules directly into Apple Calendar, Google Calendar, or Microsoft Outlook.
* **Developer Ecosystem:** Extended with custom native snippets for Android (`BankHolidayRepository.kt`, `GovUkApiService.kt`, `NextHolidayWidget.kt`) and iOS Scriptable widgets.

###  Privacy & Compliance
* Built with strict **GDPR compliance** in mind: location detection runs entirely client-side, and no personal identifiers, tracking cookies, or location logs are ever stored or shared.

---
## Preview
![Screenshot](https://github.com/karthic180/Programming/blob/main/uk-hols-tracker/uk%203%20track.png)
