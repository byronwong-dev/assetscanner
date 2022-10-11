package gateways

import jakarta.inject.Singleton
import entities.Quote
import org.jsoup.Jsoup
import java.text.NumberFormat
import java.util.*

@Singleton
class YahooFinanceStockScanner() : IStockScanner {

    override fun getQuotePrice(ticket_name: String): Quote {
        val marketPriceElement = Jsoup.connect("https://finance.yahoo.com/quote/$ticket_name").get().select("fin-streamer[data-field=regularMarketPrice][data-symbol=$ticket_name]").first()
        val price = NumberFormat.getNumberInstance(Locale.ENGLISH).parse(marketPriceElement?.html() ?: "0").toDouble()
        return Quote(ticket_name, price)
    }
}