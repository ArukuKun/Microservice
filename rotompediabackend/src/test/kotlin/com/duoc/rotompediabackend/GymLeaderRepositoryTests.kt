package com.duoc.rotompediabackend

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class GymLeaderRepositoryTests @Autowired constructor(
    private val repository: GymLeaderRepository
) {

    @Test
    fun `findByRegionIgnoreCase devuelve los lideres de una region ignorando mayusculas`() {
        repository.deleteAll()
        repository.saveAll(
            listOf(
                GymLeader(name = "Ash", region = "Kanto", typeSpecialty = "electric", badgeName = "Medalla Trueno", imageUrl = "https://example.com/ash.png"),
                GymLeader(name = "Brock", region = "kanto", typeSpecialty = "rock", badgeName = "Medalla Roca", imageUrl = "https://example.com/brock.png"),
                GymLeader(name = "Misty", region = "Johto", typeSpecialty = "water", badgeName = "Medalla Cascada", imageUrl = "https://example.com/misty.png")
            )
        )

        val leaders = repository.findByRegionIgnoreCase("KANTO")

        assertEquals(2, leaders.size)
        assertTrue(leaders.any { it.name == "Ash" })
        assertTrue(leaders.any { it.name == "Brock" })
    }
}
