package com.callibrity.spring.vthreads;

import io.gatling.javaapi.core.Simulation;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.rampUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;


public class GatlingSimulation extends Simulation {

    {
        var protocol = http.baseUrl("http://localhost:8080")
                .acceptHeader("application/json")
                .contentTypeHeader("application/json");

        var purchaseTickets = scenario("Purchase Tickets")
                .exec(http("Purchase Request")
                        .post("/tickets")
                        .body(StringBody("{\"firstName\":\"James\", \"lastName\":\"Carman\", \"count\": 3}"))
                        .check(status().is(200)));

        setUp(
                purchaseTickets.injectOpen(
                        rampUsersPerSec(100)
                                .to(1000)
                                .during(Duration.ofMinutes(5)))
        ).protocols(protocol);
    }
}
