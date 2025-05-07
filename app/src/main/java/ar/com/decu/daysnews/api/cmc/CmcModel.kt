package ar.com.decu.daysnews.api.cmc

data class CmcModel(
    val data: List<CmdData>
)

data class CmdData(
    val id: Int,
    val name: String,
    val cmcRank: Int,
    val quote: Quote
)

data class Quote (
    val USD: Usd
)

data class Usd (
    val price: Double
)
