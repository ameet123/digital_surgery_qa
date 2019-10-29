package com.jnj.surgery.qa

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

class DSPTester extends Simulation {

//  println("=>Performing Loading Testing of Service")
//  val httpProtocol: HttpProtocolBuilder = http // 4
//    .baseUrl("http://fhirtest.uhn.ca/baseR4/Organization?_format=json&_pretty=true") // 5
//    .acceptHeader("\ttext/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // 6
//    .doNotTrackHeader("1")
//    .acceptLanguageHeader("en-US,en;q=0.5")
//    .acceptEncodingHeader("gzip, deflate")
//    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")
//
//  val scn: ScenarioBuilder = scenario("FHIRSimulation") // 7
//    .exec(http("init_req") // 8
//      .get("/")) // 9
//    .pause(2) // 10
//
//  setUp( // 11
//    scn.inject(atOnceUsers(1)) // 12
//  ).protocols(httpProtocol) // 13
}
