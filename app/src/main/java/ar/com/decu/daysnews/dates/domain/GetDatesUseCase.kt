package ar.com.decu.daysnews.dates.domain

import ar.com.decu.daysnews.dates.data.DatesRepository
import ar.com.decu.daysnews.dates.data.net.response.DatesResponse

class GetDatesUseCase {
    private val repo = DatesRepository()

    suspend operator fun invoke(): DatesResponse {
        return repo.getDates()
    }
}