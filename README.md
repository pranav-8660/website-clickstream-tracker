### This is the default branch for development

## Currectly we have decided to use some microservices, namely:
- Frontend Tracker SDK : A js based sdk that will be used by web-applications to capture events and invoke requests to ECS(event collector service)
- Event Collector Service(ECS) - Expose endpoint for incoming events. Produce the event to Kafka topic(clickstream-events).
- Event Processor Service(EPS) - Consume from kafka topic's partition(clickstream-events).Enrich events (geo-IP lookup, device parsing, session stitching) and Publish enriched events to processed-events Kafka topic.
- Storage Service - Consume from processed-events and Store events in the database for querying and analytics.
    - PostgreSQL → Relational analysis (sessions, funnels).
    - MongoDB → Flexible JSON schema storage.
    - Elasticsearch → Search + dashboard integrations.
- Analytics API Service(AAS) - ML/Visualization/Analytics service on the data from databases.
- Configuration Service (optional for later) - Let website owners define what events to track. Provide config API for frontend SDK (e.g., GET /config/{websiteId}). Ensure only allowed events are ingested.
