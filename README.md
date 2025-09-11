# Website Clickstream Tracker (Spring Boot + Kafka)

A generalized clickstream tracking system built with **Spring Boot** and **Apache Kafka**.  
This project allows website owners to capture, process, and analyze user interactions such as page views, clicks, and form submissions in a configurable and extensible way.

---

## Features

- **Configurable Tracking**: Website owners decide what events to track.
- **Lightweight Frontend Snippet**: A JavaScript snippet to send user interactions to the backend.
- **Event Ingestion API**: Spring Boot service to collect and validate events.
- **Kafka Integration**: Events are published to Kafka for scalable, real-time processing.
- **Flexible Data Model**: Generic JSON schema supports custom event types and data.
- **Extensible Consumers**: Pluggable consumers to log, store, or enrich events.
- **Multi-Tenant Support**: Different websites can track events independently.

---

## Architecture

1. **Frontend Tracker**  
   - A JavaScript snippet embedded on websites.  
   - Captures configured events and sends them to the backend.

2. **Spring Boot Event Collector**  
   - Provides an endpoint (`/track`) to receive events.  
   - Validates events and publishes them to Kafka.

3. **Kafka Topics**  
   - `clickstream-events`: Raw incoming events.  
   - Additional topics can be used for processed/enriched events.

4. **Consumers**  
   - Example consumer stores events in a database.  
   - Can be extended to support analytics pipelines or real-time dashboards.

---
### main branch for releases, develop branch for development

---

## Example Event

```json
{
  "websiteId": "site_123",
  "sessionId": "sess_456",
  "eventType": "button_click",
  "eventData": {
    "buttonId": "signup-btn",
    "pageUrl": "/home"
  },
  "userAgent": "Mozilla/5.0",
  "ip": "192.168.1.10",
  "timestamp": "2025-09-11T06:45:00Z"
}
