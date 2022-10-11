package byronwong.scanner.gateways

import byronwong.scanner.entities.Quote

interface IStockScanner {
    fun getQuotePrice(ticket_name: String): Quote
}