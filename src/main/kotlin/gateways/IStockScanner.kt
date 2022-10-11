package gateways

import entities.Quote

interface IStockScanner {
    fun getQuotePrice(ticket_name: String): Quote
}