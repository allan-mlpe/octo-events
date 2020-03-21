package octo.api

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.javalin.Javalin
import io.javalin.plugin.json.JavalinJackson
import octo.controller.IssueEventController
import octo.model.IssueEvent
import octo.utils.PropertiesUtil
import java.text.SimpleDateFormat

fun setupServer() : Javalin {
    return Javalin.create()
        .also { app ->
            configureMapper()
        }
        .start(PropertiesUtil.SERVER_PORT)
}

fun configureMapper() {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    JavalinJackson.configure(jacksonObjectMapper()
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .setDateFormat(dateFormat)
        .configure(SerializationFeature.WRITE_DATES_WITH_ZONE_ID, true)
        .setPropertyNamingStrategy(PropertyNamingStrategy.LowerCaseStrategy.SNAKE_CASE)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    )
}

fun main() {
    val issueEventController = IssueEventController()

    val app = setupServer()

    // Retrieves events based on issue ID
    app.get("issues/:id/events") {ctx ->
        val issueId = ctx.pathParam("id")
        val issues = issueEventController.findByIssueId(issueId.toInt())

        ctx.json(issues)
    }

    // Saves a event in database
    app.post("/") { ctx ->
        val issue = ctx.body<IssueEvent>()
        val insertedIssue = issueEventController.createIssueEvent(issue)

        ctx.json(insertedIssue)
    }
}