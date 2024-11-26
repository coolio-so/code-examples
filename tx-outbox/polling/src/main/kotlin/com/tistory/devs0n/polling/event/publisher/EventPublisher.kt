package com.tistory.devs0n.polling.event.publisher

import org.springframework.stereotype.Component

@Component
class EventPublisher(
    private val repository: EventRepository,
) {
    fun publish(event: Event) {
        this.repository.save(event)
    }
}
