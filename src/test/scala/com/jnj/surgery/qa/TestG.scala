package com.jnj.surgery.qa


import com.jnj.surgery.qa.config.DSPConstants
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._

class TestG extends Simulation {

  println("=>Performing Loading Testing of Service")
  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl(DSPConstants.PUBLIC_GW_HOST)
    .header(HttpHeaderNames.Accept, HttpHeaderValues.ApplicationFormUrlEncoded)
    .header(HttpHeaderNames.Accept, "*/*")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val getPatientFailUser: ScenarioBuilder = scenario("GET_PATIENT_FAIL")
    .exec(http("getPatientFailure")
      .get(DSPConstants.GET_PATIENT_URI).header(HttpHeaderNames.Authorization, DSPConstants.AMEET_JWT)
      .check(status.in(401))
    )
  val getPatientSuccessUser: ScenarioBuilder = scenario("GET_PATIENT_SUCCESS")
    .exec(http("getPatientSuccess")
      .get(DSPConstants.GET_PATIENT_URI).header(HttpHeaderNames.Authorization, DSPConstants.JENNY_JWT)
      .check(status.in(200))
    )
  val createPatientSuccessUser: ScenarioBuilder = scenario("CREATE_PATIENT_SUCCESS")
    .exec(http("createPatientSuccess")
      .post(DSPConstants.CREATE_PATIENT_URI)
      .body(StringBody(DSPConstants.PATIENT_CREATE_BODY))
      .header(HttpHeaderNames.Authorization, DSPConstants.AMEET_JWT)
      .check(status.in(201))
    )
  val createPatientFailUser: ScenarioBuilder = scenario("CREATE_PATIENT_Failure")
    .exec(http("createPatientFail")
      .post(DSPConstants.CREATE_PATIENT_URI)
      .body(StringBody(DSPConstants.PATIENT_CREATE_BODY))
      .header(HttpHeaderNames.Authorization, DSPConstants.ARYA_JWT)
      .check(status.in(401))
    )
  // Service Request
  val createServiceRequestSuccessUser: ScenarioBuilder = scenario("CREATE_SVC_REQ_SUCCESS")
    .exec(http("createServiceRequestSuccess")
      .post(DSPConstants.CREATE_SVC_REQ_URI)
      .body(StringBody(DSPConstants.SVC_REQ_CREATE_BODY))
      .header(HttpHeaderNames.Authorization, DSPConstants.DRHOUSE_JWT)
      .check(status.in(201, 200))
    )
  val createServiceRequestFailUser: ScenarioBuilder = scenario("CREATE_SVC_REQ_FAILURE")
    .exec(http("createServiceRequestFailure")
      .post(DSPConstants.CREATE_SVC_REQ_URI)
      .body(StringBody(DSPConstants.SVC_REQ_CREATE_BODY))
      .header(HttpHeaderNames.Authorization, DSPConstants.ARYA_JWT)
      .check(status.in(401))
    )

  val healthCheckUser: ScenarioBuilder = scenario("HealthCheck")
    .exec(http("healthCheckUser")
      .get(DSPConstants.HEALTH_CHEKCK_URI)
      .check(status.in(200))
    )

  setUp(
    getPatientFailUser.inject(rampUsers(2) during (3 seconds)),
    healthCheckUser.inject(rampUsers(5) during (5 seconds)),
    getPatientSuccessUser.inject(rampUsers(2) during (3 seconds)),
    createPatientFailUser.inject(rampUsers(2) during (5 seconds)),
    createPatientSuccessUser.inject(rampUsers(2) during (5 seconds)),
    // important to have 10 seconds or so of break in between, else we get 504 gateway timeout
    createServiceRequestSuccessUser.inject(atOnceUsers(1), nothingFor(10 seconds), atOnceUsers(1)),
    createServiceRequestFailUser.inject(rampUsers(2) during (10 seconds))
  ).protocols(httpProtocol)
}
