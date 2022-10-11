package byronwong.scanner

import gateways.YahooFinanceStockScanner
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import org.jsoup.Jsoup
import org.jsoup.nodes.Element


@MicronautTest
class YahooFinanceStockScannerTest: DescribeSpec({

    describe("YahooFinanceStockScanner") {
        it("can getQuotePrice") {

            mockkStatic(Jsoup::class)
            val stubElement = mockk<Element>()
            every { stubElement.html() } returns "200.40"
            every { Jsoup.connect("https://finance.yahoo.com/quote/TEST").get().
            select("fin-streamer[data-field=regularMarketPrice][data-symbol=TEST]").first() } returns stubElement
            println("Executed")
            val scanner = YahooFinanceStockScanner();
            val quote = scanner.getQuotePrice("TEST")
            quote.shouldNotBeNull()
            quote.price.shouldBe(200.40)
            quote.name.shouldBe("TEST")
        }
    }

})