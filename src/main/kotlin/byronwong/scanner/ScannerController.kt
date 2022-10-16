package byronwong.scanner

import byronwong.scanner.entities.Quote
import byronwong.scanner.exceptions.QuoteNotFoundException
import io.micronaut.http.annotation.Controller
import byronwong.scanner.gateways.IStockScanner
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get

@Controller("/quote")
class ScannerController(private val scanner: IStockScanner) {

    @Get("/{quote}")
    fun getQuote(quote: String): HttpResponse<Quote?> {
        return try {
            HttpResponse.ok(scanner.getQuotePrice(quote))
        } catch (err: QuoteNotFoundException) {
            HttpResponse.notFound()
        }
    }
}