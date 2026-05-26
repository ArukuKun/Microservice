package com.duoc.rotompediabackend

import io.mockk.every
import com.ninjasquad.springmockk.MockkBean // Import correcto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(GymLeaderController::class)
class GymLeaderControllerTests(@Autowired val mockMvc: MockMvc) {

    // Se agrega relaxed = true para evitar el MockKException en el arranque
    @MockkBean(relaxed = true)
    lateinit var repository: GymLeaderRepository

    @Test
    fun `GET all leaders devuelve 200 y la lista JSON`() {
        val expected = listOf(
            GymLeader(id = 1, name = "Brock", region = "Kanto", typeSpecialty = "rock", badgeName = "Medalla Roca", imageUrl = "https://example.com/brock.png")
        )

        every { repository.findAll() } returns expected

        mockMvc.get("/api/leaders") {
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            jsonPath("$[0].name") { value("Brock") }
            jsonPath("$[0].region") { value("Kanto") }
        }
    }

    @Test
    fun `GET leaders by region devuelve solo la region solicitada`() {
        val expected = listOf(
            GymLeader(id = 2, name = "Misty", region = "Kanto", typeSpecialty = "water", badgeName = "Medalla Cascada", imageUrl = "https://example.com/misty.png")
        )

        every { repository.findByRegionIgnoreCase("kanto") } returns expected

        mockMvc.get("/api/leaders/region/kanto") {
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            jsonPath("$[0].name") { value("Misty") }
            jsonPath("$[0].region") { value("Kanto") }
        }
    }
}