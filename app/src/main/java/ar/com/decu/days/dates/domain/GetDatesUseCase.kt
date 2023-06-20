package ar.com.decu.days.dates.domain

import ar.com.decu.days.dates.data.DatesRepository
import ar.com.decu.days.dates.data.net.response.DatesResponse

class GetDatesUseCase {
    private val repo = DatesRepository()

    suspend operator fun invoke(): DatesResponse {
        return repo.getDates()
    }
}