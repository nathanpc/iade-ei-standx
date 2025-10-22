package pt.iade.ei.standx.controllers

import android.util.Log
import com.github.kittinunf.fuel.httpGet
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import pt.iade.ei.standx.models.CarItem

class CarItemController {
    val serverRoot = "http://10.0.2.2:5000"

    fun GetListOfCars(
        callback: (carsList: List<CarItem>) -> Unit
    ) {
        "$serverRoot/cars".httpGet().response {
                request, response, result ->
            // Gets the JSON as a string from the server's response.
            val responseBody = String(response.data)

            // Setup Gson library and parse JSON object.
            val gson = GsonBuilder().create()
            val json = gson.fromJson(responseBody, JsonObject().javaClass) as JsonObject

            // Loop through cars in JSON array.
            val carsList = mutableListOf<CarItem>()
            val carsJson = json.getAsJsonArray("cars")
            for (carJson in carsJson) {
                val obj = carJson as JsonObject
                val car = CarItem(
                    id = obj.get("id").asInt,
                    make = obj.get("make").asString,
                    model = obj.get("model").asString,
                    year = obj.get("year").asInt,
                    km = obj.get("km").asInt,
                    price = obj.get("price").asFloat,
                    transmission = obj.get("transmission").asString,
                    fuel = obj.get("fuel").asString,
                    seats = obj.get("seats").asInt
                )

                carsList.add(car)
            }

            // Return cars list to parent function call.
            callback(carsList)
        }
    }
}