package byronwong.scanner.entities

import com.fasterxml.jackson.databind.PropertyNamingStrategies.UpperCamelCaseStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

data class Quote(val name: String, val price: Double?)