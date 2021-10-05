# Estate Monitor

## Plan

```
┌───────────────┐
│               │
│ Thermostat 1  ├──────┐
│               │      │
└───────────────┘      │
                       │
┌───────────────┐      │       ┌─────────────────┐       ┌────────────────┐
│               │      │       │                 ◄───────┘                │
│ Thermostat 2  ├─────►│       │   Java Server   ┌───────► Vue api client │
│               │      │       │                 │       │                │
└───────────────┘      │       └────────▲────────┘       └─────────▲──────┘
                       │                │                          │
┌───────────────┐      │       ┌────────┴─────────┐                │
│               │      ▼       │                  │                │
│ Thermostat 3  ├──────────────► Active MQ server ├────────────────┘
│               │              │                  │
└───────────────┘              └──────────────────┘
```

### Producers - Thermostats

* Dockerized
* Use the telemetry emulator

### Consumer - Java api

* Consumes messages from the queues generated by the thermostats
* determines weather the data is outside of the bounds set by the user
* alerts the user if a thermostat is down
* handles users logging in and out, managing sessions
* durable queues

### UI - Vue

* setting user bounds
* showing the data from the pubsub queues
