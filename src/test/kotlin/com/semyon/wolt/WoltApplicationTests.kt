package com.semyon.wolt

import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
@RunWith(SpringRunner::class)
class WoltApplicationTests {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `Send JSON and assert response`() {
        val request = MockMvcRequestBuilders.post("/api/schedule")
            .contentType(MediaType.APPLICATION_JSON)
            .content(javaClass.classLoader.getResource("data.json").readText())

        mockMvc.perform(request)
            .andExpect(status().isOk)
            .andExpect(
                MockMvcResultMatchers.content().string(
                    """
                    Monday: Closed
                    Tuesday: 9:00 AM - 11:00 AM, 4:00 PM - 11:00 PM
                    Wednesday: Closed
                    Thursday: 10:00 AM - 6:00 PM
                    Friday: 10:00 AM - 1:00 AM
                    Saturday: 10:00 AM - 1:00 AM
                    Sunday: 12:00 PM - 9:00 PM
                    """.trimIndent()
                )
            )
    }

}
