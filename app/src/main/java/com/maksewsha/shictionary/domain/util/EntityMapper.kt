package com.maksewsha.shictionary.domain.util

interface EntityMapper<F, T> {
    fun mapFromEntity(entity: F): T
}